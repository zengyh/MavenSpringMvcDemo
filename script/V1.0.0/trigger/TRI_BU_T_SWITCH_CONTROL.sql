CREATE OR REPLACE TRIGGER TRI_BU_T_SWITCH_CONTROL
   BEFORE UPDATE ON T_SWITCH_CONTROL
   REFERENCING NEW AS NEW OLD AS OLD
   FOR EACH ROW
DECLARE
  CURSOR c_switch(c_switch t_tr_switch.switch_for%TYPE) IS
    SELECT status
      FROM t_tr_switch
     WHERE trigger_name = 'TRI_BU_T_SWITCH_CONTROL'
       AND switch_for = c_switch;

  CURSOR GEN_SEQ IS
    SELECT extract(YEAR FROM SYSDATE) ||
           lpad(nvl(max(substr(seq_id, 5)), 0) + 1, 16, '0')
      FROM T_SWITCH_CONTROL_LOG;

  v_trigger_user  VARCHAR2(100);
  v_trigger_date  DATE;
  v_status        t_tr_switch.status%TYPE;
  v_sqlcode       VARCHAR2(6);
  v_sqlerrm       VARCHAR2(200);
  v_error_comment VARCHAR2(300);
  -- 序列号
  v_seq_id T_SWITCH_CONTROL_LOG.seq_id%type;
  myEx1 exception;
BEGIN
  v_error_comment := 'before get_user';
  v_trigger_user  := pub_user_package.get_user;
  v_trigger_date  := SYSDATE;

  v_error_comment := 'before T_SWITCH_CONTROL';
  -- 获取触发器控制开关
  OPEN c_switch('T_SWITCH_CONTROL');
  FETCH c_switch
    INTO v_status;
  IF c_switch%FOUND AND v_status = '1' THEN
    IF UPDATING('ID') then
      RAISE myEx1;
    END IF;
    :new.updated_user := v_trigger_user;
    :new.updated_date := v_trigger_date;
  
    if :new.SWITCH_NAME <> :old.SWITCH_NAME then
      OPEN gen_seq;
      fetch gen_seq
        into v_seq_id;
      CLOSE gen_seq;
      INSERT INTO T_SWITCH_CONTROL_LOG
        (seq_id,
         switch_id,
         col_name,
         col_value,
         trigger_type,
         trigger_user,
         trigger_date)
      values
        (v_seq_id,
         :new.id,
         'SWITCH_NAME',
         :new.SWITCH_NAME,
         'UPDATE',
         v_trigger_user,
         v_trigger_date);
    end if;
  
    if :new.DESCRIPTION is not null and :old.DESCRIPTION is null then
      OPEN gen_seq;
      fetch gen_seq
        into v_seq_id;
      CLOSE gen_seq;
      INSERT INTO T_SWITCH_CONTROL_LOG
        (seq_id,
         switch_id,
         col_name,
         col_value,
         trigger_type,
         trigger_user,
         trigger_date)
      values
        (v_seq_id,
         :new.id,
         'DESCRIPTION',
         :new.DESCRIPTION,
         'UPDATE',
         v_trigger_user,
         v_trigger_date);
    elsif :new.DESCRIPTION is null and :old.DESCRIPTION is not null then
      OPEN gen_seq;
      fetch gen_seq
        into v_seq_id;
      CLOSE gen_seq;
      INSERT INTO T_SWITCH_CONTROL_LOG
        (seq_id,
         switch_id,
         col_name,
         col_value,
         trigger_type,
         trigger_user,
         trigger_date)
      values
        (v_seq_id,
         :new.id,
         'DESCRIPTION',
         :new.DESCRIPTION,
         'UPDATE',
         v_trigger_user,
         v_trigger_date);
    elsif :new.DESCRIPTION <> :old.DESCRIPTION then
      OPEN gen_seq;
      fetch gen_seq
        into v_seq_id;
      CLOSE gen_seq;
      INSERT INTO T_SWITCH_CONTROL_LOG
        (seq_id,
         switch_id,
         col_name,
         col_value,
         trigger_type,
         trigger_user,
         trigger_date)
      values
        (v_seq_id,
         :new.id,
         'DESCRIPTION',
         :new.DESCRIPTION,
         'UPDATE',
         v_trigger_user,
         v_trigger_date);
    end if;
  
    if :new.VALID_DATE is not null and :old.VALID_DATE is null then
      OPEN gen_seq;
      fetch gen_seq
        into v_seq_id;
      CLOSE gen_seq;
      INSERT INTO T_SWITCH_CONTROL_LOG
        (seq_id,
         switch_id,
         col_name,
         col_value,
         trigger_type,
         trigger_user,
         trigger_date)
      values
        (v_seq_id,
         :new.id,
         'VALID_DATE',
         to_char(:new.VALID_DATE, 'yyyy-mm-dd hh24:mi:ss'),
         'UPDATE',
         v_trigger_user,
         v_trigger_date);
    elsif :new.VALID_DATE is null and :old.VALID_DATE is not null then
      OPEN gen_seq;
      fetch gen_seq
        into v_seq_id;
      CLOSE gen_seq;
      INSERT INTO T_SWITCH_CONTROL_LOG
        (seq_id,
         switch_id,
         col_name,
         col_value,
         trigger_type,
         trigger_user,
         trigger_date)
      values
        (v_seq_id,
         :new.id,
         'VALID_DATE',
         to_char(:new.VALID_DATE, 'yyyy-mm-dd hh24:mi:ss'),
         'UPDATE',
         v_trigger_user,
         v_trigger_date);
    elsif :new.VALID_DATE <> :old.VALID_DATE then
      OPEN gen_seq;
      fetch gen_seq
        into v_seq_id;
      CLOSE gen_seq;
      INSERT INTO T_SWITCH_CONTROL_LOG
        (seq_id,
         switch_id,
         col_name,
         col_value,
         trigger_type,
         trigger_user,
         trigger_date)
      values
        (v_seq_id,
         :new.id,
         'VALID_DATE',
         to_char(:new.VALID_DATE, 'yyyy-mm-dd hh24:mi:ss'),
         'UPDATE',
         v_trigger_user,
         v_trigger_date);
    end if;
  
    if :new.is_valid <> :old.is_valid then
      OPEN gen_seq;
      fetch gen_seq
        into v_seq_id;
      CLOSE gen_seq;
      INSERT INTO T_SWITCH_CONTROL_LOG
        (seq_id,
         switch_id,
         col_name,
         col_value,
         trigger_type,
         trigger_user,
         trigger_date)
      values
        (v_seq_id,
         :new.id,
         'IS_VALID',
         :new.is_valid,
         'UPDATE',
         v_trigger_user,
         v_trigger_date);
    end if;
  
  END IF;
  CLOSE c_switch;
  
EXCEPTION
  WHEN myEx1 THEN
    raise_application_error(-2000, '不能更新T_SWITCH_CONTROL.ID字段');
  WHEN OTHERS THEN
    v_sqlcode := SQLCODE;
    v_sqlerrm := substr(SQLERRM, 1, 200);
    INSERT INTO t_tr_error_log
      (error_no,
       error_message,
       trigger_name,
       trigger_user,
       trigger_date,
       error_comment)
    VALUES
      (v_sqlcode,
       v_sqlerrm,
       'TRI_BU_T_SWITCH_CONTROL',
       v_trigger_user,
       v_trigger_date,
       v_error_comment);
  
END TRI_BU_T_SWITCH_CONTROL;
/
