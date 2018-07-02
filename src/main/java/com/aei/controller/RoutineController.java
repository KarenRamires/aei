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
import com.aei.domain.Routine;
import com.aei.service.RoutineService;

import lombok.Data;

@Controller
@Data
@RequestMapping("/routine")
public class RoutineController {

	private final Messages messages;
	private final RoutineService routineService;

	public RoutineController(Messages messages, RoutineService routineService) {

		this.messages = messages;
		this.routineService = routineService;
	}

	@GetMapping("/lista")
	public String listRoutine(Model model) {
		model.addAttribute("routineList", routineService.listAll());
		return "/routine/lista";
	}

	@GetMapping("/new")
	public String newRoutine(Model model) {
		model.addAttribute("routine", new Routine());
		model.addAttribute("activitys", routineService.activityList());
		return "/routine/form";
	}

	@PostMapping("save")
	public ModelAndView save(@Valid Routine routine, BindingResult bindingResult, RedirectAttributes redirectAttr,
			Locale locale) {

		if (bindingResult.hasErrors()) {
			return new ModelAndView("/routine/lista");
		}

		ModelAndView mav = new ModelAndView("redirect:/routine/lista");
		mav.addObject("routine", routineService.save(routine));
		redirectAttr.addFlashAttribute("message", messages.get("field.saved")); // mensagem de erro

		return mav;
	}

	@GetMapping("/edit/{id}")
	public String editRoutine(Model model, @PathVariable Long id) {
		model.addAttribute("routine", routineService.find(id));
		return "/routine/form";
	}

	@GetMapping("/delete/{id}")
	public String deleteRoutine(Model model, @PathVariable Long id) {
		routineService.delete(id);
		return "redirect:/routine/lista";
	}

}