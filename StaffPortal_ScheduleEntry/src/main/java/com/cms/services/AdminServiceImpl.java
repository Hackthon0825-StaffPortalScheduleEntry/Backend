package com.cms.services;
import com.cms.dto.AdminDTO;
import com.cms.pojos.Admin;
import com.cms.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository repository;

    @Override
    @Transactional
    public AdminDTO login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Username and password are required");
        }

        Admin admin = repository.findByUsernameAndPassword(username, password);
        if (admin == null || !admin.isActive()) {
            throw new IllegalArgumentException("Invalid credentials or account is inactive");
        }

        // Update last login time
        admin.setLastLogin(LocalDateTime.now());
        repository.save(admin);

        // Map to DTO
        return new AdminDTO(
            admin.getId(),
            admin.getUsername(),
            admin.getPassword(),
            admin.getFirstName(),
            admin.getLastName(),
            admin.getLastLogin(),
            admin.isActive()
        );
    }
}