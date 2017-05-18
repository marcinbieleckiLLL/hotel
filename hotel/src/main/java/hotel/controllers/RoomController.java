package hotel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import hotel.domain.Basket;
import hotel.domain.Floor;
import hotel.domain.rest.Data;
import hotel.service.BasketItemService;
import hotel.service.BasketService;
import hotel.service.DataService;
import hotel.service.FloorService;
import hotel.service.RoomService;
import hotel.service.UserService;

@Controller
@SessionAttributes("Room")
public class RoomController{

	@Autowired
	RoomService roomService;
	
	@Autowired
	FloorService floorService;
	
	@Autowired
	DataService dataService;
	
	@Autowired
	BasketService basketService;
	
	@Autowired
	BasketItemService basketItemService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/floors/{floorName}")
	public String start(Model model, @PathVariable("floorName") String floorName){
		
		Floor currentFloor = floorService.getFloorByName(floorName);
		floorService.setCurrentFloor(currentFloor);
		model.addAttribute("rooms", roomService.getAllRoomsFromOneFloor(currentFloor));
		
		return "rooms";
	}
	
	@RequestMapping(value = "/room/rest",  method = RequestMethod.POST, consumes = {"application/json"})
	public void data(@RequestBody Data request){
		
		String text = request.getText();
		dataService.setQuantityOfDaysAndBreakfasts(text);
		
		
	}
}
