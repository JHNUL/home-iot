-- Simple group-based visibility filtering for devices.
-- Devices are created automagically from incoming MQTT
-- messages, so they also must be manually made visible
-- to users via groups by an admin.
CREATE TABLE access.group_device
(
    group_name        VARCHAR(255) NOT NULL,
    device_identifier VARCHAR(255) NOT NULL,
    PRIMARY KEY (group_name, device_identifier)
);
