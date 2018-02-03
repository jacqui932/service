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
-- Temporary view structure for view `event_summary`
--

DROP TABLE IF EXISTS `event_summary`;
/*!50001 DROP VIEW IF EXISTS `event_summary`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `event_summary` AS SELECT 
 1 AS `id`,
 1 AS `name`,
 1 AS `active`,
 1 AS `date_time`,
 1 AS `season_id`,
 1 AS `masterpoint_type`,
 1 AS `entries`,
 1 AS `unpaid_pay_in_advance_count`,
 1 AS `unpaid_pay_on_the_day_count`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `heat_qualifier_email_view`
--

DROP TABLE IF EXISTS `heat_qualifier_email_view`;
/*!50001 DROP VIEW IF EXISTS `heat_qualifier_email_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `heat_qualifier_email_view` AS SELECT 
 1 AS `id`,
 1 AS `club_name`,
 1 AS `first_name`,
 1 AS `email`,
 1 AS `heat_qualifier_id`,
 1 AS `date_time`,
 1 AS `event_id`,
 1 AS `event_name`,
 1 AS `event_date`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `heat_qualifiers_summary`
--

DROP TABLE IF EXISTS `heat_qualifiers_summary`;
/*!50001 DROP VIEW IF EXISTS `heat_qualifiers_summary`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `heat_qualifiers_summary` AS SELECT 
 1 AS `heat_id`,
 1 AS `club_id`,
 1 AS `club_name`,
 1 AS `heat_date`,
 1 AS `event_id`,
 1 AS `season_id`,
 1 AS `event_name`,
 1 AS `num_qualifiers`,
 1 AS `num_entries`,
 1 AS `num_unmatched_entries`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `heat_summary`
--

DROP TABLE IF EXISTS `heat_summary`;
/*!50001 DROP VIEW IF EXISTS `heat_summary`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `heat_summary` AS SELECT 
 1 AS `id`,
 1 AS `club_id`,
 1 AS `club_name`,
 1 AS `date_time`,
 1 AS `event_id`,
 1 AS `event_name`,
 1 AS `num_qualifiers`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `club_qualifiers_summary`
--

DROP TABLE IF EXISTS `club_qualifiers_summary`;
/*!50001 DROP VIEW IF EXISTS `club_qualifiers_summary`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `club_qualifiers_summary` AS SELECT 
 1 AS `club_id`,
 1 AS `name`,
 1 AS `active`,
 1 AS `season_id`,
 1 AS `num_heats`,
 1 AS `num_heats_without_qualifiers`,
 1 AS `total_entries`,
 1 AS `num_unmatched_event_entries`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `event_summary`
--

/*!50001 DROP VIEW IF EXISTS `event_summary`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`bridgeevents`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `event_summary` AS select `b`.`id` AS `id`,`b`.`name` AS `name`,`b`.`active` AS `active`,`b`.`date_time` AS `date_time`,`b`.`season_id` AS `season_id`,`b`.`masterpoint_type` AS `masterpoint_type`,count(`t`.`event`) AS `entries`,cast(sum(ifnull(`t`.`unpaid_pay_in_advance_count`,0)) as signed) AS `unpaid_pay_in_advance_count`,cast(sum(ifnull(`t`.`unpaid_pay_on_the_day_count`,0)) as signed) AS `unpaid_pay_on_the_day_count` from (`bridge`.`bridge_event` `b` left join ((select `bridge`.`event_entry`.`event` AS `event`,(case when ((`bridge`.`event_entry`.`fully_paid` = 0) and (`bridge`.`event_entry`.`payment_method` <> 'Pay On The Day')) then 1 else 0 end) AS `unpaid_pay_in_advance_count`,(case when ((`bridge`.`event_entry`.`fully_paid` = 0) and (`bridge`.`event_entry`.`payment_method` = 'Pay On The Day')) then 1 else 0 end) AS `unpaid_pay_on_the_day_count` from `bridge`.`event_entry` where (`bridge`.`event_entry`.`withdrawn` = 0))) `t` on((`t`.`event` = `b`.`id`))) group by `b`.`id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `heat_qualifier_email_view`
--

/*!50001 DROP VIEW IF EXISTS `heat_qualifier_email_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`bridgeevents`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `heat_qualifier_email_view` AS select `hqp`.`id` AS `id`,`c`.`name` AS `club_name`,`hqp`.`first_name` AS `first_name`,`p`.`email` AS `email`,`hq`.`id` AS `heat_qualifier_id`,`h`.`date_time` AS `date_time`,`h`.`event_id` AS `event_id`,`be`.`name` AS `event_name`,`be`.`date_time` AS `event_date` from ((((`heat` `h` join `heat_qualifier` `hq`) join `club` `c`) join `bridge_event` `be`) join (`heat_qualifier_player` `hqp` left join `player` `p` on((`p`.`ebu_number` = `hqp`.`ebu_number`)))) where (`hqp`.`heat_qualifier_id` in (select `hq`.`id` from `heat_qualifier` `hq` where isnull(`hq`.`event_entry_id`)) and (`h`.`id` = `hq`.`heat`) and (`hqp`.`heat_qualifier_id` = `hq`.`id`) and (`h`.`event_id` = `be`.`id`) and (`c`.`id` = `h`.`club_id`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `heat_qualifiers_summary`
--

/*!50001 DROP VIEW IF EXISTS `heat_qualifiers_summary`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`bridgeevents`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `heat_qualifiers_summary` AS select `heat`.`id` AS `heat_id`,`club`.`id` AS `club_id`,`club`.`name` AS `club_name`,`heat`.`date_time` AS `heat_date`,`heat`.`event_id` AS `event_id`,`bridge_event`.`season_id` AS `season_id`,`bridge_event`.`name` AS `event_name`,(select count(0) from `heat_qualifier` where (`heat_qualifier`.`heat` = `heat`.`id`)) AS `num_qualifiers`,(select count(0) from `event_entry` where (`event_entry`.`heat` = `heat`.`id`)) AS `num_entries`,(select count(0) from `event_entry` where ((`event_entry`.`heat` = `heat`.`id`) and (not(exists(select 1 from `heat_qualifier` where (`heat_qualifier`.`event_entry_id` = `event_entry`.`id`)))))) AS `num_unmatched_entries` from ((`club` join `heat` on((`heat`.`club_id` = `club`.`id`))) join `bridge_event` on((`bridge_event`.`id` = `heat`.`event_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `heat_summary`
--

/*!50001 DROP VIEW IF EXISTS `heat_summary`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`bridgeevents`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `heat_summary` AS select `heat`.`id` AS `id`,`heat`.`club_id` AS `club_id`,`club`.`name` AS `club_name`,`heat`.`date_time` AS `date_time`,`heat`.`event_id` AS `event_id`,`bridge_event`.`name` AS `event_name`,(select count(0) from `heat_qualifier` where (`heat_qualifier`.`heat` = `heat`.`id`)) AS `num_qualifiers` from ((`heat` join `club` on((`heat`.`club_id` = `club`.`id`))) join `bridge_event` on((`heat`.`event_id` = `bridge_event`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `club_qualifiers_summary`
--

/*!50001 DROP VIEW IF EXISTS `club_qualifiers_summary`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`bridgeevents`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `club_qualifiers_summary` AS select `club`.`id` AS `club_id`,`club`.`name` AS `name`,`club`.`active` AS `active`,`season`.`id` AS `season_id`,(select count(0) from `heat` where (`heat`.`event_id` in (select `bridge_event`.`id` from `bridge_event` where (`bridge_event`.`season_id` = `season`.`id`)) and (`heat`.`club_id` = `club`.`id`))) AS `num_heats`,(select count(0) from `heat` where (`heat`.`event_id` in (select `bridge_event`.`id` from `bridge_event` where (`bridge_event`.`season_id` = `season`.`id`)) and (`heat`.`club_id` = `club`.`id`) and (`heat`.`date_time` < curdate()) and (not(exists(select 1 from `heat_qualifier` where (`heat_qualifier`.`heat` = `heat`.`id`)))))) AS `num_heats_without_qualifiers`,(select count(0) from `event_entry` where `event_entry`.`heat` in (select `heat`.`id` from `heat` where (`heat`.`event_id` in (select `bridge_event`.`id` from `bridge_event` where (`bridge_event`.`season_id` = `season`.`id`)) and (`heat`.`club_id` = `club`.`id`)))) AS `total_entries`,(select count(0) from `event_entry` where (`event_entry`.`heat` in (select `heat`.`id` from `heat` where (`heat`.`event_id` in (select `bridge_event`.`id` from `bridge_event` where (`bridge_event`.`season_id` = `season`.`id`)) and (`heat`.`club_id` = `club`.`id`))) and (not(exists(select 1 from `heat_qualifier` where (`heat_qualifier`.`event_entry_id` = `event_entry`.`id`)))))) AS `num_unmatched_event_entries` from (`club` join `season`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-03 17:10:25
