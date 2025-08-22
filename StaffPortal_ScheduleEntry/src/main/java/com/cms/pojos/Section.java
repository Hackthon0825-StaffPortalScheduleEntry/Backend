package com.cms.pojos;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@NoArgsConstructor 
@AllArgsConstructor
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @OneToMany(mappedBy = "section")
    private List<Topic> topics;
}

