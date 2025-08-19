package com.cms.services;

import com.cms.dto.AdminDTO;

public interface AdminService {
    AdminDTO login(String username, String password);
}