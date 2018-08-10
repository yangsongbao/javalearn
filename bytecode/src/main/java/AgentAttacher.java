import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;
import com.sun.tools.attach.spi.AttachProvider;
import sun.tools.attach.BsdVirtualMachine;
import sun.tools.attach.LinuxVirtualMachine;
import sun.tools.attach.SolarisVirtualMachine;
import sun.tools.attach.WindowsVirtualMachine;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.List;

class AgentAttacher {

    private static final AttachProvider ATTACH_PROVIDER = new AttachProvider() {
        @Override
        public String name() {
            return null;
        }

        @Override
        public String type() {
            return null;
        }

        @Override
        public VirtualMachine attachVirtualMachine(String id) {
            return null;
        }

        @Override
        public List<VirtualMachineDescriptor> listVirtualMachines() {
            return null;
        }
    };

    private static VirtualMachine getVirtualMachineImplementationFromEmbeddedOnes(String pid) {
        Class<? extends VirtualMachine> vmClass = findVirtualMachineClassAccordingToOS();
        Class<?>[] parameterTypes = {AttachProvider.class, String.class};

        try {
            // This is only done with Reflection to avoid the JVM pre-loading all the XyzVirtualMachine classes.
            Constructor<? extends VirtualMachine> vmConstructor = vmClass.getConstructor(parameterTypes);
            return vmConstructor.newInstance(ATTACH_PROVIDER, pid);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Class<? extends VirtualMachine> findVirtualMachineClassAccordingToOS() {
        if (File.separatorChar == '\\') {
            return WindowsVirtualMachine.class;
        }

        String osName = System.getProperty("os.name");

        if (osName.startsWith("Linux") || osName.startsWith("LINUX")) {
            return LinuxVirtualMachine.class;
        } else if (osName.startsWith("Mac OS X")) {
            return BsdVirtualMachine.class;
        } else if (osName.startsWith("Solaris")) {
            return SolarisVirtualMachine.class;
        }

        throw new IllegalStateException("Cannot use Attach API on unknown OS: " + osName);
    }

    private static VirtualMachine attachToRunningVM(String pid) {
        try {
            return VirtualMachine.attach(pid);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    void loadAgent(String pid, String jarFile, String args) {
        VirtualMachine vm;

        if (AttachProvider.providers().isEmpty()) {
            String vmName = System.getProperty("java.vm.name");
            if (vmName.contains("HotSpot") || vmName.contains("OpenJDK")) {
                vm = getVirtualMachineImplementationFromEmbeddedOnes(pid);
            } else {
                String helpMessage = getHelpMessageForNonHotSpotVM(vmName, jarFile);
                throw new IllegalStateException(helpMessage);
            }
        } else {
            vm = attachToRunningVM(pid);
        }

        loadAgentAndDetachFromRunningVM(vm, jarFile, args);
    }

    private String getHelpMessageForNonHotSpotVM(String vmName, String jarFilePath) {
        String helpMessage = "To run on " + vmName;

        if (vmName.contains("J9")) {
            helpMessage += ", add <IBM SDK>/lib/tools.jar to the runtime classpath (before jmockit), or";
        }

        return helpMessage + " use -javaagent:" + jarFilePath;
    }

    private void loadAgentAndDetachFromRunningVM(VirtualMachine vm, String jarFilePath, String args) {
        try {
            vm.loadAgent(jarFilePath, args);
            vm.detach();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
