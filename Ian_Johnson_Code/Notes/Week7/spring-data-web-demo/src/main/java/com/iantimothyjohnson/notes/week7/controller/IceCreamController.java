package com.iantimothyjohnson.notes.week7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iantimothyjohnson.notes.week7.model.IceCream;
import com.iantimothyjohnson.notes.week7.service.IceCreamService;

@RestController
@RequestMapping("/ice-cream")
public class IceCreamController {
	@Autowired
	private IceCreamService iceCreamService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<IceCream> getIceCream() {
		return iceCreamService.findAll();
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public IceCream createIceCream(@RequestBody IceCream iceCream) {
		return iceCreamService.create(iceCream);
	}
}
