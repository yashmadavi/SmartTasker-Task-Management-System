package com.yt.SmartTasker.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yt.SmartTasker.dto.User;
import com.yt.SmartTasker.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository repository;
	
	public User saveUser(User user) {
		return repository.save(user);
	}
	
	public User findUser(int id) {
		return repository.findUser(id);
	}
	
	public void deleteUser(int id) {
		 repository.deleteById(id);
	}
	
	public User updateUser(User user) {
		User user1 = repository.findUser(user.getId());
		if(user1!=null) {
			return repository.save(user);
		}else {
			return null;
		}
	}
	
	public User loginUser(String email) {
		return repository.findEmail(email);
	}
}
