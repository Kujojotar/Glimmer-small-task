package com.example.demo.service;

import com.example.demo.bean.TodoList;
import com.example.demo.dao.TodoListMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoListServiceImpl {
    @Autowired
    TodoListMapper mapper;

    TodoList list;

    public boolean insertTodoList(TodoList todoList){
        return mapper.insertTodoList(todoList);
    }

    public boolean isListPresent(Integer id){
        list=mapper.isTodoListDone(id);
        return list!=null;
    }

    public boolean isListTodo(Integer id){
        if(list.getTodoId()!=id) {
            list = mapper.isTodoListDone(id);
        }
        if(list.getDone()){
            return true;
        }
        return false;
    }

    public void updateTodoList(Integer id){
        mapper.updateTodoList(true,id);
    }

    public void todolistUpdate(TodoList todoList){
        mapper.todolistUpdate(todoList);
    }

    public List<TodoList> getListsByUserName(String username){
        return mapper.getTodoListsByUsername(username);
    }

    public boolean deleteTodoList(Integer id){
        return mapper.deleteById(id);
    }
}
