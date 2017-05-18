package hotel.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import hotel.service.UserRolesService;
import hotel.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

@Controller
@SessionAttributes("UserRoles") 
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRolesService userRolesService;
	
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
