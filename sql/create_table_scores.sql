USE scoreboarddb;

CREATE TABLE `scoreboarddb`.`scores` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ranking` INT NOT NULL,
  `score` DOUBLE NOT NULL,
  `userid` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `ranking_UNIQUE` (`ranking` ASC) VISIBLE);
