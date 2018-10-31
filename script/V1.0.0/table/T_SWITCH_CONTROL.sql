create table T_SWITCH_CONTROL(
   ID             VARCHAR2(32) DEFAULT RAWTOHEX(SYS_GUID()),
   SWITCH_NAME    VARCHAR2(50) NOT NULL,
   DESCRIPTION    VARCHAR2(500),   
   VALID_DATE     DATE,
   IS_VALID       VARCHAR2(1) DEFAULT 'Y' NOT NULL,
   CREATED_USER   VARCHAR2(100),
   CREATED_DATE   DATE,
   UPDATED_USER   VARCHAR2(100),
   UPDATED_DATE   DATE
);

comment on table T_SWITCH_CONTROL is '开关表';
comment on column T_SWITCH_CONTROL.ID is 'ID';
comment on column T_SWITCH_CONTROL.SWITCH_NAME is '开关名称';
comment on column T_SWITCH_CONTROL.DESCRIPTION is '开关描述';
comment on column T_SWITCH_CONTROL.VALID_DATE is '生效日期（当天生效），如果为空，则立即生效';
comment on column T_SWITCH_CONTROL.IS_VALID is '开关是否下线';
comment on column T_SWITCH_CONTROL.CREATED_USER is '录入人';
comment on column T_SWITCH_CONTROL.CREATED_DATE is '录入日期';
comment on column T_SWITCH_CONTROL.UPDATED_USER is '修改人';
comment on column T_SWITCH_CONTROL.UPDATED_DATE is '修改日期';

create unique index IDX_T_SWITCH_CONTROL_ID on T_SWITCH_CONTROL(ID) storage  (initial 64k next 64k);
create unique index IDX_T_SWITCH_CONTROL_NAMEVALID on T_SWITCH_CONTROL(SWITCH_NAME, IS_VALID)  storage (initial 64k next 64k);
create index IDX_T_SWITCH_CONTROL_COMCOL on T_SWITCH_CONTROL(CREATED_USER, CREATED_DATE)  storage (initial 64k next 64k);
alter table T_SWITCH_CONTROL add constraint PK_T_SWITCH_CONTROL primary key(ID) using index  IDX_T_SWITCH_CONTROL_ID;
