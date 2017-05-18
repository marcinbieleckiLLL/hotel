package hotel.repository;

import java.util.List;

import hotel.domain.User;
import hotel.domain.UserRoles;



public interface UserRepository {
	
	
	public void save(User user);
	public List<User> getAllUsers();
	public void setCurrentUser(User currentUser);
	public User getCurrentUser();
	public User getUserByName(String name);
	
}
