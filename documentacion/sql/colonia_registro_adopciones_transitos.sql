-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: colonia
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `registro_adopciones_transitos`
--

DROP TABLE IF EXISTS `registro_adopciones_transitos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registro_adopciones_transitos` (
  `fechaFin` date DEFAULT NULL,
  `fechaInicio` date NOT NULL,
  `idFamilia` int DEFAULT NULL,
  `idGato` int DEFAULT NULL,
  `idRegistro` int NOT NULL AUTO_INCREMENT,
  `idVoluntario` int DEFAULT NULL,
  `tipo` varchar(20) NOT NULL,
  `observaciones` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idRegistro`),
  KEY `FK77ijw8k7b9h2i8d468gbad2cc` (`idFamilia`),
  KEY `FKlrp0d4fauid0nda1r6d9p17jo` (`idGato`),
  KEY `FKdual1sv9888micsbqecx8lv57` (`idVoluntario`),
  CONSTRAINT `FK77ijw8k7b9h2i8d468gbad2cc` FOREIGN KEY (`idFamilia`) REFERENCES `familia_adoptante` (`idUsuario`),
  CONSTRAINT `FKdual1sv9888micsbqecx8lv57` FOREIGN KEY (`idVoluntario`) REFERENCES `voluntario` (`idUsuario`),
  CONSTRAINT `FKlrp0d4fauid0nda1r6d9p17jo` FOREIGN KEY (`idGato`) REFERENCES `gato` (`idGato`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro_adopciones_transitos`
--

LOCK TABLES `registro_adopciones_transitos` WRITE;
/*!40000 ALTER TABLE `registro_adopciones_transitos` DISABLE KEYS */;
/*!40000 ALTER TABLE `registro_adopciones_transitos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-10-31 21:43:35
