package bg.jwd.webstore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.jwd.webstore.dao.user.WebstoreUserDao;
import bg.jwd.webstore.entities.WebstoreUser;

@Service
public class WebstoreUserServiceImpl implements WebstoreUserService {

	@Autowired
	private WebstoreUserDao webstoreUserDao;

	@Override
	public List<WebstoreUser> getUsers(String username, String status) {
		return webstoreUserDao.getUsers(username, status);
	}

	@Override
	public List<WebstoreUser> getUsers() {
		return webstoreUserDao.getUsers();
	}
}