package com.cms.pojos;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Infrastructure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String type;  // Lecture Hall, Lab, etc.
    private String description;

    @OneToMany(mappedBy = "infrastructure")
    private List<Schedule> schedules;
}
