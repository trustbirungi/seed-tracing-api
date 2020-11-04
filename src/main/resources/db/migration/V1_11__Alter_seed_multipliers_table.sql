ALTER TABLE `seed_tracing_db`.`seed_multipliers`
    CHANGE COLUMN `meta_model_version` `meta_model_version` VARCHAR(255) NOT NULL ,
    CHANGE COLUMN `meta_is_complete` `meta_is_complete` VARCHAR(255) NOT NULL ,
    CHANGE COLUMN `consent` `consent` VARCHAR(255) NOT NULL ,
    CHANGE COLUMN `seed_multiplier_sex` `seed_multiplier_sex` VARCHAR(255) NOT NULL ,
    CHANGE COLUMN `trained_other_farmers` `trained_other_farmers` VARCHAR(255) NOT NULL ,
    CHANGE COLUMN `trained_other_groups` `trained_other_groups` VARCHAR(255) NOT NULL ,
    CHANGE COLUMN `trained_group_trained_others` `trained_group_trained_others` VARCHAR(255) NOT NULL ,
    CHANGE COLUMN `average_planting_materials_bought_per_individual` `average_planting_materials_bought_per_individual` VARCHAR(255) NOT NULL ;
