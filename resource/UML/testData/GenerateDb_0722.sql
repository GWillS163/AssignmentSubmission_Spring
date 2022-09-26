/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     22/07/2022 17:51:27                          */
/*==============================================================*/


drop index Index_1 on assignment;

drop table if exists assignment;

drop index Index_1 on clazz;

drop table if exists clazz;

drop index Index_1 on curriculum;

drop table if exists curriculum;

drop index Index_1 on file;

drop table if exists file;

drop index Index_1 on user;

drop table if exists user;

mysql> source <file_name>;

mysql> source <file_name>;

mysql> source <file_name>;

mysql> source <file_name>;

mysql> source <file_name>;

mysql> source <file_name>;

alter table assignment add constraint FK_Reference_4 foreign key (userId)
      references user (userId) on delete restrict on update restrict;

alter table assignment add constraint FK_Reference_8 foreign key (curriId)
      references curriculum (curriId) on delete restrict on update restrict;

alter table curriculum add constraint FK_Reference_5 foreign key (userId)
      references user (userId) on delete restrict on update restrict;

alter table curriculum add constraint FK_Reference_9 foreign key (clazzId)
      references clazz (clazzId) on delete restrict on update restrict;

alter table file add constraint FK_Reference_3 foreign key (assiId)
      references assignment (assiId) on delete restrict on update restrict;

alter table file add constraint FK_Reference_6 foreign key (userId)
      references user (userId) on delete restrict on update restrict;

alter table user add constraint FK_Reference_7 foreign key (clazzId)
      references clazz (clazzId) on delete restrict on update restrict;

