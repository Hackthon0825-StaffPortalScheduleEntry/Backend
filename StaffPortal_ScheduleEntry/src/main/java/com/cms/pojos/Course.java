package com.cms.pojos;

import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "batch_cycle_id")
    private BatchCycle batchCycle;

    @ManyToOne
    @JoinColumn(name = "premises_id")
    private Premises premises;

    @ManyToOne
    @JoinColumn(name = "course_type_id")
    private CourseType courseType;

    @OneToMany(mappedBy = "course")
    private List<Subject> subjects;

    @OneToMany(mappedBy = "course")
    private List<CourseGroup> courseGroups;

    @OneToMany(mappedBy = "course")
    private List<CourseCoordinatorAssignment> coordinatorAssignments;
}

