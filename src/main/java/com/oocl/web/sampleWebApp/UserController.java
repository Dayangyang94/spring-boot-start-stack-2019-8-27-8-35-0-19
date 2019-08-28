package com.oocl.web.sampleWebApp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	private List<User> users=new ArrayList<User>() {
	{
		add(new User("xiaoliu"));
	}};
	@GetMapping
	public ResponseEntity<List<User>> getUser(){
		return ResponseEntity.ok(users);
	}
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user){
		users.add(user);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
