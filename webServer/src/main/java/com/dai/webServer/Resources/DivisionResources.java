package com.dai.webServer.Resources;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dai.webServer.Exceptions.UtilizadorNotFoundException;
import com.dai.webServer.Objects.Division;
import com.dai.webServer.Objects.User;
import com.dai.webServer.Repos.DivisionRepository;
import com.dai.webServer.Repos.UtilizadorRepository;

@CrossOrigin(origins = "http://localhost:5000", maxAge = 3600)
public class DivisionResources {
	
	@Autowired
	private DivisionRepository divisionRepository;
	
	@GetMapping("/division/{id}")
	public Division retrieveDivision(@PathVariable long id) {
		Optional<Division> division = divisionRepository.findById(id);

		if (!division.isPresent())
			throw new UtilizadorNotFoundException("id-" + id);

		return division.get();
	}
	
	@PostMapping("/division")
	public ResponseEntity<Object> createDivision(@RequestBody Division division) {
		
		Division savedDivision = divisionRepository.save(division);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedDivision.getId_division()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
}
