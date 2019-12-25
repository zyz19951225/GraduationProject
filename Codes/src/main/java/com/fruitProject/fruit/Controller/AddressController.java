package com.fruitProject.fruit.Controller;


import com.fruitProject.fruit.dataobject.AddressDO;
import com.fruitProject.fruit.error.BusinessException;
import com.fruitProject.fruit.error.EmBusinessError;
import com.fruitProject.fruit.response.CommonReturnType;
import com.fruitProject.fruit.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("address")
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;


    //用户地址查询
    @RequestMapping(value = "/findUserAddress")
    @ResponseBody
    public CommonReturnType findUserAddress(String userId) throws BusinessException {
        Integer id =Integer.valueOf(userId);
        //入参校验
        if (id == null ) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        //用户登陆服务，用来校验用户登陆是否合法
        List<AddressDO> addressDOList = addressService.selectByUserId(id);
        return CommonReturnType.create(addressDOList);
    }

    //用户地址修改
    @RequestMapping(value = "/updateUsersAddress")
    @ResponseBody
    public CommonReturnType updateUsersAddress(@RequestBody AddressDO addressDO) throws BusinessException {
        int flag = addressService.updateByPrimaryKey(addressDO);
        return CommonReturnType.create(null);
    }

    //用户默认地址查询
    @RequestMapping(value = "/selectUserDefaultAddress")
    @ResponseBody
    public CommonReturnType selectUserDefaultAddress(int userId) throws BusinessException {
        Integer id =userId;
        //入参校验
        if (id == null ) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        //用户登陆服务，用来校验用户登陆是否合法
        AddressDO addressDO = addressService.selectUserDefaultAddress(id);
        return CommonReturnType.create(addressDO);
    }

    //用户地址Add
    @RequestMapping(value = "/addUsersAddress")
    @ResponseBody
    public CommonReturnType addUsersAddress(@RequestBody AddressDO addressDO) throws BusinessException {
        int flag = addressService.insertSelective(addressDO);
        return CommonReturnType.create(null);
    }

}
