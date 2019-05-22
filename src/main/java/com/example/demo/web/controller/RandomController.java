package com.example.demo.web.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheney on 2017/6/15.
 */
@RestController
@RequestMapping("random")
public class RandomController {

    @GetMapping("")
    public Object random() {
        List<Row> list = new ArrayList<>();

        list.add(new Row("RandomStringUtils.random(5)", RandomStringUtils.random(5), "产生5位长度的随机字符串，中文环境下是乱码"));

        list.add(new Row("RandomStringUtils.random(5, new char[]{'a', 'b', 'c', 'd', 'e', 'f', '1', '2', '3'})",
                RandomStringUtils.random(5, new char[]{'a', 'b', 'c', 'd', 'e', 'f', '1', '2', '3'}),
                "使用指定的字符生成5位长度的随机字符串"));

        list.add(new Row("RandomStringUtils.randomAlphanumeric(5)",
                RandomStringUtils.randomAlphanumeric(5),
                "生成指定长度的字母和数字的随机组合字符串"));

        list.add(new Row("RandomStringUtils.randomNumeric(5)",
                RandomStringUtils.randomNumeric(5),
                "生成随机数字字符串"));


        list.add(new Row("RandomStringUtils.randomAlphabetic(5)",
                RandomStringUtils.randomAlphabetic(5),
                "生成随机[a-z]字符串，包含大小写"));

        list.add(new Row("RandomStringUtils.randomAscii(4)",
                RandomStringUtils.randomAscii(4),
                "生成从ASCII 32到126组成的随机字符串"));

        return list;
    }

    class Row{
        private String key;
        private String value;
        private String message;

        public Row(String key, String value, String message) {
            this.key = key;
            this.value = value;
            this.message = message;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
