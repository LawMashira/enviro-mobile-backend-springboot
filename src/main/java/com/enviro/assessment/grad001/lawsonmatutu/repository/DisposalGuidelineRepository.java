package com.enviro.assessment.grad001.lawsonmatutu.repository;

import com.enviro.assessment.grad001.lawsonmatutu.entity.DisposalGuideline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuideline, UUID> {
}
