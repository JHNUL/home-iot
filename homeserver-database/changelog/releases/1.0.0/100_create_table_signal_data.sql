-- Creating one table for all signals leads to sparse
-- data which is bad for spatial efficiency and indices.
-- EAV model would work so long as signals are of the
-- same type, which they won't be. Sparse model it is.
CREATE TABLE sensor.signal_data
(
    identifier             VARCHAR(255) NOT NULL,
    measurement_time       TIMESTAMPTZ  NOT NULL,
    temperature_celsius    DOUBLE PRECISION,
    temperature_fahrenheit DOUBLE PRECISION,
    relative_humidity      DOUBLE PRECISION
) WITH (
      timescaledb.hypertable,
      timescaledb.segmentby = 'identifier',
      timescaledb.orderby = 'measurement_time DESC');

-- composite primary key
ALTER TABLE sensor.signal_data
    ADD PRIMARY KEY (identifier, measurement_time);

-- identifier is a foreign key reference, devices cannot be deleted if they have data.
ALTER TABLE sensor.signal_data
    ADD CONSTRAINT identifier_fkey
        FOREIGN KEY (identifier)
            REFERENCES sensor.device (identifier)
            ON DELETE RESTRICT;

-- compound index on identifier and measurement time
-- https://www.tigerdata.com/blog/use-composite-indexes-to-speed-up-time-series-queries-sql-8ca2df6b3aaa
CREATE INDEX sensor_identifier_time_idx ON sensor.signal_data (identifier, measurement_time);
