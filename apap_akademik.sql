-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 14, 2017 at 05:42 PM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `apap_akademik`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `nama_lengkap` varchar(100) NOT NULL,
  `id_univ` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `email`, `nama_lengkap`, `id_univ`) VALUES
(1, 'admin', 'admin@global.com', 'admin', 0),
(2, 'admin.ui', 'admin@ui.ac.id', 'Joko Sutarta', 1),
(3, 'admin.gunadarma', 'admin@gunadarma.ac.id', 'Heti Gendis Kinandar Putri', 2);

-- --------------------------------------------------------

--
-- Table structure for table `akun`
--

CREATE TABLE `akun` (
  `id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `enabled` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `akun`
--

INSERT INTO `akun` (`id`, `username`, `password`, `enabled`) VALUES
(1, 'admin', 'admin', 1),
(2, 'gugun.dah', 'gundahgulana00', 1),
(3, 'gilang.guritno', 'gil4ngguritno', 1),
(4, 'doni.alamsyah', '112233don', 1),
(5, 'andrew.wijaya', 'doniwi74y4', 1),
(6, 'zi.long', 'ui2017uye', 1),
(7, 'admin.ui', 'uiuikampusku', 1),
(8, 'admin.gunadarma', 'gundarjaya00', 1),
(23, 'galuh.octavia', 'password', 1),
(25, 'maba2', 'maba098', 1),
(28, 'maba1', 'maba098', 1),
(29, 'mabaanon', 'mabamaba', 1),
(30, 'mabanaon2', 'mabamaba', 1),
(31, 'mabaanon3', 'mabamaba', 1),
(32, 'mabaanon4', 'mabamaba', 1),
(33, 'mabajago', 'mabamaba', 1),
(34, 'test', 'test', 1),
(37, 'mahasiswa', 'mabamaba', 1),
(38, 'testi', 'test', 1);

-- --------------------------------------------------------

--
-- Table structure for table `akun_roles`
--

CREATE TABLE `akun_roles` (
  `id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `role` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `akun_roles`
--

INSERT INTO `akun_roles` (`id`, `username`, `role`) VALUES
(1, 'admin', 'ADMIN'),
(2, 'gugun.dah', 'USER'),
(3, 'gilang.guritno', 'USER'),
(4, 'doni.alamsyah', 'USER'),
(5, 'andrew.wijaya', 'USER'),
(6, 'zi.long', 'USER'),
(7, 'admin.ui', 'ADMIN'),
(8, 'admin.gunadarma', 'ADMIN'),
(10, 'galuh.octavia', 'USER'),
(12, 'maba2', 'USER'),
(14, 'maba1', 'USER'),
(15, 'mabaanon', 'USER'),
(16, 'mabanaon2', 'USER'),
(17, 'mabaanon3', 'USER'),
(18, 'mabaanon4', 'USER'),
(19, 'mabajago', 'USER'),
(20, 'test', 'USER'),
(22, 'mahasiswa', 'USER'),
(23, 'testi', 'USER');

-- --------------------------------------------------------

--
-- Table structure for table `irs`
--

CREATE TABLE `irs` (
  `id` int(11) NOT NULL,
  `id_user_mhs` int(11) NOT NULL,
  `status_irs` varchar(20) NOT NULL,
  `tanggal_pengisian` datetime NOT NULL,
  `term` varchar(50) NOT NULL,
  `kodemk` varchar(20) DEFAULT NULL,
  `nama_kelas` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `irs`
--

INSERT INTO `irs` (`id`, `id_user_mhs`, `status_irs`, `tanggal_pengisian`, `term`, `kodemk`, `nama_kelas`) VALUES
(51, 1, 'Menunggu Persetujuan', '2017-12-14 21:03:40', '2014/2015-2', 'CSC002', 'DDP 2 A'),
(54, 1, 'Menunggu Persetujuan', '2017-12-14 23:16:12', '2014/2015-2', 'CSC001', 'DDP 1 A'),
(55, 1, 'Menunggu Persetujuan', '2017-12-14 23:16:13', '2014/2015-2', 'CSC003', 'SDA A'),
(58, 5, 'Disetujui', '2017-12-14 23:33:59', '2014/2015-2', 'CSC001', 'DDP 1 A');

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `id` int(11) NOT NULL,
  `npm` varchar(10) NOT NULL,
  `username` varchar(40) NOT NULL,
  `nama_lengkap` varchar(100) NOT NULL,
  `IPK` double NOT NULL,
  `id_fakultas` int(11) DEFAULT NULL,
  `id_prodi` int(11) DEFAULT NULL,
  `id_univ` int(11) DEFAULT NULL,
  `jenjang` varchar(255) DEFAULT NULL,
  `kode_kurikulum` varchar(255) DEFAULT NULL,
  `tahun_masuk` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`id`, `npm`, `username`, `nama_lengkap`, `IPK`, `id_fakultas`, `id_prodi`, `id_univ`, `jenjang`, `kode_kurikulum`, `tahun_masuk`) VALUES
(1, '1234367892', 'gugun.dah', 'Gugun Dahidayat', 0, 1, 1, 1, 'S2', 'CSUI2011', 2011),
(2, '1506757844', 'zi.long', 'Muhammad Zidane Longatumbala', 0, 1, 1, 1, 'S1', 'CSUI2011', 2015),
(3, '1506757866', 'doni.alamsyah', 'Doni Alamsyah', 0, 1, 1, 1, 'S1', 'CSUI2011', 2015),
(4, '1506757849', 'andrew.wijaya', 'Andrew Wijaya Sumampan', 0, 1, 1, 1, 'S2', 'CSUI2011', 207),
(5, '1709090909', 'gilang.guritno', 'ilang Guritno', 0, 1, 1, 1, 'S1', 'CSUI2011', 2016),
(16, '1507060504', 'maba2', 'Mahasiswa Baru 2', 0, 1, 1, 1, 'S1', 'CSUI2011', 2016),
(18, '1709080707', 'maba1', 'Mahasiswa Baru', 0, 1, 1, 1, 'S1', 'CSUI2011', 2017),
(19, '1101010101', 'mabaanon', 'Maba Anon', 0, 1, 1, 1, 'S1', 'CSUI2011', 2011),
(20, '1102020202', 'mabanaon2', 'Mahasiswa Baru', 0, 1, 1, 1, 'S2', 'CSUI2011', 2011),
(21, '1103030303', 'mabaanon3', 'Mahasiswa Baru', 0, 1, 1, 1, 'S3', 'CSUI2011', 2011),
(22, '1104040404', 'mabaanon4', 'Mahasiswa Baru', 0, 1, 1, 1, 'S2', 'CSUI2011', 2015),
(23, '1104040405', 'mabajago', 'Maba Anon', 0, 1, 1, 1, 'S2', 'CSUI2011', 2015),
(24, '1101010102', 'test', 'testimoni', 0, 2, 1, 1, 'S1', 'FTUI2012', 2011),
(26, '1101010103', 'mahasiswa', 'Mahasiswa Baru', 0, 2, 1, 1, 'S1', 'FTUI2012', 2012),
(27, '0000000001', 'testi', 'testimoni', 0, 3, 1, 1, 'S1', 'FEUI2013', 2013);

-- --------------------------------------------------------

--
-- Table structure for table `penilaian_matkul`
--

CREATE TABLE `penilaian_matkul` (
  `id` int(11) NOT NULL,
  `id_riwayat` int(11) NOT NULL,
  `id_user_mhs` int(11) NOT NULL,
  `kode_mk` varchar(20) NOT NULL,
  `nilai_angka` double NOT NULL,
  `nilai_huruf` varchar(2) NOT NULL,
  `is_lulus` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penilaian_matkul`
--

INSERT INTO `penilaian_matkul` (`id`, `id_riwayat`, `id_user_mhs`, `kode_mk`, `nilai_angka`, `nilai_huruf`, `is_lulus`) VALUES
(1, 1, 1, 'CSC001', 82.2, 'A-', '1'),
(2, 2, 2, 'CSC001', 85.5, 'A', '1'),
(3, 3, 3, 'CSC001', 57.57, 'C', '1'),
(4, 4, 4, 'CSC001', 90.1, 'A', '1'),
(5, 5, 5, 'CSC001', 84.99, 'A-', '1'),
(6, 2, 1, 'CSC002', 70, 'B', '1');

-- --------------------------------------------------------

--
-- Table structure for table `riwayat`
--

CREATE TABLE `riwayat` (
  `id` int(11) NOT NULL,
  `id_user_mhs` int(11) NOT NULL,
  `sks_lulus` int(11) NOT NULL,
  `id_term` varchar(50) NOT NULL,
  `IP` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `riwayat`
--

INSERT INTO `riwayat` (`id`, `id_user_mhs`, `sks_lulus`, `id_term`, `IP`) VALUES
(1, 1, 21, '2016/2017-2', 3.24),
(2, 1, 20, '2016/2017-1 ', 3.8),
(3, 3, 4, '2016/2017-2', 2.43),
(4, 4, 21, '2016/2017-3 ', 4),
(5, 5, 24, '2016/2017-1', 3.51);

-- --------------------------------------------------------

--
-- Table structure for table `status_lulus`
--

CREATE TABLE `status_lulus` (
  `id` int(11) NOT NULL,
  `id_user_mhs` int(11) NOT NULL,
  `status_lulus` int(11) NOT NULL,
  `is_wisuda` tinyint(1) NOT NULL,
  `is_aktif` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `status_lulus`
--

INSERT INTO `status_lulus` (`id`, `id_user_mhs`, `status_lulus`, `is_wisuda`, `is_aktif`) VALUES
(1, 1, 0, 0, 1),
(2, 2, 0, 0, 0),
(3, 3, 0, 1, 1),
(4, 16, 0, 0, 1),
(5, 5, 0, 0, 1),
(6, 4, 0, 0, 0),
(7, 18, 0, 0, 1),
(8, 19, 0, 0, 1),
(9, 20, 0, 0, 1),
(10, 21, 0, 0, 1),
(11, 22, 0, 0, 1),
(12, 23, 0, 0, 1),
(13, 24, 0, 0, 1),
(15, 26, 0, 0, 1),
(16, 27, 0, 0, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `admin_email_uindex` (`email`),
  ADD UNIQUE KEY `admin_id_uindex` (`id`),
  ADD UNIQUE KEY `admin_username_uindex` (`username`);

--
-- Indexes for table `akun`
--
ALTER TABLE `akun`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `akun_id_uindex` (`id`),
  ADD UNIQUE KEY `akun_username_uindex` (`username`);

--
-- Indexes for table `akun_roles`
--
ALTER TABLE `akun_roles`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `akun_roles_id_uindex` (`id`),
  ADD UNIQUE KEY `akun_roles_username_uindex` (`username`);

--
-- Indexes for table `irs`
--
ALTER TABLE `irs`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `IRS_id_uindex` (`id`),
  ADD KEY `fk_IRS_npm` (`id_user_mhs`);

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `user_mahasiswa_id_uindex` (`id`),
  ADD UNIQUE KEY `user_mahasiswa_npm_uindex` (`npm`),
  ADD UNIQUE KEY `user_mahasiswa_username_uindex` (`username`);

--
-- Indexes for table `penilaian_matkul`
--
ALTER TABLE `penilaian_matkul`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `penilaian_matkul_id_uindex` (`id`),
  ADD KEY `FKl9sa5bg1d0nttgk823il7k9m7` (`id_user_mhs`),
  ADD KEY `FKbxogm2q2nmh7yi5bbpkj4t80a` (`id_riwayat`) USING BTREE;

--
-- Indexes for table `riwayat`
--
ALTER TABLE `riwayat`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `riwayat_id_uindex` (`id`),
  ADD KEY `fk_riwayat_npm` (`id_user_mhs`);

--
-- Indexes for table `status_lulus`
--
ALTER TABLE `status_lulus`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `status_lulus_id_uindex` (`id`),
  ADD UNIQUE KEY `status_lulus_id_user_mhs_uindex` (`id_user_mhs`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `akun`
--
ALTER TABLE `akun`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `akun_roles`
--
ALTER TABLE `akun_roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `irs`
--
ALTER TABLE `irs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;

--
-- AUTO_INCREMENT for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `penilaian_matkul`
--
ALTER TABLE `penilaian_matkul`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `riwayat`
--
ALTER TABLE `riwayat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `status_lulus`
--
ALTER TABLE `status_lulus`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `fk_admin_username` FOREIGN KEY (`username`) REFERENCES `akun` (`username`);

--
-- Constraints for table `irs`
--
ALTER TABLE `irs`
  ADD CONSTRAINT `FKf7dfow5tbp114ugf0mvvd3ldn` FOREIGN KEY (`id_user_mhs`) REFERENCES `mahasiswa` (`id`),
  ADD CONSTRAINT `fk_IRS_npm` FOREIGN KEY (`id_user_mhs`) REFERENCES `mahasiswa` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD CONSTRAINT `fk_mahasiswa_username` FOREIGN KEY (`username`) REFERENCES `akun` (`username`);

--
-- Constraints for table `penilaian_matkul`
--
ALTER TABLE `penilaian_matkul`
  ADD CONSTRAINT `FKbxogm2q2nmh7yi5bbpkj4t80a` FOREIGN KEY (`id_riwayat`) REFERENCES `riwayat` (`id`),
  ADD CONSTRAINT `FKl9sa5bg1d0nttgk823il7k9m7` FOREIGN KEY (`id_user_mhs`) REFERENCES `mahasiswa` (`id`),
  ADD CONSTRAINT `FKqlji8ox7u7dkuit90lyekq1mw` FOREIGN KEY (`id_riwayat`) REFERENCES `riwayat` (`id`),
  ADD CONSTRAINT `penilaian_matkul_mahasiswa_id_fk` FOREIGN KEY (`id_user_mhs`) REFERENCES `mahasiswa` (`id`),
  ADD CONSTRAINT `penilaian_matkul_riwayat_id_fk` FOREIGN KEY (`id_riwayat`) REFERENCES `riwayat` (`id`);

--
-- Constraints for table `riwayat`
--
ALTER TABLE `riwayat`
  ADD CONSTRAINT `FK6v20wnnqnphdutaqmx3a0vwix` FOREIGN KEY (`id_user_mhs`) REFERENCES `mahasiswa` (`id`),
  ADD CONSTRAINT `fk_riwayat_npm` FOREIGN KEY (`id_user_mhs`) REFERENCES `mahasiswa` (`id`);

--
-- Constraints for table `status_lulus`
--
ALTER TABLE `status_lulus`
  ADD CONSTRAINT `FKb1qhdh1lipsjvjxs1qk5wu849` FOREIGN KEY (`id_user_mhs`) REFERENCES `mahasiswa` (`id`),
  ADD CONSTRAINT `fk_status_lulus_npm` FOREIGN KEY (`id_user_mhs`) REFERENCES `mahasiswa` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
