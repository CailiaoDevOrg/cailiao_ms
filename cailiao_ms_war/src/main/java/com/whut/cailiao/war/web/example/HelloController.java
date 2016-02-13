package com.whut.cailiao.war.web.example;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.whut.cailiao.api.model.example.Student;
import com.whut.cailiao.api.service.example.StudentService;

/**
 * Created by niuyang on 16/1/26.
 */
@Controller
public class HelloController {

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Resource(name = "studentService")
    private StudentService studentService;

    @RequestMapping("/ajaxTest.html")
    public @ResponseBody String ajaxTest() {
        logger.error("error :[log4j testing]");
        logger.warn("warn : {hello warning}");
        return "test message";
    }

    /**
     * 测试页面跳转
     * @return
     */
    @RequestMapping("/hello.html")
    public String hello() {
        return "hello";
    }


    /**
     * 测试数据库连接池
     * redis缓存
     * @return
     */
    @RequestMapping(value = "/sql.html", method = RequestMethod.GET)
    public @ResponseBody String getStudentInfo() {
        long begin = System.currentTimeMillis();
        Student stu = studentService.getBeanByName("test");
        long end = System.currentTimeMillis();
        System.out.println("========time=======" + (end - begin));
        return JSON.toJSONString(stu);
    }

    /**
     * 测试mybatis基本功能
     * @return
     */
    @RequestMapping("/insert.html")
    public @ResponseBody String insertStudentItem() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "java");
        map.put("age", 19);
        return "SUCCESS";
    }
}
