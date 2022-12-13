package com.example.firstapi.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstapi.Entity.Student;
import com.example.firstapi.Repo.Studentrepo;

@RestController
public class firstcontroller {
	
	
	@Autowired
	Studentrepo repo;
	
	@PostMapping("/api/student")
	public ResponseEntity<Student> savedata(@RequestBody Student s)
	{
		return new ResponseEntity<>(repo.save(s),HttpStatus.CREATED);
		
	}
	@GetMapping("/api/student")
	public ResponseEntity<List<Student>> getdata()
	{
		return new ResponseEntity<>(repo.findAll(),HttpStatus.OK);
		
	}
	@GetMapping("/api/student/{id}")
	public ResponseEntity<Student> getsingledata(@PathVariable long id)
	{
		Optional<Student> obj=repo.findById(id);
		if(obj.isPresent())
		{
			return new ResponseEntity<>(obj.get(),HttpStatus.FOUND);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);		
		}
	}
		
		@PutMapping("/api/student/{id}")
		public ResponseEntity<Student> updatedata(@PathVariable long id,@RequestBody Student s)
		{
			Optional<Student> obj=repo.findById(id);
			if(obj.isPresent())
			{
				obj.get().setName(s.getName());
				obj.get().setEmail(s.getEmail());
				
			
				return new ResponseEntity<>(repo.save(obj.get()),HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
				}
			
	}
		@DeleteMapping("/api/student/{id}")
		public ResponseEntity<Student> deletedata(@PathVariable long id)
		{
			Optional<Student> obj=repo.findById(id);
			if(obj.isPresent())
			{
				repo.deleteById(id);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);		
			}
		}
		
	

}
