package com.cms.controller;

import com.cms.Cycledto.BatchCycleDTO;
import com.cms.services.BatchCycleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/batch-cycles")
@RequiredArgsConstructor
public class BatchCycleController {

    private final BatchCycleService service;

    @PostMapping
    public ResponseEntity<BatchCycleDTO> addBatchCycle(@RequestBody BatchCycleDTO dto) {
        try {
            BatchCycleDTO created = service.addBatchCycle(dto);
            return ResponseEntity.ok(created);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}