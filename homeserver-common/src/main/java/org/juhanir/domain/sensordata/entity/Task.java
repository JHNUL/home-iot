package org.juhanir.domain.sensordata.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "task", schema = "calendar")
public class Task extends BaseEntity {

    /**
     * Plaintext description of the task.
     */
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    /**
     * When the task was created.
     */
    @NotNull
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    /**
     * When the task was last modified.
     */
    @NotNull
    @Column(name = "modified_at", nullable = false)
    private Instant modifiedAt;

    public String getDescription() {
        return description;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Task setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Instant getModifiedAt() {
        return modifiedAt;
    }

    public Task setModifiedAt(Instant modifiedAt) {
        this.modifiedAt = modifiedAt;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(description, task.description) && Objects.equals(createdAt, task.createdAt) && Objects.equals(modifiedAt, task.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, createdAt, modifiedAt);
    }

    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}
