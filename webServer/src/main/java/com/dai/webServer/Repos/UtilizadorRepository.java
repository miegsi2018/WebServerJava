package com.dai.webServer.Repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dai.webServer.Objects.Utilizador;

import java.util.Optional;

@Repository

public interface UtilizadorRepository extends JpaRepository<Utilizador, Long>{


	public Optional<Utilizador> findByEmail(String email);
	
	
}
