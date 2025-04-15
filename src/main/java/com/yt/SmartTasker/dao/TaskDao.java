package com.yt.SmartTasker.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yt.SmartTasker.dto.Task;
import com.yt.SmartTasker.repository.TaskRepository;

@Repository
public class TaskDao {

	@Autowired
	private TaskRepository taskRepository;
	
	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}
	
	public Task findTask(int id) {
		return taskRepository.findTask(id);
	}
	
	public void deleteTask(int id) {
		taskRepository.deleteById(id);
	}
	
	public Task updateTask(Task task) {
		return taskRepository.save(task);
	}
}
