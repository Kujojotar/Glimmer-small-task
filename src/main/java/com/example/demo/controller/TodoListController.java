package com.example.demo.controller;

import com.example.demo.bean.ResponseList;
import com.example.demo.bean.ResponseObject;
import com.example.demo.bean.TodoList;
import com.example.demo.service.TodoListServiceImpl;
import java.util.List;

import com.example.demo.util.JsonTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoListController {
    @Autowired
    TodoListServiceImpl service;

    @PostMapping("/todolist")
    @CrossOrigin
    @ResponseBody
    public Object insertTodoList(@Validated TodoList todoList){
        todoList.setDone(false);
        ResponseObject response=new ResponseObject();
        if(service.insertTodoList(todoList)){
            response.setData("插入成功");
            response.setMsg("Success");
            response.setCode(400);
            response.setSuccess(true);
        }else{
            response.setData(null);
            response.setMsg("Fail");
            response.setCode(200);
            response.setSuccess(false);
        }
        return response;
    }

    @GetMapping("/todolist")
    @CrossOrigin
    @ResponseBody
    public Object getTodoLists(String username){
        System.out.println(username);
        if(username==null){
            ResponseObject response=new ResponseObject();
            response.setCode(400);
            response.setSuccess(false);
            response.setMsg("需要");
            response.setData(null);
            return response;
        }
        List<TodoList> list=service.getListsByUserName(username);
        ResponseList responseList=new ResponseList();
        responseList.setSuccess(true);
        responseList.setCode(200);
        responseList.setMsg("success");
        responseList.setData(list);
        return responseList;
    }

    @PutMapping("/todolist/{id}")
    @CrossOrigin
    @ResponseBody
    public Object updateStatus(@PathVariable("id") Integer id,TodoList todolist){
        ResponseObject response=new ResponseObject();
        if(todolist.getTitle()!=null){
            System.out.println(todolist);
             service.todolistUpdate(todolist);
            response.setCode(200);
            response.setSuccess(true);
            response.setMsg("success");
            response.setData("任务完成");
            return response;
        }else{
        if(!service.isListPresent(id)){
            response.setCode(400);
            response.setSuccess(false);
            response.setMsg("todoList目标不存在");
            response.setData(null);
            return response;
        }
        if(service.isListTodo(id)){
            response.setCode(400);
            response.setSuccess(false);
            response.setMsg("请勿重复操作");
            response.setData(null);
            return response;
        }
        service.updateTodoList(id);
        response.setCode(200);
        response.setSuccess(true);
        response.setMsg("success");
        response.setData("任务完成");
        return response;
        }
    }


    @DeleteMapping("/todolist/{id}")
    @ResponseBody
    @CrossOrigin
    public Object deleteTodoList(@PathVariable("id") Integer id){
        ResponseObject response=new ResponseObject();
        if(!service.isListPresent(id)){
            response.setCode(400);
            response.setSuccess(false);
            response.setMsg("该list已被删除");
            response.setData(null);
            return JsonTransfer.ObjectToJason(response);
        }
        if(service.deleteTodoList(id)){
            response.setCode(200);
            response.setSuccess(true);
            response.setMsg("success");
            response.setData("删除成功");
        }else{
            response.setCode(400);
            response.setSuccess(false);
            response.setMsg("删除过程出了些问题");
            response.setData(null);
        }
        return JsonTransfer.ObjectToJason(response);
    }

}
