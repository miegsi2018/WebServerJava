package com.dai.webServer.Repos;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dai.webServer.Objects.Division;


@Repository

public interface DivisionRepository extends JpaRepository<Division, Long>{


	
}
