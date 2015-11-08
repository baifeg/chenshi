CREATE TABLE `Person` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `iteraryName` VARCHAR(45) NULL,
  `birthday` DATE NULL,
  `parentId` BIGINT NOT NULL DEFAULT 0,
  `updatedAt` TIMESTAMP NOT NULL,
  `createdAt` TIMESTAMP NOT NULL,
  `description` TEXT NULL,
  `operator` VARCHAR(45) NOT NULL DEFAULT admin,
  `lifeStatus` VARCHAR(45) NOT NULL,
  `deathday` DATE NULL,
  PRIMARY KEY(`id`)
);

CREATE TABLE `PersonInfo` (
  `id` BIGINT NOT NULL,
  `email` VARCHAR(45) NULL,
  `mobile` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY(`id`)
);

CREATE TABLE `Admin` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY(`id`)
);