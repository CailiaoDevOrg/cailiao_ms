package com.whut.cailiao.war.sevice.impl.example;

import com.whut.cailiao.war.dao.example.StudentDao;
import com.whut.cailiao.war.utils.redis.RedisSupport;
import com.whut.cailiao.api.model.example.Student;
import com.whut.cailiao.api.service.example.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by niuyang on 16/2/1.
 */
@Service("studentService")
public class StudentServiceImpl extends RedisSupport implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student getBeanByName(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        String key = "testDataStudent";
        Student stu = (Student) getTestData(key);
        if (stu == null) {
            stu = studentDao.selectBeanByName("test");
            setTestData(key, stu);
        }
        return stu;
    }
}
