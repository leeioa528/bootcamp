package com.example.bootcamp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:josh@joshlong.com">Josh Long</a>
 */
@Component
@Aspect
class LoggingAspect {

	private final Log log = LogFactory.getLog(getClass());

	/**
	 * '* com.example..* = anything in this package
	 *  '.* = any type and method
	 *  '(..) = any parameters'
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	@Around("execution( * com.example..*.*(..)  )")
	public Object log(ProceedingJoinPoint pjp) throws Throwable {
		this.log.info("before " + pjp.toString());
		//injecting spring in here
		Object object = pjp.proceed();
		this.log.info("after " + pjp.toString());
		//return back to the client
		return object;
	}

}
