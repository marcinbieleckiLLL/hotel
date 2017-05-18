package hotel.repositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hotel.domain.User;
import hotel.domain.UserRoles;
import hotel.repository.UserRepository;




@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository{

	@PersistenceContext
	private EntityManager emManager;
	private User currentUser;
	
	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		if(this.currentUser == null)
			this.currentUser = currentUser;
	}

	public UserRepositoryImpl(){
		
	}
	
	public void save(User user){
		List<User> listOfUsers = getAllUsers();
		boolean save = true;
		
		for(User u: listOfUsers){
			if(u.getUsername() == user.getUsername()){
				save = false;
			}
		}
		if(save){
			emManager.persist(user);
		}
	}
	

	public List<User> getAllUsers() {
		
		 return emManager.createQuery("SELECT u FROM User u", User.class).getResultList();
	}


	public User getUserByName(String name) {
		
		TypedQuery<User> query = emManager.createQuery("SELECT u FROM User u WHERE u.name = :name", User.class);
		query.setParameter("name", name);
		
		return query.getSingleResult();
	}	

}
