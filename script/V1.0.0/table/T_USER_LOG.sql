create table T_USER_LOG(
    SEQ_ID        VARCHAR2(20),
    USER_ID       NUMBER(10),
    COL_NAME      VARCHAR2(100),
    COL_VALUE     VARCHAR2(200),
    TRIGGER_TYPE  VARCHAR2(20),
    TRIGGER_USER  VARCHAR2(100),
    TRIGGER_DATE  DATE
);

comment on table T_USER_LOG is '�û������¼��';
comment on column T_USER_LOG.SEQ_ID is '����';
comment on column T_USER_LOG.USER_ID is '����T_USER���ID�����ǲ������������Լ����';
comment on column T_USER_LOG.COL_NAME is '������ֶ���';
comment on column T_USER_LOG.COL_VALUE is '�������ֶ�ֵ';
comment on column T_USER_LOG.TRIGGER_TYPE is '������ͣ�INSERT ������UPDATE ���£�DELETE ɾ����';
comment on column T_USER_LOG.TRIGGER_USER is '������Ա';
comment on column T_USER_LOG.TRIGGER_DATE is '����ʱ��';

create unique index IDX_T_USER_LOG_ID on T_USER_LOG(SEQ_ID) storage (initial 64k next 64k);
create index IDX_T_USER_LOG_USERID on T_USER_LOG(USER_ID) storage (initial 64k next 64k);
create index IDX_T_USER_LOG_TRDATE on T_USER_LOG(TRIGGER_DATE) storage (initial 64k next 64k);
alter table T_USER_LOG add constraint PK_T_USER_LOG primary key(SEQ_ID) using index  IDX_T_USER_LOG_ID;

