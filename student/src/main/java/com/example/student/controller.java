package com.example.student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
	Map<String,studentinfo> a = new HashMap<>();
	@GetMapping("/users")
	public Collection<studentinfo> getdata()
	{
		return a.values();
	}
	@PostMapping("/data")
	public String postdata(@RequestBody studentinfo user)
	{
		studentinfo add = new studentinfo();
		add.setUserId(user.getUserId());
		add.setName(user.getName());
		add.setEmail(user.getEmail());
		a.put(user.getUserId(), add);
		return "User added successfully";
	}
	@PutMapping(path="/users/{userId}")
	public String putdata(@PathVariable String userId,@RequestBody studentinfo user)
	{
		if(a.containsKey(userId))
		{
			studentinfo add = new studentinfo();
			add.setUserId(user.getUserId());
			add.setName(user.getName());
			add.setEmail(user.getEmail());
			a.put(userId, add);
			return "updated successfully";
		}
		else
		{
			return "userId not found";
		}
	}
	
	@DeleteMapping(path="/users/{userId}")
	public String deletedata(@PathVariable String userId)
	{
		if(a.containsKey(userId))
		{
			a.remove(userId);
			return "deleted successfully";
		}
		else
		{
			return "UserId not found";
		}
	}
	
}


