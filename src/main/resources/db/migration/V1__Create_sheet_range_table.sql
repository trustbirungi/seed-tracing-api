CREATE TABLE
    `seed_tracing_db`.`sheet_range`
        (
            `id` INT NOT NULL AUTO_INCREMENT,
            `previous_range` VARCHAR(255) NULL,
            `current_range` VARCHAR(255) NULL,
            PRIMARY KEY (id)
        );
