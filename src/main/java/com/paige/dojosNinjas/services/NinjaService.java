package com.paige.dojosNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.paige.dojosNinjas.models.Ninja;
import com.paige.dojosNinjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;
	NinjaService(NinjaRepository ninjaRepository){
		this.ninjaRepository = ninjaRepository;
	}
	
	public List<Ninja> allNinjas(){
		return ninjaRepository.findAll();
	}
	
	public Ninja create(Ninja ninja) {
		ninjaRepository.save(ninja);
		return ninja;
	}
	
	public Ninja findNinja(Long id) {
		Optional<Ninja> optNinja = ninjaRepository.findById(id);
		if (optNinja.isPresent()) {
			return optNinja.get();
		}
		else {
			return null;
		}
	}

}
