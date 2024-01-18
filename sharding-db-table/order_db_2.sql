create database if not exists order_db_2 default charset utf8mb4 ;

use order_db_2;

DROP TABLE IF EXISTS `t_order_1`;
CREATE TABLE `t_order_1` (
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `price` decimal(10,2) NOT NULL COMMENT '订单价格',
  `user_id` bigint(20) NOT NULL COMMENT '下单用户id',
  `status` varchar(50) NOT NULL COMMENT '订单状态',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

INSERT INTO `t_order_1` VALUES ('491708667008122880', '10.00', '1', 'WAIT_PAY|1');
INSERT INTO `t_order_1` VALUES ('491708667448524800', '20.00', '1', 'WAIT_PAY|3');
INSERT INTO `t_order_1` VALUES ('491708667901509632', '30.00', '1', 'WAIT_PAY|5');
INSERT INTO `t_order_1` VALUES ('491708668362883072', '40.00', '1', 'WAIT_PAY|7');
INSERT INTO `t_order_1` VALUES ('491708668799090688', '50.00', '1', 'WAIT_PAY|9');

DROP TABLE IF EXISTS `t_order_2`;
CREATE TABLE `t_order_2` (
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `price` decimal(10,2) NOT NULL COMMENT '订单价格',
  `user_id` bigint(20) NOT NULL COMMENT '下单用户id',
  `status` varchar(50) NOT NULL COMMENT '订单状态',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

INSERT INTO `t_order_2` VALUES ('491708666341228545', '5.00', '1', 'WAIT_PAY|0');
INSERT INTO `t_order_2` VALUES ('491708667238809601', '15.00', '1', 'WAIT_PAY|2');
INSERT INTO `t_order_2` VALUES ('491708667662434305', '25.00', '1', 'WAIT_PAY|4');
INSERT INTO `t_order_2` VALUES ('491708668111224833', '35.00', '1', 'WAIT_PAY|6');
INSERT INTO `t_order_2` VALUES ('491708668568403969', '45.00', '1', 'WAIT_PAY|8');
