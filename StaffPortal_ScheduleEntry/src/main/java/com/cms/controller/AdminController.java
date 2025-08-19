package com.cms.controller;

import com.cms.dto.AdminDTO;
import com.cms.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admins")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService service;

    @PostMapping("/login")
    public ResponseEntity<AdminDTO> login(
            @RequestParam String username,
            @RequestParam String password) {
        try {
            AdminDTO admin = service.login(username, password);
            return ResponseEntity.ok(admin);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}