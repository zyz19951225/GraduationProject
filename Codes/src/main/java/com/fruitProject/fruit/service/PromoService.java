package com.fruitProject.fruit.service;

import com.fruitProject.fruit.service.model.PromoModel;

public interface PromoService {
    //根据itemId获取正在进行或即将进行的秒杀活动
    PromoModel getPromoModelByItemId(Integer itemid);
}
