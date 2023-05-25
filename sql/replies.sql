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

 Date: 22/04/2023 13:23:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for replies
-- ----------------------------
DROP TABLE IF EXISTS `replies`;
CREATE TABLE `replies`  (
  `id` int NOT NULL,
  `post_id` int NOT NULL,
  `user_id` int NOT NULL,
  `reply_content` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `post_id`(`post_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `replies_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `replies_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of replies
-- ----------------------------
INSERT INTO `replies` VALUES (1, 1, 2, '非常喜欢这篇文章，写得非常好。', '2023-04-21 21:50:04');
INSERT INTO `replies` VALUES (2, 1, 3, '我也同意作者的观点，学习英语口语需要勤练习和自信心。', '2023-04-21 21:50:04');
INSERT INTO `replies` VALUES (3, 1, 4, '作者提到的方法非常实用，我会尝试一下。', '2023-04-21 21:50:04');
INSERT INTO `replies` VALUES (4, 2, 5, '我也是一位程序员，非常感谢作者的分享。', '2023-04-21 21:50:04');
INSERT INTO `replies` VALUES (5, 2, 6, '这篇文章让我对编程有了更深入的了解，谢谢作者。', '2023-04-21 21:50:04');
INSERT INTO `replies` VALUES (6, 2, 7, '我也有同样的问题，感谢作者提供了解决方案。', '2023-04-21 21:50:04');
INSERT INTO `replies` VALUES (7, 3, 8, '很赞同作者的观点，阅读对于人的成长和发展非常重要。', '2023-04-21 21:50:04');
INSERT INTO `replies` VALUES (8, 3, 9, '我也是一个热爱阅读的人，很喜欢这篇文章。', '2023-04-21 21:50:04');
INSERT INTO `replies` VALUES (9, 4, 10, '我非常想去巴厘岛旅游，看了你的分享更加坚定了我的决心。', '2023-04-21 21:50:04');
INSERT INTO `replies` VALUES (10, 4, 11, '你的游记写得非常详细，让人仿佛也去了一次旅行。', '2023-04-21 21:50:04');
INSERT INTO `replies` VALUES (11, 4, 12, '感谢你的分享，让我更加了解巴厘岛的美丽。', '2023-04-21 21:50:04');
INSERT INTO `replies` VALUES (12, 5, 13, '我非常赞同作者的观点，爱情需要双方共同维护和努力。', '2023-04-21 21:50:04');
INSERT INTO `replies` VALUES (13, 5, 14, '作者的话让我想起了自己的感情问题，谢谢你的分享。', '2023-04-21 21:50:04');
INSERT INTO `replies` VALUES (14, 5, 15, '爱情的意义和价值确实需要我们去认真思考和面对，非常感谢作者的观点。', '2023-04-21 21:50:04');
INSERT INTO `replies` VALUES (15, 6, 16, '环保问题是我们每个人都需要关注和参与的，感谢作者提供了一些实用的环保行动建议。', '2023-04-21 21:50:04');
INSERT INTO `replies` VALUES (16, 6, 17, '我也在积极行动，尽可能减少使用塑料袋和支持低碳生活。', '2023-04-21 21:50:04');
INSERT INTO `replies` VALUES (17, 6, 18, '这篇文章让我意识到自己还可以在环保方面做得更多，谢谢你的分享。', '2023-04-21 21:50:04');
INSERT INTO `replies` VALUES (18, 7, 19, '谢谢你的分享，我也是一个喜欢运动的人，你的经验对我很有帮助。', '2023-04-21 21:50:04');
INSERT INTO `replies` VALUES (19, 7, 20, '我也非常喜欢运动，最近在尝试跑步，感觉很好。', '2023-04-21 21:50:04');
INSERT INTO `replies` VALUES (20, 7, 1, '谢谢你的分享，让我更加坚定了继续运动的决心。', '2023-04-21 21:50:04');

SET FOREIGN_KEY_CHECKS = 1;
