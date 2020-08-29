package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Img;

@Repository
public interface ImgRepository extends JpaRepository<Img, Long>{
	
	List<Img> findByUserId(long userId);
}
