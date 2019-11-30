package com.qf.serviceImpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.StuMapper;
import com.qf.entity.Classes;
import com.qf.entity.Student;
import com.qf.service.IClassesService;
import com.qf.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class StuServiceImpl implements IStuService {

    @Autowired
    private StuMapper stuMapper;

    @Reference
    private IClassesService classesService;

    @Override
    public List<Student> list() {
        List<Student> students = stuMapper.selectList(null);
        for (Student student : students) {
            Integer cid = student.getCid();
            Classes classes = classesService.queryById(cid);
            student.setClasses(classes);
        }
        return students;
    }
}
