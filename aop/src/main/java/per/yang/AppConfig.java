package per.yang;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *
 * Created by songbao.yang on 2016/10/15.
 */
@Configuration
@EnableAspectJAutoProxy
// @AspectJ 是一种使用 Java 注解来实现 AOP 的编码风格.
// @AspectJ 风格的 AOP 是 AspectJ Project 在 AspectJ 5 中引入的, 并且 Spring 也支持@AspectJ 的 AOP 风格.
@ComponentScan("per.yang")
public class AppConfig {

}
