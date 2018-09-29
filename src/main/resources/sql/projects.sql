/*
Navicat MySQL Data Transfer

Source Server         : ymh_localmysql
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : yhkjbugs

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2018-09-29 18:08:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for projects
-- ----------------------------
DROP TABLE IF EXISTS `projects`;
CREATE TABLE `projects` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `create_name` varchar(50) DEFAULT NULL COMMENT '创建人名称',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人登录名称',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_name` varchar(50) DEFAULT NULL COMMENT '更新人名称',
  `update_by` varchar(50) DEFAULT NULL COMMENT '更新人登录名称',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `sys_org_code` varchar(50) DEFAULT NULL COMMENT '所属部门',
  `sys_company_code` varchar(50) DEFAULT NULL COMMENT '所属公司',
  `bpm_status` varchar(32) DEFAULT '1' COMMENT '流程状态',
  `name` varchar(64) NOT NULL COMMENT '项目',
  `ids` varchar(64) DEFAULT NULL COMMENT 'ID',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
