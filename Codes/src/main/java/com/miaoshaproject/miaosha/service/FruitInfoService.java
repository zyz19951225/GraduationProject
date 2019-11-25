package com.miaoshaproject.miaosha.service;

import com.miaoshaproject.miaosha.dataobject.FruitInfoDO;
import com.miaoshaproject.miaosha.dataobject.FruitInfoDOCriteria;

import java.util.List;

public interface FruitInfoService {

    List<FruitInfoDO> selectByCriteria();

    FruitInfoDO selectByPrimaryKey(Integer fruitId);
}
