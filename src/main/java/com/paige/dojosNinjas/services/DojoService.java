package com.paige.dojosNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.paige.dojosNinjas.models.Dojo;
import com.paige.dojosNinjas.models.Ninja;
import com.paige.dojosNinjas.repositories.DojoRepository;
import com.paige.dojosNinjas.repositories.NinjaRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;
	private final NinjaRepository ninjaRepository;
	DojoService(DojoRepository dojoRepository, NinjaRepository ninjaRepository){
		this.dojoRepository = dojoRepository;
		this.ninjaRepository = ninjaRepository;
	}
	
	public List<Dojo> allDojos(){
		return dojoRepository.findAll();
	}
	
	public Dojo create(Dojo dojo) {
		dojoRepository.save(dojo);
		return dojo;
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> optDojo = dojoRepository.findById(id);
		if (optDojo.isPresent()) {
			return optDojo.get();
		}
		else {
			return null;
		}
	}
	
	public List<Ninja> getNinjas(Long DojoId){
		List<Ninja>  ninjas = ninjaRepository.findBydojo_id(DojoId);
		System.out.println(ninjas);
		return ninjas;
		
	}

}
