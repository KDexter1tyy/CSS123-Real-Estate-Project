-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: realestate
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.27-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `lottable`
--

DROP TABLE IF EXISTS `lottable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lottable` (
  `LotID` int(11) NOT NULL AUTO_INCREMENT,
  `LotSize` int(11) NOT NULL,
  `LotBlock` int(11) NOT NULL,
  `LotNum` int(11) NOT NULL,
  `LotPrice` int(11) NOT NULL,
  `LotStatus` varchar(45) NOT NULL,
  `UserID` int(11) DEFAULT NULL,
  PRIMARY KEY (`LotID`)
) ENGINE=InnoDB AUTO_INCREMENT=145 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lottable`
--

LOCK TABLES `lottable` WRITE;
/*!40000 ALTER TABLE `lottable` DISABLE KEYS */;
INSERT INTO `lottable` VALUES (1,154,1,1,3666801,'Available',NULL),(2,159,1,2,1098045,'Sold',5),(3,161,1,3,161661,'Available',NULL),(4,143,1,4,1089150,'Available',NULL),(5,207,1,5,738913,'Available',NULL),(6,139,1,6,3336998,'Available',NULL),(7,127,1,7,3052751,'Available',NULL),(8,97,1,8,669285,'Available',NULL),(9,248,1,9,1941663,'Available',NULL),(10,93,1,10,3568030,'Available',NULL),(11,114,1,11,1017617,'Available',NULL),(12,70,1,12,3922460,'Available',NULL),(13,59,1,13,2868198,'Available',NULL),(14,50,1,14,693631,'Available',NULL),(15,186,1,15,4065207,'Available',NULL),(16,157,1,16,4096256,'Available',NULL),(17,250,1,17,742018,'Available',NULL),(18,216,1,18,2732044,'Available',NULL),(19,167,1,19,330685,'Available',NULL),(20,164,1,20,2794625,'Sold',5),(32,132,2,1,821706,'Available',NULL),(33,177,2,2,2760800,'Available',NULL),(34,84,2,3,159858,'Available',NULL),(35,167,2,4,3690103,'Available',NULL),(36,125,2,5,1773250,'Available',NULL),(37,215,2,6,3980818,'Available',NULL),(38,255,2,7,1576292,'Available',NULL),(39,191,2,8,2022200,'Available',NULL),(40,74,2,9,1335170,'Available',NULL),(41,60,2,10,1868446,'Available',NULL),(42,227,2,11,583938,'Available',NULL),(43,247,2,12,2178809,'Available',NULL),(44,149,2,13,4441947,'Available',NULL),(45,151,2,14,2287706,'Available',NULL),(46,52,2,15,2588896,'Available',NULL),(47,213,2,16,1299679,'Available',NULL),(48,252,2,17,493851,'Available',NULL),(49,153,2,18,1186058,'Available',NULL),(50,199,2,19,3990454,'Available',NULL),(51,100,2,20,2644102,'Available',NULL),(63,81,3,1,223862,'Available',NULL),(64,190,3,2,1556468,'Available',NULL),(65,174,3,3,258131,'Available',NULL),(66,124,3,4,3196294,'Available',NULL),(67,138,3,5,306411,'Available',NULL),(68,243,3,6,2555171,'Available',NULL),(69,249,3,7,890559,'Available',NULL),(70,253,3,8,1824087,'Available',NULL),(71,50,3,9,3742632,'Available',NULL),(72,78,3,10,993224,'Available',NULL),(73,174,3,11,1887584,'Available',NULL),(74,95,3,12,4025080,'Available',NULL),(75,213,3,13,1388271,'Available',NULL),(76,67,3,14,2451436,'Available',NULL),(77,137,3,15,2382847,'Available',NULL),(78,116,3,16,311180,'Available',NULL),(79,107,3,17,1166800,'Available',NULL),(80,128,3,18,868592,'Available',NULL),(81,200,3,19,702057,'Available',NULL),(82,150,3,20,221749,'Available',NULL),(94,189,4,1,1394720,'Available',NULL),(95,141,4,2,1603948,'Available',NULL),(96,127,4,3,3822540,'Available',NULL),(97,72,4,4,4492739,'Available',NULL),(98,187,4,5,1659189,'Available',NULL),(99,207,4,6,3389943,'Available',NULL),(100,143,4,7,176221,'Available',NULL),(101,200,4,8,2738710,'Available',NULL),(102,216,4,9,1149509,'Available',NULL),(103,208,4,10,692290,'Available',NULL),(104,124,4,11,1907928,'Available',NULL),(105,248,4,12,2720028,'Available',NULL),(106,66,4,13,2809196,'Available',NULL),(107,222,4,14,1594474,'Available',NULL),(108,88,4,15,4112254,'Available',NULL),(109,50,4,16,1282554,'Available',NULL),(110,120,4,17,4058250,'Available',NULL),(111,147,4,18,3063766,'Available',NULL),(112,244,4,19,3187308,'Available',NULL),(113,189,4,20,1284970,'Available',NULL),(125,116,5,1,3628664,'Available',NULL),(126,59,5,2,3679892,'Available',NULL),(127,242,5,3,1159983,'Available',NULL),(128,131,5,4,1220657,'Available',NULL),(129,67,5,5,3052643,'Available',NULL),(130,69,5,6,2114301,'Available',NULL),(131,51,5,7,2997942,'Available',NULL),(132,106,5,8,1832187,'Available',NULL),(133,80,5,9,2530077,'Available',NULL),(134,116,5,10,4281786,'Available',NULL),(135,212,5,11,483250,'Available',NULL),(136,64,5,12,545681,'Available',NULL),(137,109,5,13,718694,'Available',NULL),(138,222,5,14,3444059,'Available',NULL),(139,109,5,15,868887,'Available',NULL),(140,50,5,16,2212328,'Available',NULL),(141,131,5,17,2514253,'Available',NULL),(142,163,5,18,559856,'Available',NULL),(143,229,5,19,309003,'Available',NULL),(144,177,5,20,4332348,'Available',NULL);
/*!40000 ALTER TABLE `lottable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `UserID` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'wow','wow'),(2,'mkdn','123'),(3,'1234','1234'),(4,'buco','alex'),(5,'123','123');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-02 16:07:52
