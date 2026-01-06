package org.juhanir.domain.sensordata.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

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

}
