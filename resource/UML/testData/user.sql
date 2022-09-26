/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     22/07/2022 17:51:27                          */
/*==============================================================*/


/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   userId               text not null,
   clazzId              int,
   userName             text,
   registeTime          datetime,
   lastLoginTime        datetime,
   mail                 text,
   type                 Integer,
   qq                   Integer,
   phone                String,
   primary key (userId)
);

/*==============================================================*/
/* Index: Index_1                                               */
/*==============================================================*/
create unique index Index_1 on user
(
   userId
);

