package com.springrest.springrest.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.Entities.Courses;

public interface CouurseDao extends JpaRepository<Courses, Long> {
	 boolean existsById(Long id);
//	 Courses findById(Long id);
}
