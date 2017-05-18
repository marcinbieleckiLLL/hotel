package hotel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hotel.domain.Room;
import hotel.service.BasketService;
import hotel.service.RoomService;

@Controller
public class EndController {

	@Autowired
	BasketService basketService;
	
	@Autowired
	RoomService roomService;
	
	@RequestMapping("/end")
	public String koniec(Model model){
		Room currentRoom = roomService.getCurrentRoom();
		basketService.deleteBasketAndBasketItems(currentRoom.getName());
		roomService.changeAvailability(currentRoom, "zajete");
		
		return "end";
	}
}
