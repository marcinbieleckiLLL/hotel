package hotel.repositoryImpl;

import java.util.ArrayList;
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
	
	public User getUserByNameAndUserRole(User user, UserRoles userRole){
		
		TypedQuery<User> query = emManager.createNamedQuery("User.findUser", User.class);
		query.setParameter("name", user.getUsername());
		query.setParameter("id", userRole.getId());
			
		User result = new User();
		try{
			result = query.getSingleResult();
		}catch(NoResultException exception){
			
		}
		
		return result;
	}

	public User getUserById(Long id) {	
		return emManager.find(User.class, id);
	}

	public void update(User user) {
		emManager.merge(user);		
	}

	public User getUserByName(String name) {
		
		TypedQuery<User> query = emManager.createQuery("SELECT u FROM User u WHERE u.name = :name", User.class);
		query.setParameter("name", name);
		
		return query.getSingleResult();
	}	

}
