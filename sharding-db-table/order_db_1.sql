create database if not exists order_db_1 default charset utf8mb4 ;

use order_db_1;

DROP TABLE IF EXISTS `t_order_1`;
CREATE TABLE `t_order_1` (
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `price` decimal(10,2) NOT NULL COMMENT '订单价格',
  `user_id` bigint(20) NOT NULL COMMENT '下单用户id',
  `status` varchar(50) NOT NULL COMMENT '订单状态',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

INSERT INTO `t_order_1` VALUES ('491708669222715392', '20.00', '2', 'WAIT_PAY|1');
INSERT INTO `t_order_1` VALUES ('491708669663117312', '40.00', '2', 'WAIT_PAY|3');
INSERT INTO `t_order_1` VALUES ('491708670116102144', '60.00', '2', 'WAIT_PAY|5');
INSERT INTO `t_order_1` VALUES ('491708670556504064', '80.00', '2', 'WAIT_PAY|7');
INSERT INTO `t_order_1` VALUES ('491708670980128768', '100.00', '2', 'WAIT_PAY|9');

DROP TABLE IF EXISTS `t_order_2`;
CREATE TABLE `t_order_2` (
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `price` decimal(10,2) NOT NULL COMMENT '订单价格',
  `user_id` bigint(20) NOT NULL COMMENT '下单用户id',
  `status` varchar(50) NOT NULL COMMENT '订单状态',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

INSERT INTO `t_order_2` VALUES ('491708669004611585', '10.00', '2', 'WAIT_PAY|0');
INSERT INTO `t_order_2` VALUES ('491708669436624897', '30.00', '2', 'WAIT_PAY|2');
INSERT INTO `t_order_2` VALUES ('491708669881221121', '50.00', '2', 'WAIT_PAY|4');
INSERT INTO `t_order_2` VALUES ('491708670334205953', '70.00', '2', 'WAIT_PAY|6');
INSERT INTO `t_order_2` VALUES ('491708670766219265', '90.00', '2', 'WAIT_PAY|8');
