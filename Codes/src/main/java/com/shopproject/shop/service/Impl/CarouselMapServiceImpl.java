package com.shopproject.shop.service.Impl;

import com.shopproject.shop.dao.CarouselMapDOMapper;
import com.shopproject.shop.dataobject.CarouselMapDO;
import com.shopproject.shop.dataobject.CarouselMapDOCriteria;
import com.shopproject.shop.service.model.CarouselMapService;
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
