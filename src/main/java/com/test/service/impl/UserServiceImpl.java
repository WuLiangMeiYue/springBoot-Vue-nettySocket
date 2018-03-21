package com.test.service.impl;

import com.test.entity.User;
import com.test.repository.UserDao;
import com.test.service.UserService;
import com.test.vo.User_vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean login(User_vo user_vo) {
        User user = userDao.getByName(user_vo.getUserName());
        if (user == null) {
            return false;
        }
        if (!(user.getPassword().equals(user_vo.getUserPwd()))){
            return false;
        }
        return true;
    }

    @Override
    public int regist(User_vo user_vo) {
        User user = new User();
        user.setName(user_vo.getUserName());
        user.setPassword(user_vo.getUserPwd());
        userDao.save(user);
        return 1;
    }
}
