package task.handler;

import static java.util.stream.Collectors.joining;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import lombok.extern.slf4j.Slf4j;
import task.exception.ValidCustomException;
import task.util.JsonUtils;

@Component
@Aspect
@Slf4j
public class GlobalAspectHandler {

//    @Before("execution(* task..*.*(..))")
//    public void before(JoinPoint joinPoint) {
//        Signature signature = joinPoint.getSignature();
//        log.info("call method before :: {}", signature.getName());
//    }

    @Around("within(task.controller.*)")
    public Object logBefore(ProceedingJoinPoint point) throws Throwable {
        Object resultVal = point.proceed();

        long start = System.currentTimeMillis();
        long processTime = System.currentTimeMillis() - start;

        Object[] params = point.getArgs();

        String paramMessage = Arrays.stream(params).map(JsonUtils::toJson).collect(joining(", "));

        log.info("---------------------------------------------------------------------------------------------------------------------------");
        log.info("Processing Time({}) : {} ms", point.getSignature().toShortString(), processTime);
        log.info("Param : {}", paramMessage);
        log.info("Result : {}", JsonUtils.toJson(resultVal));
        log.info("---------------------------------------------------------------------------------------------------------------------------");

        return resultVal;
    }

//    @After("execution(* task..*.*(..))")
//    public void after(JoinPoint joinPoint) {
//        Signature signature = joinPoint.getSignature();
//        log.info("call method after :: {}", signature.getName());
//    }
}
