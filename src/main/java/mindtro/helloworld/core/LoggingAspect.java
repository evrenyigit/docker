package mindtro.helloworld.core;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    //@Before("execution(* mindtro.helloworld.business.MyService.*(..))")
    @Before("@annotation(LogAspect)")
    public void log(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println("Do something methodundan önce logging\n" + System.getProperty("os.name") + "\n" +
                joinPoint.getSignature().getDeclaringTypeName() + "\n" + joinPoint.getSignature().getName() + "\n" +
                joinPoint.getSignature().toShortString() + " \n " + joinPoint.getSignature().toLongString());
        System.out.println("------------------\n");
                for (Object arg:args){
                    System.out.println("Argument :" + arg.toString());
                }
    }

}
