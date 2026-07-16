package org.juhanir.message_server.rest.resource;

import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.juhanir.domain.sensordata.dto.incoming.CreateTaskRequestBody;
import org.juhanir.domain.sensordata.dto.outgoing.TaskResponse;
import org.juhanir.domain.sensordata.entity.Task;
import org.juhanir.message_server.repository.TaskRepository;
import org.juhanir.message_server.rest.api.TaskApi;

import java.time.Instant;

public class TaskResource implements TaskApi {

    private final TaskRepository taskRepository;

    @Inject
    public TaskResource(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    @WithTransaction
    public Uni<Response> createTask(CreateTaskRequestBody requestBody) {
        final Instant now = Instant.now();
        final Task newTask = new Task()
                .setDescription(requestBody.getDescription())
                .setCreatedAt(now)
                .setModifiedAt(now);
        return taskRepository.persist(newTask)
                .map(TaskResponse::fromTask)
                .map(task -> Response.status(Response.Status.CREATED).entity(task).build());
    }
}
