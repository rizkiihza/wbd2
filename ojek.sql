-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 06, 2017 at 11:30 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ojek`
--

-- --------------------------------------------------------

--
-- Table structure for table `driver`
--

CREATE TABLE `driver` (
  `ID` int(11) NOT NULL,
  `voter` int(11) NOT NULL,
  `rating_ratarata` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `driver`
--

INSERT INTO `driver` (`ID`, `voter`, `rating_ratarata`) VALUES
(1, 34, 4.5),
(3, 24, 4.1);

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE `history` (
  `ID_Cust` int(11) NOT NULL,
  `Source` varchar(50) DEFAULT NULL,
  `Dest` varchar(50) DEFAULT NULL,
  `ID_Driver` int(11) NOT NULL,
  `Order_Date` date DEFAULT NULL,
  `Rating` int(11) DEFAULT NULL,
  `Comment` varchar(140) DEFAULT NULL,
  `HidDriver` int(1) DEFAULT NULL,
  `HidCust` int(1) DEFAULT NULL,
  `Order_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `history`
--

INSERT INTO `history` (`ID_Cust`, `Source`, `Dest`, `ID_Driver`, `Order_Date`, `Rating`, `Comment`, `HidDriver`, `HidCust`, `Order_Id`) VALUES
(1, 'Saffron City', 'Pewter City', 3, '2017-01-10', 2, 'mamangnya bau', 0, 0, 1),
(2, 'Saffron City', 'Pewter City', 1, '2017-01-10', 4, 'mantap ojeknya', 0, 0, 2);

-- --------------------------------------------------------

--
-- Table structure for table `pref_location`
--

CREATE TABLE `pref_location` (
  `ID` int(11) NOT NULL,
  `Location` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pref_location`
--

INSERT INTO `pref_location` (`ID`, `Location`) VALUES
(1, 'Pewter City'),
(1, 'Saffron City'),
(3, 'Pewter City');

-- --------------------------------------------------------

--
-- Table structure for table `profil`
--

CREATE TABLE `profil` (
  `ID` int(11) NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Username` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Password` varchar(50) DEFAULT NULL,
  `Phone` varchar(50) DEFAULT NULL,
  `Driver` int(11) DEFAULT NULL,
  `foto` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `profil`
--

INSERT INTO `profil` (`ID`, `Name`, `Username`, `Email`, `Password`, `Phone`, `Driver`, `foto`) VALUES
(1, 'eki', 'pikapikapikachu', 'pikachu@pokemonworld.net', 'pokepokemon', '4321', 1, '../gambar/508247.jpg'),
(2, 'Paul Sitanggang', 'paulcuk', 'paulcuk@yahoo.com', 'poletarism', '081208120812', 0, '../gambar/profil_1.png'),
(3, 'Poke John', 'johntol', 'johntol@gmail.com', '12341234', '081208130814', 1, '../gambar/profil_1.png'),
(4, 'a', 'a', 'a@gmail.com', 'a', '081208130815', 1, '../gambar/profil_1.png');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `driver`
--
ALTER TABLE `driver`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`Order_Id`),
  ADD KEY `history_ibfk_1` (`ID_Cust`),
  ADD KEY `history_ibfk_2` (`ID_Driver`);

--
-- Indexes for table `pref_location`
--
ALTER TABLE `pref_location`
  ADD PRIMARY KEY (`ID`,`Location`);

--
-- Indexes for table `profil`
--
ALTER TABLE `profil`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `history`
--
ALTER TABLE `history`
  MODIFY `Order_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `profil`
--
ALTER TABLE `profil`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `driver`
--
ALTER TABLE `driver`
  ADD CONSTRAINT `driver_ibfk_1` FOREIGN KEY (`id`) REFERENCES `profil` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `history`
--
ALTER TABLE `history`
  ADD CONSTRAINT `history_ibfk_1` FOREIGN KEY (`ID_Cust`) REFERENCES `profil` (`ID`),
  ADD CONSTRAINT `history_ibfk_2` FOREIGN KEY (`ID_Driver`) REFERENCES `profil` (`ID`);

--
-- Constraints for table `pref_location`
--
ALTER TABLE `pref_location`
  ADD CONSTRAINT `pref_location_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `profil` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
