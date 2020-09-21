CREATE TABLE
    `seed_tracing_db`.`buyers`
(
    `meta_instance_id`            VARCHAR(255) NOT NULL PRIMARY KEY,
    `meta_model_version`           VARCHAR(255)  NOT NULL,
    `meta_ui_version`             VARCHAR(255),
    `meta_submission_date`         DATETIME(50) NOT NULL,
    `meta_is_complete`             BOOLEAN(7) NOT NULL,
    `meta_date_marked_as_complete` DATETIME(50) NOT NULL,
    `biodata_note`                 VARCHAR(255),
    `consent`                      VARCHAR(3) NOT NULL,
    `first_name`                  VARCHAR(255) NOT NULL,
    `last_name`                    VARCHAR(255) NOT NULL,
    `buyer_sex`                    VARCHAR(7) NOT NULL,
    `date_of_birth`                DATE(50)  NOT NULL,
    `farmer_group`                 VARCHAR(255) NOT NULL,
    `female_members_quantity`      INTEGER(7)  NOT NULL,
    `male_members_quantity`        INTEGER(7)  NOT NULL,
    `buyer_district`               VARCHAR(255) NOT NULL,
    `buyer_county`                 VARCHAR(255) NOT NULL,
    `buyer_subcounty`              VARCHAR(255) NOT NULL,
    `buyer_parish`                 VARCHAR(255) NOT NULL,
    `buyer_village`                VARCHAR(255) NOT NULL,
    `instance_id`                  VARCHAR(255) NOT NULL
);
