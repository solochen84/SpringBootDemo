package com.example.demo.web.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cheney on 2017/6/15.
 */
@RestController
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("")
    public JSONObject hello(String name) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("random11", RandomStringUtils.randomAlphabetic(16));
        if (StringUtils.isNotBlank(name)) {
            jsonObject.put("welcome", "hello, " + name + "!");
        }
        jsonObject.put("welcome1", "1");
        jsonObject.put("welcome6", "6");
        logger.info("result msg: {}", jsonObject.toJSONString());
        return jsonObject;
    }

}
