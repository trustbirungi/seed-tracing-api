CREATE TABLE
    `seed_tracing_db`.`users`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `active` int(2) NOT NULL,
    `roles` VARCHAR(255) NULL,
    `permissions` VARCHAR(255) NULL,
    PRIMARY KEY (id)
);
