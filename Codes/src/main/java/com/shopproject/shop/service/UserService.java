package com.shopproject.shop.service;

import com.shopproject.shop.error.BusinessException;
import com.shopproject.shop.service.model.UserModel;

public interface UserService {
    //调用用户Id获取用户对象的方法
    UserModel getUserById(Integer id);

    //用户注册
    void register(UserModel userModel) throws BusinessException;

    UserModel validatelogin(String telephone, String encrptPassword) throws BusinessException;
}
