package com.whut.cailiao.war.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.whut.bssearch.api.SearchClient;
import com.whut.cailiao.api.commons.ApiResponse;

/**
 * Created by niuyang on 16/3/8.
 */
@RestController
public class TestController {

    @Autowired
    private SearchClient client;

    @RequestMapping("/bstest.html")
    public String bstest() throws Exception {

        ApiResponse response = client.search(null);

        return JSON.toJSONString(response);
    }
}
