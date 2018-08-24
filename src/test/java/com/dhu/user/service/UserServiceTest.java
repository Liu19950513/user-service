package com.dhu.user.service;

import com.dhu.user.UserApplicationTests;
import com.dhu.user.VO.UserInfoVO;
import com.dhu.user.dataobject.UserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.Assert.*;

@Component
public class UserServiceTest extends UserApplicationTests {
    @Autowired
    private  UserService userService;
    @Test
    public void findByNameAndPassword() {
        UserInfo userInfo = userService.findByEmailAndPassword("98409212@qq.com","asd13579");
        Assert.assertTrue(userInfo != null);
    }
    @Test
    public void update(){
        UserInfoVO userInfoVO = new UserInfoVO( (long)3,"cute",22,160,
                "standard","mid_warm");
        UserInfo userInfo = userService.update(userInfoVO);
        Assert.assertTrue(userInfo != null);
    }
}