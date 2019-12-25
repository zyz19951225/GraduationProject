package com.fruitProject.fruit.service.Impl;

import com.fruitProject.fruit.dao.CarouselMapDOMapper;
import com.fruitProject.fruit.dataobject.CarouselMapDO;
import com.fruitProject.fruit.dataobject.CarouselMapDOCriteria;
import com.fruitProject.fruit.service.model.CarouselMapService;
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
