declare
  -- 自定义异常名称
  NO_CONFIG_EXCEPTION exception;
  v_sqlcode varchar2(20);  -- 错误码
  v_sqlerrm varchar2(300); -- 错误信息
  -- 告诉编译器将异常名 与 ORACLE 错误码结合起来
  pragma exception_init(NO_CONFIG_EXCEPTION, -20001);
begin
  raise_application_error(-20001, 'Hello Exception Message');
exception
  when NO_CONFIG_EXCEPTION then
    v_sqlcode := sqlcode;
    v_sqlerrm := sqlerrm;
    dbms_output.put_line(v_sqlcode);
    dbms_output.put_line(v_sqlerrm);
end
/
