package com.paige.dojosNinjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.paige.dojosNinjas.models.Ninja;
import com.paige.dojosNinjas.services.DojoService;
import com.paige.dojosNinjas.services.NinjaService;


@Controller
public class NinjaController {
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	
	public  NinjaController(NinjaService ninjaService, DojoService dojoService){
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
	

	@RequestMapping("/ninja/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "newNinja.jsp";
	}
	
    @RequestMapping(value="/ninja/save", method=RequestMethod.POST)
    public String saveNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
    		if(result.hasErrors()) {
    			return "newNinja.jsp";
    		}
    		else {
    			ninjaService.create(ninja);
    			return "redirect:/dojo/" + ninja.getDojo().getId();
    		}
    }
}
