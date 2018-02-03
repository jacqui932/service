-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: bridge.cfm1eicskngd.us-west-2.rds.amazonaws.com    Database: bridge
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `bridge_event`
--

DROP TABLE IF EXISTS `bridge_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bridge_event` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `competition_type` varchar(12) NOT NULL,
  `cost` int(11) NOT NULL,
  `date_time` datetime NOT NULL,
  `description` varchar(1000) NOT NULL,
  `masterpoint_type` varchar(5) NOT NULL,
  `name` varchar(1000) NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '0',
  `season_id` bigint(20) NOT NULL,
  `venue` bigint(20) NOT NULL,
  `club_heats` tinyint(1) NOT NULL DEFAULT '0',
  `entry_confirmation_email_addresses` varchar(1000) DEFAULT '',
  `club_representative` tinyint(1) NOT NULL DEFAULT '0',
  `more_info` varchar(255) DEFAULT NULL,
  `allow_pay_on_the_day` tinyint(1) NOT NULL DEFAULT '0',
  `victor_ludorum` tinyint(1) NOT NULL DEFAULT '0',
  `bank_account_id` bigint(20) unsigned NOT NULL DEFAULT '1',
  `heat_qualifier_rule` varchar(9) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3xycp2s6od64f8fcx5h3vk4y3` (`season_id`),
  KEY `FK7otsmf5tdp5o0wm1fnrguegt8` (`venue`),
  KEY `bridge_event_bank_account_idx` (`bank_account_id`),
  CONSTRAINT `FK3xycp2s6od64f8fcx5h3vk4y3` FOREIGN KEY (`season_id`) REFERENCES `season` (`id`),
  CONSTRAINT `FK7otsmf5tdp5o0wm1fnrguegt8` FOREIGN KEY (`venue`) REFERENCES `venue` (`id`),
  CONSTRAINT `bridge_event_bank_account` FOREIGN KEY (`bank_account_id`) REFERENCES `bank_account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-03 17:08:34
