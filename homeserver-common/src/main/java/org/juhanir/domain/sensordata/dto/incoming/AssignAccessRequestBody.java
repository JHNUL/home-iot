package org.juhanir.domain.sensordata.dto.incoming;

import jakarta.validation.constraints.NotBlank;

public class AssignAccessRequestBody {

    @NotBlank(message="Device identifier must not be blank")
    public String deviceIdentifier;

    @NotBlank(message="Group name must not be blank")
    public String groupName;

    public String getDeviceIdentifier() {
        return deviceIdentifier;
    }

    public String getGroupName() {
        return groupName;
    }

    @Override
    public String toString() {
        return "AssignAccessRequestBody{" +
                "deviceIdentifier='" + deviceIdentifier + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
