package com.cms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cms.pojos.Staff;
import com.cms.repository.StaffRepo;

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
