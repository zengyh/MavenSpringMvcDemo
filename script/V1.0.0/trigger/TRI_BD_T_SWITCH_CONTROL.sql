CREATE OR REPLACE TRIGGER TRI_BD_T_SWITCH_CONTROL
   BEFORE DELETE ON T_SWITCH_CONTROL
   REFERENCING OLD AS OLD
   FOR EACH ROW
DECLARE
  CURSOR c_switch(c_switch t_tr_switch.switch_for%TYPE) IS
    SELECT status
      FROM t_tr_switch
     WHERE trigger_name = 'TRI_BD_T_SWITCH_CONTROL'
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
       :old.id,
       'SWITCH_NAME',
       :old.SWITCH_NAME,
       'DELETE',
       v_trigger_user,
       v_trigger_date);
  
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
       :old.id,
       'DESCRIPTION',
       :old.DESCRIPTION,
       'DELETE',
       v_trigger_user,
       v_trigger_date);
  
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
       :old.id,
       'VALID_DATE',
       to_char(:old.VALID_DATE, 'yyyy-mm-dd hh24:mi:ss'),
       'DELETE',
       v_trigger_user,
       v_trigger_date);
  
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
       :old.id,
       'IS_VALID',
       :old.is_valid,
       'DELETE',
       v_trigger_user,
       v_trigger_date);
  
  END IF;
  CLOSE c_switch;
EXCEPTION
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
       'TRI_BD_T_SWITCH_CONTROL',
       v_trigger_user,
       v_trigger_date,
       v_error_comment);
  
END TRI_BD_T_SWITCH_CONTROL;
/
