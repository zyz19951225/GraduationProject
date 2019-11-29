package com.shopproject.shop.service;

import com.shopproject.shop.dataobject.OrderInfoDO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderInfoService {

    int createOrderInfo(OrderInfoDO orderInfoDO);

    List<OrderInfoDO> selectByCriteria(int userId);

}
