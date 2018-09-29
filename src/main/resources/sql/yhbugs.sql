/*
Navicat MySQL Data Transfer

Source Server         : ymh_localmysql
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : yhkjbugs

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2018-09-29 18:08:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for yhbugs
-- ----------------------------
DROP TABLE IF EXISTS `yhbugs`;
CREATE TABLE `yhbugs` (
  `id` varchar(36) NOT NULL,
  `create_name` varchar(50) DEFAULT NULL COMMENT '创建人名称',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人登录名称',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_name` varchar(50) DEFAULT NULL COMMENT '更新人名称',
  `update_by` varchar(50) DEFAULT NULL COMMENT '更新人登录名称',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `sys_org_code` varchar(50) DEFAULT NULL COMMENT '所属部门',
  `sys_company_code` varchar(50) DEFAULT NULL COMMENT '所属公司',
  `bpm_status` varchar(32) DEFAULT '1' COMMENT '流程状态',
  `name` varchar(32) DEFAULT NULL COMMENT '项目',
  `error_message` longtext COMMENT '异常信息',
  `script_uri` longtext COMMENT '异常文件路径',
  `line_no` varchar(32) DEFAULT NULL COMMENT '异常行号',
  `column_no` varchar(32) DEFAULT NULL COMMENT '异常列号',
  `error` longtext COMMENT '异常堆栈信息',
  `system` longtext COMMENT '系统环境',
  `member` varchar(64) DEFAULT NULL COMMENT '操作人信息',
  `local_st` longtext COMMENT '存储的信息',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
