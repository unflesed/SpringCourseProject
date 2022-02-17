package courseProject.aspects;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import static java.lang.System.out;

public class Logger {
    private ApplicationContext applicationContext;

    public void beforeMethodInvocation(JoinPoint joinPoint) {
        out.println("*********************************************");
        out.println("Log : before "+ joinPoint.getKind() + " " + joinPoint.getSignature().toShortString() + ". ");
        out.println("Log : " + joinPoint.getTarget().toString());
        out.println("*********************************************");
    }

    public void afterReturn(JoinPoint joinPoint, Object result) {
        out.println(joinPoint.getSignature().getName() + " method of " + joinPoint.getTarget().toString() + " was invoked!");
        out.println("Result of method execution : " + result);
        out.println("***********************************");
        out.println("**  successful method invocation  *");
        out.println("***********************************");
    }

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
