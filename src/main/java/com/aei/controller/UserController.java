package com.aei.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aei.config.Messages;
import com.aei.config.auth.UserImpl;
import com.aei.domain.User;
import com.aei.service.UserService;

import javax.validation.Valid;
import java.util.Locale;

@Controller
@RequestMapping("/user/")
public class UserController {

	private final Messages messages;
	private final UserService userService;

	public UserController(Messages messages, UserService userService) {
		this.messages = messages;
		this.userService = userService;
	}

	@GetMapping("profile")
	public ModelAndView viewProfile(@AuthenticationPrincipal UserImpl activeUser) {
		ModelAndView mav = new ModelAndView("/user/profile");
		mav.addObject("user", userService.getOne(activeUser.getUser()));
		return mav;
	}

	@PostMapping("save")
	public ModelAndView save(@Valid User user, BindingResult bindingResult, RedirectAttributes redirectAttr,
			Locale locale) {

		if (bindingResult.hasErrors()) {
			return new ModelAndView("/user/profile");
		}

		ModelAndView mav = new ModelAndView("redirect:/user/profile");
		mav.addObject("user", userService.save(user));
		redirectAttr.addFlashAttribute("message", messages.get("field.saved")); // mensagem de erro

		return mav;
	}
}
