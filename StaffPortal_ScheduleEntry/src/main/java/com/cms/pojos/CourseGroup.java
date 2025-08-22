package com.cms.pojos;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class CourseGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupEntity group;
}

