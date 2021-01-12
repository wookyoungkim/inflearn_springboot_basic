package hello.hellospirng.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAOP {

    //이 공통 관심사항을 어디에 타겟팅할건지???
    @Around("execution(* hello.hellospirng..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("start= " + joinPoint.toString());
        try{
            return joinPoint.proceed();
            //다음 로직의 진행
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("end= " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
