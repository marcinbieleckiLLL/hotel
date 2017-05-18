package hotel.repositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hotel.domain.Basket;
import hotel.domain.BasketItem;
import hotel.domain.Floor;
import hotel.repository.BasketItemRepository;

@Repository
@Transactional
public class BasketItemRepositoryImpl implements BasketItemRepository{

	@PersistenceContext
	private EntityManager emManager;
	
	public BasketItemRepositoryImpl(){}

	public void save(BasketItem basketItem) {
		List<BasketItem> basketItemList = getAll();
		boolean save = true;
		
		if(!basketItemList.isEmpty()){
			for(BasketItem item: basketItemList){
				if(item.getBasket().equals(basketItem.getBasket())){
					if(item.getRoom().equals(basketItem.getRoom())){
						save = false;
					}
				}
			}
		}
		
		if(save){
			emManager.persist(basketItem);
		}
		
	}

	public List<BasketItem> getAll() {
		return emManager.createQuery("SELECT b FROM BasketItem b", BasketItem.class).getResultList();
	}

	public void update(BasketItem basketItem) {
		emManager.merge(basketItem);	
	}

	public List<BasketItem> getBasketItemListByBasket(Basket basket) {
		TypedQuery<BasketItem> query = emManager.createNamedQuery("BasketItem.getBasketItemListByBasket", BasketItem.class);
		query.setParameter("user", basket.getUser());
		return query.getResultList();
	}

	public void deleteAllBasketItems() {
		
		if(emManager == null){
				throw new NullPointerException("emManager null!");
			}else{
				final Query query = emManager.createQuery("DELETE FROM BasketItem b");
				final int executeUpdate = query.executeUpdate();
				
			}
		
	}
}
