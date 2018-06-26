-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 26, 2018 at 04:09 PM
-- Server version: 5.7.21
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `stockmarket`
--

-- --------------------------------------------------------

--
-- Table structure for table `bank`
--

DROP TABLE IF EXISTS `bank`;
CREATE TABLE IF NOT EXISTS `bank` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bank`
--

INSERT INTO `bank` (`id`, `name`) VALUES
(1, 'African Development Bank'),
(2, 'Asian Development Bank'),
(3, 'HSBC'),
(4, 'Bank Of Cylon'),
(5, 'NDB'),
(6, 'Bank of America'),
(7, 'Bank of China'),
(8, 'Pan Asia'),
(9, 'Sampath'),
(10, 'DFCC');

-- --------------------------------------------------------

--
-- Table structure for table `broker`
--

DROP TABLE IF EXISTS `broker`;
CREATE TABLE IF NOT EXISTS `broker` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `broker`
--

INSERT INTO `broker` (`id`, `name`, `rating`) VALUES
(1, 'Lightspeed Trading', 1),
(2, 'TradeStation Securities', 2),
(3, 'optionsXpress', 4),
(4, 'Sampath Brokers', 2),
(5, 'Allianz Security', 1),
(6, 'Lanka Securities', 1),
(7, 'Asia Securities', 5),
(8, 'Softlogic Brokers', 3),
(9, 'TKS Securities', 4),
(10, 'Navara Securities', 5);

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
CREATE TABLE IF NOT EXISTS `company` (
  `id` bigint(20) NOT NULL,
  `grade` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `no_of_shares` int(11) DEFAULT NULL,
  `share_value` double DEFAULT NULL,
  `sector_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmumulhrkylrdxsl33736gudi6` (`sector_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`id`, `grade`, `name`, `no_of_shares`, `share_value`, `sector_id`) VALUES
(1, 2, 'Allion Technologies', 10000, 50, 1),
(2, 3, 'DMS', 10000, 30, 1),
(3, 1, 'MIT', 10000, 60, 1),
(4, 4, 'HEMAS', 10000, 70, 2),
(5, 1, 'ODEL', 10000, 50, 2),
(6, 2, 'Brandix', 10000, 50, 2),
(7, 3, 'Softlogic Finance', 10000, 40, 3),
(8, 1, 'Singer', 10000, 45, 3),
(9, 1, 'Adidas', 10000, 80, 2),
(10, 3, 'Sysco Finance', 10000, 50, 3),
(11, 1, 'Virtusa', 10000, 55, 1),
(12, 5, 'Blue Ocean', 10000, 20, 2),
(13, 1, 'Emar Parm', 10000, 30, 3),
(14, 1, 'Jhon Keels', 10000, 100, 1),
(15, 1, 'Abance', 10000, 100, 1);

-- --------------------------------------------------------

