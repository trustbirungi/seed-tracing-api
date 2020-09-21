CREATE TABLE
    `seed_tracing_db`.`trainee_repeat`
(
    `id`					INTEGER(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `parent_uid`            VARCHAR(255) NOT NULL,
    `trainee_first_name`    VARCHAR(255) NOT NULL,
    `trainee_last_name`     VARCHAR(255) NOT NULL,
    `trainee_sex`           VARCHAR(7) NOT NULL,
    `trainee_training_date` DATE  NOT NULL,
    `trainee_district`      VARCHAR(255) NOT NULL,
    KEY `parent_uid_fk_idx_trainee_repeat` (`parent_uid`),
    CONSTRAINT `parent_uid_fk_trainee_repeat` FOREIGN KEY (parent_uid) REFERENCES `seed_multipliers` (`meta_instance_id`) ON
        DELETE CASCADE
);
