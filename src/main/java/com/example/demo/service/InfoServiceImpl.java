package com.example.demo.service;

import java.util.List;
import com.example.demo.bean.Info;
import com.example.demo.dao.InfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl {
    @Autowired
    InfoMapper mapper;

    public List<Info> getInfos(){
        return mapper.getInfos();
    }

    public boolean insertInfo(Info info){
        return mapper.insertInfo(info);
    }

    public Info getInfo(Integer infoId){
        return mapper.getInfoById(infoId);
    }

    public boolean deleteInfo(Integer infoId){
        return mapper.deleteInfo(infoId);
    }

    public boolean updateInfo(Info info){
        return mapper.updateInfo(info);
    }
}
