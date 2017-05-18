package hotel.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="User")
@NamedQuery(name = "User.findUser", query = "SELECT u FROM User u WHERE u.username = :username AND u.userRole.id = :id" )
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	 
	
	@Id
	@GeneratedValue
	@Column(name="User_id")
	private Long id;
	@Column(name="password")
	private String password;
	@Column(name="username")
	private String username;
	@Column(name="enabled")
	private String enabled;
	@ManyToOne(targetEntity = UserRoles.class)
	@JoinColumn(name = "User_Role")
	private UserRoles userRole;
	
	
	public User(){}
	
	public User(String password, String username, String enbled, UserRoles userRole) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enbled;
		this.userRole = userRole;
	}
	
	public UserRoles getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRoles userRole) {
		this.userRole = userRole;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enbled) {
		this.enabled = enbled;
	}

	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	

	
	
	
	
}
