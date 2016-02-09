package com.whut.cailiao.api.service.example;

import com.whut.cailiao.api.model.example.Student;

/**
 * Created by niuyang on 16/2/2.
 */
public interface StudentService {

    /**
     * 根据名字获取Student信息
     * @param name
     * @return
     */
    Student getBeanByName(String name);
}
