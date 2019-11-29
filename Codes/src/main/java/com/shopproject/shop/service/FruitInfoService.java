package com.shopproject.shop.service;

import com.shopproject.shop.dataobject.FruitInfoDO;

import java.util.List;

public interface FruitInfoService {

    List<FruitInfoDO> selectByCriteria();

    List<FruitInfoDO> selectFruitBatch(Integer startNum);

    FruitInfoDO selectByPrimaryKey(Integer fruitId);
}
