package com.yt.SmartTasker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yt.SmartTasker.dto.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("select user from User user where user.id =?1")
	public User findUser(int id);
	
	@Query("select user from User user where user.email=?1")
	public User findEmail(String email);
}
