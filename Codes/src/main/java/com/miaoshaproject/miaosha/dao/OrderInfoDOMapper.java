package com.miaoshaproject.miaosha.dao;

import com.miaoshaproject.miaosha.dataobject.OrderInfoDO;
import com.miaoshaproject.miaosha.dataobject.OrderInfoDOCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface OrderInfoDOMapper {
    int countByCriteria(OrderInfoDOCriteria example);

    int deleteByCriteria(OrderInfoDOCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(OrderInfoDO record);

    int insertSelective(OrderInfoDO record);

    List<OrderInfoDO> selectByCriteriaWithRowbounds(OrderInfoDOCriteria example, RowBounds rowBounds);

    List<OrderInfoDO> selectByCriteria(OrderInfoDOCriteria example);

    OrderInfoDO selectByPrimaryKey(String id);

    int updateByCriteriaSelective(@Param("record") OrderInfoDO record, @Param("example") OrderInfoDOCriteria example);

    int updateByCriteria(@Param("record") OrderInfoDO record, @Param("example") OrderInfoDOCriteria example);

    int updateByPrimaryKeySelective(OrderInfoDO record);

    int updateByPrimaryKey(OrderInfoDO record);
}