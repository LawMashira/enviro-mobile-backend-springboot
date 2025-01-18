package com.enviro.assessment.grad001.lawsonmatutu.controller;

import com.enviro.assessment.grad001.lawsonmatutu.entity.RecyclingTip;
import com.enviro.assessment.grad001.lawsonmatutu.service.RecyclingTipService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {

    private final RecyclingTipService service;

    public RecyclingTipController(RecyclingTipService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RecyclingTip> createTip(@Valid @RequestBody RecyclingTip tip) {
        return ResponseEntity.ok(service.createTip(tip));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTip> getTipById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getTipById(id));
    }

    @GetMapping
    public ResponseEntity<List<RecyclingTip>> getAllTips() {
        return ResponseEntity.ok(service.getAllTips());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTip> updateTip(@PathVariable UUID id, @Valid @RequestBody RecyclingTip tip) {
        return ResponseEntity.ok(service.updateTip(id, tip));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTip(@PathVariable UUID id) {
        service.deleteTip(id);
        return ResponseEntity.noContent().build();
    }
}
