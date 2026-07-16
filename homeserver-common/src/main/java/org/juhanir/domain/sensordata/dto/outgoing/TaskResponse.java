package org.juhanir.domain.sensordata.dto.outgoing;

import org.juhanir.domain.sensordata.entity.Task;

import java.time.Instant;

public record TaskResponse(
        long id,
        String description,
        Instant createdAt,
        Instant modifiedAt
) {

    public static TaskResponse fromTask(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getDescription(),
                task.getCreatedAt(),
                task.getModifiedAt()
        );
    }
}
