DROP database db_ms;
CREATE database db_ms;

USE db_ms;

DROP TABLE `tb_questionnaire_content`;

CREATE TABLE `tb_questionnaire_content` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `questionnaireTemplateId` int(11) NOT NULL COMMENT '问卷模板id',
  `cementFactoryId` varchar(45) NOT NULL COMMENT '水泥厂id',
  `productionLine` varchar(45) NOT NULL COMMENT '生产线',
  `modifyTime` datetime NOT NULL COMMENT '修改时间',
  `lastModifyTime` datetime DEFAULT NULL COMMENT '上次修改时间',
  `jsonContent` varchar(4000) DEFAULT NULL COMMENT '详细内容',
  `status` int(11) NOT NULL COMMENT '状态 填写中, 已提交, 审核中, 审核通过',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


DROP TABLE `tb_questionnaire_template`;

CREATE TABLE `tb_questionnaire_template` (
  `id` int(4) NOT NULL COMMENT 'id',
  `name` varchar(60) NOT NULL COMMENT '问卷名称',
  `description` varchar(4000) DEFAULT NULL COMMENT '问卷描述',
  `modifyTime` datetime NOT NULL COMMENT '问卷最后修改时间',
  `beginTime` datetime NOT NULL COMMENT '问卷生效时间',
  `endTime` datetime NOT NULL COMMENT '问卷失效时间',
  `templateJspUrl` varchar(200) NOT NULL COMMENT 'tsp模板url',
  `status` int(4) NOT NULL COMMENT '问卷时间状态',
  `lastModifyTime` datetime DEFAULT NULL COMMENT '问卷上次修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE `tb_questionnaire_template_edit`;

CREATE TABLE `tb_questionnaire_template_edit` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(60) NOT NULL COMMENT '问卷名称',
  `description` varchar(4000) DEFAULT NULL COMMENT '问卷描述',
  `modifyTime` datetime NOT NULL COMMENT '问卷最后修改时间',
  `beginTime` datetime NOT NULL COMMENT '问卷生效时间',
  `endTime` datetime NOT NULL COMMENT '问卷失效时间',
  `templateJspUrl` varchar(200) NOT NULL COMMENT 'tsp模板url',
  `status` int(4) NOT NULL COMMENT '问卷时间状态',
  `lastModifyTime` datetime DEFAULT NULL COMMENT '问卷上次修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


