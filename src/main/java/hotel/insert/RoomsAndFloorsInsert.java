package hotel.insert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import hotel.domain.Floor;
import hotel.domain.Room;
import hotel.service.FloorService;
import hotel.service.RoomService;

public class RoomsAndFloorsInsert {

	public RoomsAndFloorsInsert(){}
	
	public void insert(RoomService roomService, FloorService floorService){
		
		List<Floor> listOfFloors = floorInsert();
		List<Room> listOfRoomsOnOneFloor = roomInsert();
		Set<Room> setOfRoomsOnOneFloor = new HashSet<Room>(0);
	
		setOfRoomsOnOneFloor.addAll(listOfRoomsOnOneFloor);
		Long id = new Long(0);
		
		for(Floor floor:listOfFloors){
			floor.setRooms(setOfRoomsOnOneFloor);
			floorService.save(floor);
			for(Room room:setOfRoomsOnOneFloor){
				room.setId(id);
				room.setFloor(floor);
				roomService.save(room);
				id = id + 1;
			}
		}		
	}
	
	public List<Floor> floorInsert(){
		
		List<Floor> listOfFloors = new ArrayList<Floor>();
		
		Floor floor1 = new Floor("parter","Nie","Nie","Tak","Nie");
		listOfFloors.add(floor1);
		Floor floor2 = new Floor("piêtro pierwsze","Nie","Tak","Nie","Nie");
		listOfFloors.add(floor2);
		Floor floor3 = new Floor("piêtro drugie","Nie","Nie","Nie","Tak");
		listOfFloors.add(floor3);
		Floor floor4 = new Floor("piêtro trzecie","Nie","Nie","Nie","Nie");
		listOfFloors.add(floor4);
		Floor floor5 = new Floor("piêtro czwarte","Nie","Nie","Nie","Tak");
		listOfFloors.add(floor5);
		Floor floor6 = new Floor("piêtro pi¹te","Nie","Nie","Nie","Nie");
		listOfFloors.add(floor6);
		Floor floor7 = new Floor("piêtro szóste","Nie","Nie","Nie","Tak");
		listOfFloors.add(floor7);
		Floor floor8 = new Floor("piêtro siódme","Tak","Nie","Nie","Nie");
		listOfFloors.add(floor8);
		Floor floor9 = new Floor("piêtro ósme","Nie","Nie","Nie","Tak");
		listOfFloors.add(floor9);
		Floor floor10 = new Floor("piêtro dziewi¹te","Tak","Nie","Nie","Nie");
		listOfFloors.add(floor10);
		
		return listOfFloors;
	}
	
	public List<Room> roomInsert(){
		
		List<Room> listOfRoomsOnOneFloor = new ArrayList<Room>();
		
		Room room = new Room("pokój pierwszy","jednoosobowy", 120, "pó³noc");
		listOfRoomsOnOneFloor.add(room);
		Room room1 = new Room("pokój drugi","dwuosobowy", 190, "po³udnie");
		listOfRoomsOnOneFloor.add(room1);
		Room room2 = new Room("pokój trzeci","czteroosobowy", 350, "wschód");
		listOfRoomsOnOneFloor.add(room2);
		Room room3 = new Room("pokój czwarty","trzyosobowy", 240, "zachód");
		listOfRoomsOnOneFloor.add(room3);
		
		return listOfRoomsOnOneFloor;
	}
	
}
