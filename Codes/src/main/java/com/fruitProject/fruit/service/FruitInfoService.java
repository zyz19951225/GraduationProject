package com.fruitProject.fruit.service;

import com.fruitProject.fruit.dataobject.FruitInfoDO;

import java.util.List;

public interface FruitInfoService {

    List<FruitInfoDO> selectByCriteria();

    List<FruitInfoDO> selectFruitBatch(Integer startNum);

    FruitInfoDO selectByPrimaryKey(Integer fruitId);
}
