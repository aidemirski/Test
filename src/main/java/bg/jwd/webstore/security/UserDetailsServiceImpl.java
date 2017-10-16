package bg.jwd.webstore.security;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import bg.jwd.webstore.dao.user.WebstoreUserDao;
import bg.jwd.webstore.entities.Authority;
import bg.jwd.webstore.entities.WebstoreUser;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private WebstoreUserDao webstoreUserDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				
		WebstoreUser webstoreUser = webstoreUserDao.getUser(username);
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (Authority authority : webstoreUser.getAuthorities()) {
			authorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
		}
		return new WebstoreUserSecurity(webstoreUser.getUsername(), webstoreUser.getPassword(), authorities);
	}
}