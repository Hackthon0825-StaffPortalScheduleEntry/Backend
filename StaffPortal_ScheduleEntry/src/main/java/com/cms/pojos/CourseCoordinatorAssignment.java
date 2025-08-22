package com.cms.pojos;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data 
@NoArgsConstructor
@AllArgsConstructor
public class CourseCoordinatorAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;
}
