package com.enviro.assessment.grad001.lawsonmatutu.service;

import com.enviro.assessment.grad001.lawsonmatutu.entity.WasteCategory;

import java.util.List;
import java.util.UUID;

public interface WasteCategoryService {
    WasteCategory createCategory(WasteCategory wasteCategory);
    WasteCategory updateCategory(UUID id, WasteCategory wasteCategory);
    void deleteCategory(UUID id);
    WasteCategory getCategoryById(UUID id);
    List<WasteCategory> getAllCategories();
}
