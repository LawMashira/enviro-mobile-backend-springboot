package com.enviro.assessment.grad001.lawsonmatutu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Base entity class to encapsulate common properties.
 * All entities inherit from this class.
 */
@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class BaseEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id; // Unique identifier for the entity

    @Column(updatable = false)
    private LocalDateTime createdAt; // Timestamp for record creation

    private LocalDateTime updatedAt; // Timestamp for last update

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}