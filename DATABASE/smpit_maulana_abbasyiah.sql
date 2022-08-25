-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 10 Jul 2022 pada 12.28
-- Versi server: 10.4.24-MariaDB
-- Versi PHP: 7.4.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `smpit_maulana_abbasyiah`
--
DROP DATABASE IF EXISTS `smpit_maulana_abbasyiah`;
CREATE DATABASE IF NOT EXISTS `smpit_maulana_abbasyiah` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `smpit_maulana_abbasyiah`;

-- --------------------------------------------------------

--
-- Struktur dari tabel `absen`
--

CREATE TABLE `absen` (
  `nis` char(18) DEFAULT NULL,
  `nama_siswa` varchar(50) NOT NULL,
  `kelas` varchar(30) NOT NULL,
  `hadir` int(5) NOT NULL,
  `tidak_hadir` int(5) NOT NULL,
  `izin` int(5) NOT NULL,
  `sakit` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `absen`
--

INSERT INTO `absen` (`nis`, `nama_siswa`, `kelas`, `hadir`, `tidak_hadir`, `izin`, `sakit`) VALUES
('001', 'Siswa1', '7', 20, 1, 1, 1),
('002', 'Siswa2', '7', 20, 0, 0, 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `id` char(3) NOT NULL,
  `namalengkap` varchar(20) DEFAULT NULL,
  `user` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`id`, `namalengkap`, `user`, `password`) VALUES
('001', 'Naufal Sholahuddin', 'admin', 'admin'),
('002', 'wanju', 'wanju', 'wanju');

-- --------------------------------------------------------

--
-- Struktur dari tabel `guru`
--

CREATE TABLE `guru` (
  `nama` varchar(50) NOT NULL,
  `nip` char(18) NOT NULL,
  `email` varchar(50) NOT NULL,
  `no_hp` char(15) NOT NULL,
  `alamat` varchar(200) NOT NULL,
  `jenis_kel` varchar(50) NOT NULL,
  `tgl_lahir` varchar(50) NOT NULL,
  `tmp_lahir` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `guru`
--

INSERT INTO `guru` (`nama`, `nip`, `email`, `no_hp`, `alamat`, `jenis_kel`, `tgl_lahir`, `tmp_lahir`) VALUES
('Guru1', '00000001', 'example@gmail.com', '08500000000', 'Jl.Bogor', 'Laki-Laki', '1-januari-1977', 'bogor'),
('Guru2', '00000002', 'example2@gmail.com', '08500000000', 'Jl. Jakarta', 'Perempuan', '2-februari-1977', 'jakarta'),
('Guru3', '00000003', 'example3@gmail.com', '08380000000', 'Jl. Depok', 'Perempuan', '3-oktober-1976', 'depok'),
('Guru4', '00000004', 'example3@gmail.com', '08380000000', 'Jl. Depok', 'Perempuan', '3-oktober-1976', 'depok');

-- --------------------------------------------------------

--
-- Struktur dari tabel `nilai_akhir_semester`
--

CREATE TABLE `nilai_akhir_semester` (
  `nis` char(18) DEFAULT NULL,
  `nama_siswa` varchar(50) NOT NULL,
  `kelas` varchar(30) NOT NULL,
  `kd_mapel` char(6) NOT NULL,
  `mapel` varchar(50) NOT NULL,
  `semester` varchar(30) NOT NULL,
  `tahun_ajar` char(9) NOT NULL,
  `nilai_pengetahuan` int(3) NOT NULL,
  `nilai_keterampilan` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `nilai_akhir_semester`
--

INSERT INTO `nilai_akhir_semester` (`nis`, `nama_siswa`, `kelas`, `kd_mapel`, `mapel`, `semester`, `tahun_ajar`, `nilai_pengetahuan`, `nilai_keterampilan`) VALUES
('002', 'Siswa2', '7', '001', 'Pendidikan Agama Islam dan Budi Pekerti', 'GANJIL', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '002', 'Pendidikan Pancasila dan Kewarganegaraan', 'GANJIL', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '003', 'Bahasa Indonesia', 'GANJIL', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '004', 'Matematika', 'GANJIL', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '005', 'Ilmu Pengetahuan Alam', 'GANJIL', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '006', 'Ilmu Pengetahuan Sosial', 'GANJIL', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '007', 'Seni Budaya dan Keterampilan', 'GANJIL', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '008', 'Pendidikan Jasmani, Olahraga dan Kesehatan', 'GANJIL', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '009', 'Bahasa Inggris', 'GANJIL', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '010', 'Bahasa Arab', 'GANJIL', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '011', 'Aqidah Akhlak', 'GANJIL', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '012', 'Tahfidz', 'GANJIL', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '013', 'Sejarah Kebudayaan Islam', 'GANJIL', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '014', 'Amtsilati', 'GANJIL', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '015', 'Al Quran Hadist', 'GANJIL', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '016', 'Prakarya', 'GANJIL', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '017', 'BTQ', 'GANJIL', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '018', 'TIK', 'GANJIL', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '001', 'Pendidikan Agama Islam dan Budi Pekerti', 'GENAP', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '002', 'Pendidikan Pancasila dan Kewarganegaraan', 'GENAP', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '003', 'Bahasa Indonesia', 'GENAP', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '004', 'Matematika', 'GENAP', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '005', 'Ilmu Pengetahuan Alam', 'GENAP', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '006', 'Ilmu Pengetahuan Sosial', 'GENAP', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '007', 'Seni Budaya dan Keterampilan', 'GENAP', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '008', 'Pendidikan Jasmani, Olahraga dan Kesehatan', 'GENAP', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '009', 'Bahasa Inggris', 'GENAP', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '010', 'Bahasa Arab', 'GENAP', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '011', 'Aqidah Akhlak', 'GENAP', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '012', 'Tahfidz', 'GENAP', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '013', 'Sejarah Kebudayaan Islam', 'GENAP', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '014', 'Amtsilati', 'GENAP', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '015', 'Al Quran Hadist', 'GENAP', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '016', 'Prakarya', 'GENAP', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '017', 'BTQ', 'GENAP', '2021/2022', 90, 80),
('002', 'Siswa2', '7', '018', 'TIK', 'GENAP', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '001', 'Pendidikan Agama Islam dan Budi Pekerti', 'GANJIL', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '002', 'Pendidikan Pancasila dan Kewarganegaraan', 'GANJIL', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '003', 'Bahasa Indonesia', 'GANJIL', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '004', 'Matematika', 'GANJIL', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '005', 'Ilmu Pengetahuan Alam', 'GANJIL', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '006', 'Ilmu Pengetahuan Sosial', 'GANJIL', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '007', 'Seni Budaya dan Keterampilan', 'GANJIL', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '008', 'Pendidikan Jasmani, Olahraga dan Kesehatan', 'GANJIL', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '009', 'Bahasa Inggris', 'GANJIL', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '010', 'Bahasa Arab', 'GANJIL', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '011', 'Aqidah Akhlak', 'GANJIL', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '012', 'Tahfidz', 'GANJIL', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '013', 'Sejarah Kebudayaan Islam', 'GANJIL', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '014', 'Amtsilati', 'GANJIL', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '015', 'Al Quran Hadist', 'GANJIL', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '016', 'Prakarya', 'GANJIL', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '017', 'BTQ', 'GANJIL', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '018', 'TIK', 'GANJIL', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '001', 'Pendidikan Agama Islam dan Budi Pekerti', 'GENAP', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '002', 'Pendidikan Pancasila dan Kewarganegaraan', 'GENAP', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '003', 'Bahasa Indonesia', 'GENAP', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '004', 'Matematika', 'GENAP', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '005', 'Ilmu Pengetahuan Alam', 'GENAP', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '006', 'Ilmu Pengetahuan Sosial', 'GENAP', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '007', 'Seni Budaya dan Keterampilan', 'GENAP', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '008', 'Pendidikan Jasmani, Olahraga dan Kesehatan', 'GENAP', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '009', 'Bahasa Inggris', 'GENAP', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '010', 'Bahasa Arab', 'GENAP', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '011', 'Aqidah Akhlak', 'GENAP', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '012', 'Tahfidz', 'GENAP', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '013', 'Sejarah Kebudayaan Islam', 'GENAP', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '014', 'Amtsilati', 'GENAP', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '015', 'Al Quran Hadist', 'GENAP', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '016', 'Prakarya', 'GENAP', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '017', 'BTQ', 'GENAP', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '018', 'TIK', 'GENAP', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '016', 'Prakarya', 'GENAP', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '017', 'BTQ', 'GENAP', '2021/2022', 90, 80),
('001', 'Siswa1', '7', '018', 'TIK', 'GENAP', '2021/2022', 90, 80);

-- --------------------------------------------------------

--
-- Struktur dari tabel `nilai_tengah_semester`
--

CREATE TABLE `nilai_tengah_semester` (
  `nis` char(18) NOT NULL,
  `nama_siswa` varchar(50) NOT NULL,
  `kelas` varchar(30) NOT NULL,
  `kd_mapel` char(6) NOT NULL,
  `mapel` varchar(50) NOT NULL,
  `semester` varchar(30) NOT NULL,
  `tahun_ajar` char(9) NOT NULL,
  `nilai` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `nilai_tengah_semester`
--

INSERT INTO `nilai_tengah_semester` (`nis`, `nama_siswa`, `kelas`, `kd_mapel`, `mapel`, `semester`, `tahun_ajar`, `nilai`) VALUES
('002', 'Siswa2', '7', '001', 'Pendidikan Agama Islam dan Budi Pekerti', 'GANJIL', '2021/2022', 70),
('002', 'Siswa2', '7', '002', 'Pendidikan Pancasila dan Kewarganegaraan', 'GANJIL', '2021/2022', 70),
('002', 'Siswa2', '7', '003', 'Bahasa Indonesia', 'GANJIL', '2021/2022', 70),
('002', 'Siswa2', '7', '004', 'Matematika', 'GANJIL', '2021/2022', 70),
('002', 'Siswa2', '7', '005', 'Ilmu Pengetahuan Alam', 'GANJIL', '2021/2022', 70),
('002', 'Siswa2', '7', '006', 'Ilmu Pengetahuan Sosial', 'GANJIL', '2021/2022', 70),
('002', 'Siswa2', '7', '007', 'Seni Budaya dan Keterampilan', 'GANJIL', '2021/2022', 70),
('002', 'Siswa2', '7', '008', 'Pendidikan Jasmani, Olahraga dan Kesehatan', 'GANJIL', '2021/2022', 70),
('002', 'Siswa2', '7', '009', 'Bahasa Inggris', 'GANJIL', '2021/2022', 70),
('002', 'Siswa2', '7', '010', 'Bahasa Arab', 'GANJIL', '2021/2022', 70),
('002', 'Siswa2', '7', '011', 'Aqidah Akhlak', 'GANJIL', '2021/2022', 70),
('002', 'Siswa2', '7', '012', 'Tahfidz', 'GANJIL', '2021/2022', 70),
('002', 'Siswa2', '7', '013', 'Sejarah Kebudayaan Islam', 'GANJIL', '2021/2022', 70),
('002', 'Siswa2', '7', '014', 'Amtsilati', 'GANJIL', '2021/2022', 70),
('002', 'Siswa2', '7', '016', 'Prakarya', 'GENAP', '2021/2022', 70),
('002', 'Siswa2', '7', '017', 'BTQ', 'GENAP', '2021/2022', 70),
('002', 'Siswa2', '7', '018', 'TIK', 'GENAP', '2021/2022', 70),
('001', 'Siswa1', '7', '001', 'Pendidikan Agama Islam dan Budi Pekerti', 'GANJIL', '2021/2022', 70),
('001', 'Siswa1', '7', '002', 'Pendidikan Pancasila dan Kewarganegaraan', 'GANJIL', '2021/2022', 70),
('001', 'Siswa1', '7', '003', 'Bahasa Indonesia', 'GANJIL', '2021/2022', 70),
('001', 'Siswa1', '7', '004', 'Matematika', 'GANJIL', '2021/2022', 70),
('001', 'Siswa1', '7', '005', 'Ilmu Pengetahuan Alam', 'GANJIL', '2021/2022', 70),
('001', 'Siswa1', '7', '006', 'Ilmu Pengetahuan Sosial', 'GANJIL', '2021/2022', 70),
('001', 'Siswa1', '7', '007', 'Seni Budaya dan Keterampilan', 'GANJIL', '2021/2022', 70),
('001', 'Siswa1', '7', '008', 'Pendidikan Jasmani, Olahraga dan Kesehatan', 'GANJIL', '2021/2022', 70),
('001', 'Siswa1', '7', '009', 'Bahasa Inggris', 'GANJIL', '2021/2022', 70),
('001', 'Siswa1', '7', '010', 'Bahasa Arab', 'GANJIL', '2021/2022', 70),
('001', 'Siswa1', '7', '011', 'Aqidah Akhlak', 'GANJIL', '2021/2022', 70),
('001', 'Siswa1', '7', '012', 'Tahfidz', 'GANJIL', '2021/2022', 70),
('001', 'Siswa1', '7', '013', 'Sejarah Kebudayaan Islam', 'GANJIL', '2021/2022', 70),
('001', 'Siswa1', '7', '014', 'Amtsilati', 'GANJIL', '2021/2022', 70),
('001', 'Siswa1', '7', '016', 'Prakarya', 'GENAP', '2021/2022', 70),
('001', 'Siswa1', '7', '017', 'BTQ', 'GENAP', '2021/2022', 70),
('001', 'Siswa1', '7', '018', 'TIK', 'GENAP', '2021/2022', 70),
('002', 'Siswa2', '7', '015', 'Al Quran Hadist', 'GANJIL', '2021/2022', 70),
('001', 'Siswa1', '7', '015', 'Al Quran Hadist', 'GANJIL', '2021/2022', 70),
('001', 'Siswa1', '7', '016', 'Prakarya', 'GANJIL', '2021/2022', 70),
('001', 'Siswa1', '7', '017', 'BTQ', 'GANJIL', '2021/2022', 70),
('001', 'Siswa1', '7', '018', 'TIK', 'GANJIL', '2021/2022', 70),
('002', 'Siswa2', '7', '016', 'Prakarya', 'GANJIL', '2021/2022', 70),
('002', 'Siswa2', '7', '017', 'BTQ', 'GANJIL', '2021/2022', 70),
('002', 'Siswa2', '7', '018', 'TIK', 'GANJIL', '2021/2022', 70),
('002', 'Siswa2', '7', '001', 'Pendidikan Agama Islam dan Budi Pekerti', 'GENAP', '2021/2022', 70),
('002', 'Siswa2', '7', '002', 'Pendidikan Pancasila dan Kewarganegaraan', 'GENAP', '2021/2022', 70),
('002', 'Siswa2', '7', '003', 'Bahasa Indonesia', 'GENAP', '2021/2022', 70),
('002', 'Siswa2', '7', '004', 'Matematika', 'GENAP', '2021/2022', 70),
('002', 'Siswa2', '7', '005', 'Ilmu Pengetahuan Alam', 'GENAP', '2021/2022', 70),
('002', 'Siswa2', '7', '006', 'Ilmu Pengetahuan Sosial', 'GENAP', '2021/2022', 70),
('002', 'Siswa2', '7', '007', 'Seni Budaya dan Keterampilan', 'GENAP', '2021/2022', 70),
('002', 'Siswa2', '7', '008', 'Pendidikan Jasmani, Olahraga dan Kesehatan', 'GENAP', '2021/2022', 70),
('002', 'Siswa2', '7', '009', 'Bahasa Inggris', 'GENAP', '2021/2022', 70),
('002', 'Siswa2', '7', '010', 'Bahasa Arab', 'GENAP', '2021/2022', 70),
('002', 'Siswa2', '7', '011', 'Aqidah Akhlak', 'GENAP', '2021/2022', 70),
('002', 'Siswa2', '7', '012', 'Tahfidz', 'GENAP', '2021/2022', 70),
('002', 'Siswa2', '7', '013', 'Sejarah Kebudayaan Islam', 'GENAP', '2021/2022', 70),
('002', 'Siswa2', '7', '014', 'Amtsilati', 'GENAP', '2021/2022', 70),
('002', 'Siswa2', '7', '015', 'Al Quran Hadist', 'GENAP', '2021/2022', 70),
('001', 'Siswa1', '7', '001', 'Pendidikan Agama Islam dan Budi Pekerti', 'GENAP', '2021/2022', 70),
('001', 'Siswa1', '7', '002', 'Pendidikan Pancasila dan Kewarganegaraan', 'GENAP', '2021/2022', 70),
('001', 'Siswa1', '7', '003', 'Bahasa Indonesia', 'GENAP', '2021/2022', 70),
('001', 'Siswa1', '7', '004', 'Matematika', 'GENAP', '2021/2022', 70),
('001', 'Siswa1', '7', '005', 'Ilmu Pengetahuan Alam', 'GENAP', '2021/2022', 70),
('001', 'Siswa1', '7', '006', 'Ilmu Pengetahuan Sosial', 'GENAP', '2021/2022', 70),
('001', 'Siswa1', '7', '007', 'Seni Budaya dan Keterampilan', 'GENAP', '2021/2022', 70),
('001', 'Siswa1', '7', '008', 'Pendidikan Jasmani, Olahraga dan Kesehatan', 'GENAP', '2021/2022', 70),
('001', 'Siswa1', '7', '009', 'Bahasa Inggris', 'GENAP', '2021/2022', 70),
('001', 'Siswa1', '7', '010', 'Bahasa Arab', 'GENAP', '2021/2022', 70),
('001', 'Siswa1', '7', '011', 'Aqidah Akhlak', 'GENAP', '2021/2022', 70),
('001', 'Siswa1', '7', '012', 'Tahfidz', 'GENAP', '2021/2022', 70),
('001', 'Siswa1', '7', '013', 'Sejarah Kebudayaan Islam', 'GENAP', '2021/2022', 70),
('001', 'Siswa1', '7', '014', 'Amtsilati', 'GENAP', '2021/2022', 70),
('001', 'Siswa1', '7', '015', 'Al Quran Hadist', 'GENAP', '2021/2022', 70),
('001', 'Siswa1', '7', '016', 'Prakarya', 'GENAP', '2021/2022', 70),
('001', 'Siswa1', '7', '017', 'BTQ', 'GENAP', '2021/2022', 70),
('001', 'Siswa1', '7', '018', 'TIK', 'GENAP', '2021/2022', 70);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelajaran`
--

CREATE TABLE `pelajaran` (
  `kd_mapel` char(6) NOT NULL,
  `mapel` varchar(50) NOT NULL,
  `jenis` varchar(50) NOT NULL,
  `kkm` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pelajaran`
--

INSERT INTO `pelajaran` (`kd_mapel`, `mapel`, `jenis`, `kkm`) VALUES
('001', 'Pendidikan Agama Islam dan Budi Pekerti', 'Bukan Muatan Lokal', 75),
('002', 'Pendidikan Pancasila dan Kewarganegaraan', 'Bukan Muatan Lokal', 70),
('003', 'Bahasa Indonesia', 'Bukan Muatan Lokal', 70),
('004', 'Matematika', 'Bukan Muatan Lokal', 70),
('005', 'Ilmu Pengetahuan Alam', 'Bukan Muatan Lokal', 70),
('006', 'Ilmu Pengetahuan Sosial', 'Bukan Muatan Lokal', 70),
('007', 'Seni Budaya dan Keterampilan', 'Bukan Muatan Lokal', 70),
('008', 'Pendidikan Jasmani, Olahraga dan Kesehatan', 'Bukan Muatan Lokal', 70),
('009', 'Bahasa Inggris', 'Muatan Lokal', 70),
('010', 'Bahasa Arab', 'Muatan Lokal', 75),
('011', 'Aqidah Akhlak', 'Muatan Lokal', 75),
('012', 'Tahfidz', 'Muatan Lokal', 75),
('013', 'Sejarah Kebudayaan Islam', 'Muatan Lokal', 75),
('014', 'Amtsilati', 'Muatan Lokal', 75),
('015', 'Al Quran Hadist', 'Muatan Lokal', 75),
('016', 'Prakarya', 'Muatan Lokal', 70),
('017', 'BTQ', 'Muatan Lokal', 75),
('018', 'TIK', 'Muatan Lokal', 75);

-- --------------------------------------------------------

--
-- Struktur dari tabel `siswa`
--

CREATE TABLE `siswa` (
  `nis` char(18) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `tmp_lahir` varchar(50) NOT NULL,
  `tgl_lahir` varchar(50) NOT NULL,
  `kelas` varchar(40) NOT NULL,
  `agama` varchar(50) NOT NULL,
  `jenis_kel` varchar(50) NOT NULL,
  `nama_wali` varchar(50) NOT NULL,
  `jenis_kel_wali` varchar(50) NOT NULL,
  `no_telp_wali` char(15) NOT NULL,
  `alamat_wali` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `siswa`
--

INSERT INTO `siswa` (`nis`, `nama`, `tmp_lahir`, `tgl_lahir`, `kelas`, `agama`, `jenis_kel`, `nama_wali`, `jenis_kel_wali`, `no_telp_wali`, `alamat_wali`) VALUES
('001', 'Siswa1', '-', '-', '7', '-', 'Laki-Laki', '-', 'Perempuan', '-', '-'),
('002', 'Siswa2', '-', '-', '7', '-', 'Laki-Laki', '-', 'Perempuan', '-', '-'),
('003', 'Siswa3', '-', '-', '8', '-', 'Laki-Laki', '-', 'Perempuan', '-', '-');

-- --------------------------------------------------------

--
-- Struktur dari tabel `wali_kelas`
--

CREATE TABLE `wali_kelas` (
  `nip` char(18) NOT NULL,
  `nama_guru` varchar(50) NOT NULL,
  `no_hp` char(15) NOT NULL,
  `kelas` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `wali_kelas`
--

INSERT INTO `wali_kelas` (`nip`, `nama_guru`, `no_hp`, `kelas`) VALUES
('00000001', 'Guru1', '08500000000', '7'),
('00000002', 'Guru2', '08500000000', '8'),
('00000004', 'Guru4', '08380000000', '9');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `absen`
--
ALTER TABLE `absen`
  ADD UNIQUE KEY `nis` (`nis`);

--
-- Indeks untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `guru`
--
ALTER TABLE `guru`
  ADD PRIMARY KEY (`nip`);

--
-- Indeks untuk tabel `nilai_akhir_semester`
--
ALTER TABLE `nilai_akhir_semester`
  ADD KEY `nis` (`nis`),
  ADD KEY `kd_mapel` (`kd_mapel`);

--
-- Indeks untuk tabel `nilai_tengah_semester`
--
ALTER TABLE `nilai_tengah_semester`
  ADD KEY `nis` (`nis`),
  ADD KEY `kd_mapel` (`kd_mapel`);

--
-- Indeks untuk tabel `pelajaran`
--
ALTER TABLE `pelajaran`
  ADD PRIMARY KEY (`kd_mapel`);

--
-- Indeks untuk tabel `siswa`
--
ALTER TABLE `siswa`
  ADD PRIMARY KEY (`nis`),
  ADD KEY `relasi_siswa1` (`kelas`);

--
-- Indeks untuk tabel `wali_kelas`
--
ALTER TABLE `wali_kelas`
  ADD UNIQUE KEY `nip` (`nip`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `absen`
--
ALTER TABLE `absen`
  ADD CONSTRAINT `absen_relasi1` FOREIGN KEY (`nis`) REFERENCES `siswa` (`nis`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `nilai_akhir_semester`
--
ALTER TABLE `nilai_akhir_semester`
  ADD CONSTRAINT `relasi_nilai_akhir1` FOREIGN KEY (`nis`) REFERENCES `siswa` (`nis`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `relasi_nilai_akhir2` FOREIGN KEY (`kd_mapel`) REFERENCES `pelajaran` (`kd_mapel`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `nilai_tengah_semester`
--
ALTER TABLE `nilai_tengah_semester`
  ADD CONSTRAINT `relasi_nilai_tengah1` FOREIGN KEY (`nis`) REFERENCES `siswa` (`nis`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `relasi_nilai_tengah2` FOREIGN KEY (`kd_mapel`) REFERENCES `pelajaran` (`kd_mapel`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `wali_kelas`
--
ALTER TABLE `wali_kelas`
  ADD CONSTRAINT `relasi_wali_kelas1` FOREIGN KEY (`nip`) REFERENCES `guru` (`nip`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
