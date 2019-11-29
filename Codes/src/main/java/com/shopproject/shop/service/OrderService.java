package com.shopproject.shop.service;

import com.shopproject.shop.error.BusinessException;
import com.shopproject.shop.service.model.OrderModel;

public interface OrderService {
    //通过前端url传输过来的秒杀活动id，然后在下单接口内校验对应Id是否属于对应商品且活动已经开始
    OrderModel createOrder(Integer userId, Integer itemId, Integer promoId, Integer amount) throws BusinessException;
}