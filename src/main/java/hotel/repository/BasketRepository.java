package hotel.repository;

import java.util.List;
import java.util.Set;

import hotel.domain.Basket;
import hotel.domain.BasketItem;
import hotel.domain.User;

public interface BasketRepository {
	
	public void save(Basket basket);
	public List<Basket> getAll();
	public Basket get(User user);
	public void daleteBasket(User user);
	
}
