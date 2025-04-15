package com.yt.SmartTasker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yt.SmartTasker.dto.Task;

public interface TaskRepository  extends JpaRepository<Task, Integer>{

	@Query("select task from Task task where task.id=?1")
	public Task findTask(int id);
}
