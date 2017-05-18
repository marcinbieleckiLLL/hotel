package hotel.service;

import java.util.List;

import hotel.domain.Floor;


public interface FloorService {

	public List<Floor> getAll();
	public void save(Floor floor);
	public void update(Floor floor);
	public Floor getFloorByName(String floorName);
	public Floor getCurrentFloor();
	public void setCurrentFloor(Floor currentFloor);
}
