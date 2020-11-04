ALTER TABLE `seed_tracing_db`.`seed_multipliers`
    CHANGE COLUMN `meta_submission_date` `meta_submission_date` VARCHAR(255) NOT NULL ,
    CHANGE COLUMN `meta_date_marked_as_complete` `meta_date_marked_as_complete` VARCHAR(255) NOT NULL ,
    CHANGE COLUMN `date_of_birth` `date_of_birth` VARCHAR(255) NOT NULL ,
    CHANGE COLUMN `training_date` `training_date` VARCHAR(255) NOT NULL ;
