package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.IceCream;
import com.revature.service.IceCreamService;

@RestController
public class IceCreamController {

	@Autowired
	private IceCreamService iceCreamService;
	
	@PostMapping(value="/ice-cream", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public IceCream saveIceCream(@RequestBody IceCream iceCream) {
		return iceCreamService.create(iceCream);
	}
	
	@GetMapping(value="/ice-cream", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<IceCream> getAllIceCream() {
		return iceCreamService.getAllIceCream();
	}
	
}
