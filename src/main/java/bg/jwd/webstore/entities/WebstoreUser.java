package bg.jwd.webstore.entities;

import java.io.Serializable;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "WEBSTORE_USER")
public class WebstoreUser implements Serializable {//Задължително Serializable за Entity-та

	private static final long serialVersionUID = 1455960171897295767L;

	@Id
	@Column(name = "ID")
	private long id;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	// TODO: make it char[]
	private String password;

	//@Transient // не пипа полето, може дори да го няма в базата
	@Column(name = "STATUS")
	private String status;

	//За вътрешни системи винаги трябва да се знае кой е направил акаунта на служителя
	@Column(name = "CREATED_BY")
	private long createdBy;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USER_AUTHORITY",
			   joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID") },
			   inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID") })
	private List<Authority> authorities;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}