package com.miaoshaproject.miaosha.service;

import com.miaoshaproject.miaosha.dataobject.CartDO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
    List<CartDO> selectByUserId(Integer id);
    
    int insertSelective(CartDO record);

    int countByCriteria(int userId,int fruiltId);

    int deleteByPrimaryKey(Integer id);

    int deleteByCriteria(int userId);

    int deleteByCriteria(int [] needDeleteId);




}
