/*
SQLyog Ultimate v11.51 (32 bit)
MySQL - 5.6.17 : Database - svemirskiautobus
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`svemirskiautobus` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `svemirskiautobus`;

/*Table structure for table `planeta` */

DROP TABLE IF EXISTS `planeta`;

CREATE TABLE `planeta` (
  `planetaID` int(11) NOT NULL AUTO_INCREMENT,
  `koordinate` varchar(50) NOT NULL,
  `naziv` varchar(20) NOT NULL,
  `udaljenostOdZemlje` double NOT NULL,
  PRIMARY KEY (`planetaID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `planeta` */

insert  into `planeta`(`planetaID`,`koordinate`,`naziv`,`udaljenostOdZemlje`) values (2,'5869','Jupiter',5220);

/*Table structure for table `porudzbenica` */

DROP TABLE IF EXISTS `porudzbenica`;

CREATE TABLE `porudzbenica` (
  `porudzbenicaID` varchar(20) NOT NULL,
  `autobusID` int(11) NOT NULL,
  `planetaID` int(11) NOT NULL,
  `datum` date NOT NULL,
  PRIMARY KEY (`porudzbenicaID`),
  KEY `planeta_fk2` (`planetaID`),
  KEY `autobus_fk2` (`autobusID`),
  CONSTRAINT `autobus_fk2` FOREIGN KEY (`autobusID`) REFERENCES `svemirskiautobus` (`autobusID`),
  CONSTRAINT `planeta_fk2` FOREIGN KEY (`planetaID`) REFERENCES `planeta` (`planetaID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `porudzbenica` */

/*Table structure for table `profaktura` */

DROP TABLE IF EXISTS `profaktura`;

CREATE TABLE `profaktura` (
  `profakturaID` varchar(20) NOT NULL,
  `putnikID` int(11) NOT NULL,
  `autobusID` int(11) NOT NULL,
  `planetaID` int(11) NOT NULL,
  `iznos` double NOT NULL,
  `datum` date NOT NULL,
  PRIMARY KEY (`profakturaID`,`putnikID`),
  KEY `putnik_fk` (`putnikID`),
  KEY `planeta_fk` (`planetaID`),
  KEY `autobus_fk` (`autobusID`),
  CONSTRAINT `autobus_fk` FOREIGN KEY (`autobusID`) REFERENCES `svemirskiautobus` (`autobusID`),
  CONSTRAINT `planeta_fk` FOREIGN KEY (`planetaID`) REFERENCES `planeta` (`planetaID`),
  CONSTRAINT `putnik_fk` FOREIGN KEY (`putnikID`) REFERENCES `putnik` (`putnikID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `profaktura` */

/*Table structure for table `putnik` */

DROP TABLE IF EXISTS `putnik`;

CREATE TABLE `putnik` (
  `putnikID` int(11) NOT NULL AUTO_INCREMENT,
  `jmbg` varchar(13) NOT NULL,
  `imeprezime` varchar(50) NOT NULL,
  `adresa` varchar(50) NOT NULL,
  `kontaktTelefon` varchar(20) NOT NULL,
  PRIMARY KEY (`putnikID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `putnik` */

insert  into `putnik`(`putnikID`,`jmbg`,`imeprezime`,`adresa`,`kontaktTelefon`) values (1,'2708993715271','Ana Licina','Slavonskih brigada 45','0656268109'),(2,'1808996715141','Jovana Jovanovic','Jove Ilica 58','061525252');

/*Table structure for table `stavkaporudzbenice` */

DROP TABLE IF EXISTS `stavkaporudzbenice`;

CREATE TABLE `stavkaporudzbenice` (
  `rb` int(11) NOT NULL,
  `porudzbenicaID` varchar(20) NOT NULL,
  `zaliheID` int(11) NOT NULL,
  `kolicina` double NOT NULL,
  `jedinicaMere` varchar(11) NOT NULL,
  PRIMARY KEY (`rb`,`porudzbenicaID`),
  KEY `zaliheID` (`zaliheID`),
  KEY `porudzbenica_fk` (`porudzbenicaID`),
  CONSTRAINT `porudzbenica_fk` FOREIGN KEY (`porudzbenicaID`) REFERENCES `porudzbenica` (`porudzbenicaID`),
  CONSTRAINT `zaliheID` FOREIGN KEY (`zaliheID`) REFERENCES `zalihe` (`zaliheID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `stavkaporudzbenice` */

/*Table structure for table `svemirskiautobus` */

DROP TABLE IF EXISTS `svemirskiautobus`;

CREATE TABLE `svemirskiautobus` (
  `autobusID` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(20) NOT NULL,
  `maksimalanbrojsedista` int(11) NOT NULL,
  PRIMARY KEY (`autobusID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `svemirskiautobus` */

insert  into `svemirskiautobus`(`autobusID`,`naziv`,`maksimalanbrojsedista`) values (1,'Bambus',100);

/*Table structure for table `zalihe` */

DROP TABLE IF EXISTS `zalihe`;

CREATE TABLE `zalihe` (
  `zaliheID` int(11) NOT NULL AUTO_INCREMENT,
  `tip` varchar(20) NOT NULL,
  `naziv` varchar(50) NOT NULL,
  `stanje` double NOT NULL,
  PRIMARY KEY (`zaliheID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `zalihe` */

insert  into `zalihe`(`zaliheID`,`tip`,`naziv`,`stanje`) values (1,'hrana','Sendvic',50),(2,'hrana','Banana',20);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
