package com.miaoshaproject.miaosha.dao;

import com.miaoshaproject.miaosha.dataobject.AddressDO;
import com.miaoshaproject.miaosha.dataobject.AddressDOCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface AddressDOMapper {
    int countByCriteria(AddressDOCriteria example);

    int deleteByCriteria(AddressDOCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(AddressDO record);

    int insertSelective(AddressDO record);

    List<AddressDO> selectByCriteriaWithRowbounds(AddressDOCriteria example, RowBounds rowBounds);

    List<AddressDO> selectByCriteria(AddressDOCriteria example);


    AddressDO selectByPrimaryKey(Integer id);

    List<AddressDO> selectByUserId(Integer id);

    int updateByCriteriaSelective(@Param("record") AddressDO record, @Param("example") AddressDOCriteria example);

    int updateByCriteria(@Param("record") AddressDO record, @Param("example") AddressDOCriteria example);

    int updateByPrimaryKeySelective(AddressDO record);

    int updateByPrimaryKey(AddressDO record);
}