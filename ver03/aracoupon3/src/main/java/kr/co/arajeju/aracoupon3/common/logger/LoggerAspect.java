package kr.co.arajeju.aracoupon3.common.logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggerAspect {
	
	protected Log log = LogFactory.getLog(LoggerAspect.class);
	
	static String name = "";
	static String type = "";

	@Around("execution(* kr.co.arajeju.aracoupon3.controller.*Controller.*(..)) or "
			+ "execution(* kr.co.arajeju.aracoupon3.service.*Impl.*(..)) or "
			+ "execution(* kr.co.arajeju.aracoupon3.dao.*DAO.*(..))")
	public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable {
		type = joinPoint.getSignature().getDeclaringTypeName();

		if (type.indexOf("Controller") > -1) {
			name = "Controller";
		} else if (type.indexOf("Service") > -1) {
			name = "Service";
		} else if (type.indexOf("DAO") > -1) {
			name = "DAO";
		} else {
			name = "???";
		}
		if (log.isDebugEnabled()) {
			log.debug("KANG-20190312: LoggerAspect... [" + name + "] -> " + type + ". " + joinPoint.getSignature().getName() + "(...);");
		}
		return joinPoint.proceed();
	}
}