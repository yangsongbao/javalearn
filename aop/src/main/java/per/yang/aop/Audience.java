package per.yang.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 *
 * Created by songbao.yang on 2016/10/15.
 */
@Component
@Aspect
public class Audience {

//    @Pointcut("execution(* per.yang.aop.Performance.perform(String))" + "&& args(action)")
    @Pointcut("execution(* per.yang.aop.Performance.perform(..))")
    public void performance(){}

//    @Before("execution(* per.yang.aop.Performance.perform(..))")
    @Before("performance()")
    public void silenceCellPhones(){
        System.out.println("Slience cell phones");
    }
//
////    @Before("execution(* per.yang.aop.Performance.perform(..))")
//    @Before("performance(String)")
    public void takeSeats(){
        System.out.println("Taking seats");
    }
//
////    @AfterReturning("execution(* per.yang.aop.Performance.perform(..))")
//    @AfterReturning("performance(String)")
    public void applause(){
        System.out.println("CLAP CLAP CLAP!!!");
    }
//
////    @AfterThrowing("execution(* per.yang.aop.Performance.perform(..))")
    @AfterThrowing("performance()")
    public void demandRefund(){
        System.out.println("Demanding a refund");
    }

//    @Around("performance(action)")
    public void watchPerformance(ProceedingJoinPoint jp, String action){
        try {
            silenceCellPhones();
            takeSeats();
            System.out.println(action + action +action);
            jp.proceed();
            applause();
        }catch (Throwable e){
            demandRefund();
        }
    }
}
