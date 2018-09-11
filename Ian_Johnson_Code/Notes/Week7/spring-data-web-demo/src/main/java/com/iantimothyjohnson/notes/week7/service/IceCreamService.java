package com.iantimothyjohnson.notes.week7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iantimothyjohnson.notes.week7.model.IceCream;
import com.iantimothyjohnson.notes.week7.repository.IceCreamRepository;

@Service
public class IceCreamService {
	@Autowired
	private IceCreamRepository iceCreamRepository;
	
	public List<IceCream> findAll() {
		return iceCreamRepository.findAll();
	}
	
	public IceCream create(IceCream iceCream) {
		return iceCreamRepository.save(iceCream);
	}
}
