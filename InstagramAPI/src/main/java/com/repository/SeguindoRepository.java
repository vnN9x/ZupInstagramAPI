package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Seguindo;

@Repository
public interface SeguindoRepository extends JpaRepository<Seguindo, Long> {
	
	List<Seguindo> findByUserId(long userId);
}
