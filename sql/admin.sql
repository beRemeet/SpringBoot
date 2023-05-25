/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 22/04/2023 13:23:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `blog_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `is_active` tinyint(1) NULL DEFAULT 1,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`blog_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin1', 'password1', 'admin1@example.com', 1, '2023-04-21 21:38:44');
INSERT INTO `admin` VALUES (2, 'admin2', 'password2', 'admin2@example.com', 1, '2023-04-21 21:38:44');
INSERT INTO `admin` VALUES (3, 'admin3', 'password3', 'admin3@example.com', 1, '2023-04-21 21:38:44');
INSERT INTO `admin` VALUES (4, 'admin4', 'password4', 'admin4@example.com', 1, '2023-04-21 21:38:44');
INSERT INTO `admin` VALUES (5, 'admin5', 'password5', 'admin5@example.com', 1, '2023-04-21 21:38:44');

SET FOREIGN_KEY_CHECKS = 1;
