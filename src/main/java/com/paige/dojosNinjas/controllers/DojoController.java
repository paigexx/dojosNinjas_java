package com.paige.dojosNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.paige.dojosNinjas.models.Dojo;
import com.paige.dojosNinjas.models.Ninja;
import com.paige.dojosNinjas.services.DojoService;
import com.paige.dojosNinjas.services.NinjaService;

@Controller
public class DojoController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	public DojoController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	@RequestMapping("/")
	public String main(Model model) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "index.jsp";
	}
	
	
	@RequestMapping("/dojo/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	
    @RequestMapping(value="/dojo/save", method=RequestMethod.POST)
    public String saveDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
    	if (result.hasErrors()) {
    		return "newDojo.jsp";
    	}
    	else {
    		dojoService.create(dojo);
    		return "redirect:/";
    	}
    }
	
	@RequestMapping("/dojo/{id}")
	public String showNinjas(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoService.findDojo(id));
		model.addAttribute("ninjas", dojoService.getNinjas(id));
		return "showNinjas.jsp";
	}
	
	@RequestMapping("/ninjas")
	public String allNinjas(Model model) {
		List<Ninja> ninjas = ninjaService.allNinjas();
		model.addAttribute("ninjas", ninjas);
		return "allninjas.jsp";
	}
	
	@RequestMapping("/dojos")
	public String alldojos(Model model) {
		 List<Dojo> dojos = dojoService.allDojos();
		 model.addAttribute("dojos", dojos);
		 return "alldojos.jsp";
				 
	}
}
