package org.juhanir.domain.sensordata.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "group_device", schema = "access")
@IdClass(GroupDeviceId.class)
public class GroupDevice implements Serializable {

    @Id
    @Column(name = "group_name")
    private String groupName;

    @Id
    @Column(name = "device_identifier")
    private String deviceIdentifier;

    public String getGroupName() {
        return groupName;
    }

    public GroupDevice setGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public String getDeviceIdentifier() {
        return deviceIdentifier;
    }

    public GroupDevice setDeviceIdentifier(String deviceIdentifier) {
        this.deviceIdentifier = deviceIdentifier;
        return this;
    }

    @Override
    public String toString() {
        return "GroupDevice{" +
                "groupName='" + groupName + '\'' +
                ", deviceIdentifier='" + deviceIdentifier + '\'' +
                '}';
    }
}
