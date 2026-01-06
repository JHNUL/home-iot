package org.juhanir.domain.sensordata.entity;

import java.io.Serializable;
import java.util.Objects;

public class GroupDeviceId implements Serializable {

    private String groupName;
    private String deviceIdentifier;

    public String getGroupName() {
        return groupName;
    }

    public GroupDeviceId setGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public String getDeviceIdentifier() {
        return deviceIdentifier;
    }

    public GroupDeviceId setDeviceIdentifier(String deviceIdentifier) {
        this.deviceIdentifier = deviceIdentifier;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GroupDeviceId that = (GroupDeviceId) o;
        return Objects.equals(groupName, that.groupName) && Objects.equals(deviceIdentifier, that.deviceIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName, deviceIdentifier);
    }
}
