/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     22/07/2022 17:51:27                          */
/*==============================================================*/


/*==============================================================*/
/* Table: file                                                  */
/*==============================================================*/
create table file
(
   Fileid               int not null,
   assiId               int,
   userId               text,
   uploadTime           datetime,
   fileSize             Integer,
   rawName              String,
   formatName           String,
   hash                 String,
   primary key (Fileid)
);

/*==============================================================*/
/* Index: Index_1                                               */
/*==============================================================*/
create index Index_1 on file
(
   Fileid
);

