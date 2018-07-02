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
import com.aei.domain.Content;
import com.aei.service.ContentService;

import lombok.Data;

@Controller
@Data
@RequestMapping("/content")
public class ContentController {

	private final Messages messages;
	private final ContentService contentService;

	public ContentController(Messages messages, ContentService contentService) {

		this.messages = messages;
		this.contentService = contentService;
	}
	
	// TODO RNG009 - CdU003
	@GetMapping("/lista")
	public String listContent(Model model) {
		model.addAttribute("contentList", contentService.listAll());
		return "/content/lista";
	}

	// TODO RNG010 - CdU003
	@GetMapping("/new")
	public String newContent(Model model) {
		model.addAttribute("content", new Content());
		model.addAttribute("disciplines", contentService.disciplineList());
		return "/content/form";
	}
	
	// TODO RNG010 - CdU003
	@PostMapping("save")
	public ModelAndView save(@Valid Content content, BindingResult bindingResult, RedirectAttributes redirectAttr,
			Locale locale) {

		if (bindingResult.hasErrors()) {
			return new ModelAndView("/content/lista");
		}

		ModelAndView mav = new ModelAndView("redirect:/content/lista");
		mav.addObject("content", contentService.save(content));
		redirectAttr.addFlashAttribute("message", messages.get("field.saved")); // mensagem de erro

		return mav;
	}

	// TODO RNG011 - CdU003
	@GetMapping("/edit/{id}")
	public String editContent(Model model, @PathVariable Long id) {
		model.addAttribute("content", contentService.find(id));
		return "/content/form";
	}

	// TODO RNG012 - CdU003
	@GetMapping("/delete/{id}")
	public String deleteContent(Model model, @PathVariable Long id) {
		contentService.delete(id);
		return "redirect:/content/lista";
	}
}