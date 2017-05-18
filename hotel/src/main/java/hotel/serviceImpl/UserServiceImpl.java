package hotel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotel.domain.User;
import hotel.domain.UserRoles;
import hotel.repository.UserRepository;
import hotel.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	public void save(User user) {
		userRepository.save(user);
	}

	public List<User> getAllUsers() {
		return userRepository.getAllUsers();
	}
	
	public User getUserByNameAndUserRole(User user, UserRoles userRole){
		return userRepository.getUserByNameAndUserRole(user, userRole);
	}

	public User getUserById(Long id) {
		return userRepository.getUserById(id);
	}

	public void setCurrentUser(User currentUser) {
		userRepository.setCurrentUser(currentUser);
		
	}

	public User getCurrentUser() {
		return userRepository.getCurrentUser();
	}

	public void update(User user) {
		userRepository.update(user);
	}

	public User getUserByName(String name) {
		return userRepository.getUserByName(name);
	}

}
