package com.cms.Cycledto;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatchCycleDTO {

    private Long id;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
}