create or replace package pub_user_package as
  -- 获取会话连接的用户名
  function get_user return varchar2;

  -- 设置会话连接的用户名
  procedure set_user(username varchar2);
end pub_user_package;
/
