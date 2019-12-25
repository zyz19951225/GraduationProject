package com.fruitProject.fruit.service;

import com.fruitProject.fruit.error.BusinessException;
import com.fruitProject.fruit.service.model.UserModel;

public interface UserService {
    //调用用户Id获取用户对象的方法
    UserModel getUserById(Integer id);

    //用户注册
    void register(UserModel userModel) throws BusinessException;

    UserModel validatelogin(String telephone, String encrptPassword) throws BusinessException;
}
