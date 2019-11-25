package com.miaoshaproject.miaosha.service.model;

import com.miaoshaproject.miaosha.dataobject.CarouselMapDO;
import com.miaoshaproject.miaosha.dataobject.CarouselMapDOCriteria;

import java.util.List;

public interface CarouselMapService {

    List<CarouselMapDO> selectByCriteria();


}
