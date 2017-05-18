package hotel.repositoryImpl;

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
	
	public UserRolesRepositoryImpl(){}
	
	public void save(UserRoles role) {	
		emManager.persist(role);
	}
}
