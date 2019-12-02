package com.qf.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.ClassesMapper;
import com.qf.entity.Classes;
import com.qf.service.IClassesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ClassesServiceImpl implements IClassesService {

    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public List<Classes> list() {

        /*QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("cname","一年一班");*/

        return classesMapper.selectList(null);
    }

    @Override
    public Classes queryById(Integer id) {
        return classesMapper.selectById(id);
    }

    @Override
    public void update(Classes classes) {
        classesMapper.update(classes,null);
    }

}
