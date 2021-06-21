DROP TABLE if EXISTS `question`;
CREATE TABLE `question` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL COMMENT '问题名称',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '问题描述',
  `create_time` datetime NOT NULL COMMENT '发布时间',
  `modified_time` datetime DEFAULT NULL COMMENT '修改时间',
  `creator` int DEFAULT NULL COMMENT '创建人id',
  `comment_count` int DEFAULT '0' COMMENT '已评论总数',
  `view_count` int DEFAULT '0' COMMENT '已阅读总数',
  `like_count` int DEFAULT '0' COMMENT '已点赞总数',
  `tag` varchar(255) DEFAULT NULL COMMENT '标签名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;