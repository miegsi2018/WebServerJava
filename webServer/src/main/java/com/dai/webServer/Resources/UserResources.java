package com.dai.webServer.Resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import com.dai.webServer.Mqtt.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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

import com.dai.webServer.Exceptions.PasswordErrorException;
import com.dai.webServer.Exceptions.UtilizadorNotFoundException;
import com.dai.webServer.Objects.User;
import com.dai.webServer.Repos.UtilizadorRepository;


@CrossOrigin(origins = "http://localhost:5000", maxAge = 3600)
@RequestMapping("/")
@RestController
public class UserResources {
	
	@Autowired
	private UtilizadorRepository utilizadorRepository;

	@GetMapping("/utilizador")
	public List<User> retrieveAllUsers() {
		return utilizadorRepository.findAll();
	}
	
	/* Metodo get invocado pelo web site onde o mesmo envia o id do utilizador 
	 * e o java devolve todos os dados do utilizador com esse id */

	@GetMapping("/utilizador/{id}")
	public User retrieveUser(@PathVariable long id) {
		Optional<User> utilizador = utilizadorRepository.findById(id);

		if (!utilizador.isPresent())
			throw new UtilizadorNotFoundException("id-" + id);

		return utilizador.get();
	}
	
	/* Metodo post invocado pelo web site onde o mesmo envia o o email e password do utilizador 
	 * e o java verifica se o email e pass correspondem a user valido e envia para o 
	 * web site a respota ao pedido de login */
	
	@PostMapping("/login")
	public User verifyUser(@RequestBody User utilizador) {
		
	String email = utilizador.getEmail();
	String password = utilizador.getPassword();	
	
	
	User returned = findUserByEmail(email);

	String emailBase = returned.getEmail();
	String passBase  = returned.getPassword();

	if(password.equals(passBase)){

		return returned;	
	}else{
	
		throw new PasswordErrorException("401"); 
	}	
	
	}

	/* Metodo post invocado pelo web site onde o mesmo envia o email do utilizador 
	 * e o java devolve todos os dados do utilizador associados a esse email */
	
	@PostMapping("/mail")

	public User getUser(@RequestBody User utilizador) {
		
	String email = utilizador.getEmail();
	
	
	User returned = findUserByEmail(email);
	
		return returned;	
	
	
	}	
	
	public User findUserByEmail(String email) {
			
			Optional<User> utilizador = utilizadorRepository.findByEmail(email);
	
			if (!utilizador.isPresent())
				throw new UtilizadorNotFoundException("id-" + email);
	
			return utilizador.get();
		
	}
	
	
	/* Metodo delete invocado pelo web site onde o mesmo envia o id do utilizador 
	 * e o java apaga o utilizador associados a esse id */
	
	@DeleteMapping("/utilizador/{id}")
	public void deleteUser(@PathVariable long id) {
		utilizadorRepository.deleteById(id);
	}

	/* Metodo post invocado pelo web site onde o mesmo envia todos os daddos do utilizador 
	 * e o java adicionar o utilizador associados a bd */
	
	@PostMapping("/utilizador")
	public ResponseEntity<Object> createUser(@RequestBody User utilizador) {
		
		String mailReturned = utilizador.getEmail();


		Optional<User> exist = utilizadorRepository.findByEmail(mailReturned);
		if (exist.isPresent()){

		System.out.println("not");

		return  null;

		}
		System.out.println("It kind of worked");

		User savedUser = utilizadorRepository.save(utilizador);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId_user()).toUri();
		
		return ResponseEntity.created(location).build();
	
	}
	

	/* Metodo post invocado pelo web site onde o mesmo envia a cor da luz pretendida 
	 * e o java faz parser a mensagem recebida invoca o metodo sendMessage enviado para ele
	 * o topic, rgb e id e altera a luz via mqtt */
	
	@PostMapping("/changeLight")
	public void createUser(@RequestBody String light) throws ParseException {

		
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(light);
	       /*   */
		/* Object dataF = jsonObject.get("id"); */

		String topic = (String) jsonObject.get("topic");
		
		String message = (String) jsonObject.get("message");
		
		Publisher pub = new Publisher();	
		System.out.println(topic);
		System.out.println(message);
		
		String correctedTopic = "request/"  + topic;
		pub.sendMessage(correctedTopic , message ,"lightChange");	

	}


	/* Metodo put invocado pelo web site onde o mesmo envia os dados do utilizador que serão
	 * alterados e o java faz a alteração na bd*/
	
	@PutMapping("/utilizador/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody User utilizador, @PathVariable long id) {

		Optional<User> userOptional = utilizadorRepository.findById(id);

		if (!userOptional.isPresent())
			return ResponseEntity.notFound().build();

		utilizador.setId_user(id);
		
		utilizadorRepository.save(utilizador);

		return ResponseEntity.noContent().build();
	}

}

