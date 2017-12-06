package lipe.rocks.login.controller;

import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lipe.rocks.login.domain.User;
import lipe.rocks.login.service.UserService;

@Controller
public class NavigationController {

	private UserService userService;

	public NavigationController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping({ "", "/" })
	public String index(Model model, Authentication authentication) {
		if (authentication != null && authentication.isAuthenticated()) {
			User user = userService.getUserByName(authentication.getName());
			model.addAttribute("user", user);
		} else {
			return "redirect:/login";
		}
		return "index";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@PostMapping("/login")
	public String login() {
		return "redirect:/";
	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping(path = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String register(User userForm) {
		User user = userService.save(userForm);

		Model model = new ExtendedModelMap();
		model.addAttribute("user", user);

		return "redirect:/";
	}

}
