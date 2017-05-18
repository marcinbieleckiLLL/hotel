package hotel.repository;

import java.util.List;

import hotel.domain.Basket;
import hotel.domain.BasketItem;


public interface BasketItemRepository {

	public void save(BasketItem basketItem);
	public void update(BasketItem basketItem);
	public List<BasketItem> getBasketItemListByBasket(Basket basket);
	public void deleteAllBasketItems();
	
}
