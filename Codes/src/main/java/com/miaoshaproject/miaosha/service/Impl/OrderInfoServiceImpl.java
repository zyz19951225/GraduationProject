package com.miaoshaproject.miaosha.service.Impl;

import com.miaoshaproject.miaosha.dao.OrderInfoDOMapper;
import com.miaoshaproject.miaosha.dataobject.OrderInfoDO;
import com.miaoshaproject.miaosha.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    OrderInfoDOMapper orderInfoDOMapper;

    @Override
    public int createOrderInfo(OrderInfoDO orderInfoDO) {
        orderInfoDO.setId(generateOrderNo());
        Date date = new Date();
        //SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        orderInfoDO.setOrderTime(date);
        int flag = orderInfoDOMapper.insertSelective(orderInfoDO);
        return flag;
    }

    public String generateOrderNo() {
        StringBuilder stringBuilder = new StringBuilder();
        //前8位为时间信息，年月日
//        Date now = new Date();
        SimpleDateFormat df = new SimpleDateFormat("MMddHHmmss");//设置日期格式
        String date = df.format(new Date());
//        String nowDate = now.format(DateTimeFormatter.ISO_DATE).replace("-", "");
        stringBuilder.append(date);

        return stringBuilder.toString();
    }
}
