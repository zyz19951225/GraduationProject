package com.miaoshaproject.miaosha.service.Impl;

import com.miaoshaproject.miaosha.dao.FruitInfoDOMapper;
import com.miaoshaproject.miaosha.dataobject.FruitInfoDO;
import com.miaoshaproject.miaosha.dataobject.FruitInfoDOCriteria;
import com.miaoshaproject.miaosha.service.FruitInfoService;
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
    public FruitInfoDO selectByPrimaryKey(Integer fruitId) {
        return fruitInfoDOMapper.selectByPrimaryKey(fruitId);
    }
}
