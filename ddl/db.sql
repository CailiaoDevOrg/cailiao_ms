DROP database db_ms;
CREATE database db_ms;

USE db_ms;

DROP TABLE `ms_tb_questionnaire`;
CREATE TABLE `ms_tb_questionnaire` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(60) NOT NULL COMMENT '问卷名称',
  `description` varchar(4000) DEFAULT NULL COMMENT '问卷描述',
  `createPerson` varchar(40) NOT NULL COMMENT '问卷创建人',
  `createTime` datetime NOT NULL COMMENT '问卷创建时间',
  `modifyTime` datetime DEFAULT NULL COMMENT '问卷最后修改时间',
  `beginTime` datetime NOT NULL COMMENT '问卷生效时间',
  `endTime` datetime NOT NULL COMMENT '问卷失效时间',
  `templateJspUrl` varchar(200) NOT NULL COMMENT 'tsp模板url',
  `status4Time` int(4) NOT NULL COMMENT '问卷时间状态',
  `status4Op` int(4) NOT NULL COMMENT '问卷操作状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;