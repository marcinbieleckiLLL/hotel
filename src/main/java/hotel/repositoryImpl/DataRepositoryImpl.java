package hotel.repositoryImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hotel.domain.Data;
import hotel.domain.Room;
import hotel.repository.DataRepository;

@Repository
@Transactional
public class DataRepositoryImpl implements DataRepository {

	@PersistenceContext
	private EntityManager emManager;
	
	public DataRepositoryImpl(){}
	
	
	
	public void setQuantityOfDaysAndBreakfasts(String text) {
		List<Integer> listOfIndexes = new ArrayList<Integer>();
		
		for(int i=0;i<text.length();i++){
			if(text.charAt(i) != '0'){
				listOfIndexes.add(i);
			}
		}	
		
		int quantityOfDays = Character.getNumericValue(text.charAt(listOfIndexes.get(0)));
		int quantityOfBreakfasts = Character.getNumericValue(text.charAt(listOfIndexes.get(1)));
		Data data = new Data();
		data.setQuantityOfDays(quantityOfDays);
		data.setQuantityOfBreakfast(quantityOfBreakfasts);
		save(data);
		
	}
	
	public void save(Data data){
		emManager.persist(data);
	}


	public Data getActualData() {
		List<Data> listOfAllData = getAll();
		Data toReturn = new Data();
		
		for(Data data:listOfAllData){
			toReturn = data;
		}
		return toReturn;
	}

	public List<Data> getAll(){
		return emManager.createQuery("SELECT d FROM Data d", Data.class).getResultList();
	}

	public void update(Data data) {
		emManager.merge(data);
	}
	
	public void countBasketItemPrice(Room currentRoom){
		int priceConnecetdWithOneData = 0;
		int breakfastPrice = 17;
		int priceForOneDay = currentRoom.getPriceForOneDay();
		
		Data actualData = getActualData();
		
		priceConnecetdWithOneData = breakfastPrice * actualData.getQuantityOfBreakfast() + priceForOneDay*actualData.getQuantityOfDays(); 
		
		actualData.setPriceConnecetdWithOneData(priceConnecetdWithOneData);
		update(actualData);
		
	}



	public void countWholeBasketPrice() {
		int wholePrice = 0;
		Data actualData = getActualData();
		List<Data> listOfAllData = getAll();
		
		for(Data data: listOfAllData){
			wholePrice += data.getPriceConnecetdWithOneData();
		}
		
		actualData.setPriceConnecetdWithWholeBasket(wholePrice);
		update(actualData);
	}



	public void deleteAllData() {
		final Query query = emManager.createQuery("DELETE FROM Data d");
		final int executeUpdate = query.executeUpdate();
	}
	
}