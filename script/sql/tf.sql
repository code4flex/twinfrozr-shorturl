-- ----------------------------
-- Table structure for link_short_url
-- ----------------------------
DROP TABLE IF EXISTS `link_short_url`;
CREATE TABLE `link_short_url` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `l_url` varchar(4000) DEFAULT NULL COMMENT '长链',
  `s_url` varchar(6) DEFAULT NULL COMMENT '短链码',
  `create_time` int(11) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `s_url` (`s_url`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;