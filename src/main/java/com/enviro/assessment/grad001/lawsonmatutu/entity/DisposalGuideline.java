package com.enviro.assessment.grad001.lawsonmatutu.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DisposalGuideline extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "waste_category_id")
    @JsonIgnoreProperties({"disposalGuidelines", "description"}) // Ignore unnecessary fields
    private WasteCategory wasteCategory;

    @NotBlank(message = "Guideline text is required.")
    private String guidelineText;


    @OneToMany(mappedBy = "disposalGuideline", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecyclingTip> recyclingTips;

    public WasteCategory getWasteCategory() {
        return wasteCategory;
    }

    public void setWasteCategory(WasteCategory wasteCategory) {
        this.wasteCategory = wasteCategory;
    }

    public String getGuidelineText() {
        return guidelineText;
    }

    public void setGuidelineText(String guidelineText) {
        this.guidelineText = guidelineText;
    }
}
