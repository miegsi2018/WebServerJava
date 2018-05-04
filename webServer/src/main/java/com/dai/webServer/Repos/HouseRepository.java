package com.dai.webServer.Repos;

import org.springframework.data.jpa.repository.JpaRepository;


import com.dai.webServer.Objects.House;

public interface HouseRepository extends JpaRepository<House, Long>{

}
