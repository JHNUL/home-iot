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

}
