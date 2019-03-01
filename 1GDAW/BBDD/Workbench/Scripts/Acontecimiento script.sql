-- MySQL Script generated by MySQL Workbench
-- Fri Feb 23 08:39:08 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema acontecimientos
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `acontecimientos` ;

-- -----------------------------------------------------
-- Schema acontecimientos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `acontecimientos` DEFAULT CHARACTER SET utf8 ;
USE `acontecimientos` ;

-- -----------------------------------------------------
-- Table `acontecimientos`.`Acontecimiento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `acontecimientos`.`Acontecimiento` ;

CREATE TABLE IF NOT EXISTS `acontecimientos`.`Acontecimiento` (
  `id_a` INT(2) NOT NULL,
  `nombre` VARCHAR(15) NOT NULL,
  `lugar` VARCHAR(15) NOT NULL,
  `fecha` DATE NOT NULL,
  `hora_inicio` TIME NOT NULL,
  `hora_fin` TIME NOT NULL,
  `aforo` INT(2) NOT NULL,
  PRIMARY KEY (`id_a`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `acontecimientos`.`Empresa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `acontecimientos`.`Empresa` ;

CREATE TABLE IF NOT EXISTS `acontecimientos`.`Empresa` (
  `NIF` VARCHAR(8) NOT NULL,
  `nombre` VARCHAR(20) NOT NULL,
  `razon_social` VARCHAR(40) NOT NULL,
  `CNAE` INT(5) NOT NULL,
  PRIMARY KEY (`NIF`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `acontecimientos`.`Persona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `acontecimientos`.`Persona` ;

CREATE TABLE IF NOT EXISTS `acontecimientos`.`Persona` (
  `DNI` VARCHAR(12) NOT NULL,
  `nombre` VARCHAR(15) NOT NULL,
  `ape1` VARCHAR(25) NOT NULL,
  `ape2` VARCHAR(25) NOT NULL,
  `tel` VARCHAR(13) NOT NULL,
  `Empresa_NIF` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`DNI`, `Empresa_NIF`),
  INDEX `fk_Asistente_Empresa1_idx` (`Empresa_NIF` ASC),
  CONSTRAINT `fk_Asistente_Empresa1`
    FOREIGN KEY (`Empresa_NIF`)
    REFERENCES `acontecimientos`.`Empresa` (`NIF`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `acontecimientos`.`Asistente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `acontecimientos`.`Asistente` ;

CREATE TABLE IF NOT EXISTS `acontecimientos`.`Asistente` (
  `Acontecimiento_id_a` INT(2) NOT NULL,
  `Asistente_DNI` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`Acontecimiento_id_a`, `Asistente_DNI`),
  INDEX `fk_Acontecimiento_has_Asistente_Asistente1_idx` (`Asistente_DNI` ASC),
  INDEX `fk_Acontecimiento_has_Asistente_Acontecimiento_idx` (`Acontecimiento_id_a` ASC),
  CONSTRAINT `fk_Acontecimiento_has_Asistente_Acontecimiento`
    FOREIGN KEY (`Acontecimiento_id_a`)
    REFERENCES `acontecimientos`.`Acontecimiento` (`id_a`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Acontecimiento_has_Asistente_Asistente1`
    FOREIGN KEY (`Asistente_DNI`)
    REFERENCES `acontecimientos`.`Persona` (`DNI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;