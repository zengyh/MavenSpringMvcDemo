create or replace package body pub_user_package as
  v_username varchar2(50);

  -- ��ȡ�Ự���ӵ��û���
  function get_user return varchar2 as
  begin
    if v_username is null then
      v_username := SYS_CONTEXT('USERENV', 'OS_USER');
    end if;
    return v_username;
  end get_user;

  -- ���ûỰ���ӵ��û���
  procedure set_user(username varchar2) as
  begin
    v_username := username;
  end set_user;
   
end pub_user_package;
/
