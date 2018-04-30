package com.dai.webServer.Repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dai.webServer.Objects.Analytics;

public interface AnalyticsRepository extends JpaRepository<Analytics, Long>{


	public Optional<Analytics> findById(String id);

}
