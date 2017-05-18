package hotel.service;

import java.util.List;

import hotel.domain.Basket;
import hotel.domain.BasketItem;

public interface BasketItemService {

	public void save(BasketItem basketItem);
	public void update(BasketItem basketItem);
	public List<BasketItem> getBasketItemListByBasket(Basket basket);
	public void deleteAllBasketItems();
	
}
