package bg.jwd.webstore.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import bg.jwd.webstore.security.WebstoreUserSecurity;

public class UserUtils {

	private UserUtils() {
	}

	public static WebstoreUserSecurity getUser() {
		Object principal;

		try {
			principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (NullPointerException e) {
			return null;
		}

		if (principal == null || !(principal instanceof WebstoreUserSecurity)) {
			return null;
		}

		return (WebstoreUserSecurity) principal;
	}
}