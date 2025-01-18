package com.enviro.assessment.grad001.lawsonmatutu.service;

import com.enviro.assessment.grad001.lawsonmatutu.entity.DisposalGuideline;

import java.util.List;
import java.util.UUID;

public interface DisposalGuidelineService {
    DisposalGuideline createGuideline(DisposalGuideline guideline);
    DisposalGuideline updateGuideline(UUID id, DisposalGuideline guideline);
    void deleteGuideline(UUID id);
    DisposalGuideline getGuidelineById(UUID id);
    List<DisposalGuideline> getAllGuidelines();
}
