-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 22, 2026 at 08:37 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projek_pbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `donatur`
--

CREATE TABLE `donatur` (
  `id_donatur` varchar(20) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `jenis` varchar(255) NOT NULL,
  `lokasi` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `no_hp` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `donatur`
--

INSERT INTO `donatur` (`id_donatur`, `nama`, `jenis`, `lokasi`, `email`, `no_hp`) VALUES
('D0001', 'Adit', 'Katering', 'Jl. Kayu Putih No. 29', 'adit@gmail.com', '081234567890'),
('D0002', 'Ahmad Fauzan', 'Kafe', 'Jl.Sultan Syarif Kasim II', 'ahmadfauzan26@gmail.com', '089988776677'),
('D0003', 'Firman Ardiansyah', 'Katering', 'Jl.Rindang I', 'Firmanpku20@gmail.com', '081122443322'),
('D0004', 'Wanto', 'Restoran', 'Jl.Soerkarno Hatta', 'wantowanto11@gmail.com', '08988776655');

-- --------------------------------------------------------

--
-- Table structure for table `makanan`
--

CREATE TABLE `makanan` (
  `id_makanan` varchar(20) NOT NULL,
  `id_donatur` varchar(20) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `stok` int(6) NOT NULL,
  `status` varchar(255) NOT NULL,
  `tgl_kadaluarsa` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `makanan`
--

INSERT INTO `makanan` (`id_makanan`, `id_donatur`, `nama`, `stok`, `status`, `tgl_kadaluarsa`) VALUES
('M0001', 'D0001', 'Nasi Goreng', 6, '', '2026-06-23'),
('M0002', 'D0002', 'French Fries ', 5, '', '2026-06-16'),
('M0003', 'D0003', ' Ayam Goreng Kalasan ', 9, '', '2026-06-09'),
('M0004', 'D0004', 'Rendang Daging ', 12, '', '2026-06-02');

-- --------------------------------------------------------

--
-- Table structure for table `penerima`
--

CREATE TABLE `penerima` (
  `id_penerima` varchar(20) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `jenis` varchar(255) NOT NULL,
  `lokasi` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `no_hp` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `penerima`
--

INSERT INTO `penerima` (`id_penerima`, `nama`, `jenis`, `lokasi`, `email`, `no_hp`) VALUES
('P0001', 'Rizwan Saputra', 'Orang Kurang Mampu', 'Jl. CemaraII', 'rizwanpku0@gmail.com', '0897797398783'),
('P0002', 'Mizan Amanah', 'Panti Asuhan', 'Jl. Belimbing', 'mizanamanahpku@gmail.com', '088998997367'),
('P0003', 'Scholars of Sustenance ', 'Bank Makanan', 'Jl. Sudirman', 'scholars@gmail.com', '0899776556'),
('P0004', 'Sahabat Yatim', 'Panti Asuhan', 'Jl. Lembaga', 'sahabatyeateam@gmail.com', '08997774832');

-- --------------------------------------------------------

--
-- Table structure for table `penyaluran`
--

CREATE TABLE `penyaluran` (
  `id_penyaluran` varchar(20) NOT NULL,
  `id_makanan` varchar(20) NOT NULL,
  `id_penerima` varchar(20) NOT NULL,
  `tgl_penyaluran` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `penyaluran`
--

INSERT INTO `penyaluran` (`id_penyaluran`, `id_makanan`, `id_penerima`, `tgl_penyaluran`) VALUES
('PL0001', 'M0001', 'P0001', '2026-06-21'),
('PL0002', 'M0002', 'P0002', '2026-06-23'),
('PL0003', 'M0003', 'P0003', '2026-06-01'),
('PL0004', 'M0004', 'P0004', '2026-06-03');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `donatur`
--
ALTER TABLE `donatur`
  ADD PRIMARY KEY (`id_donatur`);

--
-- Indexes for table `makanan`
--
ALTER TABLE `makanan`
  ADD PRIMARY KEY (`id_makanan`),
  ADD KEY `id_donatur` (`id_donatur`);

--
-- Indexes for table `penerima`
--
ALTER TABLE `penerima`
  ADD PRIMARY KEY (`id_penerima`);

--
-- Indexes for table `penyaluran`
--
ALTER TABLE `penyaluran`
  ADD PRIMARY KEY (`id_penyaluran`),
  ADD KEY `id_makanan` (`id_makanan`),
  ADD KEY `FK_CON_IDPENERIMA` (`id_penerima`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `makanan`
--
ALTER TABLE `makanan`
  ADD CONSTRAINT `FK_CON_IDDONATUR` FOREIGN KEY (`id_donatur`) REFERENCES `donatur` (`id_donatur`);

--
-- Constraints for table `penyaluran`
--
ALTER TABLE `penyaluran`
  ADD CONSTRAINT `FK_CON_IDMAKANAN` FOREIGN KEY (`id_makanan`) REFERENCES `makanan` (`id_makanan`),
  ADD CONSTRAINT `FK_CON_IDPENERIMA` FOREIGN KEY (`id_penerima`) REFERENCES `penerima` (`id_penerima`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
