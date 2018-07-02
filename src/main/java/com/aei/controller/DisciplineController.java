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
import com.aei.domain.Discipline;
import com.aei.service.DisciplineService;

import lombok.Data;

@Controller
@Data
@RequestMapping("/discipline")
public class DisciplineController {

	private final Messages messages;
	private final DisciplineService disciplineService;

	public DisciplineController(Messages messages, DisciplineService disciplineService) {

		this.messages = messages;
		this.disciplineService = disciplineService;
	}

	// TODO RNG001 - CdU001
	@GetMapping("/lista")
	public String listDiscipline(Model model) {
		model.addAttribute("disciplineList", disciplineService.listAll());
		return "/discipline/lista";
	}

	// TODO RNG002 - CdU001
	@GetMapping("/new")
	public String newDiscipline(Model model) {
		model.addAttribute("discipline", new Discipline());
		return "/discipline/form";
	}

	// TODO RNG002 - CdU001
	@PostMapping("save")
	public ModelAndView save(@Valid Discipline discipline, BindingResult bindingResult, RedirectAttributes redirectAttr,
			Locale locale) {

		if (bindingResult.hasErrors()) {
			return new ModelAndView("/discipline/lista");
		}

		ModelAndView mav = new ModelAndView("redirect:/discipline/lista");
		mav.addObject("discipline", disciplineService.save(discipline));
		redirectAttr.addFlashAttribute("message", messages.get("field.saved")); // mensagem de erro

		return mav;
	}

	// TODO RNG003 - CdU001
	@GetMapping("/edit/{id}")
	public String editDiscipline(Model model, @PathVariable Long id) {
		model.addAttribute("discipline", disciplineService.find(id));
		return "/discipline/form";
	}

	// TODO RNG004 - CdU001
	@GetMapping("/delete/{id}")
	public String deleteDiscipline(Model model, @PathVariable Long id) {
		disciplineService.delete(id);
		return "redirect:/discipline/lista";
	}
}