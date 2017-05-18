package hotel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotel.domain.UserRoles;
import hotel.repository.UserRolesRepository;
import hotel.service.UserRolesService;




@Service
public class UserRolesServiceImpl implements UserRolesService {

	@Autowired
	UserRolesRepository userRolesRepository;
	

	public List<UserRoles> getAllUserRoles() {
		return userRolesRepository.getAllUserRoles();
	}

	public void save(UserRoles role) {
		userRolesRepository.save(role);
		
	}

	public UserRoles getUserRoleById(Long id) {
		return userRolesRepository.getUserRoleById(id);
	}

}