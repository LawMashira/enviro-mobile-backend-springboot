package com.enviro.assessment.grad001.lawsonmatutu.service;

import com.enviro.assessment.grad001.lawsonmatutu.entity.RecyclingTip;

import java.util.List;
import java.util.UUID;

public interface RecyclingTipService {
    RecyclingTip createTip(RecyclingTip tip);
    RecyclingTip updateTip(UUID id, RecyclingTip tip);
    void deleteTip(UUID id);
    RecyclingTip getTipById(UUID id);
    List<RecyclingTip> getAllTips();
}
