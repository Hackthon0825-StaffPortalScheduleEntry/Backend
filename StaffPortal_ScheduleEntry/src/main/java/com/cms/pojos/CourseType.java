package com.cms.pojos;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class CourseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @OneToMany(mappedBy = "courseType")
    private List<Course> courses;
}

