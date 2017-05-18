package hotel.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotel.domain.Data;
import hotel.domain.Room;
import hotel.repository.DataRepository;
import hotel.repository.RoomRepository;
import hotel.service.DataService;

@Service
public class DataServiceImpl implements DataService {

	@Autowired
	DataRepository dataRepository;
	
	
	public void setQuantityOfDaysAndBreakfasts(String text) {
		dataRepository.setQuantityOfDaysAndBreakfasts(text);
	}


	public void countBasketItemPrice(Room currentRoom) {
		dataRepository.countBasketItemPrice(currentRoom);
	}


	public void countWholeBasketPrice() {
		dataRepository.countWholeBasketPrice();
	}


	public void deleteAllData() {
		dataRepository.deleteAllData();
	}

}
