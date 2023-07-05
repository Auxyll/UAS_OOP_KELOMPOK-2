-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 05, 2023 at 10:51 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dblalin`
--

-- --------------------------------------------------------

--
-- Table structure for table `golongan_tbl`
--

CREATE TABLE `golongan_tbl` (
  `golongan` varchar(100) NOT NULL,
  `harga` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `golongan_tbl`
--

INSERT INTO `golongan_tbl` (`golongan`, `harga`) VALUES
('1', '13000\r\n'),
('2', '19000'),
('3', '19500'),
('4', '25500'),
('5', '25000'),
('6', '5000');

-- --------------------------------------------------------

--
-- Table structure for table `lalin_tbl`
--

CREATE TABLE `lalin_tbl` (
  `id` int(11) NOT NULL,
  `Tanggal` varchar(250) NOT NULL,
  `Golongan` varchar(250) NOT NULL,
  `Harga` varchar(250) NOT NULL,
  `Volume` int(11) NOT NULL,
  `Total` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `lalin_tbl`
--

INSERT INTO `lalin_tbl` (`id`, `Tanggal`, `Golongan`, `Harga`, `Volume`, `Total`) VALUES
(49, '21-07-2023', '5', '25000', 500, 'Rp12.500.000,00'),
(50, '08-07-2023', '3', '19500', 800, 'Rp15.600.000,00'),
(51, '08-07-2023', '5', '25000', 300, 'Rp7.500.000,00'),
(52, '06-07-2023', '4', '25500', 300, 'Rp7.650.000,00');

-- --------------------------------------------------------

--
-- Table structure for table `user_tbl`
--

CREATE TABLE `user_tbl` (
  `id` int(11) NOT NULL,
  `username` varchar(150) NOT NULL,
  `password` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_tbl`
--

INSERT INTO `user_tbl` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `golongan_tbl`
--
ALTER TABLE `golongan_tbl`
  ADD PRIMARY KEY (`golongan`);

--
-- Indexes for table `lalin_tbl`
--
ALTER TABLE `lalin_tbl`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_tbl`
--
ALTER TABLE `user_tbl`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `lalin_tbl`
--
ALTER TABLE `lalin_tbl`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT for table `user_tbl`
--
ALTER TABLE `user_tbl`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
