CREATE OR REPLACE TRIGGER TRI_BI_T_USER
   BEFORE INSERT ON T_USER
   REFERENCING NEW AS NEW OLD AS OLD
   FOR EACH ROW
DECLARE
  CURSOR c_switch(c_switch t_tr_switch.switch_for%TYPE) IS
    SELECT status
      FROM t_tr_switch
     WHERE trigger_name = 'TRI_BI_T_USER'
       AND switch_for = c_switch;

  CURSOR GEN_SEQ IS
    SELECT extract(YEAR FROM SYSDATE) ||
           lpad(nvl(max(substr(seq_id, 5)), 0) + 1, 16, '0')
      FROM t_user_log;

  v_trigger_user  VARCHAR2(100);
  v_trigger_date  DATE;
  v_status        t_tr_switch.status%TYPE;
  v_sqlcode       VARCHAR2(6);
  v_sqlerrm       VARCHAR2(200);
  v_error_comment VARCHAR2(300);
  -- 序列号
  v_seq_id t_user_log.seq_id%type;
BEGIN
  v_error_comment := 'before get_user';
  v_trigger_user  := pub_user_package.get_user;
  v_trigger_date  := SYSDATE;

  v_error_comment := 'before T_USER';
  -- 获取触发器控制开关
  OPEN c_switch('T_USER');
  FETCH c_switch
    INTO v_status;
  IF c_switch%FOUND AND v_status = '1' THEN
    :new.created_user := v_trigger_user;
    :new.created_date := v_trigger_date;
    :new.updated_user := v_trigger_user;
    :new.updated_date := v_trigger_date;
  
    OPEN gen_seq;
    fetch gen_seq
      into v_seq_id;
    CLOSE gen_seq;
  
    INSERT INTO t_user_log
      (seq_id,
       user_id,
       col_name,
       col_value,
       trigger_type,
       trigger_user,
       trigger_date)
    values
      (v_seq_id,
       :new.id,
       'USERNAME',
       :new.username,
       'INSERT',
       v_trigger_user,
       v_trigger_date);
  
    OPEN gen_seq;
    fetch gen_seq
      into v_seq_id;
    CLOSE gen_seq;
  
    INSERT INTO t_user_log
      (seq_id,
       user_id,
       col_name,
       col_value,
       trigger_type,
       trigger_user,
       trigger_date)
    values
      (v_seq_id,
       :new.id,
       'PASSWORD',
       :new.password,
       'INSERT',
       v_trigger_user,
       v_trigger_date);
  
    OPEN gen_seq;
    fetch gen_seq
      into v_seq_id;
    CLOSE gen_seq;
  
    INSERT INTO t_user_log
      (seq_id,
       user_id,
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
       'INSERT',
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
       'TRI_BI_T_USER',
       v_trigger_user,
       v_trigger_date,
       v_error_comment);
  
END TRI_BI_T_USER;
/
