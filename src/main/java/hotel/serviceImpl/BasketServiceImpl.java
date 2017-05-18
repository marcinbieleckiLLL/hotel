package hotel.serviceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotel.domain.Basket;
import hotel.domain.BasketItem;
import hotel.domain.Floor;
import hotel.domain.Room;
import hotel.domain.User;
import hotel.repository.BasketItemRepository;
import hotel.repository.BasketRepository;
import hotel.repository.FloorRepository;
import hotel.repository.RoomRepository;
import hotel.repository.UserRepository;
import hotel.service.BasketService;
import hotel.service.DataService;

@Service
public class BasketServiceImpl implements BasketService {

	@Autowired
	BasketRepository basketRepository;
	
	@Autowired
	BasketItemRepository basketItemRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	FloorRepository floorRepository;
	
	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	DataService dataService;
	
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

	
	public void createBasketAndBasketItems(String roomName){
		
		try {
		    Thread.sleep(1000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		
		Floor currentFloor = floorRepository.getCurrentFloor();
		User currentUser = userRepository.getCurrentUser();
		Room currentRoom = roomRepository.getRoomByName(roomName, currentFloor);
		
		Basket basketToSave = new Basket(currentUser);
        BasketItem basketItem = new BasketItem(currentRoom);
        
        Set<BasketItem> basketItemList = new HashSet<BasketItem>(); 
        basketItemList.add(basketItem);
		
        basketToSave.setBasketItems(basketItemList);
        basketItem.setBasket(basketToSave);
        currentRoom.setBasketItemList(basketItemList);
			
		basketRepository.save(basketToSave);
		basketItem.setBasket(basketRepository.get(currentUser));
		
		basketItemRepository.save(basketItem);
		
		roomRepository.update(currentRoom);
		
		
	}

	public void deleteBasketAndBasketItems(String roomName) {
		User currentUser = userRepository.getCurrentUser();
		Basket currentBasket = basketRepository.get(currentUser);
		List<BasketItem> basketItemList = basketItemRepository.getBasketItemListByBasket(currentBasket);
		
		for(BasketItem basketItem: basketItemList){
			basketItem.setBasket(null);
			Room currentRoom = roomRepository.getRoomByName(roomName, floorRepository.getCurrentFloor());
			currentRoom.setBasketItemList(null);
			roomRepository.update(currentRoom);
			basketItem.setRoom(null);
			basketItemRepository.update(basketItem);
			
		}
		
		currentBasket.setBasketItems(null);
		basketItemRepository.deleteAllBasketItems();
		basketRepository.daleteBasket(currentUser);
		floorRepository.setCurrentFloor(null);
		roomRepository.deleteAllTemporaryBusyRooms();
		dataService.deleteAllData();
		
	}
	
}
