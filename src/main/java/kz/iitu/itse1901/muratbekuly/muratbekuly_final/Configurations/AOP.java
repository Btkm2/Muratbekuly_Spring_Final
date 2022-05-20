package kz.iitu.itse1901.muratbekuly.muratbekuly_final.Configurations;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.Logger;

@Aspect
@EnableAspectJAutoProxy
@Component
public class AOP {
    @Pointcut("execution(public * kz.iitu.itse1901.muratbekuly.muratbekuly_final.Services.UserService.find*(..))")
    public void findAll(){}

    @Before("findAll()")
    public void BeforeCallMyMethod(JoinPoint jp){
        System.out.println("Message before " + jp.getSignature().getName());
    }

    @After("findAll()")
    public void AfterCallMyMethod(JoinPoint jp){
        System.out.println("Message after " + jp.getSignature().getName());
    }

    @Around("findAll()")
    public Object AroundCallMyMethod(ProceedingJoinPoint pjp) throws Throwable{
//        System.out.println("Message around " + pjp.getSignature().getName());
//        try {
//            return pjp.proceed(pjp.getArgs());
//        } catch (Throwable) {
//            Logger log = null;
//            log.error(e.getMessage(), e);
//
//        }
        System.out.println("Message before working around method");
        Object object = pjp.proceed();
        System.out.println("Message after working around method");
        return object;
    }

    @AfterReturning("findAll()")
    public void AfterReturningCallMyMethod(JoinPoint jp){
        System.out.println("Message after returning " + jp.getSignature().getName());
    }

    @AfterThrowing("findAll()")
    public void AfterThrowingCallMyMethod(JoinPoint jp){
        System.out.println("Message after throwing " + jp.getSignature().getName());
    }
}
