package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Staff;
import com.app.repositories.StaffRepo;

@Service
public class AuthService implements AuthServiceInterface {

	@Autowired
	StaffRepo staffRepo ;
	
	@Override
	public String userLogin(String email, String password) {
		
		Staff staff = staffRepo.findByEmail(email).orElseThrow(()-> new RuntimeException("User not found"));
		
		if(staff.getPassword().equals(password))
		{
			return "user login successfully";
		}
		return "Enter valid credentials";
	}

}
