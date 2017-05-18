package hotel.service;

import java.util.List;
import java.util.Set;

import hotel.domain.Basket;
import hotel.domain.BasketItem;
import hotel.domain.User;

public interface BasketService {

	public void save(Basket basket);
	//public void updateBasket(Basket basket);
	public List<Basket> getAll();
	public Basket get(User user);
	public void daleteBasket(User user);
	public void countBasketPrice(Set<BasketItem> basketItemList, Basket basket);
	public void createBasketAndBasketItems(String roomName);
	
}
