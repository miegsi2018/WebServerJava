package com.dai.webServer.View;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface ViewRepository extends JpaRepository<View, Long>{


	public List<View> findThem(String email);
	
	
}
