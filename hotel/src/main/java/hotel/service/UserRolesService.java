package hotel.service;

import java.util.List;

import hotel.domain.UserRoles;


public interface UserRolesService {

	public List<UserRoles> getAllUserRoles();
	public void save(UserRoles rola);
	public UserRoles getUserRoleById(Long id);
}
