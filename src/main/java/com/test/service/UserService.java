package com.test.service;

import com.test.vo.User_vo;

public interface UserService {
    boolean login(User_vo user_vo);

    int regist(User_vo user_vo);
}
