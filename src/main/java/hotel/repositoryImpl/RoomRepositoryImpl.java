package hotel.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hotel.domain.Floor;
import hotel.domain.Room;
import hotel.domain.User;
import hotel.repository.RoomRepository;


@Repository
@Transactional
public class RoomRepositoryImpl implements RoomRepository {

	@PersistenceContext
	private EntityManager emManager;
	
	private Room currentRoom;
	
	
	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

	public List<Room> getAll() {
		return emManager.createQuery("SELECT r FROM Room r", Room.class).getResultList();
	}

	public void save(Room roomToSave) {
		List<Room> listOfAllRooms = getAll();
		boolean save = true;
		
		for(Room room: listOfAllRooms){
			if(room != null){
				if(room.getName().equals(roomToSave.getName())){
					if(roomToSave.getFloor().getName().equals(room.getFloor().getName())){
						save = false;
					}
				}
			}
		}
		
		if(save)
			emManager.persist(roomToSave);
	}
	
	
	public void update(Room room) {
		emManager.merge(room);
	}

	public List<Room> getAllRoomsFromOneFloor(Floor floor) {
		List<Room> listOfAllRooms = getAll();
		List<Room> listOfRoomsOnOurFloor = new ArrayList<Room>();
		
		for(Room room:listOfAllRooms){
			if(room.getFloor().equals(floor)){
				listOfRoomsOnOurFloor.add(room);
			}
		}
		return listOfRoomsOnOurFloor;
	}

	public Room getRoomByName(String name,Floor floor) {
		TypedQuery<Room> query = emManager.createNamedQuery("Room.getRoomByName", Room.class);
		query.setParameter("name", name);
		List<Room> listOfRoomsOnOneFloor = query.getResultList();
		Room roomToReturn = new Room();
		
		for(Room room: listOfRoomsOnOneFloor){
			if(room.getFloor().equals(floor)){
				roomToReturn = room;
			}
		}
		
		return roomToReturn;
	}

	public void changeAvailability(Room room, String availability) {
		room.setAvailability(availability);
		update(room);
	}

	public void changeDaysToBeEmpty(Room room, int quantityOfDays) {
		room.setDaysToBeEmpty(quantityOfDays);
		update(room);
	}

	public void deleteAllTemporaryBusyRooms() {
		List<Room> listOfAllRooms = getAll();
		List<Room> listOfTemporaryBusyRooms = new ArrayList<Room>();
		
		for(Room room: listOfAllRooms){
			if(room.getAvailability().equals("chwilowoZajete")){
				listOfTemporaryBusyRooms.add(room);
			}
		}
		
		for(Room room: listOfTemporaryBusyRooms){
			room.setAvailability("wolne");
			update(room);
		}
	}

}