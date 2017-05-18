package hotel.repository;

import java.util.List;

import hotel.domain.UserRoles;


public interface UserRolesRepository {
	
	public List<UserRoles> getAllUserRoles();
	public void save(UserRoles role);
	public UserRoles getUserRoleById(Long id);
}
