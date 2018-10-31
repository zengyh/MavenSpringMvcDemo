create table T_TR_ERROR_LOG(
    ERROR_NO       VARCHAR2(50),
    ERROR_MESSAGE  VARCHAR2(300),
    TRIGGER_NAME   VARCHAR2(100),
    TRIGGER_USER   VARCHAR2(100),
    TRIGGER_DATE   DATE,
    ERROR_COMMENT  VARCHAR2(500)
);

comment on table T_TR_ERROR_LOG is '������������־��';
comment on column T_TR_ERROR_LOG.ERROR_NO is 'SQLCODE';
comment on column T_TR_ERROR_LOG.ERROR_MESSAGE is 'SQLERRM';
comment on column T_TR_ERROR_LOG.TRIGGER_NAME is '����������';
comment on column T_TR_ERROR_LOG.TRIGGER_USER is '������Ա';
comment on column T_TR_ERROR_LOG.TRIGGER_DATE is '��������';
comment on column T_TR_ERROR_LOG.ERROR_COMMENT is '��������';

create index IDX_T_TR_ERROR_LOG_TRNAME on T_TR_ERROR_LOG(TRIGGER_NAME) storage (initial 64k next 64k);
create index IDX_T_TR_ERROR_LOG_TRDATE on T_TR_ERROR_LOG(TRIGGER_DATE) storage (initial 64k next 64k);
