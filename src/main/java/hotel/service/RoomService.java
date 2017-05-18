package hotel.service;

import java.util.List;

import hotel.domain.Floor;
import hotel.domain.Room;

public interface RoomService {

	public List<Room> getAll();
	public List<Room> getAllRoomsFromOneFloor(Floor floor);
	public void save(Room room);
	public void update(Room room);
	public Room getRoomByName(String name, Floor floor);
	public void changeAvailability(Room room, String availability);
	public void changeDaysToBeEmpty(Room room, int quantityOfDays);
	public void deleteAllTemporaryBusyRooms();
	public Room getCurrentRoom();
	public void setCurrentRoom(Room currentRoom);
}
