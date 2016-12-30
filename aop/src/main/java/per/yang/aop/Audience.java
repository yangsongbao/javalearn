package per.yang.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 *
 * Created by songbao.yang on 2016/10/15.
 */
@Component
@Aspect
public class Audience {

    @Pointcut("execution(* per.yang.aop.IPerformance.perform(..))")
    public void performance(){}

//    @Before("performance() && args(action)")
//    @Before("within(per.yang.aop.*) && args(action)")
    public void silenceCellPhones(String action){
        System.out.println(action + ": Slience cell phones");
    }
//
//    @Before("performance()")
    public void takeSeats(){
        System.out.println("Taking seats");
    }
//
//    @AfterReturning("performance()")
    public void applause(){
        System.out.println("CLAP CLAP CLAP!!!");
    }
//
//    @AfterThrowing("performance()")
    public void demandRefund(){
        System.out.println("Demanding a refund");
    }

    @Around("performance()" + "&& args(action)")
    public void watchPerformance(ProceedingJoinPoint jp, String action){
        try {
            silenceCellPhones(action);
            takeSeats();
            jp.proceed();
            applause();
        }catch (Throwable e){
            demandRefund();
        }
    }


    @DeclareParents(value = "per.yang.aop.IPerformance+", defaultImpl = DefaultSinger.class)
    public static ISinger singer;
}
