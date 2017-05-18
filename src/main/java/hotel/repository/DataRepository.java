package hotel.repository;

import java.util.List;
import java.util.Set;

import hotel.domain.BasketItem;
import hotel.domain.Data;
import hotel.domain.Room;

public interface DataRepository {
	public void setQuantityOfDaysAndBreakfasts(String text);
	public void save(Data data);
	public void update(Data data);
	public Data getActualData();
	public List<Data> getAll();
	public void countBasketItemPrice(Room currentRoom);
	public void countWholeBasketPrice();
	public void deleteAllData();
}
