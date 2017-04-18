-- MySQL dump 10.13  Distrib 5.5.54, for debian-linux-gnu (armv7l)
--
-- Host: localhost    Database: INSE
-- ------------------------------------------------------
-- Server version	5.5.54-0+deb8u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Accessory`
--

DROP TABLE IF EXISTS `Accessory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Accessory` (
  `ID` int(11) NOT NULL,
  `Description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `Accessory_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `Part` (`PartID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Accessory`
--

LOCK TABLES `Accessory` WRITE;
/*!40000 ALTER TABLE `Accessory` DISABLE KEYS */;
INSERT INTO `Accessory` VALUES (3,'TestAccessory1'),(56,'Quiet Case Fan'),(57,'Quiet Case Fan'),(58,'Black Fan controller, with 7 LED backligh colors'),(59,'uninteruptable power supply (UPS) - rack mountable'),(60,'computer monitor (24.0\") with HDMI'),(61,'computer monitor (21.0\") with 2 HDMI ports'),(95,'A gaming mouse with RGB LED and optical sensors');
/*!40000 ALTER TABLE `Accessory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Account`
--

DROP TABLE IF EXISTS `Account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Account` (
  `ID` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Fname` varchar(50) DEFAULT NULL,
  `Sname` varchar(50) DEFAULT NULL,
  `Email` varchar(60) NOT NULL,
  `accountType` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Email` (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Account`
--

