package hotel.repositoryImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hotel.domain.Basket;
import hotel.domain.BasketItem;
import hotel.domain.User;
import hotel.repository.BasketRepository;

@Repository
@Transactional
public class BasketRepositoryImpl implements BasketRepository{

	@PersistenceContext
	private EntityManager emManager;
	
	public BasketRepositoryImpl(){}

	
	public void save(Basket basketToSave) {
		List<Basket> listOfAllBaskets = getAll();
		boolean save = true;
		
		for(Basket basket: listOfAllBaskets){
			if(basketToSave.getUser().equals(basket.getUser())){
				save = false;
			}
		}
		
		if(save){
			emManager.persist(basketToSave);
		}	
	}
	
		
	public List<Basket> getAll() {	
		return emManager.createQuery("SELECT b FROM Basket b", Basket.class).getResultList();
	}

	
	public Basket get(User user) {
		List<Basket> listOfAllBaskets = getAll();
		Basket basketToReturn = new Basket();
		
		for(Basket basket:listOfAllBaskets){
			if(basket.getUser() != null){
				if(basket.getUser().equals(user)){
					basketToReturn = basket;
				}
			}
		}
		return basketToReturn;
	}

	
	public void daleteBasket(User user) throws NullPointerException{
		if(user != null){
			if(emManager != null){
				final Query query = emManager.createNamedQuery("Basket.deleteBasket");
				query.setParameter("id", user.getId());
				final int executeUpdate = query.executeUpdate();
			}else{
				throw new NullPointerException("emManager = null");
			}
		}else{
			throw new NullPointerException("Podany u¿ytkownik nie istnieje");
		}
	}
	
}
