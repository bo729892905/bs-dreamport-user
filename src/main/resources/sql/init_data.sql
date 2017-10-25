CREATE TABLE
  t_user
(
  id            INT(6) not null AUTO_INCREMENT,
  username      VARCHAR(32) NOT NULL
  COMMENT '用户名',
  password      VARCHAR(32) NOT NULL
  COMMENT '密码',
  real_name     VARCHAR(32) COMMENT '真实姓名',
  gender        INT(1) COMMENT '性别',
  mobile_phone  VARCHAR(20) COMMENT '手机号',
  email         VARCHAR(64) COMMENT '邮箱',
  salt          VARCHAR(16) COMMENT '盐',
  locked        TINYINT(1) DEFAULT 0
  COMMENT '是否锁定',
  create_date DATETIME COMMENT '注册时间',
  state        TINYINT(1) DEFAULT 1
  COMMENT '删除状态',
  PRIMARY KEY (id),
  CONSTRAINT username_UNIQUE UNIQUE (username)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;