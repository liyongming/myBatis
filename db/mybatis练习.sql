/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2017/11/12 15:41:29                          */
/*==============================================================*/

/*==============================================================*/
/* Table: tb_article                                            */
/*==============================================================*/
create table tb_article 
(
   article_id           INT                  not null,
   name                 VARCHAR2(18),
   price                INT,
   remark               VARCHAR2(18),
   constraint PK_TB_ARTICLE primary key (article_id)
);

/*==============================================================*/
/* Table: tb_item                                               */
/*==============================================================*/
create table tb_item 
(
   item_id              int                  not null,
   id                   int,
   article_id           INT,
   constraint PK_TB_ITEM primary key (item_id)
);

/*==============================================================*/
/* Table: tb_order                                              */
/*==============================================================*/
create table tb_order 
(
   id                   int                  not null,
   user_id              INT,
   code                 VARCHAR2(18),
   total                INT,
   constraint PK_TB_ORDER primary key (id)
);

/*==============================================================*/
/* Table: tb_user                                               */
/*==============================================================*/
create table tb_user 
(
   user_id              INT                  not null,
   username             VARCHAR2(18),
   loginname            VARCHAR2(18),
   password             VARCHAR2(18),
   phone                VARCHAR2(18),
   address              VARCHAR2(18),
   constraint PK_TB_USER primary key (user_id)
);

alter table tb_item
   add constraint FK_TB_ITEM_REFERENCE_TB_ORDER foreign key (id)
      references tb_order (id);

alter table tb_item
   add constraint FK_TB_ITEM_REFERENCE_TB_ARTIC foreign key (article_id)
      references tb_article (article_id);

alter table tb_order
   add constraint FK_TB_ORDER_REFERENCE_TB_USER foreign key (user_id)
      references tb_user (user_id);

