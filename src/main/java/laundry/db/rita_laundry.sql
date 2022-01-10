-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 10, 2022 at 05:51 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 7.4.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rita_laundry`
--

-- --------------------------------------------------------

--
-- Table structure for table `laundry`
--

CREATE TABLE `laundry` (
  `id_laundry` varchar(15) NOT NULL,
  `berat` double NOT NULL,
  `setrika` varchar(5) NOT NULL,
  `id_parfum` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `laundry`
--

INSERT INTO `laundry` (`id_laundry`, `berat`, `setrika`, `id_parfum`) VALUES
('L1', 1.7, 'yes', 2),
('L2', 2, 'no', 1),
('L3', 3, 'yes', 3),
('L4', 4, 'yes', 3),
('L5', 4, 'yes', 3);

-- --------------------------------------------------------

--
-- Table structure for table `parfum`
--

CREATE TABLE `parfum` (
  `id_parfum` int(11) NOT NULL,
  `nama_parfum` varchar(100) NOT NULL,
  `harga` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `parfum`
--

INSERT INTO `parfum` (`id_parfum`, `nama_parfum`, `harga`) VALUES
(1, 'Tanpa Setrika', 0),
(2, 'Tanpa Parfum', 2000),
(3, 'Rose', 3500),
(4, 'April Rose', 4000),
(5, 'Blue Diamond', 4000),
(6, 'Hugo Boss', 5000);

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_pelanggan` varchar(11) NOT NULL,
  `nama_pelanggan` varchar(50) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `telp` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`id_pelanggan`, `nama_pelanggan`, `alamat`, `telp`) VALUES
('P1', 'Annur', 'Bangkal Rt.02 No.10', '081239171231'),
('P2', 'Resa', 'bangkal Rt.01 No.3', '081234567890'),
('P3', 'Sari', 'jl sukamara no 34 bangkal', '0853445678');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_laundry` varchar(15) NOT NULL,
  `kasir` varchar(15) NOT NULL,
  `tanggal` date NOT NULL,
  `waktu` time NOT NULL,
  `id_pelanggan` varchar(15) NOT NULL,
  `nama_pelanggan` varchar(50) NOT NULL,
  `telp` varchar(15) NOT NULL,
  `member` varchar(5) NOT NULL,
  `status` varchar(15) NOT NULL,
  `harga` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_laundry`, `kasir`, `tanggal`, `waktu`, `id_pelanggan`, `nama_pelanggan`, `telp`, `member`, `status`, `harga`) VALUES
('L1', 'rita', '2021-12-09', '10:15:34', 'null', 'Ehan', '089618263712', 'no', 'Sudah Diambil', 10200),
('L2', 'habibi', '2021-12-09', '10:15:51', 'P1', 'Annur', '081239171231', 'yes', 'Belum Diambil', 6800),
('L3', 'habibi', '2021-12-09', '10:34:09', 'null', 'Dewi', '01927192371', 'no', 'Sudah Diambil', 24000),
('L4', 'rita', '2021-12-09', '13:09:33', 'null', 'Imar', '08918293172', 'no', 'Sudah Diambil', 32000),
('L5', 'rita', '2021-12-09', '14:49:22', 'P1', 'Annur', '081239171231', 'yes', 'Pencucian', 25500);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `level` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user`, `password`, `level`) VALUES
('admin', 'admin', 'Admin'),
('habibi', 'habibi123', 'Kariawan'),
('kariawan', 'kariawan', 'Kariawan'),
('rita', 'rita123', 'Admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `laundry`
--
ALTER TABLE `laundry`
  ADD PRIMARY KEY (`id_laundry`);

--
-- Indexes for table `parfum`
--
ALTER TABLE `parfum`
  ADD PRIMARY KEY (`id_parfum`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_laundry`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `parfum`
--
ALTER TABLE `parfum`
  MODIFY `id_parfum` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
