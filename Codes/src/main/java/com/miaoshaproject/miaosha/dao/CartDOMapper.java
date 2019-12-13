package com.miaoshaproject.miaosha.dao;

import com.miaoshaproject.miaosha.dataobject.CartDO;
import com.miaoshaproject.miaosha.dataobject.CartDOCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface CartDOMapper {
    int countByCriteria(CartDOCriteria example);

    int deleteByCriteria(CartDOCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(CartDO record);

    int insertSelective(CartDO record);

    List<CartDO> selectByCriteriaWithRowbounds(CartDOCriteria example, RowBounds rowBounds);

    List<CartDO> selectByCriteria(CartDOCriteria example);

    List<CartDO> selectByUserId(Integer id);

    CartDO selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") CartDO record, @Param("example") CartDOCriteria example);

    int updateByCriteria(@Param("record") CartDO record, @Param("example") CartDOCriteria example);

    int updateByPrimaryKeySelective(CartDO record);

    int updateByPrimaryKey(CartDO record);
}