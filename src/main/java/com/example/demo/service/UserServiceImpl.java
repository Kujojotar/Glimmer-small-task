package com.example.demo.service;

import com.example.demo.bean.User;
import com.example.demo.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper mapper;

    public boolean addUser(User user){
        return mapper.insertUser(user);
    }

    public boolean deleteUser(String target){
        return mapper.deleteUser(target);
    }

    public char examineUser(User user){
        User model=findUser(user.getUsername());
        if(model==null){
            return 'n';
        }
        if(!user.getPassword().equals(model.getPassword())){
            return 'f';
        }
        return 't';
    }

    private User findUser(String userAccount){
        return mapper.getUserByName(userAccount);
    }
}
