-- phpMyAdmin SQL Dump
-- version 4.4.15.5
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 10, 2016 at 10:54 AM
-- Server version: 5.6.30
-- PHP Version: 5.5.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hms`
--

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE IF NOT EXISTS `doctor` (
  `docId`     INT(5)                           NOT NULL,
  `uName`     VARCHAR(15)
              COLLATE utf8_general_mysql500_ci NOT NULL,
  `fName`     VARCHAR(20)
              COLLATE utf8_general_mysql500_ci NOT NULL,
  `mName`     VARCHAR(20)
              COLLATE utf8_general_mysql500_ci NOT NULL,
  `lName`     VARCHAR(20)
              COLLATE utf8_general_mysql500_ci NOT NULL,
  `telephone` VARCHAR(10)
              COLLATE utf8_general_mysql500_ci NOT NULL,
  `pw`        VARCHAR(64)
              COLLATE utf8_general_mysql500_ci DEFAULT NULL,
  `nic`       VARCHAR(10)
              COLLATE utf8_general_mysql500_ci NOT NULL,
  `specialty` VARCHAR(20)
              COLLATE utf8_general_mysql500_ci DEFAULT NULL,
  `salary`    INT(15)                          NOT NULL
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8
  COLLATE = utf8_general_mysql500_ci;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`docId`, `uName`, `fName`, `mName`, `lName`, `telephone`, `pw`, `nic`, `specialty`, `salary`)
VALUES
  (1, 'root', 'Jake', 'the', 'Dog', '0123456789', '4813494D137E1631BBA301D5ACAB6E7BB7AA74CE1185D456565EF51D737677B2',
   '987654321z', 'magic', 300000),
  (2, 'calvinRules', 'Calvin', 'the', 'Great', '9999999999',
   '8bbc095572ae61b1f60ec7fe7d40c70062b426cbbe1597b7fc85f0909ec20bbd', '999999999x', 'dinosaurs', 5),
  (3, 'elTigre', 'Hobbes', 'the', 'Tiger', '7165432598',
   '1c121042385dfe5546613af05ca8a3f08c60a1d626b416d4d5d73d17eb7818ff', 'empty', 'tigers', 5),
  (5, 'BlondeGenius', 'Urumi', '', 'Kanzaki', '1254789634',
   'AC1163E44120BF7F7C3B54F36EA8F1A7031CE96B6C7A586AE6825DBD71F3393C', '145896325x', '200IQ', 900000);

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE IF NOT EXISTS `patient` (
  `patientId` INT(10)                          NOT NULL,
  `type`      SET ('in', 'out')
              COLLATE utf8_general_mysql500_ci NOT NULL DEFAULT 'out',
  `fName`     VARCHAR(20)
              COLLATE utf8_general_mysql500_ci NOT NULL,
  `mName`     VARCHAR(20)
              COLLATE utf8_general_mysql500_ci NOT NULL,
  `lName`     VARCHAR(20)
              COLLATE utf8_general_mysql500_ci NOT NULL,
  `telephone` VARCHAR(10)
              COLLATE utf8_general_mysql500_ci NOT NULL,
  `nic`       VARCHAR(10)
              COLLATE utf8_general_mysql500_ci NOT NULL,
  `age`       INT(2)                           NOT NULL,
  `prognosis` VARCHAR(50)
              COLLATE utf8_general_mysql500_ci NOT NULL,
  `diagnosis` VARCHAR(50)
              COLLATE utf8_general_mysql500_ci NOT NULL,
  `symptoms`  VARCHAR(200)
              COLLATE utf8_general_mysql500_ci NOT NULL,
  `comments`  TEXT COLLATE utf8_general_mysql500_ci
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8
  COLLATE = utf8_general_mysql500_ci;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`patientId`, `type`, `fName`, `mName`, `lName`, `telephone`, `nic`, `age`, `prognosis`, `diagnosis`, `symptoms`, `comments`)
VALUES
  (1, 'in', 'Susie', 'GROSS', 'Derkins', '5467893210', '145236529l', 8, 'girl', 'girl', 'cooties, grossness',
   'Diagnosed by Calvin'),
  (2, 'out', 'Dumb', 'Dumber', 'Dumbest', '2145632595', '456325698x', 29, 'Dumbbb', 'Dummy', 'dumbby', 'dumby'),
  (3, 'out', 'doom', 'doom', 'doom', '454612132', '54612321d', 45, 'balh', 'nahs', 'asdasd', 'asdasd');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE IF NOT EXISTS `payment` (
  `payId`     INT(15)                          NOT NULL,
  `amount`    INT(7)                           NOT NULL,
  `date`      DATETIME                         NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `method`    SET ('cash', 'credit')
              COLLATE utf8_general_mysql500_ci NOT NULL DEFAULT 'cash',
  `patientId` INT(10)                          NOT NULL
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8
  COLLATE = utf8_general_mysql500_ci;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`payId`, `amount`, `date`, `method`, `patientId`) VALUES
  (1, 300, '2016-06-08 23:34:08', 'cash', 2),
  (2, 13675, '2016-06-09 00:01:18', 'credit', 1),
  (3, 529, '2016-06-09 01:48:53', 'credit', 3),
  (4, 9876, '2016-06-09 01:51:43', 'credit', 3),
  (6, 184, '2016-06-09 02:00:48', 'cash', 3);

-- --------------------------------------------------------

--
-- Table structure for table `report`
--

CREATE TABLE IF NOT EXISTS `report` (
  `reportId`  INT(15)                               NOT NULL,
  `contents`  TEXT COLLATE utf8_general_mysql500_ci NOT NULL,
  `patientId` INT(10)                               NOT NULL
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8
  COLLATE = utf8_general_mysql500_ci;

--
-- Dumping data for table `report`
--

INSERT INTO `report` (`reportId`, `contents`, `patientId`) VALUES
  (1, 'Severe case of being a girl.', 1),
  (2, 'I don''t need math to know that Susie is gross.', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`docId`),
  ADD UNIQUE KEY `nic` (`nic`),
  ADD UNIQUE KEY `uName` (`uName`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`patientId`),
  ADD UNIQUE KEY `nic` (`nic`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`payId`),
  ADD KEY `patientId` (`patientId`);

--
-- Indexes for table `report`
--
ALTER TABLE `report`
  ADD PRIMARY KEY (`reportId`),
  ADD KEY `patientId` (`patientId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `docId` INT(5) NOT NULL AUTO_INCREMENT,
  AUTO_INCREMENT = 6;
--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `patientId` INT(10) NOT NULL AUTO_INCREMENT,
  AUTO_INCREMENT = 4;
--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `payId` INT(15) NOT NULL AUTO_INCREMENT,
  AUTO_INCREMENT = 7;
--
-- AUTO_INCREMENT for table `report`
--
ALTER TABLE `report`
  MODIFY `reportId` INT(15) NOT NULL AUTO_INCREMENT,
  AUTO_INCREMENT = 3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `fkey` FOREIGN KEY (`patientId`) REFERENCES `patient` (`patientId`);

--
-- Constraints for table `report`
--
ALTER TABLE `report`
  ADD CONSTRAINT `FOREIGN KEY` FOREIGN KEY (`patientId`) REFERENCES `patient` (`patientId`);

/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
