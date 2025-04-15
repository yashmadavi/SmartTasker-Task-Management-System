package com.yt.SmartTasker.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yt.SmartTasker.dto.AssignTask;
import com.yt.SmartTasker.dto.Task;
import com.yt.SmartTasker.dto.User;
import com.yt.SmartTasker.repository.UserRepository;
import com.yt.SmartTasker.service.TaskService;
import com.yt.SmartTasker.service.UserService;
import com.yt.SmartTasker.util.ResponseStructure;

@RestController
public class Controller {

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/saveUser")
	public User saveUser(@RequestBody User user ) {
		return userService.saveUser(user);
	}
	
	@PostMapping("/saveTask")
	public Task saveTask(@RequestBody Task task) {
		return taskService.saveTask(task);
	}
	
	@GetMapping("/findUser/{id}")
	public ResponseEntity<ResponseStructure<User>> findUser(@PathVariable int id) {
		return userService.findUser(id);
	}
	
	@GetMapping("/findTask/{id}")
	public ResponseEntity<ResponseStructure<Task>> findTask(@PathVariable int id) {
		return taskService.findTask(id);
		}
	
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<ResponseStructure<User>> deleteUser(@PathVariable int id) {
		 return userService.deleteUser(id);
	}
	
	@DeleteMapping("/deleteTask/{id}")
	public ResponseEntity<ResponseStructure<Task>> deleteTask(@PathVariable int id){
		return taskService.deleteTask(id);
	}
	
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<ResponseStructure<User>> updateUser(@PathVariable int id,@RequestBody User user){
		return userService.updateUser(id, user);
	}
	
	@PutMapping("/updateTask/{id}")
	public ResponseEntity<ResponseStructure<Task>> updateTask(@PathVariable int id , @RequestBody Task task){
		return taskService.updateTask(id ,task);
	}
	@PostMapping("/assignTask")
	public Task assignTaskToUser(@RequestBody AssignTask assignTask) {
		User user = userService.getUserById(assignTask.getUserId());
		
		if (user == null) {
	        throw new RuntimeException("User not found with ID: " + assignTask.getUserId());
	    }

	    Task task = new Task();
	    task.setTitle(assignTask.getTitle());
	    task.setDescription(assignTask.getDescription());
	    task.setStatus(assignTask.getStatus());
	    task.setDuedate(assignTask.getDueDate());
	    task.setCreatedAt(LocalDateTime.now());
	    task.setUser(user);

	    return taskService.saveTask(task);
	}
	
	@PostMapping("/loginUser")
	public ResponseEntity<ResponseStructure<User>> loginUser(@RequestBody User user){
		return userService.loginUser(user);
	}
}
