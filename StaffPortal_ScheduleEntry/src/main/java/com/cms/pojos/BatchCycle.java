package com.cms.pojos;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "batch_cycles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatchCycle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;
    
    @OneToMany(mappedBy = "batchCycle")
    private List<Course> courses;
}