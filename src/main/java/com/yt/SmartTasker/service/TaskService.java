package com.yt.SmartTasker.service;

import javax.print.DocFlavor.READER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.yt.SmartTasker.dao.TaskDao;
import com.yt.SmartTasker.dto.Task;
import com.yt.SmartTasker.util.ResponseStructure;

@Service
public class TaskService {

	@Autowired
	private TaskDao dao ;
	
	ResponseStructure<Task> structure = new ResponseStructure<>();
	public Task saveTask(Task task) {
		return dao.saveTask(task);
	}
	
	public ResponseEntity<ResponseStructure<Task>> findTask(int id) {
		Task task = dao.findTask(id);
		
		if(task != null) {
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setMessage("Required Task is fetched");
			structure.setData(task);
			
			return new ResponseEntity<ResponseStructure<Task>>(structure , HttpStatus.FOUND);
		}else {
			throw new RuntimeException("Task is not added");
			
		}
	}
	
	public ResponseEntity<ResponseStructure<Task>> deleteTask(int id) {
		Task task = dao.findTask(id);
		
		if(task != null) {
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			structure.setMessage("Task is deleted");
			structure.setData(task);
			
			return new ResponseEntity<ResponseStructure<Task>>(structure , HttpStatus.ACCEPTED);
		}else {
			throw new RuntimeException("Task is not presenet");
			
		}
	}
	
	public ResponseEntity<ResponseStructure<Task>> updateTask(int id ,Task task){
		Task task1 = dao.findTask(id);
		
		if(task1 !=null) {
			task1.setStatus(task.getStatus());
			task1.setDescription(task.getDescription());
			task1.setDuedate(task.getDuedate());
			task1.setCreatedAt(task.getCreatedAt());
			task1.setUser(task.getUser());
			task1.setTitle(task.getTitle());
			
			dao.saveTask(task1);
			
			structure.setData(task1);
			structure.setMessage("Task updated Successfully");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			
			return new ResponseEntity<ResponseStructure<Task>>(structure , HttpStatus.ACCEPTED);
			
		}else {
			throw new RuntimeException("Task is not present");
		}
	}
}
