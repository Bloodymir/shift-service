package com.vladimiro.shift.consumer.repository;

import com.vladimiro.shift.consumer.domain.ShiftEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftRepository extends JpaRepository<ShiftEntity, Long> {
}
