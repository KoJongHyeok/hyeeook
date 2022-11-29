
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect     // AOP 기능을 사용하기 위한 애너테이션
public class LoggingAdvice {    // 부가 기능(advice)으로 사용할 클래스

    @Around("execution(* com.fastcampus.ch3.aop.MyMath.*(..))")     // pointcut : 부가 기능이 적용될 메서드의 패턴
//    @Around("execution(* com.fastcampus.ch3.aop.MyMath.add*(..))")  // pointcut : 부가 기능이 적용될 메서드의 패턴
    public Object methodCalling(ProceedingJoinPoint pjp) throws Throwable {

        long start = System.currentTimeMillis();    // 메서드가 시작된 시간
        System.out.println("<<[start] " + pjp.getSignature().getName() + Arrays.toString(pjp.getArgs()));
        //-----------------여기까지 Before Advice----------------------- 메서드 선언부.메서드 이름 + 매개변수 목록--------------

        Object result = pjp.proceed();  // target의 메서드 호출

        //-----------------여기부터 After Advice-------------------------------------------------------------------------
        System.out.println("result = " + result);
        System.out.println("[end]>> " + (System.currentTimeMillis()-start) + "ms"); // 수행하는데 걸린 시간 계산.
        return result;

    }
}
