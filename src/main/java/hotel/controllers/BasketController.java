package hotel.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hotel.domain.Floor;
import hotel.domain.User;
import hotel.repository.DataRepository;
import hotel.service.BasketItemService;
import hotel.service.BasketService;
import hotel.service.DataService;
import hotel.service.FloorService;
import hotel.service.RoomService;
import hotel.service.UserService;

@Controller
public class BasketController {

	@Autowired
	BasketService basketService;
	
	@Autowired
	BasketItemService basketItemService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	FloorService floorService;
	
	@Autowired
	RoomService roomService;
	
	@Autowired 
	DataService dataService;
	
	@Autowired
	DataRepository dataRepository;
	
	String roomName;
	
	
	
	@RequestMapping("/basket/{roomName}")
	public String createBasket(Model model, @PathVariable("roomName") String roomName){
		
		 User currentUser = userService.getCurrentUser();
		 Floor currentFloor = floorService.getCurrentFloor();
		 this.roomName = roomName;
		 
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     String name = auth.getName();  
	     
	     if(currentUser == null){
	           userService.setCurrentUser(userService.getUserByName(name));   
	     }
	    
	     if(currentFloor != null){
	       basketService.createBasketAndBasketItems(roomName);
		}

	    model.addAttribute("basket", basketService.get(currentUser));
	    model.addAttribute("data", dataRepository.getAll());

	    return "basket";
	}
	
	@RequestMapping(value = "/basket/rest/rest",  method = RequestMethod.POST)
	public void deletBasket(){
		basketService.deleteBasketAndBasketItems(this.roomName);
	}
}
