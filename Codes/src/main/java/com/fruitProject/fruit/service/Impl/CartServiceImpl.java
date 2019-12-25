package com.fruitProject.fruit.service.Impl;

import com.fruitProject.fruit.dao.CartDOMapper;
import com.fruitProject.fruit.dataobject.CartDO;
import com.fruitProject.fruit.dataobject.CartDOCriteria;
import com.fruitProject.fruit.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartDOMapper cartDOMapper;

    @Override
    public List<CartDO> selectByUserId(Integer id) {
        List<CartDO> cartDOList = cartDOMapper.selectByUserId(id);
        return cartDOList;
    }


    @Override
    public int insertSelective(CartDO record) {
        int flag = cartDOMapper.insertSelective(record);
        return flag;
    }

    @Override
    public int countByCriteria(int userId,int fruiltId) {
        CartDOCriteria exmp = new CartDOCriteria();
        CartDOCriteria.Criteria cs = exmp.createCriteria();
        cs.andUserIdEqualTo(userId);
        cs.andFruitIdEqualTo(fruiltId);

        int flag = cartDOMapper.countByCriteria(exmp);

        return flag;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        int flag = cartDOMapper.deleteByPrimaryKey(id);
        return flag;
    }

    @Override
    public int deleteByCriteria(int userId) {
        CartDOCriteria exmp = new CartDOCriteria();
        CartDOCriteria.Criteria cs = exmp.createCriteria();
        cs.andUserIdEqualTo(userId);
        int flag = cartDOMapper.deleteByCriteria(exmp);
        return flag;
    }

    @Override
    public int deleteByCriteria(int [] needDeleteId ) {
        int flag=0;
        for(int id : needDeleteId){
             flag = cartDOMapper.deleteByPrimaryKey(id);
        }

        return flag;
    }
}
