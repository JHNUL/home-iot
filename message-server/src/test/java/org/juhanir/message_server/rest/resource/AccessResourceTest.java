package org.juhanir.message_server.rest.resource;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.juhanir.domain.sensordata.entity.GroupDevice;
import org.juhanir.message_server.MessageServerTestResource;
import org.juhanir.message_server.rest.api.Role;
import org.juhanir.message_server.utils.MessageServerTestBase;
import org.junit.jupiter.api.Test;

@QuarkusTest
@QuarkusTestResource(value = MessageServerTestResource.class)
public class AccessResourceTest extends MessageServerTestBase {

    @Test()
    void canAssignDeviceToGroupName() {
        final String deviceIdentifier = createDeviceToDatabase();
        final var groupDevice = new GroupDevice();
        groupDevice.setDeviceIdentifier(deviceIdentifier);
        groupDevice.setGroupName("group123");
        authenticateUsingRole(Role.ADMIN)
                .body(groupDevice)
                .contentType("application/json")
                .post("access/assign")
                .then()
                .statusCode(200);
    }

    @Test()
    void canAssignSameDeviceToMultipleGroupName() {
        final String deviceIdentifier = createDeviceToDatabase();
        final var groupDevice = new GroupDevice();
        groupDevice.setDeviceIdentifier(deviceIdentifier);
        groupDevice.setGroupName("group123");
        authenticateUsingRole(Role.ADMIN)
                .body(groupDevice)
                .contentType("application/json")
                .post("access/assign")
                .then()
                .statusCode(200);

        final var groupDevice2 = new GroupDevice();
        groupDevice2.setDeviceIdentifier(deviceIdentifier);
        groupDevice2.setGroupName("group999");
        authenticateUsingRole(Role.ADMIN)
                .body(groupDevice2)
                .contentType("application/json")
                .post("access/assign")
                .then()
                .statusCode(200);
    }

}
