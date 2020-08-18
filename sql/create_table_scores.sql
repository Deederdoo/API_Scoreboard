USE scoreboarddb;

CREATE TABLE `scoreboarddb`.`scores_easy` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ranking` INT NOT NULL,
  `score` DOUBLE NOT NULL,
  `userid` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `scoreboarddb`.`scores_intermediate` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ranking` INT NOT NULL,
  `score` DOUBLE NOT NULL,
  `userid` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `scoreboarddb`.`scores_hard` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ranking` INT NOT NULL,
  `score` DOUBLE NOT NULL,
  `userid` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `scoreboarddb`.`scores_savant` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ranking` INT NOT NULL,
  `score` DOUBLE NOT NULL,
  `userid` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`id`));
