package com.dhu.user.controller;

import com.dhu.user.VO.ResultVO;
import com.dhu.user.VO.UserInfoVO;
import com.dhu.user.VO.UserVO;
import com.dhu.user.dataobject.UserInfo;
import com.dhu.user.service.UserService;
import com.dhu.user.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * creater: LIUYING
 * date:2018/8/14 18:23
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping(value = "/validate/{email}/{password}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultVO<UserVO> validate(@PathVariable String email, @PathVariable String password){
        UserInfo userInfo = userService.findByEmailAndPassword(email,password);
        if(userInfo != null){
            //用户登陆状态
            userInfo.setType(1);
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userInfo,userVO);
        return ResultVOUtil.success(userVO);
    }

    @PostMapping("/register/")
    public String register(UserVO userVO){
        UserInfo user = userService.IsExist(userVO.getEmail());
        if(user.getUserId() != null){
            return "用户已存在，请勿重复注册！";
        }
        else{
            BeanUtils.copyProperties(userVO,user);
            userService.register(user);
            return "注册成功！";
        }
    }

    @PostMapping("/userInfoForRecommend")
    public UserInfoVO listForRecommend(@RequestBody String userId){
        return userService.findUserInfo(userId);
    }

}
