-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 17, 2023 at 05:36 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `varun`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `book_id` int(11) NOT NULL,
  `book_name` varchar(30) DEFAULT NULL,
  `athr_name` varchar(30) DEFAULT NULL,
  `book_brn_id` int(11) DEFAULT NULL,
  `book_price` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`book_id`, `book_name`, `athr_name`, `book_brn_id`, `book_price`) VALUES
(11, 'Basics Of Science', 'George.c', NULL, 455),
(12, 'Basics Of Maths', 'Hadhway Rome', NULL, 657),
(13, 'Algebra 101', 'Katty Holmes', NULL, 345),
(14, 'Stars And Moons', 'Marty & Josh', NULL, 999),
(15, 'C++ All In One', 'Jason.y', NULL, 867),
(16, 'Python For DS', 'Jose.Port', NULL, 567);

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

CREATE TABLE `branch` (
  `brn_id` int(11) NOT NULL,
  `brn_name` varchar(20) DEFAULT NULL,
  `brn_ctg` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `branch`
--

INSERT INTO `branch` (`brn_id`, `brn_name`, `brn_ctg`) VALUES
(1001, 'Heisengton', 'Science'),
(1002, 'JumbleNumbers', 'Mathematics'),
(1003, 'HelloWorld', 'IT');

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

CREATE TABLE `faculty` (
  `faculty_Id` int(11) NOT NULL,
  `faculty_name` varchar(50) DEFAULT NULL,
  `faculty_salary` decimal(10,2) DEFAULT NULL,
  `faculty_Contact` varchar(10) DEFAULT NULL,
  `faculty_Email` varchar(20) DEFAULT NULL,
  `faculty_department` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `faculty`
--

INSERT INTO `faculty` (`faculty_Id`, `faculty_name`, `faculty_salary`, `faculty_Contact`, `faculty_Email`, `faculty_department`) VALUES
(1, 'shayam', '40000.80', '7433673894', 'shayam@gmail.com', 'CSE'),
(2, 'Harry2', '3000.40', '2147483647', 'harry2@gmail.com', 'EE'),
(3, 'Harry2', '6000.50', '2147483647', 'harry3@gmail.com', 'EC'),
(4, 'Harry4', '8000.40', '2147483647', 'harry4@gmail.com', 'MSME'),
(5, 'Harry5', '78000.50', '2147483647', 'harry5@gmail.com', 'CIVIL'),
(6, 'Ram', '1000.80', '9873345362', 'ram@gmail.com', 'ME'),
(10, 'xyz', '12335.70', '9996643323', 'xyz@gmai.com', 'Cse');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `Id` int(11) NOT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`Id`, `user_name`, `password`) VALUES
(101, 'shayam', 'shayam@123'),
(102, 'ram', 'ram@1995'),
(103, 'mukesh', 'mukesh@2003');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `product_id` int(11) NOT NULL,
  `product_name` varchar(20) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_id`, `product_name`, `price`, `quantity`) VALUES
(1, 'English', '102.50', 20),
(2, 'Maths', '200.50', 30),
(3, 'Science', '300.50', 50),
(4, 'Social Science', '400.50', 60),
(5, 'Hindi', '500.50', 70),
(6, 'Grammer', '700.40', 90);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `stu_id` int(11) NOT NULL,
  `stu_name` varchar(30) DEFAULT NULL,
  `stu_ph_no` int(11) DEFAULT NULL,
  `stu_email` varchar(30) DEFAULT NULL,
  `stu_dob` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`stu_id`, `stu_name`, `stu_ph_no`, `stu_email`, `stu_dob`) VALUES
(911, 'Bennett Johns', 7394658, 'Bennetttt6748@gmail.com', '1994-09-03'),
(912, 'Immanuel Collier', 5936827, 'collierIma674@gmail.com', '1993-05-08'),
(913, 'Dayton Luettgen', 9564836, 'LueDay3841@gmail.com', '1998-07-13'),
(914, 'Courtney Reinger', 8375663, 'Reignthe43@gmail.com', '2000-05-07'),
(915, 'Retta Hammes', 6492657, 'RettaSamuela45@gmail.com', '1998-02-03'),
(916, 'Monte Haley', 8573543, 'Monteray564@gmail.com', '1999-07-21'),
(917, 'Ryann Franecki', 1637429, 'ryanben786654@gmail.com', '2000-05-08'),
(918, 'Shayne Denesik', 5471257, 'uthSha4@gmail.com', '2001-11-05'),
(919, 'Skylar Grady', 9687452, 'Skylaryou5t@gmail.com', '1997-09-19'),
(920, 'Idell Franecki', 7365841, 'itsmeIdeLL4@gmail.com', '1999-02-01');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `usr_id` int(11) NOT NULL,
  `usr_name` varchar(30) DEFAULT NULL,
  `usr_ph_no` int(11) DEFAULT NULL,
  `usr_email` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`book_id`);

--
-- Indexes for table `branch`
--
ALTER TABLE `branch`
  ADD PRIMARY KEY (`brn_id`);

--
-- Indexes for table `faculty`
--
ALTER TABLE `faculty`
  ADD PRIMARY KEY (`faculty_Id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`stu_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`usr_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
