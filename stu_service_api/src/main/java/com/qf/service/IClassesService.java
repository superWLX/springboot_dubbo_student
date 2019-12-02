package com.qf.service;

import com.qf.entity.Classes;
import java.util.List;

public interface IClassesService {
    List<Classes> list();
    Classes queryById(Integer id);

    void update(Classes classes);
}
