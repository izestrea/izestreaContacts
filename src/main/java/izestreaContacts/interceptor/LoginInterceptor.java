package izestreaContacts.interceptor;

/**
 * The LoginInterceptor is a Spring interceptor that has the same behavior of a JEE Filter, but it can receive Spring injected objects
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import izestreaContacts.model.User;
import izestreaContacts.service.UserService;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private UserService userService;

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");
		if (user == null) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String email = auth.getName();
			user = userService.findByEmail(email);
			session.setAttribute("user", user);
		}

		return super.preHandle(request, response, handler);
	}
}
