package com.fruitProject.fruit.service;

import com.fruitProject.fruit.dataobject.OrderInfoDO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderInfoService {

    int createOrderInfo(OrderInfoDO orderInfoDO);

    List<OrderInfoDO> selectByCriteria(int userId);

}
