CREATE TABLE IF NOT EXISTS `language` (
    `id` INT AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    `platform` VARCHAR(100),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;
