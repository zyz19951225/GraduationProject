package com.shopproject.shop.dao;

import com.shopproject.shop.dataobject.FruitInfoDO;
import com.shopproject.shop.dataobject.FruitInfoDOCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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

    @Select("select * from fruit_info limit #{startNum},#{endNum}")
    List<FruitInfoDO> selectFruitBatch(@Param("startNum") Integer startNum,@Param("endNum") Integer endNum);

    int updateByCriteriaSelective(@Param("record") FruitInfoDO record, @Param("example") FruitInfoDOCriteria example);

    int updateByCriteria(@Param("record") FruitInfoDO record, @Param("example") FruitInfoDOCriteria example);

    int updateByPrimaryKeySelective(FruitInfoDO record);

    int updateByPrimaryKey(FruitInfoDO record);
}