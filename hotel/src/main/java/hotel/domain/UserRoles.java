package hotel.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="UserRoles")
@Table(name="UserRoles")
public class UserRoles implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="UserRole_id")
	private Long id;
	@OneToMany(mappedBy="userRole")
	private Set<User> users = new HashSet<User>(0);
	@Column(name="role")
	private String role;
	
	
	
	public UserRoles(){}
	
	public UserRoles(String role) {
		super();
		
		this.role = role;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<User> getUsers() {
		return this.users;
	}
	public void setUsers(Set<User> listaUzytkownikow) {
		this.users = listaUzytkownikow;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String rola) {
		this.role = rola;
	}

	
	
}
	
