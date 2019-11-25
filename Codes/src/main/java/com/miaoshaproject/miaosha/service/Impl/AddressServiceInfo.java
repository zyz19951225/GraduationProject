package com.miaoshaproject.miaosha.service.Impl;

import com.miaoshaproject.miaosha.dao.AddressDOMapper;
import com.miaoshaproject.miaosha.dataobject.AddressDO;
import com.miaoshaproject.miaosha.service.AddressService;
import com.miaoshaproject.miaosha.service.model.AddressModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceInfo implements AddressService {
    @Autowired
    AddressDOMapper addressDOMapper;

    @Override
    public List<AddressDO> selectByUserId(Integer id) {
        List<AddressDO> addressDOList = addressDOMapper.selectByUserId(id);
        return addressDOList;
    }

    @Override
    public int updateByPrimaryKey(AddressDO record) {
        int flag = addressDOMapper.updateByPrimaryKey(record);
        return flag;
    }

    @Override
    public int insertSelective(AddressDO record) {
        int flag = addressDOMapper.insertSelective(record);
        return flag;
    }
}
