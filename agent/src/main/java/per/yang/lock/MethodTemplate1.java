package per.yang.lock;

import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.bytecode.assign.Assigner;

import java.util.Arrays;

/**
 *
 * @author songbao.yang
 * @date 2018/6/3
 */
public class MethodTemplate1 {

    @Advice.OnMethodEnter
    static String  enter(@Advice.This Object self) {

        System.out.println("~~~~~~~~~~~~Enter MethodTemplate1");
        return "1111111111111";
    }

    @Advice.OnMethodExit(onThrowable = Throwable.class)
    static void ee(@Advice.This Object self,
                   @Advice.Return(readOnly = false, typing = Assigner.Typing.DYNAMIC) Object returned,
                   @Advice.AllArguments Object[] args,
                   @Advice.Thrown Throwable t,
                   @Advice.Enter String enter) {
        System.out.println("returned: "  + returned);
        System.out.println("args: " + Arrays.toString(args));
        System.out.println("enter: " + enter);
        System.out.println("throwable: " + t);
        returned = "yangsongbao";
        System.out.println("~~~~~~~~~~~~Exit MethodTemplate1");
    }
}
