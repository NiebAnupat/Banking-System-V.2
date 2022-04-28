-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 28, 2022 at 09:30 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `banking-system-v2`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `user_id` varchar(512) CHARACTER SET utf8 NOT NULL,
  `ac_number` varchar(20) CHARACTER SET utf8 NOT NULL,
  `bank_id` varchar(11) CHARACTER SET utf8 NOT NULL,
  `ac_name` varchar(512) CHARACTER SET utf8 NOT NULL,
  `ac_balance` double NOT NULL,
  `ac_pin` varchar(6) CHARACTER SET utf8 NOT NULL,
  `ac_user_tel` varchar(10) CHARACTER SET utf8 NOT NULL,
  `ac_user_citizen_id` varchar(13) CHARACTER SET utf8 NOT NULL,
  `ac_user_address` varchar(256) CHARACTER SET utf8 NOT NULL,
  `ac_status` varchar(5) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`user_id`, `ac_number`, `bank_id`, `ac_name`, `ac_balance`, `ac_pin`, `ac_user_tel`, `ac_user_citizen_id`, `ac_user_address`, `ac_status`) VALUES
('Admin01', '0946451', '2', 'Test4', 1772, '1234', 'Test4', 'Test4', 'Test4', 't'),
('Admin01', '1234', '1', 'Anupat Kaewmee', 1351, '1234', '0661128806', '1149900762794', 'Admin', 't'),
('anupat', '4695742', '4', 'Anupat Kaewmee', 250, '1111', '0000000000', '11111111111', 'Test', 't'),
('admin01', '5379585', '5', 'asd', 0, '1234', 'a', 'a', 'a', 't'),
('6401861', '5493046', '1', 'Non Here', -801, '25520', '0943986347', '54684', '5485', 't'),
('6401861', '6279136', '6', 'Mai Mee Tang', 999810, '5446', '0943986347', '2842186', '55555', 't'),
('admin01', '6938887', '1', 'a', 0, '1234', 'a', 'a', 'a', 't'),
('Admin01', '7258132', '4', 'Test', 1812, '1234', 'Test', 'Test', 'Test', 't'),
('Admin01', '7332418', '5', 'Test02', 5195, '4321', 'Test02', 'Test02', 'Test02', 't'),
('Admin01', '8633843', '6', 'Test3', 1000, '1234', 'Test3', 'Test3', 'Test3', 't');

-- --------------------------------------------------------

--
-- Table structure for table `bank`
--

