package hotel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotel.domain.Floor;
import hotel.domain.Room;
import hotel.repository.RoomRepository;
import hotel.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomRepository roomRepository;
	
	public List<Room> getAll() {
		return roomRepository.getAll();
	}

	public List<Room> getAllRoomsFromOneFloor(Floor floor) {
		return roomRepository.getAllRoomsFromOneFloor(floor);
	}

	public void save(Room room) {
		roomRepository.save(room);
	}

	public void update(Room room) {
		roomRepository.update(room);
	}

	public Room getRoomByName(String name, Floor floor) {
		return roomRepository.getRoomByName(name, floor);
	}

}
