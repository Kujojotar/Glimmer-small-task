package com.example.demo.dao;

import com.example.demo.bean.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("select * from user where username=#{username}")
    public User getUserByName(String username);

    @Insert("insert into user values(#{username},#{password})")
    public boolean insertUser(User user);

    @Delete("delete from user where username=#{username}")
    public boolean deleteUser(String username);

    @Update("<script>update user <set>" +
            "<if test='user.username!=null'>username=#{user.username},</if>" +
            "<if test='user.password!=null'>password=#{user.password},</if>" +
            "</set> where username=#{target} </script>")
    public int updateUser(@Param("user") User user,@Param("target") String target);
}
