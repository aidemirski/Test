package bg.jwd.webstore.dao.user;

import java.util.List;
import bg.jwd.webstore.entities.WebstoreUser;

public interface WebstoreUserDao {
	WebstoreUser getUser(String username);
	List<WebstoreUser> getUsers();
	List<WebstoreUser> getUsers(String username, String status);
	
}