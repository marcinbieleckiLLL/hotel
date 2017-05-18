package hotel.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotel.domain.Floor;
import hotel.repository.FloorRepository;
import hotel.service.FloorService;


@Service
public class FloorServiceImpl implements FloorService {

	@Autowired
	FloorRepository floorRepository;
	
	public List<Floor> getAll() {
		return floorRepository.getAll();
	}

	public void save(Floor floor) {
		floorRepository.save(floor);
	}

	public void update(Floor floor) {
		floorRepository.update(floor);
	}

	public Floor getFloorByName(String floorName) {
		return floorRepository.getFlorByName(floorName);
	}

	public Floor getCurrentFloor() {
		return floorRepository.getCurrentFloor();
	}

	public void setCurrentFloor(Floor currentFloor) {
		floorRepository.setCurrentFloor(currentFloor);
	}

}
