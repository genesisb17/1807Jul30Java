package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.IceCream;
import com.example.repository.IceCreamRepository;

@Service
public class IceCreamService {

	@Autowired
	private IceCreamRepository iceCreamRepository;
	
	public IceCream create(IceCream iceCream) {
		return iceCreamRepository.save(iceCream);
	}
	
	public IceCream getIceCream(String flavor) {
		return iceCreamRepository.findById(flavor).get();
	}

	public List<IceCream> getAllIceCream() {
		return iceCreamRepository.findAll();
	}
	
	
}