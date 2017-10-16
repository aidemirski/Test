package bg.jwd.webstore.controllers;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.webstore.constants.UrlConstants;
import bg.jwd.webstore.dto.UserSearch;

import bg.jwd.webstore.service.WebstoreUserService;
import bg.jwd.webstore.utils.UserUtils;


@Controller
public class UserController {
	
	@Autowired
	private WebstoreUserService webstoreUserService;

	@RequestMapping(value = UrlConstants.USER_REGISTER_URL, method = RequestMethod.GET)
	public String getWebstoreUsers(Model model, @ModelAttribute("UserSearch") UserSearch userSearch) {
				
		model.addAttribute("webstoreUsers", webstoreUserService.getUsers(userSearch.getUsername(), userSearch.getStatus()));
		model.addAttribute("userRegisterUrl", UrlConstants.USER_REGISTER_URL);
		model.addAttribute("addWebstoreUserUrl", UrlConstants.ADD_USER_URL);
		model.addAttribute("user", UserUtils.getUser());

		return "users";
	}
	
	@RequestMapping(value = UrlConstants.ADD_USER_URL, method = RequestMethod.GET)
	public String addWebstoreUsers(Model model, @ModelAttribute("UserSearch") UserSearch userSearch) {
				
		model.addAttribute("webstoreUsers", webstoreUserService.getUsers(userSearch.getUsername(), userSearch.getStatus()));
		model.addAttribute("userRegisterUrl", UrlConstants.USER_REGISTER_URL);
		model.addAttribute("addWebstoreUserUrl", UrlConstants.ADD_USER_URL);
		model.addAttribute("user", UserUtils.getUser());

		return "users";
	}
}
