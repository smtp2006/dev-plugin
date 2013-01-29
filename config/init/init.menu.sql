CREATE  TABLE `config`.`t_system_menu` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `code` VARCHAR(45) NOT NULL ,
  `description` VARCHAR(45) NULL ,
  `display_order` INT NULL ,
  `is_leaf` INT NOT NULL ,
  `is_relative` INT NOT NULL ,
  `level` INT NOT NULL ,
  `name` VARCHAR(45) NOT NULL ,
  `parent_id` INT NULL ,
  `role` VARCHAR(45) NULL ,
  `status` INT NOT NULL ,
  `uri` VARCHAR(100) NULL ,
  `version` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `code_UNIQUE` (`code` ASC) ,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) )
DEFAULT CHARACTER SET = utf8mb4;
