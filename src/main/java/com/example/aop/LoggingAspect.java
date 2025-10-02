package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Before advice - executes before the method execution
    @Before("execution(* com.example.aop.UserService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("[BEFORE] Executing: " + joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            System.out.println("[BEFORE] Method arguments: ");
            for (int i = 0; i < args.length; i++) {
                System.out.println("  arg[" + i + "]: " + args[i]);
            }
        }
    }

    // After advice - executes after the method execution (regardless of outcome)
    @After("execution(* com.example.aop.UserService.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("[AFTER] Completed: " + joinPoint.getSignature().getName());
    }

    // AfterReturning advice - executes after successful method execution
    @AfterReturning(
        pointcut = "execution(* com.example.aop.UserService.*(..))",
        returning = "result"
    )
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("[AFTER RETURNING] Method: " + joinPoint.getSignature().getName());
        if (result != null) {
            System.out.println("[AFTER RETURNING] Return value: " + result);
        }
    }

    // AfterThrowing advice - executes if method throws an exception
    @AfterThrowing(
        pointcut = "execution(* com.example.aop.UserService.*(..))",
        throwing = "exception"
    )
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        System.out.println("[AFTER THROWING] Method: " + joinPoint.getSignature().getName());
        System.out.println("[AFTER THROWING] Exception: " + exception.getMessage());
    }

    // Around advice - can control method execution
    @Around("execution(* com.example.aop.UserService.getUserById(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        
        System.out.println("[AROUND - START] Method: " + joinPoint.getSignature().getName());
        
        Object result = joinPoint.proceed(); // Execute the actual method
        
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        
        System.out.println("[AROUND - END] Method: " + joinPoint.getSignature().getName());
        System.out.println("[AROUND - END] Execution time: " + executionTime + "ms");
        
        return result;
    }
}
