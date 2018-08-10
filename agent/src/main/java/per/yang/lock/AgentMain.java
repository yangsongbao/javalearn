package per.yang.lock;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.agent.builder.ResettableClassFileTransformer;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

import java.lang.instrument.Instrumentation;

import static net.bytebuddy.matcher.ElementMatchers.named;
import static net.bytebuddy.matcher.ElementMatchers.none;

/**
 *
 * @author songbao.yang
 * @date 2018/6/3
 */
public class AgentMain {

    public static void agentmain(String arg, Instrumentation inst) {
        System.out.println("~~~~~~~~~~~~~~AgentMain: " + arg);

        AgentBuilder agentBuilder = new AgentBuilder.Default()
                .ignore(none())
                .disableClassFormatChanges()
                .with(AgentBuilder.InitializationStrategy.NoOp.INSTANCE)
                .with(AgentBuilder.RedefinitionStrategy.RETRANSFORMATION);

        AgentBuilder.Identified.Extendable transform = agentBuilder
                .type(ElementMatchers.named("Foo"))
                .transform(new AgentBuilder.Transformer() {
                    @Override
                    public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule) {
                        return builder.visit(Advice.to(MethodTemplate2.class).on(named("hello")));
                    }
                });

        ResettableClassFileTransformer classFileTransformer2 = transform.installOn(inst);

        Publisher.register(new DubboMethodListener());

        inst.removeTransformer(classFileTransformer2);
    }
}
