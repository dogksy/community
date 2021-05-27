DROP TABLE if EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id唯一标识',
  `account_id` varchar(100) NOT NULL COMMENT '第三方授权登录id',
  `name` varchar(20) NOT NULL COMMENT '用户名（昵称）',
  `token` char(36) NOT NULL COMMENT 'token',
  `gmt_create` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '创建时间',
  `gmt_modified` varbinary(100) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;