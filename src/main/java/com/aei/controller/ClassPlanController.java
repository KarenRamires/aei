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
import com.aei.domain.ClassPlan;
import com.aei.service.ClassPlanService;

import lombok.Data;

@Controller
@Data
@RequestMapping("/classPlan")
public class ClassPlanController {

	private final Messages messages;
	private final ClassPlanService classPlanService;

	public ClassPlanController(Messages messages, ClassPlanService classPlanService) {

		this.messages = messages;
		this.classPlanService = classPlanService;
	}

	// TODO RNG018 - CdU005
	@GetMapping("/lista")
	public String listClassPlan(Model model) {
		model.addAttribute("classPlanList", classPlanService.listAll());
		return "/classPlan/lista";
	}

	// TODO RNG019 - CdU005
	@GetMapping("/new")
	public String newClassPlan(Model model) {
		model.addAttribute("classPlan", new ClassPlan());
		model.addAttribute("routines", classPlanService.routineList());
		return "/classPlan/form";
	}

	// TODO RNG019 - CdU005
	@PostMapping("save")
	public ModelAndView save(@Valid ClassPlan classPlan, BindingResult bindingResult, RedirectAttributes redirectAttr,
			Locale locale) {

		if (bindingResult.hasErrors()) {
			return new ModelAndView("/classPlan/lista");
		}

		ModelAndView mav = new ModelAndView("redirect:/classPlan/lista");
		mav.addObject("classPlan", classPlanService.save(classPlan));
		redirectAttr.addFlashAttribute("message", messages.get("field.saved")); // mensagem de erro

		return mav;
	}

	// TODO RNG020 - CdU005
	@GetMapping("/edit/{id}")
	public String editClassPlan(Model model, @PathVariable Long id) {
		model.addAttribute("classPlan", classPlanService.find(id));
		return "/classPlan/form";
	}

	// TODO RNG021 - CdU005
	@GetMapping("/delete/{id}")
	public String deleteClassPlan(Model model, @PathVariable Long id) {
		classPlanService.delete(id);
		return "redirect:/classPlan/lista";
	}
	
	@GetMapping("/details/{id}")
	public String detailsClassPlan(Model model, @PathVariable("id") Long id) {
		model.addAttribute("classPlan", classPlanService.find(id));
		return "/classPlan/details";
	}
}