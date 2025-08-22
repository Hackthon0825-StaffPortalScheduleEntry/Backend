package com.cms.pojos;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String title;
    private String description;

    @OneToMany(mappedBy = "role")
    private List<Staff> staff;

    @ManyToMany
    @JoinTable(
        name = "role_menu",
        joinColumns = @JoinColumn(name = "role_id"),
        inverseJoinColumns = @JoinColumn(name = "menu_item_id")
    )
    private List<MenuItem> menuItems;
}

