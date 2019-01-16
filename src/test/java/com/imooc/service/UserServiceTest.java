package com.imooc.service;

import com.imooc.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void addOne() throws Exception {
        /*User user = new User("test01", 1, 18912345672L, "18912345679@163.com", new Date());

        log.info("user = {}", user.toString());
        userService.addOne(user);
        log.info("user = {}", user.toString());
        */
//
//        for (int i = 25; i < 30; i++) {
//            User user = new User("test01", 1, (long) i, "18912345679@163.com", new Date());
//            userService.addOne(user);
//        }
    }

    @Test
    public void findById() throws Exception {

//        for (int i = 1; i < 10; i++) {
//            User user = userService.findById((long) i);
//            System.out.println("mybatis ---->" + user);
//        }


        for (int i = 6; i < 10; i++) {
            User user = userService.findByIdByRepository((long) i);
            System.out.println("jpa ---->" + user);
        }

    }


}