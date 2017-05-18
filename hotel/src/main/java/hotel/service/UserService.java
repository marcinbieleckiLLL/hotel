package hotel.service;

import java.util.List;

import hotel.domain.User;
import hotel.domain.UserRoles;



public interface UserService {
	
	public void save(User user);
	public List<User> getAllUsers();
	public User getUserByNameAndUserRole(User user,UserRoles userRole);
	public User getUserById(Long id);
	public void setCurrentUser(User currentUser);
	public User getCurrentUser();
	public void update(User user);
	public User getUserByName(String name);
}
