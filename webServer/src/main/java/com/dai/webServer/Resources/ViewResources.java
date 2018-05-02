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
		
		return ViewRepository.findThem(email);
	}

	
}
