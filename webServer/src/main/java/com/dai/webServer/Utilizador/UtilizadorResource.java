package com.dai.webServer.Utilizador;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class UtilizadorResource {
	
	@Autowired
	private UtilizadorRepository utilizadorRepository;

	@GetMapping("/utilizador")
	public List<Utilizador> retrieveAllUsers() {
		return utilizadorRepository.findAll();
	}

	@GetMapping("/utilizador/{id}")
	public Utilizador retrieveUser(@PathVariable long id) {
		Optional<Utilizador> utilizador = utilizadorRepository.findById(id);

		if (!utilizador.isPresent())
			throw new UtilizadorNotFoundException("id-" + id);

		return utilizador.get();
	}
	//IDK tho
	@PostMapping("/login")

	public String verifyUser(@RequestBody Utilizador utilizador) {
		
	String email = utilizador.getEmail();
	String password = utilizador.getPassword();	
	
	
		return email;
	
	
	
	
	
	}
	
public Utilizador findByEmail(long email) {
		Optional<Utilizador> utilizador = utilizadorRepository.findById(email);

		if (!utilizador.isPresent())
			throw new UtilizadorNotFoundException("email-" + email);

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
	}

}

