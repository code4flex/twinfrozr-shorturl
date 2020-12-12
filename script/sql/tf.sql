
DROP TABLE IF EXISTS `link_short_url`;
CREATE TABLE `link_short_url` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `l_url` varchar(4000) DEFAULT NULL COMMENT '长链',
  `s_url` varchar(6) DEFAULT NULL COMMENT '短链码',
  `create_time` int(11) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `s_url` (`s_url`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `log_record`;
CREATE TABLE `log_record` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ip` varchar(50) DEFAULT '' COMMENT 'IP地址',
  `location` varchar(255) DEFAULT '' COMMENT '请求地点',
  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) DEFAULT '' COMMENT '操作系统',
  `url` varchar(4000) DEFAULT NULL COMMENT '请求URL',
  `s_url` varchar(6) DEFAULT NULL COMMENT '短链码',
  `create_time` int(11) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `s_url` (`s_url`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8mb4 COMMENT='短链访问记录';