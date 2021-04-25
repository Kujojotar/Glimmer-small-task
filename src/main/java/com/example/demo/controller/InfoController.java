package com.example.demo.controller;

import java.util.List;
import com.example.demo.bean.Info;
import com.example.demo.bean.ResponseList;
import com.example.demo.bean.ResponseObject;
import com.example.demo.bean.TodoList;
import com.example.demo.service.InfoServiceImpl;
import com.example.demo.service.TodoListServiceImpl;
import com.example.demo.util.JsonTransfer;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class InfoController {
    @Autowired
    InfoServiceImpl service;
    @Autowired
    TodoListServiceImpl todoListService;

    @GetMapping("/infos")
    @ResponseBody
    @CrossOrigin
    public Object getInfos(){
        List<Info> list=service.getInfos();
        ResponseList response=new ResponseList();
        response.setCode(200);
        response.setSuccess(true);
        response.setMsg("success");
        response.setData(list);
        String e=JsonTransfer.ObjectToJason(response);
        return e;
    }



    @GetMapping("/infos/{id}")
    @ResponseBody
    @CrossOrigin
    public Object getInfo(@PathVariable("id") Integer id){
        ResponseObject response=new ResponseObject();
        Info info= service.getInfo(id);
        if(info==null){
            response.setCode(400);
            response.setSuccess(false);
            response.setMsg("不存在该记录");
            response.setData(null);
            return JsonTransfer.ObjectToJason(response);
        }
        response.setCode(200);
        response.setSuccess(true);
        response.setMsg("success");
        response.setData(info);
        return JsonTransfer.ObjectToJason(response);
    }

    @PostMapping("/infos")
    @ResponseBody
    @CrossOrigin
    public Object insertInfo(@Validated Info info){
        ResponseObject response=new ResponseObject();
        if(service.insertInfo(info)){
            response.setCode(200);
            response.setSuccess(true);
            response.setMsg("success");
            response.setData("插入成功");
        }else{
            response.setCode(400);
            response.setSuccess(false);
            response.setMsg("插入记录失败");
            response.setData(null);
        }
        return JsonTransfer.ObjectToJason(response);
    }

    @GetMapping("/info/{id}")
    @ResponseBody
    @CrossOrigin
    public String showPages(@PathVariable(value = "id")Integer id){
        PageHelper.startPage(id,2);
        ResponseObject response=new ResponseObject();
        List<Info> list= service.getInfos();
        response.setCode(200);
        response.setSuccess(true);
        response.setMsg("success");
        response.setData(list);
        String e=JsonTransfer.ObjectToJason(response);
        return e;
    }

    @PutMapping("/infos/{id}")
    @ResponseBody
    @CrossOrigin
    public Object updateInfo( Info info,@PathVariable("id") Integer id){
        ResponseObject response=new ResponseObject();
        info.setInfoId(id);
        if(service.updateInfo(info)){
            response.setCode(200);
            response.setSuccess(true);
            response.setMsg("success");
            response.setData("更改成功");
        }else{
            response.setCode(400);
            response.setSuccess(false);
            response.setMsg("更改记录失败");
            response.setData(null);
        }
        return JsonTransfer.ObjectToJason(response);
    }

    @DeleteMapping("/infos/{id}")
    @ResponseBody
    @CrossOrigin
    public Object deleteInfo(@PathVariable("id") Integer id){
        ResponseObject response=new ResponseObject();
        if(service.getInfo(id)==null){
            response.setCode(400);
            response.setSuccess(false);
            response.setMsg("没有这条记录");
            response.setData(null);
            return response;
        }
        if(service.deleteInfo(id)){
            response.setCode(200);
            response.setSuccess(true);
            response.setMsg("success");
            response.setData("删除成功");
        }else{
            response.setCode(400);
            response.setSuccess(false);
            response.setMsg("删除记录失败");
            response.setData(null);
        }
        return JsonTransfer.ObjectToJason(response);
    }

    @PostMapping("/infos/{id}/move")
    @ResponseBody
    @CrossOrigin
    public Object Transfer(@PathVariable("id") Integer id,String username){
        Info info= service.getInfo(id);
        ResponseObject response=new ResponseObject();
        if(info==null){
            response.setCode(400);
            response.setSuccess(false);
            response.setMsg("没有这条记录");
            response.setData(null);
            return JsonTransfer.ObjectToJason(response);
        }
        TodoList todoList=new TodoList();
        todoList.setUsername(username);
        todoList.setDone(false);
        todoList.setTitle(info.getTitle());
        if(todoListService.insertTodoList(todoList)){
            response.setCode(200);
            response.setSuccess(true);
            response.setMsg("success");
            response.setData("添加成功");
        }else{
            response.setCode(400);
            response.setSuccess(false);
            response.setMsg("添加失败啰");
            response.setData(null);
            return JsonTransfer.ObjectToJason(response);
        }
        return JsonTransfer.ObjectToJason(response);
    }



}
