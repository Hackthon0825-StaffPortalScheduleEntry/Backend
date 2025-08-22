package com.cms.pojos;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String path;

    @ManyToMany(mappedBy = "menuItems")
    private List<Role> roles;
}

