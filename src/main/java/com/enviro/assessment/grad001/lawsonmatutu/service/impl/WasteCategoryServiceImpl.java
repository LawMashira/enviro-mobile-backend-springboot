package com.enviro.assessment.grad001.lawsonmatutu.service.impl;

import com.enviro.assessment.grad001.lawsonmatutu.entity.WasteCategory;
import com.enviro.assessment.grad001.lawsonmatutu.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.lawsonmatutu.service.WasteCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Implementation of WasteCategoryService to manage waste categories.
 */
@Service
public class WasteCategoryServiceImpl implements WasteCategoryService {

    private final WasteCategoryRepository repository;

    public WasteCategoryServiceImpl(WasteCategoryRepository repository) {
        this.repository = repository;
    }

    /**
     * Creates a new waste category.
     * @param wasteCategory The category to be created.
     * @return The created category.
     */
    @Override
    public WasteCategory createCategory(WasteCategory wasteCategory) {
        return repository.save(wasteCategory);
    }

    /**
     * Updates an existing waste category by ID.
     * @param id The ID of the category to update.
     * @param wasteCategory The updated category details.
     * @return The updated category.
     */
    @Override
    public WasteCategory updateCategory(UUID id, WasteCategory wasteCategory) {
        WasteCategory existing = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Waste category not found"));
        existing.setName(wasteCategory.getName());
        existing.setDescription(wasteCategory.getDescription());
        return repository.save(existing);
    }

    /**
     * Deletes a waste category by ID.
     * @param id The ID of the category to delete.
     */
    @Override
    public void deleteCategory(UUID id) {
        repository.deleteById(id);
    }

    /**
     * Retrieves a waste category by ID.
     * @param id The ID of the category.
     * @return The waste category.
     */
    @Override
    public WasteCategory getCategoryById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Waste category not found"));
    }

    /**
     * Retrieves all waste categories.
     * @return List of all waste categories.
     */
    @Override
    public List<WasteCategory> getAllCategories() {
        return repository.findAll();
    }
}
