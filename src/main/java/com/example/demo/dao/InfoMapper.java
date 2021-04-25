package com.example.demo.dao;

import com.example.demo.bean.Info;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InfoMapper {

    @Select("select * from info")
    public List<Info> getInfos();

    @Select("select * from info where infoId=#{id}")
    public Info getInfoById(Integer id);

    @Insert("insert into info(title,content,starttime,username) values (#{title},#{content},now(),#{username})")
    public boolean insertInfo(Info info);

    @Update("update info set title=#{title},content=#{content},username=#{username} where infoId=#{infoId}")
    public boolean updateInfo(Info info);

    @Delete("delete from info where infoId=#{infoId}")
    public boolean deleteInfo(Integer infoId);
}
