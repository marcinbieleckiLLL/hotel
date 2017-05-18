package hotel.service;

import hotel.domain.Room;

public interface DataService {
	public void setQuantityOfDaysAndBreakfasts(String text);
	public void countBasketItemPrice(Room currentRoom);
	public void countWholeBasketPrice();
	public void deleteAllData();
}