CREATE TABLE `bank` (
  `bank_id` varchar(11) NOT NULL,
  `bank_name` varchar(512) NOT NULL,
  `bank_balance` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bank`
--

INSERT INTO `bank` (`bank_id`, `bank_name`, `bank_balance`) VALUES
('1', 'Nieb Banking', 550),
('2', 'Noey Banking', 1772),
('3', 'Eng Banking', 0),
('4', 'Pimuk Banking', 2062),
('5', 'Pee Banking', 5195),
('6', 'Ice Banking', 1000810);

-- --------------------------------------------------------

--
-- Table structure for table `banking_type`
--

CREATE TABLE `banking_type` (
  `type_id` varchar(11) NOT NULL,
  `type_name` varchar(512) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `banking_type`
--

INSERT INTO `banking_type` (`type_id`, `type_name`) VALUES
('1', 'Deposit'),
('2', 'Withdraw'),
('3', 'Transfer'),
('4', 'Receive Money');

-- --------------------------------------------------------

--
-- Table structure for table `moneydeposit`
--

CREATE TABLE `moneydeposit` (
  `dp_id` int(11) NOT NULL,
  `dp_money` double NOT NULL,
  `ac_number` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `moneydeposit`
--

INSERT INTO `moneydeposit` (`dp_id`, `dp_money`, `ac_number`) VALUES
(1, 20000, '1234'),
(2, 250, '7258132'),
(9, 3200, '1234'),
(10, 90, '7332418'),
(11, 80, '7258132'),
(12, 70, '7332418'),
(13, 70, '7258132'),
(14, 60, '1234'),
(15, 8, '7258132'),
(16, 5, '7332418'),
(17, 1, '1234'),
(18, 1, '7332418'),
(19, 1, '1234'),
(20, 1, '7258132'),
(21, 1, '1234'),
(22, 1, '7258132'),
(23, 1, '1234'),
(24, 1, '1234'),
(25, 1, '7332418'),
(26, 1, '1234'),
(27, 1, '7332418'),
(28, 1, '7258132'),
(29, 1, '7258132'),
(30, 200, '7258132'),
(31, 1, '7258132'),
(32, 1, '7332418'),
(33, 1, '1234'),
(34, 2000, '1234'),
(35, 412, '7332418'),
(36, 32, '7258132'),
(37, 9, '7258132'),
(38, 54, '7258132'),
(39, 2, '7332418'),
(40, 123, '7258132'),
(41, 23, '7332418'),
(42, 1, '1234'),
(43, 3200, '7258132'),
(44, 3200, '7332418'),
(45, 860, '7258132'),
(46, 100, '1234'),
(47, 432, '1234'),
(48, 2000, '7332418'),
(49, 12, '1234'),
(50, 42, '7332418'),
(51, 4200, '7258132'),
(52, 100, '7332418'),
(53, 9, '7258132'),
(54, 100, '7258132'),
(55, 10000, '1234'),
(56, 10000, '1234'),
(57, 1000, '8633843'),
(58, 10, '7258132'),
(59, 10, '8633843'),
(60, 420, '0946451'),
(61, 3, '1234'),
(62, 31, '8633843'),
(63, 2, '7258132'),
(64, 1, '7332418'),
(65, 234, '7332418'),
(66, 234, '1234'),
(67, 10, '7332418'),
(68, 100, '1234'),
(69, 100, '0946451'),
(70, 10, '0946451'),
(71, 100, '7258132'),
(72, 10, '0946451'),
(73, 10, '0946451'),
(74, 10, '0946451'),
(75, 30, '0946451'),
(76, 9, '8633843'),
(77, 10, '0946451'),
(78, 10, '0946451'),
(79, 10, '0946451'),
(80, 10, '0946451'),
(81, 37, '0946451'),
(82, 2, '7332418'),
(83, 20000, '0946451'),
(84, 200000, '0946451'),
(85, 2000000, '0946451'),
(86, 20000000, '0946451'),
(87, 123456, '1234'),
(88, 1000000, '6279136'),
(89, 10, '6279136'),
(90, 25, '5493046'),
(91, 10000000, '0946451'),
(92, 10000000, '0946451'),
(93, 100000000, '0946451'),
(94, 1000000000, '0946451'),
(95, 4, '1234'),
(96, 20000000, '0946451'),
(97, 200000, '1234'),
(98, 500, '0946451'),
(99, 1000, '4695742');

-- --------------------------------------------------------

--
-- Table structure for table `moneytransfer`
--

CREATE TABLE `moneytransfer` (
  `tf_id` int(11) NOT NULL,
  `tf_money` double NOT NULL,
  `ac_number_transferor` varchar(256) NOT NULL,
  `ac_number_recipient` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `moneytransfer`
--

INSERT INTO `moneytransfer` (`tf_id`, `tf_money`, `ac_number_transferor`, `ac_number_recipient`) VALUES
(1, 1242, '0946451', '1234'),
(2, 9000, '7258132', '7332418'),
(3, 20000, '0946451', '1234'),
(4, 10000, '0946451', '1234'),
(5, 500, '0946451', '1234'),
(6, 500, '0946451', '7258132'),
(7, 1000, '0946451', '7258132'),
(8, 200, '6279136', '5493046'),
(9, 1000, '5493046', '1234'),
(10, 2000, '1234', '0946451'),
(11, 500, '0946451', '1234'),
(12, 500, '4695742', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `moneywithdraw`
--

CREATE TABLE `moneywithdraw` (
  `wd_id` int(11) NOT NULL,
  `wd_money` double NOT NULL,
  `ac_number` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `moneywithdraw`
--

INSERT INTO `moneywithdraw` (`wd_id`, `wd_money`, `ac_number`) VALUES
(1, 2000000, '0946451'),
(2, 20000000, '0946451'),
(3, 50, '8633843'),
(4, 10000, '7332418'),
(5, 26, '5493046'),
(6, 1000000000, '0946451'),
(7, 100000000, '0946451'),
(8, 40000000, '0946451'),
(9, 180000, '0946451'),
(10, 400000, '1234'),
(11, 7000, '0946451'),
(12, 500, '0946451'),
(13, 250, '4695742');

-- --------------------------------------------------------

--
-- Table structure for table `statements`
--

CREATE TABLE `statements` (
  `stm_id` int(11) NOT NULL,
  `stm_date` datetime NOT NULL,
  `type_id` varchar(11) NOT NULL,
  `ac_number` varchar(11) NOT NULL,
  `banking_id` varchar(11) NOT NULL,
  `amount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `statements`
--

INSERT INTO `statements` (`stm_id`, `stm_date`, `type_id`, `ac_number`, `banking_id`, `amount`) VALUES
(1, '2565-03-06 09:41:10', '1', '1234', '1', 20000),
(2, '2565-03-06 09:43:39', '1', '7258132', '2', 250),
(10, '2565-03-06 10:31:45', '1', '1234', '9', 3200),
(11, '2565-03-06 10:33:01', '1', '7332418', '10', 90),
(12, '2565-03-06 10:33:16', '1', '7258132', '11', 80),
(13, '2565-03-06 10:33:31', '1', '7332418', '12', 70),
(14, '2565-03-06 10:33:48', '1', '7258132', '13', 70),
(15, '2565-03-06 10:34:04', '1', '1234', '14', 60),
(16, '2565-03-06 10:34:14', '1', '7258132', '15', 8),
(17, '2565-03-06 10:34:28', '1', '7332418', '16', 5),
(18, '2565-03-06 10:40:04', '1', '1234', '17', 1),
(19, '2565-03-06 10:40:10', '1', '7332418', '18', 1),
(20, '2565-03-06 10:40:15', '1', '1234', '19', 1),
(21, '2565-03-06 10:40:20', '1', '7258132', '20', 1),
(22, '2565-03-06 10:40:27', '1', '1234', '21', 1),
(23, '2565-03-06 10:40:33', '1', '7258132', '22', 1),
(24, '2565-03-06 10:40:37', '1', '1234', '23', 1),
(25, '2565-03-06 10:40:44', '1', '1234', '24', 1),
(26, '2565-03-06 10:40:49', '1', '7332418', '25', 1),
(27, '2565-03-06 10:40:52', '1', '1234', '26', 1),
(28, '2565-03-06 10:41:01', '1', '7332418', '27', 1),
(29, '2565-03-06 10:41:05', '1', '7258132', '28', 1),
(30, '2565-03-06 10:41:11', '1', '7258132', '29', 1),
(31, '2565-03-06 10:41:36', '1', '7258132', '30', 200),
(32, '2565-03-06 10:41:54', '1', '7258132', '31', 1),
(33, '2565-03-06 10:42:00', '1', '7332418', '32', 1),
(34, '2565-03-06 10:42:03', '1', '1234', '33', 1),
(35, '2565-03-06 10:45:54', '1', '1234', '34', 2000),
(36, '2565-03-06 10:48:38', '1', '7332418', '35', 412),
(37, '2565-03-06 10:49:00', '1', '7258132', '36', 32),
(38, '2565-03-06 10:52:42', '1', '7258132', '37', 9),
(39, '2565-03-06 10:52:57', '1', '7258132', '38', 54),
(40, '2565-03-06 10:53:03', '1', '7332418', '39', 2),
(41, '2565-03-06 10:53:11', '1', '7258132', '40', 123),
(42, '2565-03-06 10:53:17', '1', '7332418', '41', 23),
(43, '2565-03-06 10:53:20', '1', '1234', '42', 1),
(44, '2565-03-06 11:03:35', '1', '7258132', '43', 3200),
(45, '2565-03-06 11:04:12', '1', '7332418', '44', 3200),
(46, '2565-03-06 11:05:53', '1', '7258132', '45', 860),
(47, '2565-03-06 11:47:11', '1', '1234', '46', 100),
(48, '2565-03-06 11:51:51', '1', '1234', '47', 432),
(49, '2565-03-06 12:00:08', '1', '7332418', '48', 2000),
(50, '2565-03-06 12:00:32', '1', '1234', '49', 12),
(51, '2565-03-06 12:00:40', '1', '7332418', '50', 42),
(52, '2565-03-06 12:03:51', '1', '7258132', '51', 4200),
(53, '2565-03-06 12:04:24', '1', '7332418', '52', 100),
(54, '2565-03-06 13:59:04', '1', '7258132', '53', 9),
(55, '2565-03-06 14:10:59', '1', '7258132', '54', 100),
(56, '2565-03-06 16:17:22', '1', '1234', '55', 10000),
(57, '2565-03-06 16:17:36', '1', '1234', '56', 10000),
(58, '2565-03-06 16:17:43', '1', '8633843', '57', 1000),
(59, '2565-03-06 16:18:48', '1', '7258132', '58', 10),
(60, '2565-03-06 16:18:52', '1', '8633843', '59', 10),
(61, '2565-03-06 16:27:43', '1', '946451', '60', 420),
(62, '2565-03-06 16:27:49', '1', '1234', '61', 3),
(63, '2565-03-06 16:27:53', '1', '8633843', '62', 31),
(64, '2565-03-06 16:28:05', '1', '7258132', '63', 2),
(65, '2565-03-06 16:28:14', '1', '7332418', '64', 1),
(68, '2565-03-10 06:47:18', '1', '946451', '74', 10),
(69, '2565-03-10 06:47:23', '1', '946451', '75', 30),
(70, '2565-03-10 06:47:30', '1', '8633843', '76', 9),
(73, '2565-03-10 08:35:29', '1', '0946451', '79', 10),
(74, '2565-03-10 08:36:39', '1', '0946451', '80', 10),
(75, '2565-03-10 08:36:51', '1', '0946451', '81', 37),
(76, '2565-03-10 08:36:58', '1', '7332418', '82', 2),
(77, '2565-03-10 08:37:06', '1', '0946451', '83', 20000),
(78, '2565-03-10 08:37:12', '1', '0946451', '84', 200000),
(79, '2565-03-10 08:37:35', '1', '0946451', '85', 2000000),
(80, '2565-03-10 08:37:45', '1', '0946451', '86', 20000000),
(81, '2565-03-10 08:37:57', '1', '1234', '87', 123456),
(82, '2565-03-10 08:52:24', '2', '0946451', '1', 2000000),
(83, '2565-03-10 08:52:34', '2', '0946451', '2', 20000000),
(84, '2565-03-10 08:54:06', '2', '8633843', '3', 50),
(85, '2565-03-10 11:17:11', '3', '0946451', '1', 1242),
(86, '2565-03-10 11:19:59', '3', '7258132', '2', 9000),
(87, '2565-03-10 11:21:29', '2', '7332418', '4', 10000),
(88, '2565-03-10 11:22:22', '3', '0946451', '3', 20000),
(89, '2565-03-10 11:38:03', '3', '0946451', '4', 10000),
(90, '2565-03-10 11:38:03', '4', '1234', '4', 10000),
(91, '2565-03-12 13:00:47', '3', '0946451', '5', 500),
(92, '2565-03-12 13:00:47', '4', '1234', '5', 500),
(93, '2565-03-12 13:18:04', '3', '0946451', '6', 500),
(94, '2565-03-12 13:18:04', '4', '7258132', '6', 500),
(95, '2565-03-12 13:20:05', '3', '0946451', '7', 1000),
(96, '2565-03-12 13:20:05', '4', '7258132', '7', 1000),
(97, '2565-03-18 12:33:57', '1', '6279136', '88', 1000000),
(98, '2565-03-18 12:34:23', '1', '6279136', '89', 10),
(99, '2565-03-18 12:35:22', '1', '5493046', '90', 25),
(100, '2565-03-18 12:35:39', '2', '5493046', '5', 26),
(101, '2565-03-18 12:38:22', '3', '6279136', '8', 200),
(102, '2565-03-18 12:38:22', '4', '5493046', '8', 200),
(103, '2565-03-18 12:47:26', '3', '5493046', '9', 1000),
(104, '2565-03-18 12:47:26', '4', '1234', '9', 1000),
(105, '2565-03-23 00:03:35', '1', '0946451', '91', 10000000),
(106, '2565-03-23 00:03:41', '1', '0946451', '92', 10000000),
(107, '2565-03-23 00:03:49', '1', '0946451', '93', 100000000),
(108, '2565-03-23 00:04:00', '1', '0946451', '94', 1000000000),
(109, '2565-03-23 00:04:08', '1', '1234', '95', 4),
(110, '2565-03-23 00:04:16', '2', '0946451', '6', 1000000000),
(111, '2565-03-26 04:54:40', '2', '0946451', '7', 100000000),
(112, '2565-03-26 04:54:52', '1', '0946451', '96', 20000000),
(113, '2565-03-26 04:55:08', '2', '0946451', '8', 40000000),
(114, '2565-03-26 04:55:15', '2', '0946451', '9', 180000),
(115, '2565-03-26 04:55:31', '1', '1234', '97', 200000),
(116, '2565-03-26 04:55:43', '2', '1234', '10', 400000),
(117, '2565-03-26 04:56:04', '2', '0946451', '11', 7000),
(118, '2565-04-06 06:00:10', '3', '1234', '10', 2000),
(119, '2565-04-06 06:00:10', '4', '0946451', '10', 2000),
(120, '2565-04-18 18:09:52', '3', '0946451', '11', 500),
(121, '2565-04-18 18:09:52', '4', '1234', '11', 500),
(122, '2565-04-18 18:09:59', '1', '0946451', '98', 500),
(123, '2565-04-18 18:10:07', '2', '0946451', '12', 500),
(124, '2565-04-20 10:34:47', '1', '4695742', '99', 1000),
(125, '2565-04-20 10:36:06', '3', '4695742', '12', 500),
(126, '2565-04-20 10:36:06', '4', '1234', '12', 500),
(127, '2565-04-20 10:36:44', '2', '4695742', '13', 250);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` varchar(512) NOT NULL,
  `user_password` varchar(512) NOT NULL,
  `user_name` varchar(512) NOT NULL,
  `user_tel` varchar(512) NOT NULL,
  `user_mail` varchar(50) NOT NULL,
  `user_citizen_id` varchar(13) NOT NULL,
  `user_address` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `user_password`, `user_name`, `user_tel`, `user_mail`, `user_citizen_id`, `user_address`) VALUES
('28903', '5446', 'Suchanart', '0943986347', 'Suchanart', '1103703595318', '55'),
('6401861', '5446', 'Suchanart', '0943986347', 'Suchanart.sk05@gmail.com', '026984516', '55555'),
('Admin01', 'Admin', 'Anupat Kaewmee', '0661128806', 'anupat.k64@rsu.ac.th', '1149900762794', 'Admin'),
('anupat', '1234', 'Anupat Kaewmee', '0000000000', 'Test@gmail.com', '1111111111111', 'Test'),
('Kin01', 'kin', 'Chaiwat Seangsri', 'T', 'T', 'T', 'T');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`ac_number`),
  ADD KEY `customer_id` (`user_id`),
  ADD KEY `bank_id` (`bank_id`);

--
-- Indexes for table `bank`
--
ALTER TABLE `bank`
  ADD PRIMARY KEY (`bank_id`),
  ADD UNIQUE KEY `bank_id` (`bank_id`);

--
-- Indexes for table `banking_type`
--
ALTER TABLE `banking_type`
  ADD PRIMARY KEY (`type_id`);

--
-- Indexes for table `moneydeposit`
--
ALTER TABLE `moneydeposit`
  ADD PRIMARY KEY (`dp_id`),
  ADD KEY `ac_number` (`ac_number`);

--
-- Indexes for table `moneytransfer`
--
ALTER TABLE `moneytransfer`
  ADD PRIMARY KEY (`tf_id`),
  ADD KEY `ac_number_transferor` (`ac_number_transferor`),
  ADD KEY `ac_number_recipient` (`ac_number_recipient`);

--
-- Indexes for table `moneywithdraw`
--
ALTER TABLE `moneywithdraw`
  ADD PRIMARY KEY (`wd_id`),
  ADD KEY `ac_number` (`ac_number`);

--
-- Indexes for table `statements`
--
ALTER TABLE `statements`
  ADD PRIMARY KEY (`stm_id`),
  ADD KEY `type_id` (`type_id`),
  ADD KEY `ac_number` (`ac_number`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `moneydeposit`
--
ALTER TABLE `moneydeposit`
  MODIFY `dp_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=100;

--
-- AUTO_INCREMENT for table `moneytransfer`
--
ALTER TABLE `moneytransfer`
  MODIFY `tf_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `moneywithdraw`
--
ALTER TABLE `moneywithdraw`
  MODIFY `wd_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `statements`
--
ALTER TABLE `statements`
  MODIFY `stm_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=128;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `bank_id` FOREIGN KEY (`bank_id`) REFERENCES `bank` (`bank_id`),
  ADD CONSTRAINT `customer_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

--
-- Constraints for table `moneydeposit`
--
ALTER TABLE `moneydeposit`
  ADD CONSTRAINT `ac_number` FOREIGN KEY (`ac_number`) REFERENCES `account` (`ac_number`);

--
-- Constraints for table `moneytransfer`
--
ALTER TABLE `moneytransfer`
  ADD CONSTRAINT `ac_number_recipient` FOREIGN KEY (`ac_number_recipient`) REFERENCES `account` (`ac_number`),
  ADD CONSTRAINT `ac_number_transferor` FOREIGN KEY (`ac_number_transferor`) REFERENCES `account` (`ac_number`);

--
-- Constraints for table `moneywithdraw`
--
ALTER TABLE `moneywithdraw`
  ADD CONSTRAINT `moneywithdraw_ibfk_1` FOREIGN KEY (`ac_number`) REFERENCES `account` (`ac_number`);

--
-- Constraints for table `statements`
--
ALTER TABLE `statements`
  ADD CONSTRAINT `statements_ibfk_1` FOREIGN KEY (`ac_number`) REFERENCES `account` (`ac_number`),
  ADD CONSTRAINT `type_id` FOREIGN KEY (`type_id`) REFERENCES `banking_type` (`type_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
