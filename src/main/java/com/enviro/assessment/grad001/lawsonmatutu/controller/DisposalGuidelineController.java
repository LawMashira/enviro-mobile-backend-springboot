package com.enviro.assessment.grad001.lawsonmatutu.controller;

import com.enviro.assessment.grad001.lawsonmatutu.entity.DisposalGuideline;
import com.enviro.assessment.grad001.lawsonmatutu.entity.WasteCategory;
import com.enviro.assessment.grad001.lawsonmatutu.service.DisposalGuidelineService;
import com.enviro.assessment.grad001.lawsonmatutu.service.WasteCategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {

    private final DisposalGuidelineService disposalGuidelineService;
    private final WasteCategoryService wasteCategoryService;

    public DisposalGuidelineController(DisposalGuidelineService disposalGuidelineService, WasteCategoryService wasteCategoryService) {
        this.disposalGuidelineService = disposalGuidelineService;
        this.wasteCategoryService = wasteCategoryService;
    }

    // POST endpoint to create a new guideline
    @PostMapping
    public ResponseEntity<DisposalGuideline> createGuideline(@Valid @RequestBody DisposalGuideline guideline) {
        if (guideline.getWasteCategory() != null && guideline.getWasteCategory().getId() != null) {
            // Fetch the WasteCategory by its ID
            WasteCategory wasteCategory = wasteCategoryService.getCategoryById(guideline.getWasteCategory().getId());
            guideline.setWasteCategory(wasteCategory);
        } else if (guideline.getWasteCategory() != null) {
            // Save the WasteCategory if it's new
            WasteCategory newWasteCategory = wasteCategoryService.createCategory(guideline.getWasteCategory());
            guideline.setWasteCategory(newWasteCategory);
        }

        return ResponseEntity.ok(disposalGuidelineService.createGuideline(guideline));
    }

    // Get a guideline by ID
    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuideline> getGuidelineById(@PathVariable UUID id) {
        return ResponseEntity.ok(disposalGuidelineService.getGuidelineById(id));
    }

    // Get all guidelines
    @GetMapping
    public ResponseEntity<List<DisposalGuideline>> getAllGuidelines() {
        return ResponseEntity.ok(disposalGuidelineService.getAllGuidelines());
    }

    // Update a guideline
    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuideline> updateGuideline(@PathVariable UUID id, @Valid @RequestBody DisposalGuideline guideline) {
        return ResponseEntity.ok(disposalGuidelineService.updateGuideline(id, guideline));
    }

    // Delete a guideline
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuideline(@PathVariable UUID id) {
        disposalGuidelineService.deleteGuideline(id);
        return ResponseEntity.noContent().build();
    }
}
