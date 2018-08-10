package per.yang.lock;

import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.bytecode.assign.Assigner;

import java.util.Arrays;

/**
 *
 * @author songbao.yang
 * @date 2018/6/3
 */
public class MethodTemplate2 {

    @Advice.OnMethodEnter
    static Object enter(@Advice.This Object self,
                         @Advice.AllArguments Object[] args) {
        System.out.println("~~~~~~~MethodTemplate2.enter~~~~~~~~");
        return Publisher.enter(self, args);
    }

    @Advice.OnMethodExit(onThrowable = Throwable.class)
    static void exit(@Advice.This Object self,
                   @Advice.Return(readOnly = false, typing = Assigner.Typing.DYNAMIC) Object returned,
                   @Advice.AllArguments Object[] args,
                   @Advice.Thrown(readOnly = false) Throwable t,
                   @Advice.Enter Object enter) {
        System.out.println("~~~~~~~MethodTemplate2.exit~~~~~~~~");
        Publisher.exit(self, returned, args, t, enter);
    }
}
