package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginRequestDto;
import com.app.service.AuthServiceInterface;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	AuthServiceInterface authServ;
	
	@PostMapping("/login")
	public ResponseEntity<?> userLogin(@RequestBody LoginRequestDto loginRequestDto)
	{
		String msg = authServ.userLogin(loginRequestDto.getEmail(), loginRequestDto.getPassword());
		return ResponseEntity.ok(msg);
	}

}
