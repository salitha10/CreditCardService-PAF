-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 15, 2022 at 04:02 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `consumerdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `bills`
--

CREATE TABLE `bills` (
  `bill_ID` bigint(20) NOT NULL,
  `user_ID` varchar(1000) NOT NULL,
  `account_ID` varchar(1000) NOT NULL,
  `year` int(5) NOT NULL,
  `month` varchar(20) NOT NULL,
  `date_created` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `units` float NOT NULL,
  `unit_price` float NOT NULL,
  `charge` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bills`
--

INSERT INTO `bills` (`bill_ID`, `user_ID`, `account_ID`, `year`, `month`, `date_created`, `units`, `unit_price`, `charge`) VALUES
(1, '123', '456', 2022, '3', '2022-04-29 12:54:34', 50, 10, 500),
(2, 'EGEN1', '456', 2022, '2', '2022-04-29 14:44:28', 50, 10, 500);

-- --------------------------------------------------------

--
-- Table structure for table `credit_cards`
--

CREATE TABLE `credit_cards` (
  `card_number` varchar(20) NOT NULL,
  `user_ID` varchar(1000) NOT NULL,
  `cvv` int(11) NOT NULL,
  `exp_date` varchar(10) NOT NULL,
  `name_on_card` varchar(100) NOT NULL,
  `card_issuer` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `credit_cards`
--

INSERT INTO `credit_cards` (`card_number`, `user_ID`, `cvv`, `exp_date`, `name_on_card`, `card_issuer`) VALUES
('324532545', '123', 235, '2022-05-26', 'Sali', 'AMERICAN EXPRESS'),
('432452369', '123', 453, '2022-05-09', 'Sali', 'AMERICAN EXPRESS'),
('453534784', '123', 345, '2022-05-24', 'Sali', 'MASTER CARD'),
('741852369', '123', 234, '2022-05-15', 'Sali', 'MASTER CARD');

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `payment_ID` bigint(20) NOT NULL,
  `user_ID` varchar(1000) NOT NULL,
  `bill_ID` varchar(1000) NOT NULL,
  `transaction_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `amount` float NOT NULL,
  `card_number` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payments`
--

INSERT INTO `payments` (`payment_ID`, `user_ID`, `bill_ID`, `transaction_date`, `amount`, `card_number`) VALUES
(1, '123', '1', '2022-04-02 18:30:00', 500, '789654123'),
(3, 'EGEN1', '1', '2022-04-29 12:02:22', 500, '123456789'),
(4, 'EGEN1', '1', '2022-04-29 14:32:34', 500, '123456789'),
(5, 'EGEN1', '1', '2022-04-29 15:19:15', 500, '123456789');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bills`
--
ALTER TABLE `bills`
  ADD PRIMARY KEY (`bill_ID`);

--
-- Indexes for table `credit_cards`
--
ALTER TABLE `credit_cards`
  ADD PRIMARY KEY (`card_number`);

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`payment_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bills`
--
ALTER TABLE `bills`
  MODIFY `bill_ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `payments`
--
ALTER TABLE `payments`
  MODIFY `payment_ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
