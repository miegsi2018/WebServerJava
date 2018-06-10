package com.dai.webServer.Repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.dai.webServer.Objects.House;

public interface HouseRepository extends JpaRepository<House, Long>{
	
	public Optional<House> findById(Long id_house);

}
