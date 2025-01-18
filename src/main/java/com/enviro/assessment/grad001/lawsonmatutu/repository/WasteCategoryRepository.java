package com.enviro.assessment.grad001.lawsonmatutu.repository;

import com.enviro.assessment.grad001.lawsonmatutu.entity.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WasteCategoryRepository extends JpaRepository<WasteCategory, UUID> {
}
