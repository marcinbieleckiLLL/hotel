package hotel.interceptor;

import java.security.Principal;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Interceptor extends HandlerInterceptorAdapter {

	Logger logger = Logger.getLogger("auditLogger");
	private Principal user;
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		if(request.getRequestURI().endsWith("/floors")){
			user = request.getUserPrincipal();
		}
		return true;
	}
	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,Exception exception) throws Exception{
		if(request.getRequestURI().endsWith("/floors") && response.getStatus() == 302){
			logger.info(String.format("U¿ytkowki [%s] w³aœnie wybra³ piêtro!", user.getName()));
		}
	}
}
