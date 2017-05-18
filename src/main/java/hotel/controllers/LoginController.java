package hotel.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("UserRoles") 
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String Login(Model model){		
		return "login";
	}
	
	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String LoginFailed(Model model){	
		model.addAttribute("error" , "true");
		return "login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String Logout(Model model){	
		return "login";
	}
	
}
