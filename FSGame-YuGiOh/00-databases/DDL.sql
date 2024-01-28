create database yu_gi_oh;

use yu_gi_oh;

create table `ygo_card_info`(
      id        BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT '主键ID'
    , code_02   VARCHAR(255) COMMENT '02进制码值' NOT NULL
    , code_10   VARCHAR(255) COMMENT '10进制码值' NOT NULL
    , code_16   VARCHAR(255) COMMENT '16进制码值' NOT NULL
    , code_32   VARCHAR(255) COMMENT '32进制码值' NOT NULL
    , classify  VARCHAR(255) COMMENT '类别' NOT NULL
    , chinese   VARCHAR(255) COMMENT '中文描述'
    , english   VARCHAR(255) COMMENT '英文描述'
    , japanese  VARCHAR(255) COMMENT '日文描述'
);