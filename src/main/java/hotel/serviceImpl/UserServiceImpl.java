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

	public void setCurrentUser(User currentUser) {
		userRepository.setCurrentUser(currentUser);
		
	}

	public User getCurrentUser() {
		return userRepository.getCurrentUser();
	}

	public User getUserByName(String name) {
		return userRepository.getUserByName(name);
	}

}
