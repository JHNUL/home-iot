package org.juhanir.message_server.rest.resource;

import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.juhanir.domain.sensordata.dto.incoming.AssignAccessRequestBody;
import org.juhanir.message_server.repository.AccessRepository;
import org.juhanir.message_server.rest.api.AccessApi;

public class AccessApiResource implements AccessApi {

    private final AccessRepository accessRepository;

    @Inject
    public AccessApiResource(AccessRepository accessRepository) {
        this.accessRepository = accessRepository;
    }

    @Override
    @WithSession
    public Uni<Response> assignDevice(AssignAccessRequestBody reqBody) {
        return accessRepository
                .assignDeviceToGroup(reqBody.getDeviceIdentifier(), reqBody.getGroupName())
                .map(groupDevice -> Response.ok(groupDevice).build());
    }
}
