package com.dai.webServer.Utilizador;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository

public interface UtilizadorRepository extends JpaRepository<Utilizador, Long>{


	public Optional<Utilizador> findByEmail(String email);
	
	
}
