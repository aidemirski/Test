package bg.jwd.webstore.entities;


//@Entity
//@Table(name = "USER_AUTHORITY")
public class UserAuthority {

	private WebstoreUser user;
	private Authority authority;

	public WebstoreUser getUser() {
		return user;
	}

	public void setUser(WebstoreUser user) {
		this.user = user;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
}
