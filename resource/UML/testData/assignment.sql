/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     22/07/2022 17:51:27                          */
/*==============================================================*/


/*==============================================================*/
/* Table: assignment                                            */
/*==============================================================*/
create table assignment
(
   assiId               int not null,
   userId               text,
   curriId              int,
   brifeName            text,
   "describe"           text,
   fileNameRule         text,
   ddl                  datetime,
   permitAnymous        boolean,
   fileNameVerify       boolean,
   updatedTime          Integer,
   primary key (assiId)
);

alter table assignment comment '作业规则';

/*==============================================================*/
/* Index: Index_1                                               */
/*==============================================================*/
create unique index Index_1 on assignment
(
   assiId
);

