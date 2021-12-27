package com.paige.dojosNinjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.paige.dojosNinjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	List<Ninja> findAll();
	List<Ninja> findBydojo_id(Long dojoId);
	
}
