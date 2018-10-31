create table T_SWITCH_CONTROL_LOG(
    SEQ_ID        VARCHAR2(20),
    SWITCH_ID     VARCHAR2(32),
    COL_NAME      VARCHAR2(100),
    COL_VALUE     VARCHAR2(500),
    TRIGGER_TYPE  VARCHAR2(20),
    TRIGGER_USER  VARCHAR2(100),
    TRIGGER_DATE  DATE
);

comment on table T_SWITCH_CONTROL_LOG is '���ر����¼��';
comment on column T_SWITCH_CONTROL_LOG.SEQ_ID is '����';
comment on column T_SWITCH_CONTROL_LOG.SWITCH_ID is '����T_SWITCH_CONTROL_LOG���ID�����ǲ������������Լ����';
comment on column T_SWITCH_CONTROL_LOG.COL_NAME is '������ֶ���';
comment on column T_SWITCH_CONTROL_LOG.COL_VALUE is '�������ֶ�ֵ';
comment on column T_SWITCH_CONTROL_LOG.TRIGGER_TYPE is '������ͣ�INSERT ������UPDATE ���£�DELETE ɾ����';
comment on column T_SWITCH_CONTROL_LOG.TRIGGER_USER is '������Ա';
comment on column T_SWITCH_CONTROL_LOG.TRIGGER_DATE is '����ʱ��';

create unique index IDX_T_SWITCH_CONTROL_LOG_ID on T_SWITCH_CONTROL_LOG(SEQ_ID) storage (initial 64k next 64k);
create index IDX_T_SWITCH_CONTROL_LOG_SWTID on T_SWITCH_CONTROL_LOG(SWITCH_ID) storage (initial 64k next 64k);
create index IDX_SWITCH_CONTROL_LOG_TRDATE on T_SWITCH_CONTROL_LOG(TRIGGER_DATE) storage (initial 64k next 64k);
alter table T_SWITCH_CONTROL_LOG add constraint PK_T_SWITCH_CONTROL_LOG primary key(SEQ_ID) using index  IDX_T_SWITCH_CONTROL_LOG_ID;
