package com.enviro.assessment.grad001.lawsonmatutu.service.impl;

import com.enviro.assessment.grad001.lawsonmatutu.entity.DisposalGuideline;
import com.enviro.assessment.grad001.lawsonmatutu.repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.lawsonmatutu.service.DisposalGuidelineService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DisposalGuidelineServiceImpl implements DisposalGuidelineService {

    private final DisposalGuidelineRepository repository;

    public DisposalGuidelineServiceImpl(DisposalGuidelineRepository repository) {
        this.repository = repository;
    }

    @Override
    public DisposalGuideline createGuideline(DisposalGuideline guideline) {
        return repository.save(guideline);
    }

    @Override
    public DisposalGuideline updateGuideline(UUID id, DisposalGuideline guideline) {
        DisposalGuideline existing = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Disposal guideline not found"));
        existing.setGuidelineText(guideline.getGuidelineText());
        return repository.save(existing);
    }

    @Override
    public void deleteGuideline(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public DisposalGuideline getGuidelineById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Disposal guideline not found"));
    }

    @Override
    public List<DisposalGuideline> getAllGuidelines() {
        return repository.findAll();
    }
}
