package mindtro.helloworld.core;


import com.fasterxml.jackson.databind.annotation.JsonAppend;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j;
import mindtro.helloworld.dataAccess.OperationLogRepository;
import mindtro.helloworld.entity.OperationLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.mapping.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class LoggingAspect {

    //@Before("execution(* mindtro.helloworld.business.MyService.*(..))")
//    @Before("@annotation(LogAspect)")
//    public void log(JoinPoint joinPoint){
//        Object[] args = joinPoint.getArgs();
//        System.out.println("Do something methodundan önce logging\n" + System.getProperty("os.name") + "\n" +
//                joinPoint.getSignature().getDeclaringTypeName() + "\n" + joinPoint.getSignature().getName() + "\n" +
//                joinPoint.getSignature().toShortString() + " \n " + joinPoint.getSignature().toLongString());
//        System.out.println("------------------\n");
//                for (Object arg:args){
//                    System.out.println("Argument :" + arg.toString());
//                }
//

    @Autowired
    private OperationLogRepository operationLogRepository;

    @Autowired
    private HttpServletRequest request;

    @Pointcut("@annotation(LogAspect)")
    private void addOperatingLogPointcut(){

    }

    @AfterReturning(pointcut = "addOperatingLogPointcut()")
    public void addOperatingLog(JoinPoint joinPoint){
            Date date = new Date();
            OperationLog operationLog = new OperationLog();
            operationLog.setPackageName(joinPoint.getSignature().getDeclaringTypeName());
            operationLog.setMethodName(joinPoint.getSignature().getName());
            operationLog.setOperatingSystem(System.getProperty("os.name"));
            operationLog.setClientIP(request.getRemoteAddr());
            operationLog.setClientBrowser(request.getHeader("User-Agent"));
            operationLog.setDate(date);
            operationLogRepository.save(operationLog);
    }

}