LOCK TABLES `Account` WRITE;
/*!40000 ALTER TABLE `Account` DISABLE KEYS */;
INSERT INTO `Account` VALUES ('LillieHogg','bikes','Lillie','Hogg','Lillie.Hogg@myport.ac.uk',1),('LukeJackson','computer','Luke','Jackson','Luke.Jackson@myport.ac.uk',1),('TestGenUser','password','Bob','Johnson','BJ@email.com',0),('TomChate','password','Tom','Chate','up774061@myport.ac.uk',1);
/*!40000 ALTER TABLE `Account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Build`
--

DROP TABLE IF EXISTS `Build`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Build` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Account` varchar(45) NOT NULL,
  `Motherboard` int(11) NOT NULL,
  `CPU` int(11) NOT NULL,
  `RAM` int(11) NOT NULL,
  `Storage` int(11) NOT NULL,
  `GPU` int(11) DEFAULT NULL,
  `PSU` int(11) NOT NULL,
  `PCCase` int(11) NOT NULL,
  `Cooler` int(11) DEFAULT NULL,
  `Accessory` int(11) DEFAULT NULL,
  `name` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`ID`,`Account`),
  KEY `Motherboard` (`Motherboard`),
  KEY `CPU` (`CPU`),
  KEY `RAM` (`RAM`),
  KEY `Storage` (`Storage`),
  KEY `GPU` (`GPU`),
  KEY `PSU` (`PSU`),
  KEY `PCCase` (`PCCase`),
  KEY `Cooler` (`Cooler`),
  KEY `Accessory` (`Accessory`),
  CONSTRAINT `Build_ibfk_1` FOREIGN KEY (`Motherboard`) REFERENCES `Motherboard` (`ID`),
  CONSTRAINT `Build_ibfk_2` FOREIGN KEY (`CPU`) REFERENCES `CPU` (`ID`),
  CONSTRAINT `Build_ibfk_3` FOREIGN KEY (`RAM`) REFERENCES `RAM` (`ID`),
  CONSTRAINT `Build_ibfk_4` FOREIGN KEY (`Storage`) REFERENCES `Storage` (`ID`),
  CONSTRAINT `Build_ibfk_5` FOREIGN KEY (`GPU`) REFERENCES `GPU` (`ID`),
  CONSTRAINT `Build_ibfk_6` FOREIGN KEY (`PSU`) REFERENCES `PSU` (`ID`),
  CONSTRAINT `Build_ibfk_7` FOREIGN KEY (`PCCase`) REFERENCES `PCCase` (`ID`),
  CONSTRAINT `Build_ibfk_8` FOREIGN KEY (`Cooler`) REFERENCES `Cooler` (`ID`),
  CONSTRAINT `Build_ibfk_9` FOREIGN KEY (`Accessory`) REFERENCES `Accessory` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Build`
--

LOCK TABLES `Build` WRITE;
/*!40000 ALTER TABLE `Build` DISABLE KEYS */;
/*!40000 ALTER TABLE `Build` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CPU`
--

DROP TABLE IF EXISTS `CPU`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CPU` (
  `ID` int(11) NOT NULL,
  `Speed` decimal(4,2) DEFAULT NULL,
  `Cores` int(2) DEFAULT NULL,
  `Graphics` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `CPU_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `Part` (`PartID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CPU`
--

LOCK TABLES `CPU` WRITE;
/*!40000 ALTER TABLE `CPU` DISABLE KEYS */;
INSERT INTO `CPU` VALUES (1,4.20,4,1),(2,4.20,4,1),(4,4.20,8,1),(21,4.50,4,1),(22,4.00,8,1),(23,3.90,4,1),(24,3.50,2,1),(25,3.50,6,1),(105,4.20,4,1);
/*!40000 ALTER TABLE `CPU` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Compatibility`
--

DROP TABLE IF EXISTS `Compatibility`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Compatibility` (
  `Part1` int(11) NOT NULL,
  `Part2` int(11) NOT NULL,
  `Comp` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`Part1`,`Part2`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Compatibility`
--

LOCK TABLES `Compatibility` WRITE;
/*!40000 ALTER TABLE `Compatibility` DISABLE KEYS */;
/*!40000 ALTER TABLE `Compatibility` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Cooler`
--

DROP TABLE IF EXISTS `Cooler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cooler` (
  `ID` int(11) NOT NULL,
  `MinRPM` int(4) DEFAULT NULL,
  `MaxRPM` int(4) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `Cooler_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `Part` (`PartID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cooler`
--

LOCK TABLES `Cooler` WRITE;
/*!40000 ALTER TABLE `Cooler` DISABLE KEYS */;
INSERT INTO `Cooler` VALUES (18,100,300),(19,100,3000),(20,500,2000),(36,1000,2435),(37,500,1800),(38,1600,2000),(39,1800,2200),(40,800,1800),(96,700,1000);
/*!40000 ALTER TABLE `Cooler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GPU`
--

DROP TABLE IF EXISTS `GPU`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GPU` (
  `ID` int(11) NOT NULL,
  `Series` varchar(45) DEFAULT NULL,
  `Chipset` varchar(100) DEFAULT NULL,
  `Memory` int(2) DEFAULT NULL,
  `CoreClock` decimal(3,2) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `GPU_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `Part` (`PartID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GPU`
--

LOCK TABLES `GPU` WRITE;
/*!40000 ALTER TABLE `GPU` DISABLE KEYS */;
INSERT INTO `GPU` VALUES (62,'Nvidia GeForce GTX 1060','GeForce GTX 1060 6GB ',6,1.51),(63,' GeForce GTX 1070','GeForce GTX 1070 ',8,1.59),(64,'ROG STRIX','Radeon RX 480 ',8,1.12),(65,'GeForce GTX 1060','GeForce GTX 1060 6GB ',6,1.51),(66,'GV-RX480G1 GAMING-4GD ','Radeon RX 480 ',4,1.12);
/*!40000 ALTER TABLE `GPU` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Make`
--

DROP TABLE IF EXISTS `Make`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Make` (
  `Name` varchar(45) NOT NULL DEFAULT '',
  `Website` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Make`
--

LOCK TABLES `Make` WRITE;
/*!40000 ALTER TABLE `Make` DISABLE KEYS */;
INSERT INTO `Make` VALUES ('Aerocool','www.aerocool.com'),('AMD','www.amd.com'),('Asus','www.asus.com'),('corsair','www.corsair.com'),('Crucial ','www.crucial.com'),('EVGA','www.evga.com'),('G.Skill','www.gskill.com'),('GeForce','www.geforce.co.uk'),('Gigabyte','www.gigabyte.co.uk'),('IBM','www.IBM.com'),('Intel','intel.com'),('MSI','https://uk.msi.com/'),('Sandisk','www.sandisk.com');
/*!40000 ALTER TABLE `Make` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Motherboard`
--

DROP TABLE IF EXISTS `Motherboard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Motherboard` (
  `ID` int(11) NOT NULL,
  `Socket` varchar(45) NOT NULL,
  `Form_Factor` varchar(20) DEFAULT NULL,
  `RAM_Slots` int(1) DEFAULT NULL,
  `Max_RAM` int(3) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `Motherboard_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `Part` (`PartID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Motherboard`
--

LOCK TABLES `Motherboard` WRITE;
/*!40000 ALTER TABLE `Motherboard` DISABLE KEYS */;
INSERT INTO `Motherboard` VALUES (6,'LGA1151','ATX',4,6),(41,'LGA1151','ATX',4,64),(42,'LGA1151','ATX',4,64),(43,'LGA1151','ATX',4,64),(44,'LGA1151','Micro ATX',2,8),(45,'LGA1151','ATX',4,64),(46,'LGA1151','Micro ATX',4,64),(106,'LGA1151','ATX',4,32),(115,'LGA1151','ATX',3,30);
/*!40000 ALTER TABLE `Motherboard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PCCase`
--

DROP TABLE IF EXISTS `PCCase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PCCase` (
  `ID` int(11) NOT NULL,
  `Height` int(3) DEFAULT NULL,
  `Width` int(3) DEFAULT NULL,
  `CDepth` int(3) DEFAULT NULL,
  `Colour` varchar(40) DEFAULT NULL,
  `Motherboard` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `PCCase_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `Part` (`PartID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PCCase`
--

LOCK TABLES `PCCase` WRITE;
/*!40000 ALTER TABLE `PCCase` DISABLE KEYS */;
INSERT INTO `PCCase` VALUES (7,20,30,5,'Blue','Mobo'),(47,497,210,429,'Black','ATX'),(48,627,308,527,'Red','ATX'),(49,307,304,152,'Black','Mini ITX'),(50,414,331,457,'Black','ATX'),(51,420,180,445,'Black/Red','ATX'),(98,527,223,533,'Black- orange','ATX, MicroATX, MiniITX');
/*!40000 ALTER TABLE `PCCase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PSU`
--

DROP TABLE IF EXISTS `PSU`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PSU` (
  `ID` int(11) NOT NULL,
  `Wattage` int(11) DEFAULT NULL,
  `Modular` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `PSU_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `Part` (`PartID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PSU`
--

LOCK TABLES `PSU` WRITE;
/*!40000 ALTER TABLE `PSU` DISABLE KEYS */;
INSERT INTO `PSU` VALUES (8,800,0),(52,650,0),(53,650,0),(54,650,0),(55,600,0),(68,150,1),(69,150,1),(70,120,1),(71,150,1),(72,130,0),(73,200,0),(74,150,0),(75,120,0),(76,120,0),(77,120,0),(78,23,0),(79,23,0),(80,45,0),(81,34,0),(82,45,0),(83,45,0),(84,45,0),(85,45,0),(86,0,0),(87,0,0),(88,0,0),(89,0,0),(90,0,0),(91,0,0),(92,0,0),(93,0,0),(94,0,0);
/*!40000 ALTER TABLE `PSU` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Part`
--

DROP TABLE IF EXISTS `Part`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Part` (
  `PartID` int(11) NOT NULL AUTO_INCREMENT,
  `Price` decimal(6,2) DEFAULT NULL,
  `Model` varchar(45) NOT NULL,
  `Make` varchar(45) NOT NULL,
  `PartType` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`PartID`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Part`
--

LOCK TABLES `Part` WRITE;
/*!40000 ALTER TABLE `Part` DISABLE KEYS */;
INSERT INTO `Part` VALUES (1,305.94,'Core i7-7700K','Intel','CPU'),(2,305.94,'Core i7-7700K','Intel','CPU'),(3,10.00,'TestAccessory1','Intel','Accessory'),(4,12.00,'TestCPU1','Intel','CPU'),(5,14.00,'TestCooler1','Intel','Cooler'),(6,18.00,'TestMobo1','Intel','Motherboard'),(7,18.00,'TestCase1','Intel','PCCase'),(8,10.00,'TestPSU1','Intel','PSU'),(9,16.00,'TestStor1','Intel','Storage'),(10,10.00,'TestCool1','Intel','Cooler'),(11,10.00,'TestCool1','Intel','Cooler'),(12,10.00,'testCooler1','Intel','Cooler'),(13,10.00,'testCooler1','Intel','Cooler'),(14,39.99,'Cooler Max','Intel','Cooler'),(15,39.99,'Cooler Max','Intel','Cooler'),(16,39.99,'Cooler Max','Intel','Cooler'),(17,39.99,'Cooler Max','Intel','Cooler'),(18,30.88,'Cool Running','Intel','Cooler'),(19,99.99,'Storm Z','Intel','Cooler'),(20,15.99,'LavaCooler','Intel','Cooler'),(21,300.00,'Core i7-7700K','Intel','CPU'),(22,110.00,'FX-8350','AMD','CPU'),(23,200.00,'i5-6600','Intel','CPU'),(24,50.90,'Pentium G4560','Intel','CPU'),(25,74.50,'FX-6300','AMD','CPU'),(26,120.00,'Vengance LPX','corsair','RAM'),(27,120.00,'Vengance LPX','corsair','RAM'),(28,120.00,'Vengance LXP','corsair','RAM'),(29,120.00,'Vengance LXP','corsair','RAM'),(30,120.00,'Vengance LPX','corsair','RAM'),(31,100.00,'SuperSC ','AMD','RAM'),(32,250.00,'Ripjaws V ','G.Skill','RAM'),(33,250.00,'Ripjaws V ','G.Skill','RAM'),(34,121.79,'Vengence LED','corsair','RAM'),(35,230.00,'Ballistix Sport LT','Crucial ','RAM'),(36,95.50,'H100i V2','corsair','Cooler'),(37,43.00,'Frozr L','MSI','Cooler'),(38,150.00,'A70','corsair','Cooler'),(39,84.00,'TS13X','Intel','Cooler'),(40,40.50,'BXXTS100H ','AMD','Cooler'),(41,130.00,'Z170-A','Asus','Motherboard'),(42,130.00,'Z170-A','Asus','Motherboard'),(43,143.00,'Z270 Gaming Pro','MSI','Motherboard'),(44,50.00,'DB43LD','MSI','Motherboard'),(45,220.00,'Maximus','Asus','Motherboard'),(46,69.99,'GA B250M','Gigabyte','Motherboard'),(47,56.99,'200R','corsair','PCCase'),(48,100.00,'Vento','Asus','PCCase'),(49,120.00,'Hadron','EVGA','PCCase'),(50,121.00,'Air','corsair','PCCase'),(51,100.00,'GZ-G3','Gigabyte','PCCase'),(52,75.99,'SuperNova','EVGA','PSU'),(53,50.00,'GZ-EMS65A-C1 ','EVGA','PSU'),(54,50.00,'GZ-EMS65A-C1 ','Gigabyte','PSU'),(55,60.00,'600B','EVGA','PSU'),(56,16.00,'Air Series AF140','AMD','Accessory'),(57,16.00,'Air Series AF140','corsair','Accessory'),(58,47.99,'Touch 2100','Aerocool','Accessory'),(59,40.00,'53952KX ','IBM','Accessory'),(60,239.99,'VG248QE','Asus','Accessory'),(61,120.00,'VX228H ','Asus','Accessory'),(62,270.00,'GTX 1060','GeForce','GPU'),(63,367.00,' GeForce GTX ','EVGA','GPU'),(64,273.00,'Radeon','Asus','GPU'),(65,272.00,'Geforce','MSI','GPU'),(66,196.99,'Radeon','Gigabyte','GPU'),(67,645.00,'Radeon Pro','AMD','GPU'),(68,30.00,'test','AMD','PSU'),(69,70.00,'Test','corsair','PSU'),(70,30.00,'','Aerocool','PSU'),(71,20.00,'','Intel','PSU'),(72,30.00,'','Asus','PSU'),(73,30.00,'','Crucial ','PSU'),(74,300.00,'','Aerocool','PSU'),(75,300.00,'test','AMD','PSU'),(76,300.00,'test','AMD','PSU'),(77,300.00,'test','AMD','PSU'),(78,43.00,'test1','Aerocool','PSU'),(79,43.00,'','Aerocool','PSU'),(80,0.00,'test3','Aerocool','PSU'),(81,56.00,'','Aerocool','PSU'),(82,0.00,'rtr','Aerocool','PSU'),(83,0.00,'','Aerocool','PSU'),(84,0.00,'','Aerocool','PSU'),(85,0.00,'56','Aerocool','PSU'),(86,0.00,'','Aerocool','PSU'),(87,0.00,'','Aerocool','PSU'),(88,0.00,'','Aerocool','PSU'),(89,0.00,'','Aerocool','PSU'),(90,0.00,'tr','Aerocool','PSU'),(91,0.00,'tr','Aerocool','PSU'),(92,0.00,'tr','Aerocool','PSU'),(93,0.00,'tr','Aerocool','PSU'),(94,0.00,'t','Aerocool','PSU'),(95,69.98,' Corsair Gaming Scimitar Pro','corsair','Accessory'),(96,10.98,' Dead Silence','Aerocool','Cooler'),(97,87.99,'Dominator','Aerocool','RAM'),(98,84.98,'X-Preditor','Aerocool','PCCase'),(99,114.98,'ROG Strix Geforce','Asus','GPU'),(100,114.98,'ROG Strix Geforce','Asus','GPU'),(101,114.98,'Strix OC Gaming','Asus','GPU'),(102,114.98,'Strix OC Gaming','Asus','GPU'),(103,114.98,'GeForce GTX Gaming','Asus','GPU'),(104,160.50,'Intel SSD 540s ','Intel','Storage'),(105,309.99,'Intel Core I7-7700','Intel','CPU'),(106,122.89,'Intel Z270','MSI','Motherboard'),(107,139.99,'GeForce GTX 1050','MSI','GPU'),(108,139.99,'GeForce GTX 1050','MSI','GPU'),(109,139.99,'GeForce GTX ','MSI','GPU'),(110,120.00,'test','Asus','GPU'),(111,120.00,'Test','corsair','GPU'),(112,120.00,'test','Aerocool','GPU'),(113,120.00,'test','Aerocool','GPU'),(114,120.00,'test','Aerocool','GPU'),(115,120.00,'test','Aerocool','Motherboard');
/*!40000 ALTER TABLE `Part` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RAM`
--

DROP TABLE IF EXISTS `RAM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RAM` (
  `ID` int(11) NOT NULL,
  `Speed` char(4) DEFAULT NULL,
  `SizeGB` int(2) NOT NULL,
  `Sticks` int(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `RAM_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `Part` (`PartID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RAM`
--

LOCK TABLES `RAM` WRITE;
/*!40000 ALTER TABLE `RAM` DISABLE KEYS */;
INSERT INTO `RAM` VALUES (27,'DDR4',16,16),(28,'DDR4',16,16),(29,'DDR4',16,16),(30,'DDR4',16,16),(31,'DDR4',16,1),(33,'DDR4',32,2),(34,'DDR4',16,2),(35,'DDR4',32,2),(97,'3000',8,1);
/*!40000 ALTER TABLE `RAM` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Storage`
--

DROP TABLE IF EXISTS `Storage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Storage` (
  `ID` int(11) NOT NULL,
  `Series` varchar(45) DEFAULT NULL,
  `HHD` tinyint(1) NOT NULL,
  `Speed` int(4) DEFAULT NULL,
  `CapacityGB` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `Storage_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `Part` (`PartID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Storage`
--

LOCK TABLES `Storage` WRITE;
/*!40000 ALTER TABLE `Storage` DISABLE KEYS */;
INSERT INTO `Storage` VALUES (9,'2',0,400,400),(104,'540',0,560,525);
/*!40000 ALTER TABLE `Storage` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-18 20:46:07
