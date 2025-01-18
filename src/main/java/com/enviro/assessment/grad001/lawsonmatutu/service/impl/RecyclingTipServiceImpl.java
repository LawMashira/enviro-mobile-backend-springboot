package com.enviro.assessment.grad001.lawsonmatutu.service.impl;

import com.enviro.assessment.grad001.lawsonmatutu.entity.DisposalGuideline;
import com.enviro.assessment.grad001.lawsonmatutu.entity.RecyclingTip;
import com.enviro.assessment.grad001.lawsonmatutu.entity.WasteCategory;
import com.enviro.assessment.grad001.lawsonmatutu.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.lawsonmatutu.repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.lawsonmatutu.repository.RecyclingTipRepository;
import com.enviro.assessment.grad001.lawsonmatutu.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.lawsonmatutu.service.RecyclingTipService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Implementation of RecyclingTipService to manage recycling tips.
 */
@Service
public class RecyclingTipServiceImpl implements RecyclingTipService {

    private final RecyclingTipRepository repository;

    private final DisposalGuidelineRepository  disposalGuidelineRepository;
    private WasteCategoryRepository wasteCategoryRepository;
    public RecyclingTipServiceImpl(RecyclingTipRepository repository, DisposalGuidelineRepository disposalGuidelineRepository, WasteCategoryRepository wasteCategoryRepository) {
        this.repository = repository;
        this.disposalGuidelineRepository = disposalGuidelineRepository;
        this.wasteCategoryRepository = wasteCategoryRepository;
    }

    @Override
    public RecyclingTip createTip(RecyclingTip tip) {
        // Fetch WasteCategory by ID using the appropriate repository
        WasteCategory wasteCategory =wasteCategoryRepository .findById(tip.getWasteCategory().getId())
                .orElseThrow(() -> new ResourceNotFoundException("WasteCategory not found."));

        // Fetch DisposalGuideline by ID using the appropriate repository
        DisposalGuideline disposalGuideline = disposalGuidelineRepository.findById(tip.getDisposalGuideline().getId())
                .orElseThrow(() -> new ResourceNotFoundException("DisposalGuideline not found."));

        // Set the related entities to the RecyclingTip
        tip.setWasteCategory(wasteCategory);
        tip.setDisposalGuideline(disposalGuideline);

        // Save and return the RecyclingTip
        return repository.save(tip);  // repository here should be the RecyclingTip repository
    }

    @Override
    public RecyclingTip updateTip(UUID id, RecyclingTip tip) {
        RecyclingTip existing = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Recycling tip not found"));
        existing.setTipText(tip.getTipText());
        return repository.save(existing);
    }

    @Override
    public void deleteTip(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public RecyclingTip getTipById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Recycling tip not found"));
    }

    @Override
    public List<RecyclingTip> getAllTips() {
        return repository.findAll();
    }
}
