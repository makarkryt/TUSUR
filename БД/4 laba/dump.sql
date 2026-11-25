CREATE DATABASE mydb;
use mydb;
CREATE  TABLE `mydb`.`Student` (

  `idStudent` INT NOT NULL ,

  `FIO` VARCHAR(70) NOT NULL ,

  `BDay` DATE NOT NULL ,

  `NumGroup` INT NOT NULL ,

  `Salary` INT NULL ,

  `Pol` VARCHAR(2) NULL ,

  `Starosta` TINYINT(1) NULL ,

  PRIMARY KEY (`idStudent`) );


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