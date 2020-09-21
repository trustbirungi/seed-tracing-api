CREATE TABLE
    `seed_tracing_db`.`group_trained_others_repeat`
(
    `id`                                    INTEGER(10)  NOT NULL PRIMARY KEY,
    `parent_uid`                            VARCHAR(255) NOT NULL,
    `trained_group_that_has_trained_others` VARCHAR(255) NOT NULL,
    KEY `parent_uid_fk_idx_group_trained_others_repeat` (`parent_uid`),
    CONSTRAINT `parent_uid_fk_group_trained_others_repeat` FOREIGN KEY (parent_uid) REFERENCES `seed_multipliers` (`meta_instance_id`) ON DELETE CASCADE
);
