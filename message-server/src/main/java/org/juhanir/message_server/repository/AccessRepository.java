package org.juhanir.message_server.repository;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.juhanir.domain.sensordata.entity.GroupDevice;

@ApplicationScoped
public class AccessRepository implements PanacheRepository<GroupDevice> {

    public Uni<GroupDevice> assignDeviceToGroup(String deviceIdentifier, String groupName) {
        final GroupDevice groupDevice = new GroupDevice();
        groupDevice
                .setDeviceIdentifier(deviceIdentifier)
                .setGroupName(groupName);
        return persist(groupDevice);
    }

}
