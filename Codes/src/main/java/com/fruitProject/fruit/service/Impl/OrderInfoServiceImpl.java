package com.fruitProject.fruit.service.Impl;

import com.fruitProject.fruit.dao.OrderInfoDOMapper;
import com.fruitProject.fruit.dataobject.OrderInfoDO;
import com.fruitProject.fruit.dataobject.OrderInfoDOCriteria;
import com.fruitProject.fruit.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    @Override
    public List<OrderInfoDO> selectByCriteria(int userId) {
        OrderInfoDOCriteria exmp = new OrderInfoDOCriteria();
        OrderInfoDOCriteria.Criteria cs = exmp.createCriteria();
        cs.andUserIdEqualTo(userId);
        List<OrderInfoDO> orderInfoDOList = orderInfoDOMapper.selectByCriteria(exmp);
        return orderInfoDOList;
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
