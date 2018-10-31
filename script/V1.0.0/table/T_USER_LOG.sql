create table T_USER_LOG(
    SEQ_ID        VARCHAR2(20),
    USER_ID       NUMBER(10),
    COL_NAME      VARCHAR2(100),
    COL_VALUE     VARCHAR2(200),
    TRIGGER_TYPE  VARCHAR2(20),
    TRIGGER_USER  VARCHAR2(100),
    TRIGGER_DATE  DATE
);

comment on table T_USER_LOG is '用户变更记录表';
comment on column T_USER_LOG.SEQ_ID is '主键';
comment on column T_USER_LOG.USER_ID is '关联T_USER表的ID，但是不能做外键关联约束！';
comment on column T_USER_LOG.COL_NAME is '变更的字段名';
comment on column T_USER_LOG.COL_VALUE is '变更后的字段值';
comment on column T_USER_LOG.TRIGGER_TYPE is '变更类型（INSERT 新增，UPDATE 更新，DELETE 删除）';
comment on column T_USER_LOG.TRIGGER_USER is '操作人员';
comment on column T_USER_LOG.TRIGGER_DATE is '操作时间';

create unique index IDX_T_USER_LOG_ID on T_USER_LOG(SEQ_ID) storage (initial 64k next 64k);
create index IDX_T_USER_LOG_USERID on T_USER_LOG(USER_ID) storage (initial 64k next 64k);
create index IDX_T_USER_LOG_TRDATE on T_USER_LOG(TRIGGER_DATE) storage (initial 64k next 64k);
alter table T_USER_LOG add constraint PK_T_USER_LOG primary key(SEQ_ID) using index  IDX_T_USER_LOG_ID;

