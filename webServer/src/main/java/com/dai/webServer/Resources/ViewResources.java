package com.dai.webServer.Resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dai.webServer.Objects.View;
import com.dai.webServer.Repos.ViewRepository;


@CrossOrigin(origins = "http://localhost:5000", maxAge = 3600)
@RequestMapping("/")
@RestController
public class ViewResources {
	
	@Autowired
	private ViewRepository ViewRepository;

	
	@GetMapping("/view/{email}")
	public List<View> getViews(@PathVariable String email) {
		
		return ViewRepository.findAll();
	}



		
	/*
	//IDK tho
	@PostMapping("/login")

	public Utilizador verifyUser(@RequestBody Utilizador utilizador) {
		
	String email = utilizador.getEmail();
	String password = utilizador.getPassword();	
	
	
	Utilizador returned = findUserByEmail(email);
	String passBase = returned.getPassword();
	
return returned;	
	
	
	}


	@PostMapping("/mail")

	public Utilizador getUser(@RequestBody Utilizador utilizador) {
		
	String email = utilizador.getEmail();
	
	
	Utilizador returned = findUserByEmail(email);
	
		return returned;	
	
	
	}	
	
	
	
	
public Utilizador findUserByEmail(String email) {
		
		Optional<Utilizador> utilizador = utilizadorRepository.findByEmail(email);

		if (!utilizador.isPresent())
			throw new UtilizadorNotFoundException("id-" + email);

		return utilizador.get();
	


} 
	@DeleteMapping("/utilizador/{id}")
	public void deleteUser(@PathVariable long id) {
		utilizadorRepository.deleteById(id);
	}

	@PostMapping("/utilizador")
	public ResponseEntity<Object> createUser(@RequestBody Utilizador utilizador) {
		Utilizador savedUser = utilizadorRepository.save(utilizador);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId_utilizador()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/utilizador/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody Utilizador utilizador, @PathVariable long id) {

		Optional<Utilizador> userOptional = utilizadorRepository.findById(id);

		if (!userOptional.isPresent())
			return ResponseEntity.notFound().build();

		utilizador.setId_utilizador(id);
		
		utilizadorRepository.save(utilizador);

		return ResponseEntity.noContent().build();
	}*/

}
