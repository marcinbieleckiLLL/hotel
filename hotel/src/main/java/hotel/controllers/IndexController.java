package hotel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String start(Model model){
		return "index";
	}
	
}
