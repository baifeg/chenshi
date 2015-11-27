DROP TABLE IF EXISTS `Person`;
CREATE TABLE IF NOT EXISTS `Person` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `iteraryName` VARCHAR(45) NULL,
  `birthday` DATE NULL,
  `parentId` BIGINT NOT NULL DEFAULT 0,
  `updatedAt` TIMESTAMP NOT NULL,
  `createdAt` TIMESTAMP NOT NULL,
  `description` TEXT NULL,
  `operator` VARCHAR(45) NOT NULL DEFAULT 'admin',
  `lifeStatus` VARCHAR(45) NOT NULL,
  `deathday` DATE NULL,
  PRIMARY KEY(`id`),
  constraint FK8E48877590BB7E0F foreign key (`parentId`) references `Person` (`id`)
);

DROP TABLE IF EXISTS `PersonInfo`;
CREATE TABLE IF NOT EXISTS `PersonInfo` (
  `id` BIGINT NOT NULL,
  `email` VARCHAR(45) NULL,
  `mobile` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY(`id`)
);
