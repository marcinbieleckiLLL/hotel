package hotel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotel.domain.Basket;
import hotel.domain.BasketItem;
import hotel.repository.BasketItemRepository;
import hotel.service.BasketItemService;

@Service
public class BasketItemServiceImpl implements BasketItemService {

	@Autowired
	BasketItemRepository basketItemRepository;
	
	public void save(BasketItem basketItem) {
		basketItemRepository.save(basketItem);
	}

	public void update(BasketItem basketItem) {
		basketItemRepository.update(basketItem);
	}

	public List<BasketItem> getBasketItemListByBasket(Basket basket) {
		return basketItemRepository.getBasketItemListByBasket(basket);
	}

	public void deleteAllBasketItems() {
		basketItemRepository.deleteAllBasketItems();
	}

}
