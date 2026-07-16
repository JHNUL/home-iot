package org.juhanir.message_server.rest.api;

import io.smallrye.mutiny.Uni;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.juhanir.domain.sensordata.dto.incoming.CreateTaskRequestBody;
import org.juhanir.domain.sensordata.dto.outgoing.TaskResponse;

@Path("tasks")
@RolesAllowed({Role.USER, Role.ADMIN})
public interface TaskApi {

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Operation(summary = "Create a new task.")
    @APIResponse(
            responseCode = "201",
            description = "Task was created successfully",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = TaskResponse.class)
            )
    )
    Uni<Response> createTask(@Valid CreateTaskRequestBody reqBody);
}
