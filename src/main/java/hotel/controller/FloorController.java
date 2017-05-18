package hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import hotel.insert.RoomsAndFloorsInsert;
import hotel.service.FloorService;
import hotel.service.RoomService;


@Controller
@SessionAttributes("Floor")
public class FloorController {

	@Autowired 
	FloorService floorService;
	
	@Autowired 
	RoomService roomService;
	
	@RequestMapping("/floors")
	public String start(Model model){
		
		RoomsAndFloorsInsert insert = new RoomsAndFloorsInsert();
		insert.insert(roomService,floorService);
		
		model.addAttribute("floors", floorService.getAll());		
		return "floors";
	}
	
}
