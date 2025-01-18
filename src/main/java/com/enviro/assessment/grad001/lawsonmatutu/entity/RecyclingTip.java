package com.enviro.assessment.grad001.lawsonmatutu.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class RecyclingTip extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "waste_category_id")
    @JsonBackReference
    private WasteCategory wasteCategory;

    @ManyToOne
    @JoinColumn(name = "disposal_guideline_id")
    @JsonBackReference
    private DisposalGuideline disposalGuideline;

    @NotBlank(message = "Tip text is required.")
    private String tipText;
    // Default constructor (provided by Lombok @NoArgsConstructor)
    public RecyclingTip() {
        super();
    }
    public WasteCategory getWasteCategory() {
        return wasteCategory;
    }

    public void setWasteCategory(WasteCategory wasteCategory) {
        this.wasteCategory = wasteCategory;
    }

    public DisposalGuideline getDisposalGuideline() {
        return disposalGuideline;
    }

    public void setDisposalGuideline(DisposalGuideline disposalGuideline) {
        this.disposalGuideline = disposalGuideline;
    }

    public @NotBlank(message = "Tip text is required.") String getTipText() {
        return tipText;
    }

    public void setTipText(@NotBlank(message = "Tip text is required.") String tipText) {
        this.tipText = tipText;
    }

    public RecyclingTip(WasteCategory wasteCategory, DisposalGuideline disposalGuideline, String tipText) {
        this.wasteCategory = wasteCategory;
        this.disposalGuideline = disposalGuideline;
        this.tipText = tipText;
    }
}
