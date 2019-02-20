package com.example.mybatisplustest;

import com.example.mybatisplustest.store.domain.User;
import com.example.mybatisplustest.store.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelect(){
        System.out.println("---------testSelect---------");
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }
}
