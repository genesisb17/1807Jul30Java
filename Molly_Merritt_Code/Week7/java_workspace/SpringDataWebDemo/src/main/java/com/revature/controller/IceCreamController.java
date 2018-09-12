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

@RestController	// because we're not returning views
public class IceCreamController {
	
	@Autowired
	private IceCreamService iceCreamService;
	
	@PostMapping(value="/ice-cream", consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	// RequestMapping but the method is equal to POST
	public IceCream saveIceCream(@RequestBody IceCream iceCream) {
		return iceCreamService.create(iceCream);
	}
	
	@GetMapping(value="/ice-cream", produces=MediaType.APPLICATION_JSON_VALUE)
	// could type "application/json" instead of MediaType.APPLICATION_JSON_VALUE, but want to avoid typos
	public List<IceCream> getAllIceCream() {
		return iceCreamService.getAllIceCream();
	}

}
