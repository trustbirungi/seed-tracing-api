CREATE TABLE
    `seed_tracing_db`.`group_trainee_repeat`
(
    `id`                          INTEGER(10)  NOT NULL PRIMARY KEY,
    `parent_uid`                  VARCHAR(255) NOT NULL,
    `group_trainee_name`          VARCHAR(255) NOT NULL,
    `group_trainee_training_date` DATE  NOT NULL,
    `group_trainee_district`      VARCHAR(255) NOT NULL,
    KEY `parent_uid_fk_idx_group_trainee_repeat` (`parent_uid`),
    CONSTRAINT `parent_uid_fk_group_trainee_repeat` FOREIGN KEY (parent_uid) REFERENCES `seed_multipliers`
        (`meta_instance_id`) ON DELETE CASCADE
);
