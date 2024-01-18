create database if not exists user_db default charset utf8mb4 ;

use user_db;

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `fullname` varchar(255) NOT NULL COMMENT '用户姓名',
  `user_type` char(1) DEFAULT NULL COMMENT '用户类型',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

INSERT INTO `t_user` VALUES ('491758272697597953', '??0', '0');
INSERT INTO `t_user` VALUES ('491758273087668224', '??1', 'a');
INSERT INTO `t_user` VALUES ('491758273284800513', '??2', 'b');
INSERT INTO `t_user` VALUES ('491758273511292928', '??3', '3');
INSERT INTO `t_user` VALUES ('491758273721008129', '??4', '4');
INSERT INTO `t_user` VALUES ('491758273926529024', '??5', '5');
INSERT INTO `t_user` VALUES ('491758274144632833', '??6', '6');
INSERT INTO `t_user` VALUES ('491758274350153728', '??7', '7');
INSERT INTO `t_user` VALUES ('491758274543091713', '??8', '8');
INSERT INTO `t_user` VALUES ('491758274736029696', '??9', '9');
INSERT INTO `t_user` VALUES ('491956648743534593', '张三10', '');
INSERT INTO `t_user` VALUES ('491956648970027008', '张三11', '');
INSERT INTO `t_user` VALUES ('491956648995192833', '张三12', '');
INSERT INTO `t_user` VALUES ('491956649020358656', '张三13', '');
