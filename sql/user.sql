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

 Date: 22/04/2023 13:24:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `gender` enum('male','female','other') CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `birthday` date NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `region` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `following_blog_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `following_blog_id`(`following_blog_id`) USING BTREE,
  INDEX `name`(`name`) USING BTREE,
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`following_blog_id`) REFERENCES `admin` (`blog_id`) ON DELETE SET NULL ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Alice', 'female', '1995-03-10', 'alice@example.com', 'New York', 1);
INSERT INTO `user` VALUES (2, 'Bob', 'male', '1990-07-22', 'bob@example.com', 'London', NULL);
INSERT INTO `user` VALUES (3, 'Charlie', 'male', '1992-11-05', 'charlie@example.com', 'Paris', 3);
INSERT INTO `user` VALUES (4, 'David', 'male', '1988-02-14', 'david@example.com', 'Tokyo', NULL);
INSERT INTO `user` VALUES (5, 'Emma', 'female', '1993-09-01', 'emma@example.com', 'San Francisco', NULL);
INSERT INTO `user` VALUES (6, 'Frank', 'male', '1997-05-20', 'frank@example.com', 'Beijing', NULL);
INSERT INTO `user` VALUES (7, 'Grace', 'female', '1996-12-18', 'grace@example.com', 'Sydney', NULL);
INSERT INTO `user` VALUES (8, 'Henry', 'male', '1991-04-03', 'henry@example.com', 'Toronto', NULL);
INSERT INTO `user` VALUES (9, 'Isabella', 'female', '1989-08-12', 'isabella@example.com', 'Melbourne', NULL);
INSERT INTO `user` VALUES (10, 'Jack', 'male', '1994-06-30', 'jack@example.com', 'Shanghai', NULL);
INSERT INTO `user` VALUES (11, 'Kate', 'female', '1998-01-17', 'kate@example.com', 'Rio de Janeiro', NULL);
INSERT INTO `user` VALUES (12, 'Lucas', 'male', '1990-10-11', 'lucas@example.com', 'Berlin', NULL);
INSERT INTO `user` VALUES (13, 'Mia', 'female', '1992-02-28', 'mia@example.com', 'Barcelona', NULL);
INSERT INTO `user` VALUES (14, 'Nathan', 'male', '1997-09-08', 'nathan@example.com', 'Singapore', NULL);
INSERT INTO `user` VALUES (15, 'Olivia', 'female', '1994-04-21', 'olivia@example.com', 'Chicago', NULL);
INSERT INTO `user` VALUES (16, 'Peter', 'male', '1993-12-09', 'peter@example.com', 'Hong Kong', NULL);
INSERT INTO `user` VALUES (17, 'Quentin', 'male', '1996-08-06', 'quentin@example.com', 'Mumbai', NULL);
INSERT INTO `user` VALUES (18, 'Rose', 'female', '1991-03-14', 'rose@example.com', 'Moscow', NULL);
INSERT INTO `user` VALUES (19, 'Sam', 'male', '1988-11-25', 'sam@example.com', 'Seoul', NULL);
INSERT INTO `user` VALUES (20, 'Tina', 'female', '1995-07-27', 'tina@example.com', 'Amsterdam', NULL);

SET FOREIGN_KEY_CHECKS = 1;
