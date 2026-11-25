SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `mydb5` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `mydb5` ;

-- -----------------------------------------------------
-- Table `mydb`.`Faculty`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb5`.`Faculty` ;

CREATE  TABLE IF NOT EXISTS `mydb5`.`Faculty` (
  `idFaculty` INT NOT NULL ,
  `ShortName` VARCHAR(10) NULL ,
  `FullName` VARCHAR(100) NULL ,
  PRIMARY KEY (`idFaculty`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb5`.`Cathedra`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb5`.`Cathedra` ;

CREATE  TABLE IF NOT EXISTS `mydb5`.`Cathedra` (
  `idCathedra` INT NOT NULL AUTO_INCREMENT ,
  `ShortName` VARCHAR(15) NOT NULL ,
  `FullName` VARCHAR(200) NOT NULL ,
  `Faculty` INT NOT NULL ,
  PRIMARY KEY (`idCathedra`) ,
  INDEX `fk_Cathedra_Faculty1` (`Faculty` ASC) ,
  CONSTRAINT `fk_Cathedra_Faculty1`
    FOREIGN KEY (`Faculty` )
    REFERENCES `mydb5`.`Faculty` (`idFaculty` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb5`.`Groups`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb5`.`Groups` ;

CREATE  TABLE IF NOT EXISTS `mydb5`.`Groups` (
  `NumGroup` INT NOT NULL AUTO_INCREMENT ,
  `Cathedra` INT NOT NULL ,
  PRIMARY KEY (`NumGroup`) ,
  INDEX `fk_Group_Cathedra1` (`Cathedra` ASC) ,
  CONSTRAINT `fk_Group_Cathedra1`
    FOREIGN KEY (`Cathedra` )
    REFERENCES `mydb5`.`Cathedra` (`idCathedra` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb5`.`Student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb5`.`Student` ;

