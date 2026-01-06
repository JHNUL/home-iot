package org.juhanir.domain.sensordata.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "location", schema = "sensor")
public class Location extends BaseEntity {

    /**
     * Location name
     */
    @NotNull
    @Column(name = "name")
    private String name;

    /**
     * Location type
     */
    @NotNull
    @Column(name = "type")
    private String type;

    /**
     * Creation time
     */
    @NotNull
    @Column(name = "created_at")
    private Instant createdAt;

    /**
     * Modify time
     */
    @NotNull
    @Column(name = "modified_at")
    private Instant modifiedAt;

    /**
     * Description of the location
     */
    @Column(name = "description")
    private String description;

    /**
     * Size of the space
     */
    @Column(name = "space")
    private Double space;

    /**
     * UI definition as JSON string. This might be silly,
     * but Hibernate suffers from serious clunkiness with
     * untyped JSON(B) and this column is just some UI
     * stuff persisted in the DB.
     */
    @Column(name = "ui_specification", columnDefinition = "TEXT") // PostgreSQL TEXT type
    private String uiSpecification;

    @ManyToMany(mappedBy = "locations")
    private Set<Device> devices = new HashSet<>();

    public String getName() {
        return name;
    }

    public Location setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public Location setType(String type) {
        this.type = type;
        return this;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Location setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Instant getModifiedAt() {
        return modifiedAt;
    }

    public Location setModifiedAt(Instant modifiedAt) {
        this.modifiedAt = modifiedAt;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Location setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getSpace() {
        return space;
    }

    public Location setSpace(Double space) {
        this.space = space;
        return this;
    }

    public String getUiSpecification() {
        return uiSpecification;
    }

    public Location setUiSpecification(String uiSpecification) {
        this.uiSpecification = uiSpecification;
        return this;
    }

    public Set<Device> getDevices() {
        return devices;
    }

    public Location setDevices(Set<Device> devices) {
        this.devices = devices;
        return this;
    }

    @Override
    public String toString() {
        return "Location{" +
                "uiSpecification='" + uiSpecification + '\'' +
                ", space=" + space +
                ", description='" + description + '\'' +
                ", modifiedAt=" + modifiedAt +
                ", createdAt=" + createdAt +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
