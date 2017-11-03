package com.hilla.daniel.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class controller {
	
	private int count = 0;
	
	@ModelAttribute("sessionAttribute")
    public int getSessionAttribute(){
        return count++;
    }

	@RequestMapping("/")
	public String index(Model model, @ModelAttribute("sessionAttribute") int sessionAttribute) {
		model.addAttribute("count", sessionAttribute);
		return "index";
	}
	
	@RequestMapping("/reset")
	public String reset(Model model, @ModelAttribute("sessionAttribute") int sessionAttribute) {
		count = 0;
		return "redirect:/";
	}
}
