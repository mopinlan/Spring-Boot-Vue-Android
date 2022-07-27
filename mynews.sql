/*
Navicat MySQL Data Transfer

Source Server         : 47.116.21.234_3306
Source Server Version : 50736
Source Host           : 47.116.21.234:3306
Source Database       : mynews

Target Server Type    : MYSQL
Target Server Version : 50736
File Encoding         : 65001

Date: 2022-04-27 22:22:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_category`
-- ----------------------------
DROP TABLE IF EXISTS `sys_category`;
CREATE TABLE `sys_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of sys_category
-- ----------------------------
INSERT INTO `sys_category` VALUES ('1', '生活', '关于生活');
INSERT INTO `sys_category` VALUES ('2', '学习', '关于学习');
INSERT INTO `sys_category` VALUES ('3', '娱乐', '关于娱乐');
INSERT INTO `sys_category` VALUES ('4', '体育', '关于体育');

-- ----------------------------
-- Table structure for `sys_comment`
-- ----------------------------
DROP TABLE IF EXISTS `sys_comment`;
CREATE TABLE `sys_comment` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `content` text CHARACTER SET utf8mb4 COMMENT '内容',
  `userid` int(11) DEFAULT NULL COMMENT '评论人',
  `pid` bigint(20) DEFAULT NULL COMMENT '父ID',
  `newsid` int(11) DEFAULT NULL COMMENT '关联id',
  `originid` int(11) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `foreign_id` (`newsid`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='留言表';

-- ----------------------------
-- Records of sys_comment
-- ----------------------------
INSERT INTO `sys_comment` VALUES ('29', '123', '1', null, '1', null, '2022-03-30 02:26:12');
INSERT INTO `sys_comment` VALUES ('31', '123', '1', '30', '1', '29', '2022-04-09 02:42:05');
INSERT INTO `sys_comment` VALUES ('32', '娱乐新闻评论test1', '452', null, '37', null, '2022-04-22 02:53:22');
INSERT INTO `sys_comment` VALUES ('33', '生活提示评论1', '452', null, '38', null, '2022-04-26 08:27:28');

-- ----------------------------
-- Table structure for `sys_dict`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `value` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '内容',
  `type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '内容'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('user', 'el-icon-user', 'icon');
INSERT INTO `sys_dict` VALUES ('house', 'el-icon-house', 'icon');
INSERT INTO `sys_dict` VALUES ('menu', 'el-icon-menu', 'icon');
INSERT INTO `sys_dict` VALUES ('s-custom', 'el-icon-s-custom', 'icon');
INSERT INTO `sys_dict` VALUES ('s-grid', 'el-icon-s-grid', 'icon');
INSERT INTO `sys_dict` VALUES ('document', 'el-icon-document', 'icon');
INSERT INTO `sys_dict` VALUES ('comment', 'el-icon-s-comment', 'icon');
INSERT INTO `sys_dict` VALUES ('news', 'el-icon-news', 'icon');
INSERT INTO `sys_dict` VALUES ('tools', 'el-icon-s-tools', 'icon');
INSERT INTO `sys_dict` VALUES ('more', 'el-icon-more', 'icon');

-- ----------------------------
-- Table structure for `sys_file`
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '文件名称',
  `type` varchar(255) DEFAULT NULL COMMENT '文件类型',
  `size` bigint(20) DEFAULT NULL COMMENT '文件大小',
  `url` varchar(255) DEFAULT NULL COMMENT '下载链接',
  `is_delete` tinyint(1) DEFAULT NULL COMMENT '是否删除',
  `enable` tinyint(1) DEFAULT NULL COMMENT '是否禁止',
  `md5` varchar(255) DEFAULT NULL COMMENT '文件md5',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_file
-- ----------------------------
INSERT INTO `sys_file` VALUES ('85', 'tip2.jpeg', 'jpeg', '12', 'http://47.116.21.234:9091/file/7d52d74ce9454f33af498209694d017d.jpeg', null, null, 'fcfac34089ce3ad1677d8bcc4d232d1b');
INSERT INTO `sys_file` VALUES ('86', 'tip2.jpeg', 'jpeg', '12', 'http://47.116.21.234:9091/file/7d52d74ce9454f33af498209694d017d.jpeg', null, null, 'fcfac34089ce3ad1677d8bcc4d232d1b');
INSERT INTO `sys_file` VALUES ('87', 'bitbug_favicon.ico', 'ico', '4', 'http://47.116.21.234:9091/file/7e2a4bb379bc4798bbc3930f619045e7.ico', null, null, '79add38c9d9ca12eaaa34f3ce5f18c3f');
INSERT INTO `sys_file` VALUES ('88', 'bitbug_favicon.ico', 'ico', '4', 'http://47.116.21.234:9091/file/7e2a4bb379bc4798bbc3930f619045e7.ico', null, null, '79add38c9d9ca12eaaa34f3ce5f18c3f');
INSERT INTO `sys_file` VALUES ('89', 'tip3.jpeg', 'jpeg', '25', 'http://47.116.21.234:9091/file/cdd1073c6f4549d4b9b640741550106d.jpeg', null, null, 'f63c810a05b9b249700b4c464bb8900e');
INSERT INTO `sys_file` VALUES ('90', 'tip2.jpeg', 'jpeg', '12', 'http://47.116.21.234:9091/file/7d52d74ce9454f33af498209694d017d.jpeg', null, null, 'fcfac34089ce3ad1677d8bcc4d232d1b');
INSERT INTO `sys_file` VALUES ('91', 'tip.jpeg', 'jpeg', '10', 'http://47.116.21.234:9091/file/75c7f395371548e3aa9a68a46f3de7cb.jpeg', null, null, '3c46c16f02f2010fe5a12fecde33c4e4');
INSERT INTO `sys_file` VALUES ('92', 'tip3.jpeg', 'jpeg', '25', 'http://47.116.21.234:9091/file/cdd1073c6f4549d4b9b640741550106d.jpeg', null, null, 'f63c810a05b9b249700b4c464bb8900e');
INSERT INTO `sys_file` VALUES ('93', 'tip2.jpeg', 'jpeg', '12', 'http://47.116.21.234:9091/file/7d52d74ce9454f33af498209694d017d.jpeg', null, null, 'fcfac34089ce3ad1677d8bcc4d232d1b');
INSERT INTO `sys_file` VALUES ('94', 'tip.jpeg', 'jpeg', '10', 'http://47.116.21.234:9091/file/75c7f395371548e3aa9a68a46f3de7cb.jpeg', null, null, '3c46c16f02f2010fe5a12fecde33c4e4');
INSERT INTO `sys_file` VALUES ('95', 'tip.jpeg', 'jpeg', '10', 'http://47.116.21.234:9091/file/75c7f395371548e3aa9a68a46f3de7cb.jpeg', null, null, '3c46c16f02f2010fe5a12fecde33c4e4');
INSERT INTO `sys_file` VALUES ('96', 'tip.jpeg', 'jpeg', '10', 'http://47.116.21.234:9091/file/75c7f395371548e3aa9a68a46f3de7cb.jpeg', null, null, '3c46c16f02f2010fe5a12fecde33c4e4');

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `path` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '路径',
  `icon` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图标',
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '描述',
  `pid` int(11) DEFAULT NULL COMMENT '父级id',
  `page_path` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '页面路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '主页', '/home', 'el-icon-house', '主页', null, 'Home');
INSERT INTO `sys_menu` VALUES ('2', '系统管理', null, 'el-icon-menu', '系统管理', null, null);
INSERT INTO `sys_menu` VALUES ('3', '权限管理', null, 'el-icon-setting', '权限管理', null, null);
INSERT INTO `sys_menu` VALUES ('5', '新闻管理', '/news', 'el-icon-news', '新闻管理', '2', 'News');
INSERT INTO `sys_menu` VALUES ('7', '角色管理', '/role', 'el-icon-s-custom', '角色管理', '3', 'Role');
INSERT INTO `sys_menu` VALUES ('8', '菜单管理', '/menu', 'el-icon-s-grid', '菜单管理', '3', 'Menu');
INSERT INTO `sys_menu` VALUES ('9', '评论管理', '/comment', 'el-icon-s-comment', '评论管理', '2', 'Comment');
INSERT INTO `sys_menu` VALUES ('10', '分类管理', '/category', 'el-icon-s-grid', '新闻分类', '2', 'Category');
INSERT INTO `sys_menu` VALUES ('11', '用户管理', '/user', 'el-icon-user', '用户管理', '3', 'User');
INSERT INTO `sys_menu` VALUES ('12', '更多工具', null, 'el-icon-s-tools', null, null, null);
INSERT INTO `sys_menu` VALUES ('13', '文件管理', '/file', 'el-icon-document', '上传文件管理', '12', 'File');

-- ----------------------------
-- Table structure for `sys_news`
-- ----------------------------
DROP TABLE IF EXISTS `sys_news`;
CREATE TABLE `sys_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `content` text COLLATE utf8mb4_unicode_ci,
  `time` datetime DEFAULT NULL,
  `cid` int(11) NOT NULL,
  `coverimg` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cid` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of sys_news
-- ----------------------------
INSERT INTO `sys_news` VALUES ('37', 'Test1', '<p>生活新闻test1</p><p><img src=\"http://47.116.21.234:9091/file/7d52d74ce9454f33af498209694d017d.jpeg\" style=\"max-width:100%;\" contenteditable=\"false\"/></p>', '2022-04-22 02:52:47', '3', 'http://47.116.21.234:9091/file/7d52d74ce9454f33af498209694d017d.jpeg', '1');
INSERT INTO `sys_news` VALUES ('38', '生活提示', '<p>生活提示</p>', '2022-04-26 08:23:15', '1', 'http://47.116.21.234:9091/file/cdd1073c6f4549d4b9b640741550106d.jpeg', '1');
INSERT INTO `sys_news` VALUES ('39', '重要通知', '<p>学习新闻Test1</p>', '2022-04-26 08:23:55', '2', 'http://47.116.21.234:9091/file/7d52d74ce9454f33af498209694d017d.jpeg', '1');
INSERT INTO `sys_news` VALUES ('40', '体育新闻测试1', '<p>体育新闻测试1</p>', '2022-04-26 08:24:22', '4', 'http://47.116.21.234:9091/file/75c7f395371548e3aa9a68a46f3de7cb.jpeg', '1');
INSERT INTO `sys_news` VALUES ('41', '生活类测试2', '<p>生活类测试2</p>', '2022-04-26 08:25:00', '1', 'http://47.116.21.234:9091/file/cdd1073c6f4549d4b9b640741550106d.jpeg', '1');
INSERT INTO `sys_news` VALUES ('42', '生活类测试3', '<p>生活类测试3</p>', '2022-04-26 08:25:33', '1', 'http://47.116.21.234:9091/file/7d52d74ce9454f33af498209694d017d.jpeg', '1');
INSERT INTO `sys_news` VALUES ('43', '生活类测试4', '<p>生活类测试4</p>', '2022-04-26 08:25:55', '1', 'http://47.116.21.234:9091/file/75c7f395371548e3aa9a68a46f3de7cb.jpeg', '1');
INSERT INTO `sys_news` VALUES ('44', '生活类测试5', '<p>生活类测试5</p>', '2022-04-26 08:26:13', '1', 'http://47.116.21.234:9091/file/75c7f395371548e3aa9a68a46f3de7cb.jpeg', '1');
INSERT INTO `sys_news` VALUES ('45', '生活类测试6', '<p>生活类测试6</p>', '2022-04-26 08:26:30', '1', 'http://47.116.21.234:9091/file/75c7f395371548e3aa9a68a46f3de7cb.jpeg', '1');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `flag` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '唯一标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', '管理员', 'ROLE_ADMIN');
INSERT INTO `sys_role` VALUES ('2', '普通用户', '普通用户', 'ROLE_USER');

-- ----------------------------
-- Table structure for `sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `menu_id` int(11) NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1', '1');
INSERT INTO `sys_role_menu` VALUES ('1', '2');
INSERT INTO `sys_role_menu` VALUES ('1', '3');
INSERT INTO `sys_role_menu` VALUES ('1', '5');
INSERT INTO `sys_role_menu` VALUES ('1', '7');
INSERT INTO `sys_role_menu` VALUES ('1', '8');
INSERT INTO `sys_role_menu` VALUES ('1', '9');
INSERT INTO `sys_role_menu` VALUES ('1', '10');
INSERT INTO `sys_role_menu` VALUES ('1', '11');
INSERT INTO `sys_role_menu` VALUES ('1', '12');
INSERT INTO `sys_role_menu` VALUES ('1', '13');
INSERT INTO `sys_role_menu` VALUES ('2', '1');
INSERT INTO `sys_role_menu` VALUES ('2', '2');
INSERT INTO `sys_role_menu` VALUES ('2', '4');
INSERT INTO `sys_role_menu` VALUES ('2', '6');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `nickname` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '昵称',
  `email` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '电话',
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地址',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `avatar_Url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `role` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=453 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'admin', '管理员', 'admin@qq.com', '18360720567', '江苏南京', '2022-02-28 11:12:46', 'http://47.116.21.234:9091/file/7e2a4bb379bc4798bbc3930f619045e7.ico', 'ROLE_ADMIN');
INSERT INTO `sys_user` VALUES ('445', 'Test', null, 'myTest', '2369@qq.com', '18367629876', '江苏南京', '2021-07-01 10:25:58', null, 'ROLE_USER');
INSERT INTO `sys_user` VALUES ('446', 'admin2', 'admin2', '管理员2', 'admin@qq.com', '18360720567', '江苏南京', '2020-11-04 10:32:14', 'http://localhost:9091/file/791ceff6a6584aea98ea5e04842fc9d1.ico', 'ROLE_USER');
INSERT INTO `sys_user` VALUES ('447', 'Test2', '', 'myTest2', '2369@qq.com', '18367629876', '江苏南京', '2022-11-23 10:32:14', '', 'ROLE_USER');
INSERT INTO `sys_user` VALUES ('448', 'admin3', 'admin3', '管理员3', 'admin@qq.com', '18360720567', '江苏南京', '2022-04-07 10:57:39', '', 'ROLE_USER');
INSERT INTO `sys_user` VALUES ('451', '测试', null, '测试1111', '123@qq.com', '12345678', '江苏南京', '2022-03-10 10:04:52', null, 'ROLE_USER');
INSERT INTO `sys_user` VALUES ('452', 'zzz123', 'zzz123', 'zzz123', '123@qq.com', '18360720577', '江苏南京', '2022-03-31 10:49:12', 'http://47.116.21.234:9091/file/7e2a4bb379bc4798bbc3930f619045e7.ico', 'ROLE_USER');
