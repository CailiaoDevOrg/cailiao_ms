package com.whut.cailiao.dao.example;

import com.whut.cailiao.model.example.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by niuyang on 16/1/28.
 */
@Component
public interface StudentDao {

    @Select("SELECT * FROM ms_tb_student WHERE name = #{name}")
    Student selectBeanByName(@Param("name") String name);

    @Insert("INSERT INTO ms_tb_student(name, age) VALUES(#{name}, #{age})")
    void insertNewItem(Map<String, Object> map);

}
