package com.cms.repository;

import com.cms.pojos.BatchCycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchCycleRepository extends JpaRepository<BatchCycle, Long> {
}