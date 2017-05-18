package hotel.repositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hotel.domain.UserRoles;
import hotel.repository.UserRolesRepository;


@Repository
@Transactional
public class UserRolesRepositoryImpl implements UserRolesRepository {

	@PersistenceContext
	private EntityManager emManager;
	
	public UserRolesRepositoryImpl(){
		
	}
	
	public List<UserRoles> getAllUserRoles() {
		
		 return emManager.createQuery("SELECT u FROM UserRoles u", UserRoles.class).getResultList();
	}

	public void save(UserRoles role) {
		
		emManager.persist(role);
	
	}

	public UserRoles getUserRoleById(Long id) {
		
		return emManager.find(UserRoles.class, id);
	}

}
