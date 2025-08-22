package com.cms.pojos;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;
    private String mobile;
    private String password;   
    private String type; 

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "staff")
    private List<Schedule> schedules;

    @OneToMany(mappedBy = "staff")
    private List<CourseCoordinatorAssignment> coordinatorAssignments;
}

