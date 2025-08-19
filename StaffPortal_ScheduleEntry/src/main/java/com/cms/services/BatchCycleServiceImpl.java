package com.cms.services;

import com.cms.Cycledto.BatchCycleDTO;
import com.cms.pojos.BatchCycle;
import com.cms.repository.BatchCycleRepository;

//import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BatchCycleServiceImpl implements BatchCycleService {

    private final BatchCycleRepository repository;

    @Override
    @Transactional
    public BatchCycleDTO addBatchCycle(BatchCycleDTO dto) {
        if (dto.getTitle() == null || dto.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (dto.getStartDate() == null || dto.getEndDate() == null) {
            throw new IllegalArgumentException("Start date and end date are required");
        }
        if (dto.getStartDate().isAfter(dto.getEndDate())) {
            throw new IllegalArgumentException("Start date cannot be after end date");
        }

        
        BatchCycle entity = new BatchCycle();
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());

 
        BatchCycle savedEntity = repository.save(entity);

    
        return new BatchCycleDTO(
            savedEntity.getId(),
            savedEntity.getTitle(),
            savedEntity.getDescription(),
            savedEntity.getStartDate(),
            savedEntity.getEndDate()
        );
    }
}