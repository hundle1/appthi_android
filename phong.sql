-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 10, 2024 at 09:16 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qlpks`
--

-- --------------------------------------------------------

--
-- Table structure for table `phong`
--

CREATE TABLE `phong` (
  `id` int(11) NOT NULL,
  `ten` varchar(100) NOT NULL,
  `mota` varchar(200) NOT NULL,
  `giatien` int(11) NOT NULL,
  `hinhanh` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phong`
--

INSERT INTO `phong` (`id`, `ten`, `mota`, `giatien`, `hinhanh`) VALUES
(1, 'Phòng Đơn', 'Phòng đơn với giường 1m2, phù hợp cho 1 người', 300000, 'hinh1'),
(2, 'Phòng Đôi', 'Phòng có giường đôi 1m6, phù hợp cho 2 người', 500000, 'hinh2'),
(3, 'Phòng Gia Đình', 'Phòng lớn với 2 giường đôi, phù hợp cho gia đình', 800000, 'hinh3'),
(4, 'Phòng VIP', 'Phòng VIP với giường 2m, có view hướng biển', 1200000, 'hinh4'),
(5, 'Phòng Suite', 'Phòng suite cao cấp với đầy đủ tiện nghi', 1500000, 'hinh5'),
(6, 'Phòng Studio', 'Phòng kiểu studio với giường đôi và bếp nhỏ', 600000, 'hinh6'),
(7, 'Phòng Deluxe', 'Phòng cao cấp với giường đôi và nội thất sang trọng', 1000000, 'hinh7'),
(8, 'Phòng Tiêu Chuẩn', 'Phòng tiêu chuẩn với giường đôi và view thành phố', 400000, 'hinh8'),
(9, 'Phòng Căn Hộ', 'Phòng căn hộ với phòng khách và bếp riêng', 2000000, 'hinh9'),
(10, 'Phòng Dorm', 'Phòng ngủ tập thể, giường tầng cho khách đi phượt', 200000, 'hinh10');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `phong`
--
ALTER TABLE `phong`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `phong`
--
ALTER TABLE `phong`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
