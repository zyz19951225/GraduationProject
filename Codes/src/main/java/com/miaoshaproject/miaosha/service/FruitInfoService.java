package com.miaoshaproject.miaosha.service;

import com.miaoshaproject.miaosha.dataobject.FruitInfoDO;

import java.util.List;

public interface FruitInfoService {

    List<FruitInfoDO> selectByCriteria();

    List<FruitInfoDO> selectFruitBatch(Integer startNum);

    FruitInfoDO selectByPrimaryKey(Integer fruitId);
}
