package com.example.firstapi.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.firstapi.Entity.Student;

public interface Studentrepo extends JpaRepository<Student,Long>{
	

}