--
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
CREATE TABLE IF NOT EXISTS `game` (
  `id` bigint(20) NOT NULL,
  `current_rounds` int(11) DEFAULT NULL,
  `game_leader_id` bigint(20) DEFAULT NULL,
  `game_leader_point` double DEFAULT NULL,
  `no_of_players` int(11) DEFAULT NULL,
  `no_of_rounds` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `game_company`
--

DROP TABLE IF EXISTS `game_company`;
CREATE TABLE IF NOT EXISTS `game_company` (
  `id` bigint(20) NOT NULL,
  `no_of_shares` int(11) DEFAULT NULL,
  `share_value` double DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `game_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK572spqe9qkdd02hl293el0sc8` (`company_id`),
  KEY `FKtecuf0pr0c4cfopr09eaaa9hg` (`game_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `game_player`
--

DROP TABLE IF EXISTS `game_player`;
CREATE TABLE IF NOT EXISTS `game_player` (
  `id` bigint(20) NOT NULL,
  `bankbalance` double DEFAULT NULL,
  `score` double DEFAULT NULL,
  `total_purchase` double DEFAULT NULL,
  `total_sales` double DEFAULT NULL,
  `bank_id` bigint(20) DEFAULT NULL,
  `broker_id` bigint(20) DEFAULT NULL,
  `game_id` bigint(20) DEFAULT NULL,
  `player_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa5t9sa98vbt6onm37uytm124v` (`bank_id`),
  KEY `FK2p4ett5xy1d30kofcpmefceej` (`broker_id`),
  KEY `FK8so14tnd5mqdjqabugc0cycxu` (`game_id`),
  KEY `FK7ntwi66eylpagi55pmm4i61l5` (`player_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `game_round`
--

DROP TABLE IF EXISTS `game_round`;
CREATE TABLE IF NOT EXISTS `game_round` (
  `id` bigint(20) NOT NULL,
  `round_leader_id` bigint(20) DEFAULT NULL,
  `round_leader_point` int(11) DEFAULT NULL,
  `game_id` bigint(20) DEFAULT NULL,
  `round_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoy982xqm8lmwtwackq4y4jct1` (`game_id`),
  KEY `FK722eo6n4w1iqkjo6rjd674k8d` (`round_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `game_round_company`
--

DROP TABLE IF EXISTS `game_round_company`;
CREATE TABLE IF NOT EXISTS `game_round_company` (
  `id` bigint(20) NOT NULL,
  `share_value` double DEFAULT NULL,
  `game_company_id` bigint(20) DEFAULT NULL,
  `game_round_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkq9eonpecs16weoylbdn4v9ib` (`game_company_id`),
  KEY `FK6ncn30tn818wmb685toms5jut` (`game_round_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `game_round_player`
--

DROP TABLE IF EXISTS `game_round_player`;
CREATE TABLE IF NOT EXISTS `game_round_player` (
  `id` bigint(20) NOT NULL,
  `score` double DEFAULT NULL,
  `game_round_id` bigint(20) DEFAULT NULL,
  `player_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3bog5ljfht2soqhd6ipkl6u0t` (`game_round_id`),
  KEY `FKgkiq3pd0qhass93afsjda8561` (`player_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `player`
--

DROP TABLE IF EXISTS `player`;
CREATE TABLE IF NOT EXISTS `player` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `ai` bit(1) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_playing` bit(1) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `playerpurchase`
--

DROP TABLE IF EXISTS `playerpurchase`;
CREATE TABLE IF NOT EXISTS `playerpurchase` (
  `id` bigint(20) NOT NULL,
  `no_of_share` int(11) DEFAULT NULL,
  `share_value` double DEFAULT NULL,
  `is_sold` bit(1) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `game_player_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmuss5qu6nl9rxs8vkh7hvu7gg` (`company_id`),
  KEY `FKab7gkbr7xta755t55lddm4of7` (`game_player_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `player_transactions`
--

DROP TABLE IF EXISTS `player_transactions`;
CREATE TABLE IF NOT EXISTS `player_transactions` (
  `id` bigint(20) NOT NULL,
  `amount` float DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `transaction_no` varchar(255) DEFAULT NULL,
  `bank_id` bigint(20) DEFAULT NULL,
  `game_player_id` bigint(20) DEFAULT NULL,
  `game_round_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkqvwgq82cdk0wra6i6utyg59i` (`bank_id`),
  KEY `FKqk6srghwywg47ohjfxb9c5d07` (`game_player_id`),
  KEY `FKcpki7epr7rj7urk5ck5kkqg6f` (`game_round_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `round`
--

DROP TABLE IF EXISTS `round`;
CREATE TABLE IF NOT EXISTS `round` (
  `id` bigint(20) NOT NULL,
  `round_no` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `round`
--

INSERT INTO `round` (`id`, `round_no`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- --------------------------------------------------------

--
-- Table structure for table `sector`
--

DROP TABLE IF EXISTS `sector`;
CREATE TABLE IF NOT EXISTS `sector` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sector`
--

INSERT INTO `sector` (`id`, `name`) VALUES
(1, 'IT'),
(2, 'Garment'),
(3, 'Finance');

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
CREATE TABLE IF NOT EXISTS `test` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `watch_list`
--

DROP TABLE IF EXISTS `watch_list`;
CREATE TABLE IF NOT EXISTS `watch_list` (
  `id` bigint(20) NOT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `game_player_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpb1jljwtr1kstfg17tmwiuq20` (`company_id`),
  KEY `FKyw7pl5k74nk79pdueq19pu4` (`game_player_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `company`
--
ALTER TABLE `company`
  ADD CONSTRAINT `FKmumulhrkylrdxsl33736gudi6` FOREIGN KEY (`sector_id`) REFERENCES `sector` (`id`);

--
-- Constraints for table `game_company`
--
ALTER TABLE `game_company`
  ADD CONSTRAINT `FK572spqe9qkdd02hl293el0sc8` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`),
  ADD CONSTRAINT `FKtecuf0pr0c4cfopr09eaaa9hg` FOREIGN KEY (`game_id`) REFERENCES `game` (`id`);

--
-- Constraints for table `game_player`
--
ALTER TABLE `game_player`
  ADD CONSTRAINT `FK2p4ett5xy1d30kofcpmefceej` FOREIGN KEY (`broker_id`) REFERENCES `broker` (`id`),
  ADD CONSTRAINT `FK7ntwi66eylpagi55pmm4i61l5` FOREIGN KEY (`player_id`) REFERENCES `player` (`id`),
  ADD CONSTRAINT `FK8so14tnd5mqdjqabugc0cycxu` FOREIGN KEY (`game_id`) REFERENCES `game` (`id`),
  ADD CONSTRAINT `FKa5t9sa98vbt6onm37uytm124v` FOREIGN KEY (`bank_id`) REFERENCES `bank` (`id`);

--
-- Constraints for table `game_round`
--
ALTER TABLE `game_round`
  ADD CONSTRAINT `FK722eo6n4w1iqkjo6rjd674k8d` FOREIGN KEY (`round_id`) REFERENCES `round` (`id`),
  ADD CONSTRAINT `FKoy982xqm8lmwtwackq4y4jct1` FOREIGN KEY (`game_id`) REFERENCES `game` (`id`);

--
-- Constraints for table `game_round_company`
--
ALTER TABLE `game_round_company`
  ADD CONSTRAINT `FK6ncn30tn818wmb685toms5jut` FOREIGN KEY (`game_round_id`) REFERENCES `game_round` (`id`),
  ADD CONSTRAINT `FKkq9eonpecs16weoylbdn4v9ib` FOREIGN KEY (`game_company_id`) REFERENCES `game_company` (`id`);

--
-- Constraints for table `game_round_player`
--
ALTER TABLE `game_round_player`
  ADD CONSTRAINT `FK3bog5ljfht2soqhd6ipkl6u0t` FOREIGN KEY (`game_round_id`) REFERENCES `game_round` (`id`),
  ADD CONSTRAINT `FKgkiq3pd0qhass93afsjda8561` FOREIGN KEY (`player_id`) REFERENCES `player` (`id`);

--
-- Constraints for table `playerpurchase`
--
ALTER TABLE `playerpurchase`
  ADD CONSTRAINT `FKab7gkbr7xta755t55lddm4of7` FOREIGN KEY (`game_player_id`) REFERENCES `game_player` (`id`),
  ADD CONSTRAINT `FKmuss5qu6nl9rxs8vkh7hvu7gg` FOREIGN KEY (`company_id`) REFERENCES `game_company` (`id`);

--
-- Constraints for table `player_transactions`
--
ALTER TABLE `player_transactions`
  ADD CONSTRAINT `FKcpki7epr7rj7urk5ck5kkqg6f` FOREIGN KEY (`game_round_id`) REFERENCES `game_round` (`id`),
  ADD CONSTRAINT `FKkqvwgq82cdk0wra6i6utyg59i` FOREIGN KEY (`bank_id`) REFERENCES `bank` (`id`),
  ADD CONSTRAINT `FKqk6srghwywg47ohjfxb9c5d07` FOREIGN KEY (`game_player_id`) REFERENCES `game_player` (`id`);

--
-- Constraints for table `watch_list`
--
ALTER TABLE `watch_list`
  ADD CONSTRAINT `FKpb1jljwtr1kstfg17tmwiuq20` FOREIGN KEY (`company_id`) REFERENCES `game_company` (`id`),
  ADD CONSTRAINT `FKyw7pl5k74nk79pdueq19pu4` FOREIGN KEY (`game_player_id`) REFERENCES `game_player` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
