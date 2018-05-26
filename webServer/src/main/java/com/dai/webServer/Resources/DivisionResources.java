package com.dai.webServer.Resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import org.json.simple.JSONObject;
import com.dai.webServer.Exceptions.DivisionNotFoundException;
import com.dai.webServer.Objects.Division;
import com.dai.webServer.Objects.House;
import com.dai.webServer.Repos.DivisionRepository;


@RequestMapping("/")
@RestController
@CrossOrigin(origins = "http://localhost:5000", maxAge = 3600)
public class DivisionResources {
	
	@Autowired
	private DivisionRepository divisionRepository;
	
	//listar todas as divisoes
	@GetMapping("/division")
	public List<Division> retrieveAllHouse() {
		return divisionRepository.findAll();
	}
	
	//listar divisao por id
	@GetMapping("/division/{id}")
	public Division retrieveDivision(@PathVariable long id) {
		System.out.println("shit");
		Optional<Division> division = divisionRepository.findById(id);
		
		if (!division.isPresent())
			throw new DivisionNotFoundException("id-" + id);

		return division.get();
	}
	
	//Criar Divisao
	@PostMapping("/division")
	public ResponseEntity<Object> createDivision(@RequestBody Division division) {
		
		Division savedDivision = divisionRepository.save(division);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedDivision.getId_division()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	//Alterar dados da divisao
	@PutMapping("/division/{id}")
	public ResponseEntity<Object> updateDivision(@RequestBody Division division, @PathVariable long id) {

		Optional<Division> divisionOptional = divisionRepository.findById(id);

		if (!divisionOptional.isPresent())
			return ResponseEntity.notFound().build();

		division.setId_division(id);
		
		divisionRepository.save(division);

		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/rfidAdd")
	public String addRFID(@RequestBody JSONObject json) {

		
		return "fds já está";
		
	}
}
