package com.whut.cailiao.web.example;

import com.alibaba.fastjson.JSON;
import com.whut.cailiao.model.example.Student;
import com.whut.cailiao.service.example.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by niuyang on 16/1/26.
 */
@Controller
public class HelloController {

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Resource(name = "studentService")
    private StudentService studentService;

    @RequestMapping("/test.html")
    public @ResponseBody String hello() {
        logger.error("error :[log4j testing]");
        logger.warn("warn : {hello warning}");
        return "test message";
    }

    @RequestMapping("/helloPage.html")
    public String helloPage() {
        return "hello";
    }

    @RequestMapping(value = "/sql.html", method = RequestMethod.GET)
    public @ResponseBody String getStudentInfo() {
        long begin = System.currentTimeMillis();
        Student stu = studentService.getBeanByName("test");
        long end = System.currentTimeMillis();
        System.out.println("========time=======" + (end - begin));
        return JSON.toJSONString(stu);
    }

    @RequestMapping("/insert.html")
    public @ResponseBody String insertStudentItem() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "java");
        map.put("age", 19);
        /*if (MapUtils.isNotEmpty(map)) {
            long begin = System.currentTimeMillis();
            int i = 0;
            while (i++ < 100)
                studentDao.insertNewItem(map);
            long end = System.currentTimeMillis();
            System.out.println(end - begin);
        }*/
        return "SUCCESS";
    }
}