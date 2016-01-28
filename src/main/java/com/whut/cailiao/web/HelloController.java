package com.whut.cailiao.web;

import com.alibaba.fastjson.JSON;
import com.whut.cailiao.dao.example.StudentDao;
import com.whut.cailiao.model.example.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by niuyang on 16/1/26.
 */
@Controller
public class HelloController {

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private StudentDao studentDao;

    @RequestMapping("/test.html")
    public @ResponseBody String hello() {
        logger.error("error :[log4j testing]");
        logger.warn("warn : {hello warning}");
        return "test message";
    }

    @RequestMapping("/hellopage.html")
    public String helloPage() {
        return "hello";
    }

    @RequestMapping("sql.html")
    public @ResponseBody String getStudentInfo() {
        String name = "test";
        Student stu = studentDao.selectBeanByName(name);

        return JSON.toJSONString(stu);
    }

    @RequestMapping("insert.html")
    public @ResponseBody String insertStudentItem() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "java");
        map.put("age", 19);
        studentDao.insertNewItem(map);

        return "SUCCESS";
    }
}
