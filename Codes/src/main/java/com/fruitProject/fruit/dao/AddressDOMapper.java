package com.fruitProject.fruit.dao;

import com.fruitProject.fruit.dataobject.AddressDO;
import com.fruitProject.fruit.dataobject.AddressDOCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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

    @Select("select * from address where user_id = #{id} and default_address =1 limit 1")
    AddressDO selectUserDefaultAddress(Integer id);


    AddressDO selectByPrimaryKey(Integer id);

    List<AddressDO> selectByUserId(Integer id);

    int updateByCriteriaSelective(@Param("record") AddressDO record, @Param("example") AddressDOCriteria example);

    int updateByCriteria(@Param("record") AddressDO record, @Param("example") AddressDOCriteria example);

    int updateByPrimaryKeySelective(AddressDO record);

    int updateByPrimaryKey(AddressDO record);
}