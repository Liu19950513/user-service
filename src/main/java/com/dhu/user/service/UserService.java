package com.dhu.user.service;

import com.dhu.user.VO.UserInfoVO;
import com.dhu.user.dataobject.UserInfo;

/**
 * creater: LIUYING
 * date:2018/8/14 15:48
 */
public interface UserService {
    /**
     * 登陆验证
     * @param email
     * @param password
     * @return
     */
    UserInfo findByEmailAndPassword(String email, String password);

    /**
     * 通过Id查找用户
     * @param id
     * @return
     */
    UserInfoVO findUserInfo(String id);

    /**
     * 通过邮箱查找用户
     * @param email
     * @return
     */

    UserInfo IsExist(String email);

    /**
     * 注册
     * @param email
     * @param password
     * @return
     */
    UserInfo register(UserInfo user);

    /**
     * 注销
     * @param email
     */
    void writeOff(String email);
}
