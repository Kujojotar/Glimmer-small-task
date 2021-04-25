package com.example.demo.dao;

import com.example.demo.bean.TodoList;
import java.util.List;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TodoListMapper {
    @Insert("insert into todolist(title,startTime,done,username) values(#{title},now(),#{done},#{username})")
    public boolean insertTodoList(TodoList todoList);

    @Results(id="todolist",value ={
            @Result(property = "todoId",column = "todoId"),
            @Result(property = "title",column = "title"),
            @Result(property = "startTime",column = "startTime"),
            @Result(property = "done",column = "done"),
            @Result(property = "username",column = "username"),
    })
    @Select("select * from todolist where username=#{username}")
    public List<TodoList> getTodoListsByUsername(String username);

    @Update("update todoList set done=#{Done} where todoId=#{todoId}")
    public void updateTodoList(@Param("Done")Boolean done,@Param("todoId")Integer id);

    @Update("update todoList set title=#{title},")
    public void todolistUpdate(TodoList todoList);

    @ResultMap("todolist")
    @Select("select* from todolist where todoId=#{id}")
    public TodoList isTodoListDone(Integer id);

    @Delete("delete from todolist where todoId=#{todoId}")
    public boolean deleteById(Integer id);
}
