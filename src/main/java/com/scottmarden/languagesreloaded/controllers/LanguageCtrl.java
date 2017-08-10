package com.scottmarden.languagesreloaded.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scottmarden.languagesreloaded.models.Language;
import com.scottmarden.languagesreloaded.services.LanguageService;

@Controller
public class LanguageCtrl {
	
	private final LanguageService languageService;
	public LanguageCtrl(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping(value="/")
	public String index(Model model, @ModelAttribute("newLanguage") Language newLanguage) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
	@PostMapping(value="/language/new")
	public String createLanguage(@Valid @ModelAttribute("newLanguage") Language newLanguage, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}else {
			languageService.addLanguage(newLanguage);
			return "redirect:/";
		}
		
	}
	
	@RequestMapping(value="/language/{id}")
	public String findLanguageByIndex(Model model, @PathVariable("id") Long id) {
		Language language = languageService.findLanguageById(id);
		model.addAttribute("language", language);
		return "showLanguage.jsp";
	}
	
	@RequestMapping(value="/language/update/{id}")
	public String editLanguage(Model model, @PathVariable("id") Long id) {
		Language language = languageService.findLanguageById(id);
		if(language != null) {
			model.addAttribute("language", language);
			return "editLanguage.jsp";
		}else {
			return "redirect:/";
		}
	}
	
	@PostMapping(value="/language/update/{id}")
	public String updateLanguage(@PathVariable("id") Long id, @Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "editLanguage.jsp";
		}else {
			languageService.updateLanguage(language);
			return "redirect:/language/{id}";
		}
	}
	
	@RequestMapping(value="/language/delete/{id}")
	public String deleteLanguage(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/";
	}
	
}
