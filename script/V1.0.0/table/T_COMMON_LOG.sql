create table T_COMMON_LOG(
    ID            VARCHAR2(32) DEFAULT SYS_GUID() PRIMARY KEY,
    FK_ID         VARCHAR2(32),
    TABLE_NAME    VARCHAR2(100),  
    COL_NAME      VARCHAR2(100),
    COL_VALUE     VARCHAR2(500),
    TRIGGER_TYPE  VARCHAR2(20),
    TRIGGER_USER  VARCHAR2(100),
    TRIGGER_DATE  DATE
);

comment on table T_COMMON_LOG is '日志记录表';
comment on column T_COMMON_LOG.ID is '主键';
comment on column T_COMMON_LOG.FK_ID is '操作的表的ID';
comment on column T_COMMON_LOG.TABLE_NAME is '操作的表的名字';
comment on column T_COMMON_LOG.COL_NAME is '变更的字段名';
comment on column T_COMMON_LOG.COL_VALUE is '变更后的字段值';
comment on column T_COMMON_LOG.TRIGGER_TYPE is '变更类型（INSERT 新增，UPDATE 更新，DELETE 删除）';
comment on column T_COMMON_LOG.TRIGGER_USER is '操作人员';
comment on column T_COMMON_LOG.TRIGGER_DATE is '操作时间';

create index IDX_T_COMMON_LOG_COMCOL on T_COMMON_LOG(TABLE_NAME,FK_ID);
create index IDX_T_COMMON_LOG_TRDATE on T_COMMON_LOG(TRIGGER_DATE);