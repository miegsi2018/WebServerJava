package com.dai.webServer.Resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dai.webServer.Objects.House;
import com.dai.webServer.Repos.HouseRepository;

@RequestMapping("/")
@RestController
@CrossOrigin(origins = "http://localhost:5000", maxAge = 3600)
public class HouseResources {

	@Autowired
	private HouseRepository houseRepository;
	
	@PostMapping("/house")
	public ResponseEntity<Object> createHouse(@RequestBody House house) {
		
		House savedHouse = houseRepository.save(house);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedHouse.getId_house()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
}
