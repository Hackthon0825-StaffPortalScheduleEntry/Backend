package com.cms.pojos;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class GroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "group")
    private List<CourseGroup> courseGroups;

    @OneToMany(mappedBy = "group")
    private List<Schedule> schedules;
}
