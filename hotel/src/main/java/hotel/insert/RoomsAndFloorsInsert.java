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
		Floor floor2 = new Floor("pi�tro pierwsze","Nie","Tak","Nie","Nie");
		listOfFloors.add(floor2);
		Floor floor3 = new Floor("pi�tro drugie","Nie","Nie","Nie","Tak");
		listOfFloors.add(floor3);
		Floor floor4 = new Floor("pi�tro trzecie","Nie","Nie","Nie","Nie");
		listOfFloors.add(floor4);
		Floor floor5 = new Floor("pi�tro czwarte","Nie","Nie","Nie","Tak");
		listOfFloors.add(floor5);
		Floor floor6 = new Floor("pi�tro pi�te","Nie","Nie","Nie","Nie");
		listOfFloors.add(floor6);
		Floor floor7 = new Floor("pi�tro sz�ste","Nie","Nie","Nie","Tak");
		listOfFloors.add(floor7);
		Floor floor8 = new Floor("pi�tro si�dme","Tak","Nie","Nie","Nie");
		listOfFloors.add(floor8);
		Floor floor9 = new Floor("pi�tro �sme","Nie","Nie","Nie","Tak");
		listOfFloors.add(floor9);
		Floor floor10 = new Floor("pi�tro dziewi�te","Tak","Nie","Nie","Nie");
		listOfFloors.add(floor10);
		
		return listOfFloors;
	}
	
	public List<Room> roomInsert(){
		
		List<Room> listOfRoomsOnOneFloor = new ArrayList<Room>();
		
		Room room = new Room("pok�j pierwszy","jednoosobowy", 120, "p�noc");
		listOfRoomsOnOneFloor.add(room);
		Room room1 = new Room("pok�j drugi","dwuosobowy", 190, "zach�d");
		listOfRoomsOnOneFloor.add(room1);
		Room room2 = new Room("pok�j trzeci","czteroosobowy", 350, "wsch�d");
		listOfRoomsOnOneFloor.add(room2);
		Room room3 = new Room("pok�j czwarty","trzyosobowy", 240, "zach�d");
		listOfRoomsOnOneFloor.add(room3);
		Room room4 = new Room("pok�j pi�ty","czteroosobowy", 400, "po�udnie");
		listOfRoomsOnOneFloor.add(room4);
		Room room5 = new Room("pok�j sz�sty","dwuosobowy", 200, "p�noc");
		listOfRoomsOnOneFloor.add(room5);
		Room room6 = new Room("pok�j si�dmy","jednoosobowy", 140, "wsch�d");
		listOfRoomsOnOneFloor.add(room6);
		Room room7 = new Room("pok�j �smy","trzyosobowy", 260, "po�udnie");
		listOfRoomsOnOneFloor.add(room7);
		
		return listOfRoomsOnOneFloor;
	}
	
}
