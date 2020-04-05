package cn.shenjunjie.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Junjie.Shen
 * @version 1.0
 * @date 2020/4/5 18:51
 */
@Component
@Aspect
public class MyAspect {

	@Pointcut("execution(* cn.shenjunjie.spring.entity.BService.*(..))")
	public void pointCut() {

	}

	@Before("pointCut()")
	public void doBefore() {
		System.out.println("before~~~~~");
	}


	@Around("pointCut()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("切面环绕记录下日志");
		System.out.println("当前方法:" + pjp.getSignature().getName());
		Object[] args = pjp.getArgs();
		Object result = pjp.proceed(args);
		System.out.println("当前执行结果:" + result);
		return result;
	}
}
