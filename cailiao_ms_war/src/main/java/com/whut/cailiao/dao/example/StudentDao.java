package com.whut.cailiao.dao.example;

import com.whut.cailiao.model.example.Student;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

/**
 * Created by niuyang on 16/1/28.
 */
public interface StudentDao {

    Student selectBeanByName(@Param("name") String name);

}
