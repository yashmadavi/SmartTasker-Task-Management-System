package com.yt.SmartTasker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.yt.SmartTasker.dao.UserDao;
import com.yt.SmartTasker.dto.User;
import com.yt.SmartTasker.exception.IdNotFound;
import com.yt.SmartTasker.exception.InvalidEmail;
import com.yt.SmartTasker.exception.InvalidPassword;
import com.yt.SmartTasker.repository.UserRepository;
import com.yt.SmartTasker.util.EmailUtil;
import com.yt.SmartTasker.util.ResponseStructure;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserDao dao;
	
	@Autowired
	private EmailUtil emailutil;
	
	ResponseStructure<User> structure = new ResponseStructure<>();
	
	public User getUserById(int id) {
		return userRepository.findUser(id);
	}
	public User saveUser(User user) {
		return dao.saveUser(user);
	}
	
	public ResponseEntity<ResponseStructure<User>> findUser(int id) {
		User user1 = dao.findUser(id);
		if(user1!=null) {
			structure.setData(user1);
			structure.setMessage("user found");
			structure.setStatusCode(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.FOUND);
		}else {
			throw new IdNotFound("user is not presenet");
		}
		
	}
	
	public ResponseEntity<ResponseStructure<User>> deleteUser(int id) {
		 User user1 = userRepository.findUser(id);
		 if(user1 != null) {
			 structure.setMessage("deletion Successfully");
			 structure.setStatusCode(HttpStatus.OK.value());
			 structure.setData(user1);
			 
			 return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		 }else {
			 throw new IdNotFound("user is not presenet");
		 }
	}
	
	public ResponseEntity<ResponseStructure<User>> updateUser(int id ,User user){
		User user1 = dao.findUser(id);
		if(user1!=null) {
			user1.setUsername(user.getUsername());
			user1.setRole(user.getRole());
			user1.setEmail(user.getEmail());
			user1.setFullName(user.getFullName());
			user1.setRole(user.getRole());
			user1.setTasks(user.getTasks());
			
			dao.saveUser(user1);
			
			structure.setMessage("updation Successfull");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			structure.setData(user1);
			
			return new ResponseEntity<ResponseStructure<User>>(structure , HttpStatus.ACCEPTED);
		}else {
			throw new IdNotFound("user is not presenet");
		}
	}
	
	public ResponseEntity<ResponseStructure<User>> loginUser(User user){
		User user1 = dao.loginUser(user.getEmail());
		
		if(user1!=null) {
			if(user1.getPassword().equals(user.getPassword())) {
				structure.setMessage("login successfull");
				structure.setData(user1);
				structure.setStatusCode(HttpStatus.OK.value());
				
				emailutil.sendMail(user.getEmail());
				
				return new ResponseEntity<ResponseStructure<User>>(structure , HttpStatus.OK);
			}else {
				throw new InvalidPassword("Invalid Password");
			}
		}else {
			throw new InvalidEmail("Invalid Email");
		}
	}
	
}
