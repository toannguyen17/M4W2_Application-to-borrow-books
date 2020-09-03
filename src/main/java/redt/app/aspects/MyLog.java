package redt.app.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLog {
    @AfterThrowing(pointcut = "within(redt.app.controller.HomeController)", throwing="exception")
    public void log(JoinPoint joinPoint, Throwable exception){
        System.out.println("-------------------------------------");
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println(className + "." + methodName);
        System.out.println("Exception= " + exception);
    }

    @AfterReturning(pointcut = "within(redt.app.controller.HomeController)")
    public void log(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        if (methodName.equals("index") || methodName.equals("getMyBooks"))
            return;

        System.out.println("-------------------------------------");
        System.out.println(className + "." + methodName);
        for(Object obj: joinPoint.getArgs()){
            System.out.println(obj);
        }
    }
}