CREATE  TABLE IF NOT EXISTS `mydb5`.`Student` (
  `idStudent` INT NOT NULL AUTO_INCREMENT ,
  `FIO` VARCHAR(45) NOT NULL ,
  `BDay` DATE NULL ,
  `NumGroup` INT NOT NULL ,
  `Salary` INT NULL ,
  `Pol` VARCHAR(2) NULL ,
  `Starosta` TINYINT(1) NULL ,
  PRIMARY KEY (`idStudent`) ,
  INDEX `fk_Student_Group` (`NumGroup` ASC) ,
  CONSTRAINT `fk_Student_Group`
    FOREIGN KEY (`NumGroup` )
    REFERENCES `mydb5`.`Groups` (`NumGroup` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb5`.`Teacher`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb5`.`Teacher` ;

CREATE  TABLE IF NOT EXISTS `mydb5`.`Teacher` (
  `idTeacher` INT NOT NULL ,
  `FIO` VARCHAR(45) NULL ,
  `Cathedra` INT NOT NULL ,
  PRIMARY KEY (`idTeacher`) ,
  INDEX `fk_Teacher_Cathedra1` (`Cathedra` ASC) ,
  CONSTRAINT `fk_Teacher_Cathedra1`
    FOREIGN KEY (`Cathedra` )
    REFERENCES `mydb5`.`Cathedra` (`idCathedra` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb5`.`Discipline`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb5`.`Discipline` ;

CREATE  TABLE IF NOT EXISTS `mydb5`.`Discipline` (
  `idDiscipline` INT NOT NULL AUTO_INCREMENT ,
  `Name` VARCHAR(45) NOT NULL ,
  `Teacher_idTeacher` INT NOT NULL ,
  PRIMARY KEY (`idDiscipline`) ,
  INDEX `fk_Discipline_Teacher1` (`Teacher_idTeacher` ASC) ,
  CONSTRAINT `fk_Discipline_Teacher1`
    FOREIGN KEY (`Teacher_idTeacher` )
    REFERENCES `mydb5`.`Teacher` (`idTeacher` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb5`.`Marks`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb5`.`Marks` ;

CREATE  TABLE IF NOT EXISTS `mydb5`.`Marks` (
  `idStudent` INT NOT NULL ,
  `idDiscipline` INT NOT NULL ,
  `Mark` INT NOT NULL ,
  `Date` DATETIME NULL ,
  PRIMARY KEY (`idStudent`, `idDiscipline`) ,
  INDEX `fk_Marks_Student1` (`idStudent` ASC) ,
  INDEX `fk_Marks_Discipline1` (`idDiscipline` ASC) ,
  CONSTRAINT `fk_Marks_Student1`
    FOREIGN KEY (`idStudent` )
    REFERENCES `mydb5`.`Student` (`idStudent` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Marks_Discipline1`
    FOREIGN KEY (`idDiscipline` )
    REFERENCES `mydb5`.`Discipline` (`idDiscipline` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `mydb5`.`Faculty`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
USE `mydb5`;
INSERT INTO `mydb5`.`Faculty` (`idFaculty`, `ShortName`, `FullName`) VALUES ('1', 'FVS', 'V Systems');
INSERT INTO `mydb5`.`Faculty` (`idFaculty`, `ShortName`, `FullName`) VALUES ('2', 'RKF', 'Radios Systems');

COMMIT;

-- -----------------------------------------------------
-- Data for table `mydb5`.`Cathedra`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
USE `mydb5`;
INSERT INTO `mydb5`.`Cathedra` (`idCathedra`, `ShortName`, `FullName`, `Faculty`) VALUES ('1', 'EMIS', 'Econome and Math', '1');
INSERT INTO `mydb5`.`Cathedra` (`idCathedra`, `ShortName`, `FullName`, `Faculty`) VALUES ('2', 'MG', 'Mechanics and Graphics', '1');
INSERT INTO `mydb5`.`Cathedra` (`idCathedra`, `ShortName`, `FullName`, `Faculty`) VALUES ('3', 'CIPR', 'Construct and Produce', '2');

COMMIT;

-- -----------------------------------------------------
-- Data for table `mydb5`.`Groups`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
USE `mydb5`;
INSERT INTO `mydb5`.`Groups` (`NumGroup`, `Cathedra`) VALUES ('543', '1');
INSERT INTO `mydb5`.`Groups` (`NumGroup`, `Cathedra`) VALUES ('593', '1');
INSERT INTO `mydb5`.`Groups` (`NumGroup`, `Cathedra`) VALUES ('531', '2');
INSERT INTO `mydb5`.`Groups` (`NumGroup`, `Cathedra`) VALUES ('122', '3');

COMMIT;

-- -----------------------------------------------------
-- Data for table `mydb5`.`Teacher`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
USE `mydb5`;
INSERT INTO `mydb5`.`Teacher` (`idTeacher`, `FIO`, `Cathedra`) VALUES ('1', 'Kluev K.K.', '1');
INSERT INTO `mydb5`.`Teacher` (`idTeacher`, `FIO`, `Cathedra`) VALUES ('2', 'Rogov R.A.', '1');
INSERT INTO `mydb5`.`Teacher` (`idTeacher`, `FIO`, `Cathedra`) VALUES ('3', 'Bokov M.M.', '2');

COMMIT;

-- -----------------------------------------------------
-- Data for table `mydb5`.`Discipline`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
USE `mydb5`;
INSERT INTO `mydb5`.`Discipline` (`idDiscipline`, `Name`, `Teacher_idTeacher`) VALUES ('1', 'IT', '1');
INSERT INTO `mydb5`.`Discipline` (`idDiscipline`, `Name`, `Teacher_idTeacher`) VALUES ('2', 'Comp Graphics', '1');
INSERT INTO `mydb5`.`Discipline` (`idDiscipline`, `Name`, `Teacher_idTeacher`) VALUES ('3', 'AIS', '2');
INSERT INTO `mydb5`.`Discipline` (`idDiscipline`, `Name`, `Teacher_idTeacher`) VALUES ('4', 'Statistica', '2');

COMMIT;

-- -----------------------------------------------------
-- Data for table `mydb5`.`Student`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
USE `mydb5`;
insert into Student values(1,"Ivanov I.I.","1995.12.03",593,2500,'M',0);
insert into Student values(2,"Petrov P.P.","1996.07.22",543,500,'M',1);
insert into Student values(3,"Belova B.B.","1995.02.01",543,1500,'W',0);
insert into Student values(4,"Krasnov K.K.","1995.10.03",593,2000,'M',0);
insert into Student values(5,"Leonov S.S.","1996.12.01",122,0,'M',1);
insert into Student values(6,"Kireev K.K.","1995.08.09",593,1000,'M',0);
insert into Student values(7,"Usov I.I.","1995.12.15",593,2000,'M',1);
insert into Student values(8,"Sidorova C.I.","1994.04.03",543,2500,'W',0);
insert into Student values(9,"Khvostov F.F.","1995.01.19",122,2500,'M',0);
insert into Student values(10,"Tuzov I.I.","1995.11.30",593,0,'M',0);
insert into Student values(11,"Peskov D.A.","1995.10.10",531,2000,'M',0);
COMMIT;

-- -----------------------------------------------------
-- Data for table `mydb`.`Marks`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
USE `mydb5`;
INSERT INTO `mydb5`.`Marks` (`idStudent`, `idDiscipline`, `Mark`, `Date`) VALUES ('8', '1', '4', '2014.06.08');
INSERT INTO `mydb5`.`Marks` (`idStudent`, `idDiscipline`, `Mark`, `Date`) VALUES ('2', '1', '5', '2014.06.08');
INSERT INTO `mydb5`.`Marks` (`idStudent`, `idDiscipline`, `Mark`, `Date`) VALUES ('3', '1', '4', '2014.06.08');
INSERT INTO `mydb5`.`Marks` (`idStudent`, `idDiscipline`, `Mark`, `Date`) VALUES ('1', '1', '4', '2014.06.07');
INSERT INTO `mydb5`.`Marks` (`idStudent`, `idDiscipline`, `Mark`, `Date`) VALUES ('4', '1', '3', '2014.06.07');
INSERT INTO `mydb5`.`Marks` (`idStudent`, `idDiscipline`, `Mark`, `Date`) VALUES ('10', '1', '3', '2014.06.28');
INSERT INTO `mydb5`.`Marks` (`idStudent`, `idDiscipline`, `Mark`, `Date`) VALUES ('1', '2', '4', '2014.06.15');
INSERT INTO `mydb5`.`Marks` (`idStudent`, `idDiscipline`, `Mark`, `Date`) VALUES ('2', '2', '4', '2014.06.15');
INSERT INTO `mydb5`.`Marks` (`idStudent`, `idDiscipline`, `Mark`, `Date`) VALUES ('3', '2', '5', '2014.06.15');
INSERT INTO `mydb5`.`Marks` (`idStudent`, `idDiscipline`, `Mark`, `Date`) VALUES ('4', '2', '4', '2014.06.15');
INSERT INTO `mydb5`.`Marks` (`idStudent`, `idDiscipline`, `Mark`, `Date`) VALUES ('8', '2', '3', '2014.06.15');
INSERT INTO `mydb5`.`Marks` (`idStudent`, `idDiscipline`, `Mark`, `Date`) VALUES ('10', '2', '4', '2014.06.15');

COMMIT;
