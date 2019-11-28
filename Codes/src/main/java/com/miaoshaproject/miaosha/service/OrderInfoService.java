package com.miaoshaproject.miaosha.service;

import com.miaoshaproject.miaosha.dataobject.OrderInfoDO;
import org.springframework.stereotype.Service;

@Service
public interface OrderInfoService {

    int createOrderInfo(OrderInfoDO orderInfoDO);
}
