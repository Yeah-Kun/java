/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-07-06 22:57:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
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
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '人文');
INSERT INTO `category` VALUES ('2', '政治');
INSERT INTO `category` VALUES ('4', '历史');
INSERT INTO `category` VALUES ('6', '军事');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of press
-- ----------------------------
INSERT INTO `press` VALUES ('1', '人民教育出版社', '北京', 'http://www.pep.com.cn/', '123456@qq.com');
INSERT INTO `press` VALUES ('2', 'AKB48', '南京', 'www.jiangmen.com', '654615@qq.com');
INSERT INTO `press` VALUES ('3', '志坚哥', '江门', 'www.zhijian.com', '5461@qq.com');
INSERT INTO `press` VALUES ('4', 'SBH48', '广州', 'www.wyu.com', '68465@qq.com');
