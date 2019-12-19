/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1-3306
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : 127.0.0.1:3306
 Source Schema         : pmdb

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 19/12/2019 10:56:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pm_department_d
-- ----------------------------
DROP TABLE IF EXISTS `pm_department_d`;
CREATE TABLE `pm_department_d` (
  `DepartmentID` varchar(20) NOT NULL,
  `DepartmentName` varchar(200) NOT NULL,
  PRIMARY KEY (`DepartmentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of pm_department_d
-- ----------------------------
BEGIN;
INSERT INTO `pm_department_d` VALUES ('ceshi', '测试');
INSERT INTO `pm_department_d` VALUES ('hhglrjyfb', '河湖管理软件研发部');
INSERT INTO `pm_department_d` VALUES ('jcyfb', '基础平台研发部');
INSERT INTO `pm_department_d` VALUES ('skxyjy', '水科学研究院33');
INSERT INTO `pm_department_d` VALUES ('swdsjptyfb', '水文大数据平台研发部');
INSERT INTO `pm_department_d` VALUES ('tbb', '投标部');
INSERT INTO `pm_department_d` VALUES ('wlwcpyfb', '物联网产品研发部');
INSERT INTO `pm_department_d` VALUES ('xmyfb', '项目研发部');
INSERT INTO `pm_department_d` VALUES ('ycptrjyfb', '遥测平台软件研发部');
INSERT INTO `pm_department_d` VALUES ('ydhlcpb', '移动互联产品部');
INSERT INTO `pm_department_d` VALUES ('yhtyb', '用户体验部');
INSERT INTO `pm_department_d` VALUES ('yjyfb', '物联网研发部');
INSERT INTO `pm_department_d` VALUES ('ywz', '应用服务研发部');
INSERT INTO `pm_department_d` VALUES ('ywzxb', '业务咨询部');
INSERT INTO `pm_department_d` VALUES ('yxzx', '营销中心');
INSERT INTO `pm_department_d` VALUES ('zhywyfb', '运维平台软件研发部');
INSERT INTO `pm_department_d` VALUES ('zlfzzx', '售前部');
INSERT INTO `pm_department_d` VALUES ('zlfzzzx', '战略发展中心');
INSERT INTO `pm_department_d` VALUES ('解决方案部', '解决方案部');
COMMIT;

-- ----------------------------
-- View structure for v_people
-- ----------------------------
DROP VIEW IF EXISTS `v_people`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_people` AS select `pm_people_d`.`ID` AS `ID`,`pm_people_d`.`Name` AS `NAME` from `pm_people_d`;

SET FOREIGN_KEY_CHECKS = 1;
