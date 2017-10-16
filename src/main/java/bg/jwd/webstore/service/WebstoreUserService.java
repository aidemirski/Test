package bg.jwd.webstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bg.jwd.webstore.entities.WebstoreUser;

@Service
public interface WebstoreUserService {
	List<WebstoreUser> getUsers();
	List<WebstoreUser> getUsers(String username, String status);
	
}
