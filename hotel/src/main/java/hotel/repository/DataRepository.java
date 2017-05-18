package hotel.repository;

import hotel.domain.Data;

public interface DataRepository {
	public void setQuantityOfDaysAndBreakfasts(String text);
	public Data getActualData();
	public void save(Data data);
	public void update(Data data);
}
