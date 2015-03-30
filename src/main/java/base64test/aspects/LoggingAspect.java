package base64test.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@AfterReturning(value = "execution(public * base64test.*Validator.is*(..))", returning = "returnValue")
	public void implLogging(JoinPoint joinPoint, Object returnValue) {
		logger.info(joinPoint.getTarget().getClass() +"; Method: " + joinPoint.getSignature().getName() + "(); " + returnValue);
	}
	
	@AfterReturning(value = "execution(public * base64test.*Validator.decode(*)) && args(argumentString)", returning = "returnValue")
	public void implLogging2(JoinPoint joinPoint, String argumentString, Object returnValue) {
		logger.info("{}; Method: {}(); base64 string: [{}] decoded string: [{}]", 
					joinPoint.getTarget().getClass(), joinPoint.getSignature().getName(), argumentString, returnValue);
	}

	private String createJoinPointTraceName(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		StringBuilder sb = new StringBuilder();
		sb.append(signature.getDeclaringType().getSimpleName());
		sb.append('.').append(signature.getName());
		return sb.toString();
	} 
}