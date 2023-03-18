/*
 Navicat Premium Data Transfer

 Source Server         : 1
 Source Server Type    : MySQL
 Source Server Version : 50710
 Source Host           : localhost:3306
 Source Schema         : customer_info

 Target Server Type    : MySQL
 Target Server Version : 50710
 File Encoding         : 65001

 Date: 05/05/2022 15:16:38
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for manager_info
-- ----------------------------
DROP TABLE IF EXISTS `manager_info`;
CREATE TABLE `manager_info`
(
    `managerid`       int(10) NOT NULL AUTO_INCREMENT,
    `managername`     varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `managerpassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `manageremail`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `salt`            varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `sex`             varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `birthdate`       datetime(6) NULL DEFAULT NULL,
    `tel`             bigint(255) NULL DEFAULT NULL,
    `education`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `IDcard`          bigint(255) NULL DEFAULT NULL,
    `other`           varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `manageraccount`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    PRIMARY KEY (`managerid`, `manageraccount`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 53
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manager_info
-- ----------------------------
INSERT INTO `manager_info`
VALUES (1, '熊大', '9dd94f182f6b53e8e37018a9596445b4', '1399328545@qq.com', '4c564bee7c39165a32609401b87619c9', '男',
        '2000-01-01 00:00:01.100000', 13378270917, '本科', 521511200001011008, NULL, 'A001');
INSERT INTO `manager_info`
VALUES (2, '熊二', '9dd94f182f6b53e8e37018a9596445b4', '1399328545@qq.com', '4c564bee7c39165a32609401b87619c9', '女',
        '2000-01-01 00:00:02.100000', 13378270918, '硕士', 522522200001011968, NULL, 'A002');
INSERT INTO `manager_info`
VALUES (3, '张三', '9dd94f182f6b53e8e37018a9596445b4', '1399328545@qq.com', '4c564bee7c39165a32609401b87619c9', '男',
        '2000-01-01 00:00:03.100000', 13378270919, '博士', 523533200001012992, '1', 'A003');
INSERT INTO `manager_info`
VALUES (4, '李四', '9dd94f182f6b53e8e37018a9596445b4', '1399328545@qq.com', '4c564bee7c39165a32609401b87619c9', '女',
        '2000-01-01 00:00:04.100000', 13378270920, '本科', 524544200001014016, NULL, 'A004');
INSERT INTO `manager_info`
VALUES (5, '王五', '9dd94f182f6b53e8e37018a9596445b4', '1399328545@qq.com', '4c564bee7c39165a32609401b87619c9', '男',
        '2000-01-01 00:00:05.100000', 13378270921, '硕士', 525555200001014976, NULL, 'A005');
INSERT INTO `manager_info`
VALUES (6, '赵六', '9dd94f182f6b53e8e37018a9596445b4', '1399328545@qq.com', '4c564bee7c39165a32609401b87619c9', '女',
        '2000-01-01 00:00:06.100000', 13378270922, '博士', 526566200001016000, '1', 'A006');

-- ----------------------------
-- Table structure for service
-- ----------------------------
DROP TABLE IF EXISTS `service`;
CREATE TABLE `service`
(
    `serviceid`    int(10) NOT NULL,
    `type`         varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `date`         datetime(6) NULL DEFAULT NULL,
    `time`         bigint(10) NULL DEFAULT NULL,
    `satisfaction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    PRIMARY KEY (`serviceid`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of service
-- ----------------------------
INSERT INTO `service`
VALUES (1, '上门服务', '2000-01-01 00:00:01.100000', 2, '很满意');
INSERT INTO `service`
VALUES (2, '解决客户投诉', '2000-01-01 00:00:02.200000', 2, '比较满意');
INSERT INTO `service`
VALUES (3, '客户培训', '2000-01-01 00:00:03.300000', 2, '不满意');
INSERT INTO `service`
VALUES (4, '上门服务', '2000-01-01 00:00:04.400000', 2, '很不满意');
INSERT INTO `service`
VALUES (5, '解决客户投诉', '2000-01-01 00:00:05.500000', 2, '很满意');
INSERT INTO `service`
VALUES (6, '客户培训', '2000-01-01 00:00:06.600000', 2, '比较满意');
INSERT INTO `service`
VALUES (7, '上门服务', '2000-01-01 00:00:07.700000', 2, '不满意');
INSERT INTO `service`
VALUES (8, '解决客户投诉', '2000-01-01 00:00:08.800000', 2, '很不满意');
INSERT INTO `service`
VALUES (9, '客户培训', '2000-01-01 00:00:09.900000', 2, '很满意');
INSERT INTO `service`
VALUES (10, '上门服务', '2000-01-01 00:00:01.100000', 2, '比较满意');
INSERT INTO `service`
VALUES (11, '解决客户投诉', '2000-01-01 00:00:01.110000', 2, '不满意');
INSERT INTO `service`
VALUES (12, '客户培训', '2000-01-01 00:00:01.120000', 2, '很不满意');
INSERT INTO `service`
VALUES (13, '上门服务', '2000-01-01 00:00:01.130000', 2, '很满意');
INSERT INTO `service`
VALUES (14, '解决客户投诉', '2000-01-01 00:00:01.140000', 2, '比较满意');
INSERT INTO `service`
VALUES (15, '客户培训', '2000-01-01 00:00:01.150000', 2, '不满意');
INSERT INTO `service`
VALUES (16, '上门服务', '2000-01-01 00:00:01.160000', 2, '很不满意');
INSERT INTO `service`
VALUES (17, '解决客户投诉', '2000-01-01 00:00:01.170000', 2, '很满意');
INSERT INTO `service`
VALUES (18, '客户培训', '2000-01-01 00:00:01.180000', 2, '比较满意');
INSERT INTO `service`
VALUES (19, '上门服务', '2000-01-01 00:00:01.190000', 2, '不满意');
INSERT INTO `service`
VALUES (20, '解决客户投诉', '2000-01-01 00:00:02.200000', 2, '很不满意');
INSERT INTO `service`
VALUES (21, '客户培训', '2000-01-01 00:00:02.210000', 2, '很满意');
INSERT INTO `service`
VALUES (22, '上门服务', '2000-01-01 00:00:02.220000', 2, '比较满意');
INSERT INTO `service`
VALUES (23, '解决客户投诉', '2000-01-01 00:00:02.230000', 2, '不满意');
INSERT INTO `service`
VALUES (24, '客户培训', '2000-01-01 00:00:02.240000', 2, '很不满意');
INSERT INTO `service`
VALUES (25, '上门服务', '2000-01-01 00:00:02.250000', 2, '很满意');
INSERT INTO `service`
VALUES (26, '解决客户投诉', '2000-01-01 00:00:02.260000', 2, '比较满意');
INSERT INTO `service`
VALUES (27, '客户培训', '2000-01-01 00:00:02.170000', 2, '不满意');
INSERT INTO `service`
VALUES (28, '上门服务', '2000-01-01 00:00:02.280000', 2, '很不满意');
INSERT INTO `service`
VALUES (29, '解决客户投诉', '2000-01-01 00:00:02.190000', 2, '很满意');

-- ----------------------------
-- Table structure for service_u_m
-- ----------------------------
DROP TABLE IF EXISTS `service_u_m`;
CREATE TABLE `service_u_m`
(
    `serviceid` int(10) NOT NULL,
    `userid`    int(10) NULL DEFAULT NULL,
    `managerid` int(10) NULL DEFAULT NULL,
    PRIMARY KEY (`serviceid`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of service_u_m
-- ----------------------------
INSERT INTO `service_u_m`
VALUES (1, 1, 1);
INSERT INTO `service_u_m`
VALUES (2, 1, 2);
INSERT INTO `service_u_m`
VALUES (3, 1, 3);
INSERT INTO `service_u_m`
VALUES (4, 2, 4);
INSERT INTO `service_u_m`
VALUES (5, 3, 5);
INSERT INTO `service_u_m`
VALUES (6, 4, 6);
INSERT INTO `service_u_m`
VALUES (7, 5, 7);
INSERT INTO `service_u_m`
VALUES (8, 6, 8);
INSERT INTO `service_u_m`
VALUES (9, 7, 1);
INSERT INTO `service_u_m`
VALUES (10, 8, 2);
INSERT INTO `service_u_m`
VALUES (11, 9, 3);
INSERT INTO `service_u_m`
VALUES (12, 10, 4);
INSERT INTO `service_u_m`
VALUES (13, 11, 5);
INSERT INTO `service_u_m`
VALUES (14, 12, 6);
INSERT INTO `service_u_m`
VALUES (15, 13, 7);
INSERT INTO `service_u_m`
VALUES (16, 14, 8);
INSERT INTO `service_u_m`
VALUES (17, 15, 1);
INSERT INTO `service_u_m`
VALUES (18, 16, 2);
INSERT INTO `service_u_m`
VALUES (19, 17, 3);
INSERT INTO `service_u_m`
VALUES (20, 18, 4);
INSERT INTO `service_u_m`
VALUES (21, 19, 5);
INSERT INTO `service_u_m`
VALUES (22, 20, 6);
INSERT INTO `service_u_m`
VALUES (23, 21, 7);
INSERT INTO `service_u_m`
VALUES (24, 22, 8);
INSERT INTO `service_u_m`
VALUES (25, 23, 1);
INSERT INTO `service_u_m`
VALUES (26, 24, 2);
INSERT INTO `service_u_m`
VALUES (27, 25, 3);
INSERT INTO `service_u_m`
VALUES (28, 26, 4);
INSERT INTO `service_u_m`
VALUES (29, 27, 5);

-- ----------------------------
-- Table structure for superadmin
-- ----------------------------
DROP TABLE IF EXISTS `superadmin`;
CREATE TABLE `superadmin`
(
    `superadminname`     varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `superadminpassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `superadminid`       int(10) NULL DEFAULT NULL,
    `superadminaccount`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of superadmin
-- ----------------------------
INSERT INTO `superadmin`
VALUES ('周超宇', '123456', 1, 'S001');
INSERT INTO `superadmin`
VALUES ('蒋兴宇', '123456', 2, 'S002');
INSERT INTO `superadmin`
VALUES ('李洋', '123456', 3, 'S003');
INSERT INTO `superadmin`
VALUES ('熊宇灿', '123456', 4, 'S004');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`
(
    `userid`       int(10) NOT NULL AUTO_INCREMENT,
    `username`     varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `userpassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `useremail`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `salt`         varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `sex`          varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `birthdate`    datetime(6) NULL DEFAULT NULL,
    `education`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `IDcard`       bigint(255) NULL DEFAULT NULL,
    `customerunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `managername`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `other`        varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `useraccount`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    PRIMARY KEY (`userid`, `useraccount`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 30
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info`
VALUES (1, '张三01', '9dd94f182f6b53e8e37018a9596445b4', '1256453987@qq.com', '4c564bee7c39165a32609401b87619c9', '男',
        '2000-01-01 00:00:01.100000', '大专', 510123200001121024, 'xx公司', '熊大', '1', 'B001');
INSERT INTO `user_info`
VALUES (2, '张三02', '9dd94f182f6b53e8e37018a9596445b4', '1256453987@qq.com', '4c564bee7c39165a32609401b87619c9', '女',
        '2000-01-01 00:00:02.200000', '本科', 510123200001121024, 'xx局', '熊二', NULL, 'B002');
INSERT INTO `user_info`
VALUES (3, '张三03', '9dd94f182f6b53e8e37018a9596445b4', '1256453987@qq.com', '4c564bee7c39165a32609401b87619c9', '男',
        '2000-01-01 00:00:03.300000', '硕士', 510123200001121024, 'xxx公司', '张三', NULL, 'B003');
INSERT INTO `user_info`
VALUES (4, '张三04', '9dd94f182f6b53e8e37018a9596445b4', '1256453987@qq.com', '4c564bee7c39165a32609401b87619c9', '女',
        '2000-01-01 00:00:04.400000', '博士', 510123200001121024, 'xx公司', '李四', NULL, 'B004');
INSERT INTO `user_info`
VALUES (5, '张三05', '9dd94f182f6b53e8e37018a9596445b4', '1256453987@qq.com', '4c564bee7c39165a32609401b87619c9', '男',
        '2000-01-01 00:00:05.500000', '大专', 510123200001121024, 'xx局', '王五', NULL, 'B005');
INSERT INTO `user_info`
VALUES (6, '张三06', '9dd94f182f6b53e8e37018a9596445b4', '1256453987@qq.com', '4c564bee7c39165a32609401b87619c9', '女',
        '2000-01-01 00:00:06.600000', '本科', 510123200001121024, 'xxx公司', '赵六', NULL, 'B006');
INSERT INTO `user_info`
VALUES (7, '张三07', '9dd94f182f6b53e8e37018a9596445b4', '1256453987@qq.com', '4c564bee7c39165a32609401b87619c9', '男',
        '2000-01-01 00:00:07.700000', '硕士', 510123200001121024, 'xx公司', '熊大', NULL, 'B007');
INSERT INTO `user_info`
VALUES (8, '张三08', '9dd94f182f6b53e8e37018a9596445b4', '1256453987@qq.com', '4c564bee7c39165a32609401b87619c9', '女',
        '2000-01-01 00:00:08.800000', '博士', 510123200001121024, 'xx局', '熊二', NULL, 'B008');
INSERT INTO `user_info`
VALUES (9, '张三09', '9dd94f182f6b53e8e37018a9596445b4', '1256453987@qq.com', '4c564bee7c39165a32609401b87619c9', '男',
        '2000-01-01 00:00:09.900000', '大专', 510123200001121024, 'xxx公司', '张三', NULL, 'B009');
INSERT INTO `user_info`
VALUES (10, '张三10', '9dd94f182f6b53e8e37018a9596445b4', '1256453987@qq.com', '4c564bee7c39165a32609401b87619c9', '女',
        '2000-01-01 00:00:01.100000', '本科', 510123200001121024, 'xx公司', '李四', NULL, 'B010');
INSERT INTO `user_info`
VALUES (11, '张三11', '9dd94f182f6b53e8e37018a9596445b4', '1256453987@qq.com', '4c564bee7c39165a32609401b87619c9', '男',
        '2000-01-01 00:00:01.110000', '硕士', 510123200001121024, 'xx局', '王五', NULL, 'B011');
INSERT INTO `user_info`
VALUES (12, '张三12', '9dd94f182f6b53e8e37018a9596445b4', '1256453987@qq.com', '4c564bee7c39165a32609401b87619c9', '女',
        '2000-01-01 00:00:01.120000', '博士', 510123200001121024, 'xxx公司', '赵六', NULL, 'B012');
INSERT INTO `user_info`
VALUES (13, '张三13', '9dd94f182f6b53e8e37018a9596445b4', '1256453987@qq.com', '4c564bee7c39165a32609401b87619c9', '男',
        '2000-01-01 00:00:01.130000', '大专', 510123200001121024, 'xx公司', '熊大', NULL, 'B013');
INSERT INTO `user_info`
VALUES (14, '张三14', '9dd94f182f6b53e8e37018a9596445b4', '1256453987@qq.com', '4c564bee7c39165a32609401b87619c9', '女',
        '2000-01-01 00:00:01.140000', '本科', 510123200001121024, 'xx局', '熊二', NULL, 'B014');
INSERT INTO `user_info`
VALUES (15, '张三15', '9dd94f182f6b53e8e37018a9596445b4', '1256453987@qq.com', '4c564bee7c39165a32609401b87619c9', '男',
        '2000-01-01 00:00:01.150000', '硕士', 510123200001121024, 'xxx公司', '张三', '1', 'B015');
INSERT INTO `user_info`
VALUES (16, '张三16', '9dd94f182f6b53e8e37018a9596445b4', '1256453987@qq.com', '4c564bee7c39165a32609401b87619c9', '女',
        '2000-01-01 00:00:01.160000', '博士', 510123200001121024, 'xx公司', '李四', NULL, 'B016');
INSERT INTO `user_info`
VALUES (17, '张三17', '9dd94f182f6b53e8e37018a9596445b4', '1256453987@qq.com', '4c564bee7c39165a32609401b87619c9', '男',
        '2000-01-01 00:00:01.170000', '大专', 510123200001121024, 'xx局', '王五', NULL, 'B017');
INSERT INTO `user_info`
VALUES (18, '张三18', '9dd94f182f6b53e8e37018a9596445b4', '1256453987@qq.com', '4c564bee7c39165a32609401b87619c9', '女',
        '2000-01-01 00:00:01.180000', '本科', 510123200001121024, 'xxx公司', '赵六', NULL, 'B018');
INSERT INTO `user_info`
VALUES (19, '张三19', '9dd94f182f6b53e8e37018a9596445b4', '1256453987@qq.com', '4c564bee7c39165a32609401b87619c9', '男',
        '2000-01-01 00:00:01.190000', '硕士', 510123200001121024, 'xx公司', '熊大', NULL, 'B019');
INSERT INTO `user_info`
VALUES (20, '张三20', '9dd94f182f6b53e8e37018a9596445b4', '1256453987@qq.com', '4c564bee7c39165a32609401b87619c9', '女',
        '2000-01-01 00:00:02.200000', '博士', 510123200001121024, 'xx局', '熊二', NULL, 'B020');
INSERT INTO `user_info`
VALUES (21, '张三21', '9dd94f182f6b53e8e37018a9596445b4', '1256453987@qq.com', '4c564bee7c39165a32609401b87619c9', '男',
        '2000-01-01 00:00:02.210000', '大专', 510123200001121024, 'xxx公司', '张三', NULL, 'B021');
INSERT INTO `user_info`
VALUES (22, '张三22', '9dd94f182f6b53e8e37018a9596445b4', '1256453987@qq.com', '4c564bee7c39165a32609401b87619c9', '女',
        '2000-01-01 00:00:02.220000', '本科', 510123200001121024, 'xx公司', '李四', NULL, 'B022');
INSERT INTO `user_info`
VALUES (23, '张三23', '9dd94f182f6b53e8e37018a9596445b4', '1256453987@qq.com', '4c564bee7c39165a32609401b87619c9', '男',
        '2000-01-01 00:00:02.230000', '硕士', 510123200001121024, 'xx局', '王五', NULL, 'B023');
INSERT INTO `user_info`
VALUES (24, '张三24', '9dd94f182f6b53e8e37018a9596445b4', '1256453987@qq.com', '4c564bee7c39165a32609401b87619c9', '女',
        '2000-01-01 00:00:02.240000', '博士', 510123200001121024, 'xxx公司', '赵六', NULL, 'B024');
INSERT INTO `user_info`
VALUES (25, '张三25', '9dd94f182f6b53e8e37018a9596445b4', '1256453987@qq.com', '4c564bee7c39165a32609401b87619c9', '男',
        '2000-01-01 00:00:02.250000', '大专', 510123200001121024, 'xx公司', '熊大', '1', 'B025');
INSERT INTO `user_info`
VALUES (26, '张三26', '9dd94f182f6b53e8e37018a9596445b4', '1256453987@qq.com', '4c564bee7c39165a32609401b87619c9', '女',
        '2000-01-01 00:00:02.260000', '本科', 510123200001121024, 'xx局', '熊二', NULL, 'B026');
INSERT INTO `user_info`
VALUES (27, '张三27', '9dd94f182f6b53e8e37018a9596445b4', '1256453987@qq.com', '4c564bee7c39165a32609401b87619c9', '男',
        '2000-01-01 00:00:02.270000', '硕士', 510123200001121024, 'xxx公司', '张三', NULL, 'B027');
INSERT INTO `user_info`
VALUES (28, '张三28', '9dd94f182f6b53e8e37018a9596445b4', '1256453987@qq.com', '4c564bee7c39165a32609401b87619c9', '女',
        '2000-01-01 00:00:02.280000', '博士', 510123200001121024, 'xx公司', '李四', NULL, 'B028');
INSERT INTO `user_info`
VALUES (29, '张三29', '9dd94f182f6b53e8e37018a9596445b4', '1256453987@qq.com', '4c564bee7c39165a32609401b87619c9', '男',
        '2000-01-01 00:00:02.290000', '大专', 510123200001121024, 'xx局', '王五', NULL, 'B029');

-- ----------------------------
-- Table structure for user_manager
-- ----------------------------
DROP TABLE IF EXISTS `user_manager`;
CREATE TABLE `user_manager`
(
    `user_manager_id` int(11) NOT NULL,
    `userid`          int(11) NULL DEFAULT NULL,
    `managerid`       int(11) NULL DEFAULT NULL,
    PRIMARY KEY (`user_manager_id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_manager
-- ----------------------------
INSERT INTO `user_manager`
VALUES (1, 1, 1);
INSERT INTO `user_manager`
VALUES (2, 2, 2);
INSERT INTO `user_manager`
VALUES (3, 3, 3);
INSERT INTO `user_manager`
VALUES (4, 4, 4);
INSERT INTO `user_manager`
VALUES (5, 5, 5);
INSERT INTO `user_manager`
VALUES (6, 6, 6);
INSERT INTO `user_manager`
VALUES (7, 7, 1);
INSERT INTO `user_manager`
VALUES (8, 8, 2);
INSERT INTO `user_manager`
VALUES (9, 9, 3);
INSERT INTO `user_manager`
VALUES (10, 10, 4);
INSERT INTO `user_manager`
VALUES (11, 11, 5);
INSERT INTO `user_manager`
VALUES (12, 12, 6);
INSERT INTO `user_manager`
VALUES (13, 13, 1);
INSERT INTO `user_manager`
VALUES (14, 14, 2);
INSERT INTO `user_manager`
VALUES (15, 15, 3);
INSERT INTO `user_manager`
VALUES (16, 16, 4);
INSERT INTO `user_manager`
VALUES (17, 17, 5);
INSERT INTO `user_manager`
VALUES (18, 18, 6);
INSERT INTO `user_manager`
VALUES (19, 19, 1);
INSERT INTO `user_manager`
VALUES (20, 20, 2);
INSERT INTO `user_manager`
VALUES (21, 21, 3);
INSERT INTO `user_manager`
VALUES (22, 22, 4);
INSERT INTO `user_manager`
VALUES (23, 23, 5);
INSERT INTO `user_manager`
VALUES (24, 24, 6);
INSERT INTO `user_manager`
VALUES (25, 25, 1);
INSERT INTO `user_manager`
VALUES (26, 26, 2);
INSERT INTO `user_manager`
VALUES (27, 27, 3);
INSERT INTO `user_manager`
VALUES (28, 28, 4);
INSERT INTO `user_manager`
VALUES (29, 29, 5);

SET
FOREIGN_KEY_CHECKS = 1;
