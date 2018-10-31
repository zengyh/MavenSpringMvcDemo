declare
  -- �Զ����쳣����
  NO_CONFIG_EXCEPTION exception;
  v_sqlcode varchar2(20);  -- ������
  v_sqlerrm varchar2(300); -- ������Ϣ
  -- ���߱��������쳣�� �� ORACLE ������������
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
