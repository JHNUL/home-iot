package org.juhanir.message_server.rest.api;

import io.smallrye.mutiny.Uni;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.juhanir.domain.sensordata.dto.incoming.AssignAccessRequestBody;

@Path("access")
@RolesAllowed({Role.USER, Role.ADMIN})
public interface AccessApi {

    @POST
    @Path("/assign")
    @Operation(summary = "Associate a device with a group")
    @Consumes(MediaType.APPLICATION_JSON)
    @APIResponse(
            responseCode = "200",
            description = "Device assigned to group."
    )
    @RolesAllowed({Role.ADMIN})
    Uni<Response> assignDevice(@Valid AssignAccessRequestBody reqBody);

}
