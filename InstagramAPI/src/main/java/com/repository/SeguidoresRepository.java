package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Seguidores;

@Repository
public interface SeguidoresRepository extends JpaRepository<Seguidores, Long> {
	
	List<Seguidores> findByUserId(long userId);
}
