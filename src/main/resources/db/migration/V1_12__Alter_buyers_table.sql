ALTER TABLE `seed_tracing_db`.`buyers`
    CHANGE COLUMN `meta_is_complete` `meta_is_complete` VARCHAR(255) NOT NULL ,
    CHANGE COLUMN `consent` `consent` VARCHAR(255) NOT NULL ,
    CHANGE COLUMN `buyer_sex` `buyer_sex` VARCHAR(255) NOT NULL ;
