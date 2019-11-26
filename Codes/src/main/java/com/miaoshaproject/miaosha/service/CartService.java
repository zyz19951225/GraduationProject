package com.miaoshaproject.miaosha.service;

import com.miaoshaproject.miaosha.dataobject.CartDO;
import com.miaoshaproject.miaosha.dataobject.CartDOCriteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
    List<CartDO> selectByUserId(Integer id);

    int insertSelective(CartDO record);

    int countByCriteria(int userId,int fruiltId);




}
