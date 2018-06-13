package com.dai.webServer.Repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dai.webServer.Objects.User;

import java.util.Optional;

@Repository

public interface UtilizadorRepository extends JpaRepository<User, Long>{


	public Optional<User> findByEmail(String email);
	
	
}
