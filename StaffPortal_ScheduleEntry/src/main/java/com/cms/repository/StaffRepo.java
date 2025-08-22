package com.cms.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cms.pojos.Staff;

public interface StaffRepo extends JpaRepository<Staff, Integer> {
	
	Optional<Staff> findByEmail(String email);
}
