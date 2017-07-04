/*
Navicat MySQL Data Transfer

Source Server         : connector
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-07-03 16:29:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(20) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `ISBN` varchar(50) DEFAULT NULL,
  `price` double(20,0) DEFAULT NULL,
  `pressID` int(20) DEFAULT NULL COMMENT '出版社ID',
  `categoryID` int(20) DEFAULT NULL COMMENT '图书类别ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(20) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------

-- ----------------------------
-- Table structure for press
-- ----------------------------
DROP TABLE IF EXISTS `press`;
CREATE TABLE `press` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '出版社编号',
  `name` varchar(50) DEFAULT NULL COMMENT '出版社名称',
  `adress` varchar(50) DEFAULT NULL COMMENT '图书馆地址',
  `url` varchar(50) DEFAULT NULL COMMENT '出版社网址',
  `mail` varchar(50) DEFAULT NULL COMMENT '出版社邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of press
-- ----------------------------
