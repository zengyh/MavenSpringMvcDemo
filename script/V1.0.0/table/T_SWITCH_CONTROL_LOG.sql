create table T_SWITCH_CONTROL_LOG(
    SEQ_ID        VARCHAR2(20),
    SWITCH_ID     VARCHAR2(32),
    COL_NAME      VARCHAR2(100),
    COL_VALUE     VARCHAR2(500),
    TRIGGER_TYPE  VARCHAR2(20),
    TRIGGER_USER  VARCHAR2(100),
    TRIGGER_DATE  DATE
);

comment on table T_SWITCH_CONTROL_LOG is '开关变更记录表';
comment on column T_SWITCH_CONTROL_LOG.SEQ_ID is '主键';
comment on column T_SWITCH_CONTROL_LOG.SWITCH_ID is '关联T_SWITCH_CONTROL_LOG表的ID，但是不能做外键关联约束！';
comment on column T_SWITCH_CONTROL_LOG.COL_NAME is '变更的字段名';
comment on column T_SWITCH_CONTROL_LOG.COL_VALUE is '变更后的字段值';
comment on column T_SWITCH_CONTROL_LOG.TRIGGER_TYPE is '变更类型（INSERT 新增，UPDATE 更新，DELETE 删除）';
comment on column T_SWITCH_CONTROL_LOG.TRIGGER_USER is '操作人员';
comment on column T_SWITCH_CONTROL_LOG.TRIGGER_DATE is '操作时间';

create unique index IDX_T_SWITCH_CONTROL_LOG_ID on T_SWITCH_CONTROL_LOG(SEQ_ID) storage (initial 64k next 64k);
create index IDX_T_SWITCH_CONTROL_LOG_SWTID on T_SWITCH_CONTROL_LOG(SWITCH_ID) storage (initial 64k next 64k);
create index IDX_SWITCH_CONTROL_LOG_TRDATE on T_SWITCH_CONTROL_LOG(TRIGGER_DATE) storage (initial 64k next 64k);
alter table T_SWITCH_CONTROL_LOG add constraint PK_T_SWITCH_CONTROL_LOG primary key(SEQ_ID) using index  IDX_T_SWITCH_CONTROL_LOG_ID;
