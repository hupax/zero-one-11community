package com.zeroone.star.sample;


import com.zeroone.star.project.components.easyexcel.EasyExcelComponent;
import com.zeroone.star.sample.test.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ExcelTest {
    @Resource
    EasyExcelComponent excel;
    
    final String filename = "./test.xlsx";
    
    
    @Test
    void testGenerateExcel() {
        // 定义测试数据
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i);
            user.setName("测试" + i);
            user.setPhone("123456789" + i);
            users.add(user);
        }
        excel.generateExcel(filename, "测试", User.class, users);
    }
    
    @Test
    void testParseExcel() {
        List<User> users = excel.parseExcel(filename, User.class);
        users.forEach(System.out::println);
    }
}
