package com.miaoshaproject.miaosha.service;

import com.miaoshaproject.miaosha.dataobject.AddressDO;

import java.util.List;

public interface AddressService {

    List<AddressDO> selectByUserId(Integer id);

    int updateByPrimaryKey(AddressDO record);

    int insertSelective(AddressDO record);

    AddressDO selectUserDefaultAddress(Integer id);
}
