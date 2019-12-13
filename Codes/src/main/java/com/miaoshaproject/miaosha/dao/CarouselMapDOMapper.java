package com.miaoshaproject.miaosha.dao;

import com.miaoshaproject.miaosha.dataobject.CarouselMapDO;
import com.miaoshaproject.miaosha.dataobject.CarouselMapDOCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface CarouselMapDOMapper {
    int countByCriteria(CarouselMapDOCriteria example);

    int deleteByCriteria(CarouselMapDOCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(CarouselMapDO record);

    int insertSelective(CarouselMapDO record);

    List<CarouselMapDO> selectByCriteriaWithRowbounds(CarouselMapDOCriteria example, RowBounds rowBounds);

    List<CarouselMapDO> selectByCriteria(CarouselMapDOCriteria example);

    CarouselMapDO selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") CarouselMapDO record, @Param("example") CarouselMapDOCriteria example);

    int updateByCriteria(@Param("record") CarouselMapDO record, @Param("example") CarouselMapDOCriteria example);

    int updateByPrimaryKeySelective(CarouselMapDO record);

    int updateByPrimaryKey(CarouselMapDO record);
}