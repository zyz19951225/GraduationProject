package com.miaoshaproject.miaosha.dao;

import com.miaoshaproject.miaosha.dataobject.FruitInfoDO;
import com.miaoshaproject.miaosha.dataobject.FruitInfoDOCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface FruitInfoDOMapper {
    int countByCriteria(FruitInfoDOCriteria example);

    int deleteByCriteria(FruitInfoDOCriteria example);

    int deleteByPrimaryKey(Integer fruitId);

    int insert(FruitInfoDO record);

    int insertSelective(FruitInfoDO record);

    List<FruitInfoDO> selectByCriteriaWithRowbounds(FruitInfoDOCriteria example, RowBounds rowBounds);

    List<FruitInfoDO> selectByCriteria(FruitInfoDOCriteria example);

    FruitInfoDO selectByPrimaryKey(Integer fruitId);

    int updateByCriteriaSelective(@Param("record") FruitInfoDO record, @Param("example") FruitInfoDOCriteria example);

    int updateByCriteria(@Param("record") FruitInfoDO record, @Param("example") FruitInfoDOCriteria example);

    int updateByPrimaryKeySelective(FruitInfoDO record);

    int updateByPrimaryKey(FruitInfoDO record);
}