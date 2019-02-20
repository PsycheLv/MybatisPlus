package com.example.mybatisplustest.store.domain;

import lombok.Data;

/**
 * @ClassName user
 * @Description TODO
 * @Author admin
 * @Date 2019/2/19 10:35
 * @Version 1.0
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private Long telephone;
}
