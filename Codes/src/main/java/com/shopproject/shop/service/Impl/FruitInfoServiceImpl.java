package com.shopproject.shop.service.Impl;

import com.shopproject.shop.dao.FruitInfoDOMapper;
import com.shopproject.shop.dataobject.FruitInfoDO;
import com.shopproject.shop.dataobject.FruitInfoDOCriteria;
import com.shopproject.shop.service.FruitInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FruitInfoServiceImpl implements FruitInfoService {
    @Autowired
    FruitInfoDOMapper fruitInfoDOMapper;



    @Override
    public List<FruitInfoDO> selectByCriteria() {
        FruitInfoDOCriteria fruitInfoDOCriteria = new FruitInfoDOCriteria();
        FruitInfoDOCriteria.Criteria  fruitInfoDOCriteriaCriteria= fruitInfoDOCriteria.createCriteria();
        return fruitInfoDOMapper.selectByCriteria(fruitInfoDOCriteria);
    }

    @Override
    public List<FruitInfoDO> selectFruitBatch(Integer startNum) {
        Integer endNum = startNum+8;
        List<FruitInfoDO>  fruitInfoDOList = fruitInfoDOMapper.selectFruitBatch(startNum,endNum);
        return fruitInfoDOList;
    }

    @Override
    public FruitInfoDO selectByPrimaryKey(Integer fruitId) {
        return fruitInfoDOMapper.selectByPrimaryKey(fruitId);
    }
}
