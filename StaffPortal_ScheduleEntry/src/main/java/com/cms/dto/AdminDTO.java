package com.cms.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {

    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDateTime lastLogin;
    private boolean isActive;
}