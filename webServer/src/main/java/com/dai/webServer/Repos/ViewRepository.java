package com.dai.webServer.Repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dai.webServer.Objects.View;

import java.util.List;
import java.util.Optional;

@Repository

public interface ViewRepository extends JpaRepository<View, Long>{


	public List<View> findThem(String email);
	
	
}
