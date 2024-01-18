package com.practice.demo.project.dao;

import org.springframework.data.repository.CrudRepository;

import com.practice.demo.project.model.Students;

public interface StudentsRepo extends CrudRepository<Students, Integer> {

}
