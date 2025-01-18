package com.enviro.assessment.grad001.lawsonmatutu.controller;

import com.enviro.assessment.grad001.lawsonmatutu.entity.WasteCategory;
import com.enviro.assessment.grad001.lawsonmatutu.service.WasteCategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {

    private final WasteCategoryService service;

    public WasteCategoryController(WasteCategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<WasteCategory> createCategory(@Valid @RequestBody WasteCategory wasteCategory) {
        return ResponseEntity.ok(service.createCategory(wasteCategory));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getCategoryById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getCategoryById(id));
    }

    @GetMapping
    public ResponseEntity<List<WasteCategory>> getAllCategories() {
        return ResponseEntity.ok(service.getAllCategories());
    }

    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateCategory(@PathVariable UUID id, @Valid @RequestBody WasteCategory wasteCategory) {
        return ResponseEntity.ok(service.updateCategory(id, wasteCategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable UUID id) {
        service.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
