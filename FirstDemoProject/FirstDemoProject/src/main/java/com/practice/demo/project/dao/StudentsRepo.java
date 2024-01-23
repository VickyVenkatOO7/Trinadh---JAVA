package com.practice.demo.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.practice.demo.project.model.Students;

public interface StudentsRepo extends JpaRepository<Students, Integer>{
	List<Students> findBystdTech(String Tech);
	List<Students> findBystdIdGreaterThan(int stdId);
	
	@Query("from Students where stdTech=?1 order by stdId")
	List<Students> findBystdTechSorted(String stdTech);
	
	@Query("select count(s) from Students s where s.stdTech = ?1")
	long countBystdTech(String stdTech);
}