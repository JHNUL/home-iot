ALTER TABLE sensor.device
    ADD COLUMN location INTEGER;

-- location is a foreign-key reference.
-- Had dependency to `101_create_table_location.sql.
-- Liquibase guarantees sequential order of execution
-- within a changeset.
ALTER TABLE sensor.device
    ADD CONSTRAINT location_fkey
        FOREIGN KEY (location)
            REFERENCES sensor.location (id);
