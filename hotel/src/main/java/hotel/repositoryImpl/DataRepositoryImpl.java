package hotel.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hotel.domain.Data;
import hotel.domain.Floor;
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
			if(text.charAt(i) != '1'){
				listOfIndexes.add(i);
			}
		}
		char znak = text.charAt(listOfIndexes.get(0));
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
		List<Data> listOfAllData = emManager.createQuery("SELECT d FROM Data d", Data.class).getResultList();
		Data toReturn = new Data();
		
		for(Data data:listOfAllData){
			toReturn = data;
		}
		return toReturn;
	}


	public void update(Data data) {
		emManager.merge(data);
	}
	
}
