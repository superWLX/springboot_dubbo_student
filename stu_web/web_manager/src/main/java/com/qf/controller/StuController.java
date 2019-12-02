package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Student;
import com.qf.service.IStuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/stu")
public class StuController {

    @Reference
    private IStuService stuService;

    @RequestMapping("/list")
    public String list(Model model){
        List<Student> list = stuService.list();
        model.addAttribute("stulist",list);
        return "stulist";
    }

    @RequestMapping("/add")
    public String add(Student student){
        System.out.println(student);
        System.out.println("========================================");
        stuService.add(student);
        return "index";
    }

    @RequestMapping("/toadd")
    public String toadd(){
        return "addStu";
    }

}
