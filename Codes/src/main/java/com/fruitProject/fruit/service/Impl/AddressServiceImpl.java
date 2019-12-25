package com.fruitProject.fruit.service.Impl;

import com.fruitProject.fruit.dao.AddressDOMapper;
import com.fruitProject.fruit.dataobject.AddressDO;
import com.fruitProject.fruit.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
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

    @Override
    public AddressDO selectUserDefaultAddress(Integer id) {
        AddressDO addressDO = addressDOMapper.selectUserDefaultAddress(id);
        return addressDO;
    }
}
