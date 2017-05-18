package hotel.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotel.repository.DataRepository;
import hotel.service.DataService;

@Service
public class DataServiceImpl implements DataService {

	@Autowired
	DataRepository dataRepository;
	
	
	public void setQuantityOfDaysAndBreakfasts(String text) {
		dataRepository.setQuantityOfDaysAndBreakfasts(text);
	}

}
