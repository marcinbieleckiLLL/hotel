package hotel.repository;

import java.util.List;

import hotel.domain.Floor;


public interface FloorRepository {

	public List<Floor> getAll();
	public void save(Floor floor);
	public void update(Floor floor);
	public Floor getFlorByName(String floorName);
	public Floor getCurrentFloor();
	public void setCurrentFloor(Floor currentFloor);
}
