package com.whut.cailiao.war.dao.example;

import com.whut.cailiao.api.model.example.Student;
import org.apache.ibatis.annotations.Param;

/**
 * Created by niuyang on 16/1/28.
 */
public interface StudentDao {

    Student selectBeanByName(@Param("name") String name);

}
