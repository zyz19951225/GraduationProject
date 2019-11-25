package com.miaoshaproject.miaosha.service.Impl;

import com.miaoshaproject.miaosha.dao.CarouselMapDOMapper;
import com.miaoshaproject.miaosha.dataobject.CarouselMapDO;
import com.miaoshaproject.miaosha.dataobject.CarouselMapDOCriteria;
import com.miaoshaproject.miaosha.service.model.CarouselMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarouselMapServiceImpl implements CarouselMapService {

    @Autowired
    CarouselMapDOMapper carouselMapDOMapper;

    @Override
    public List<CarouselMapDO> selectByCriteria() {
        CarouselMapDOCriteria carouselMapDOCriteria = new CarouselMapDOCriteria();
        CarouselMapDOCriteria.Criteria cc = carouselMapDOCriteria.createCriteria();

        return carouselMapDOMapper.selectByCriteria(carouselMapDOCriteria);
    }
}
