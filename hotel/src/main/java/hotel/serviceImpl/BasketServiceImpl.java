package hotel.serviceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotel.domain.Basket;
import hotel.domain.BasketItem;
import hotel.domain.Data;
import hotel.domain.Floor;
import hotel.domain.Room;
import hotel.domain.User;
import hotel.repository.BasketItemRepository;
import hotel.repository.BasketRepository;
import hotel.repository.DataRepository;
import hotel.repository.FloorRepository;
import hotel.repository.RoomRepository;
import hotel.repository.UserRepository;
import hotel.service.BasketItemService;
import hotel.service.BasketService;
import hotel.service.FloorService;
import hotel.service.RoomService;
import hotel.service.UserService;

@Service
public class BasketServiceImpl implements BasketService {

	@Autowired
	BasketRepository basketRepository;
	
	@Autowired
	BasketItemRepository basketItemRepository;
	
	@Autowired
	DataRepository dataRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	FloorRepository floorRepository;
	
	@Autowired
	RoomRepository roomRepository;
	
	
	public void save(Basket basket) {
		 basketRepository.save(basket);
	}

	public List<Basket> getAll() {
		return basketRepository.getAll();
	}

	public Basket get(User user) {
		return basketRepository.get(user);
	}

	public void daleteBasket(User user) {
		basketRepository.daleteBasket(user);
	}

	public void countBasketPrice(Set<BasketItem> basketItemList, Basket basket) {
		basketRepository.countBasketPrice(basketItemList, basket);
	}
	
	public void createBasketAndBasketItems(String roomName){
		Floor currentFloor = floorRepository.getCurrentFloor();
		User currentUser = userRepository.getCurrentUser();
		Room currentRoom = roomRepository.getRoomByName(roomName, currentFloor);
			
		Basket basketToSave = new Basket(currentUser);
        BasketItem basketItem = new BasketItem(currentRoom); 
        Data data = dataRepository.getActualData();
        
        int quantityOfDays = data.getQuantityOfDays();
        int quantityOfBreakfasts = data.getQuantityOfBreakfast();
        int priceForOneDay = currentRoom.getPriceForOneDay();
        
        int basketItemPrice = basketItemRepository.countBasketItemPrice(quantityOfDays, quantityOfBreakfasts, priceForOneDay);
		
        basketItem.setPrice(basketItemPrice);
        basketItem.setData(data);
        
        Set<BasketItem> basketItemList = new HashSet<BasketItem>(); 
        basketItemList.add(basketItem);
        
		
        basketToSave.setBasketItems(basketItemList);
        basketItem.setBasket(basketToSave);
        currentRoom.setBasketItemList(basketItemList);
        data.setBasketItems(basketItemList);
			
		basketRepository.save(basketToSave);
		basketItem.setBasket(basketRepository.get(currentUser));
		
		dataRepository.save(data);
		basketItemRepository.save(basketItem);
		
		roomRepository.update(currentRoom);
		
		
		
	}
	
	
	
	
	
	
}
