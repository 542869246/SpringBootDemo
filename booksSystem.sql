/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : booksSystem

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2018-04-22 15:33:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book_info
-- ----------------------------
DROP TABLE IF EXISTS `book_info`;
CREATE TABLE `book_info` (
  `book_id` int(10) NOT NULL AUTO_INCREMENT,
  `book_code` varchar(255) NOT NULL,
  `book_name` varchar(255) NOT NULL,
  `book_type` int(2) NOT NULL,
  `book_atuthor` varchar(255) NOT NULL,
  `publish_press` varchar(255) NOT NULL,
  `publish_date` datetime NOT NULL,
  `is_borrow` int(2) NOT NULL,
  `createdBy` varchar(255) NOT NULL,
  `creation_time` datetime NOT NULL,
  `last_updatetime` datetime NOT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_info
-- ----------------------------
INSERT INTO `book_info` VALUES ('1', 'qwfwa124', 'java编程思想', '1', 'god', 'zyf出版社', '2014-02-04 20:17:25', '0', 'zyf', '2011-03-31 20:18:00', '2014-06-17 20:18:10');
INSERT INTO `book_info` VALUES ('2', 'dfq2r1', 'java入门到入土', '1', 'zyf', 'zyf出版社', '2014-03-04 20:17:25', '1', 'zyf', '2011-03-31 20:18:00', '2014-06-17 20:18:10');
INSERT INTO `book_info` VALUES ('3', 'f1111111er', 'MySQL入门到删库跑路', '2', 'cc', 'zyf出版社', '2014-03-04 20:17:25', '0', 'zyf', '2011-04-28 20:18:00', '2014-06-17 20:18:10');
INSERT INTO `book_info` VALUES ('4', 'fqwef2', 'H5入门到要饭', '3', 'cc', 'zyf出版社', '2014-03-04 20:17:25', '0', 'zyf', '2011-04-03 20:18:00', '2014-06-17 20:18:10');
INSERT INTO `book_info` VALUES ('5', 'rt2', 'Vue.js入门到入狱', '4', 'qc', 'zyf出版社', '2014-03-04 20:17:25', '1', 'zyf', '2011-04-01 20:18:00', '2014-06-17 20:18:10');
INSERT INTO `book_info` VALUES ('6', 'vdsg2g342', '颈椎病康复指南', '5', 'zyp', 'zyf出版社', '2014-03-04 20:17:25', '0', 'zyf', '2011-04-05 20:18:00', '2014-06-17 20:18:10');
INSERT INTO `book_info` VALUES ('7', 'asfa', 'asdasdasdasd', '1', 'zyp', 'zyf出版社', '2014-03-04 20:17:25', '0', 'zyf', '2011-04-05 20:18:00', '2014-06-17 20:18:10');
INSERT INTO `book_info` VALUES ('8', 'asfa', 'asdasdasdasd', '1', 'zyp', 'zyf出版社', '2014-03-04 20:17:25', '0', 'zyf', '2011-04-05 20:18:00', '2014-06-17 20:18:10');
INSERT INTO `book_info` VALUES ('9', 'asfa', 'asdasdasdasd', '1', 'zyp', 'zyf出版社', '2014-03-04 20:17:25', '0', 'zyf', '2011-04-05 20:18:00', '2014-06-17 20:18:10');
INSERT INTO `book_info` VALUES ('10', 'asfa', 'asdasdasdasd', '1', 'zyp', 'zyf出版社', '2014-03-04 20:17:25', '0', 'zyf', '2011-04-05 20:18:00', '2014-06-17 20:18:10');
INSERT INTO `book_info` VALUES ('11', 'asfaascc', 'asdasdasdasdcc', '2', 'zypcc', 'zyf出版社cc', '2014-03-04 20:17:25', '0', 'zyfcc', '2011-04-05 20:18:00', '2014-06-17 20:18:19');
INSERT INTO `book_info` VALUES ('12', 'xjgb', '性价比高', '3', '周宇峰z', 'zz出版社z', '2014-03-04 00:00:01', '0', '哈哈z', '2014-03-04 00:00:01', '2014-03-04 00:00:01');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_code` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `gender` varchar(7) NOT NULL,
  `register_time` datetime NOT NULL,
  `last_logintime` datetime NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_code` (`user_code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '1111111', '111111', 'zxc@qq.com', '男', '2018-02-01 20:10:51', '2018-02-02 20:10:55');
INSERT INTO `users` VALUES ('2', '2222222', '222222', 'asd@qq.com', '女', '2018-02-03 20:11:16', '2018-02-04 20:11:19');
INSERT INTO `users` VALUES ('3', '3333333', '333333', 'qwe@qq.com', '男', '2018-02-06 20:11:42', '2018-02-07 20:11:48');
SET FOREIGN_KEY_CHECKS=1;
