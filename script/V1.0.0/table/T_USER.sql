CREATE TABLE T_USER (
  id          number(10)   not null,
  username    varchar2(100) not null,
  password    varchar2(100) not null,
  is_valid    varchar2(1)  default 'Y' not null,
  created_user  varchar2(100) not null,
  created_date  date not null,
  updated_user  varchar2(100) not null,
  updated_date   date not null
);

comment on table T_USER is '用户信息表';
comment on column T_USER.id is 'ID';
comment on column T_USER.username is '用户名';
comment on column T_USER.password is '密码';
comment on column T_USER.is_valid is '是否有效（Y：有效，N：无效）';
comment on column T_USER.created_user is '录入人';
comment on column T_USER.created_date is '录入日期';
comment on column T_USER.updated_user is '修改人';
comment on column T_USER.updated_date is '修改日期';

create unique index IDX_T_USER_ID on T_USER(id) storage (initial 64k next 64k);
create unique index IDX_T_USER_USERNAME on T_USER(username) storage (initial 64k next 64k);
create index IDX_T_USER_CREATEUSER on T_USER(created_user) storage (initial 64k next 64k);
create index IDX_T_USER_CREATEDATE on T_USER(created_date) storage (initial 64k next 64k);
create index IDX_T_USER_UPDATEUSER on T_USER(updated_user) storage (initial 64k next 64k);
create index IDX_T_USER_UPDATEDATE on T_USER(updated_date) storage (initial 64k next 64k);
alter table T_USER add constraint PK_T_USER primary key(id) using index  IDX_T_USER_ID;
