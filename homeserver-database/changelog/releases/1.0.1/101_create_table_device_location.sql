CREATE TABLE sensor.device_location
(
    device_id   INT REFERENCES sensor.device (id),
    location_id INT REFERENCES sensor.location (id)
);