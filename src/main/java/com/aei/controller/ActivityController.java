package com.aei.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aei.config.Messages;
import com.aei.domain.Activity;
import com.aei.service.ActivityService;

import lombok.Data;

@Controller
@Data
@RequestMapping("/activity")
public class ActivityController {

	private final ActivityService activityService;

	private final Messages messages;
	public ActivityController(Messages messages, ActivityService activityService) {

		this.messages = messages;
		this.activityService = activityService;
	}

	// TODO RNG013 - CdU004 **Solicitado pelo professor para ser implementado
	@GetMapping("/lista")
	public String listActivity(Model model) {
		model.addAttribute("activityList", activityService.listAll());
		return "/activity/lista";
	}

	// TODO RNG014 - CdU004 **Solicitado pelo professor para ser implementado
	@GetMapping("/new")
	public String newActivity(Model model) {
		model.addAttribute("activity", new Activity());
		model.addAttribute("contents", activityService.contentList());
		return "/activity/form";
	}

	// TODO RNG014 - CdU004 **Solicitado pelo professor para ser implementado
	@PostMapping("save")
	public ModelAndView save(@Valid Activity activity, BindingResult bindingResult, RedirectAttributes redirectAttr,
			Locale locale) {

		if (bindingResult.hasErrors()) {
			return new ModelAndView("/activity/lista");
		}

		ModelAndView mav = new ModelAndView("redirect:/activity/lista");
		mav.addObject("activity", activityService.save(activity));
		redirectAttr.addFlashAttribute("message", messages.get("field.saved")); // mensagem de erro

		return mav;
	}


	// TODO RNG015 - CdU004 **Solicitado pelo professor para ser implementado
	@GetMapping("/edit/{id}")
	public String editActivity(Model model, @PathVariable Long id) {
		model.addAttribute("activity", activityService.find(id));
		return "/activity/form";
	}

	// TODO RNG016 - CdU004 **Solicitado pelo professor para ser implementado
	@GetMapping("/delete/{id}")
	public String deleteActivity(Model model, @PathVariable Long id) {
		activityService.delete(id);
		return "redirect:/activity/lista";
	}

}