package com.fruitProject.fruit.Controller;


import com.fruitProject.fruit.dataobject.CartDO;
import com.fruitProject.fruit.dataobject.FruitInfoDO;
import com.fruitProject.fruit.error.BusinessException;
import com.fruitProject.fruit.response.CommonReturnType;
import com.fruitProject.fruit.service.FruitInfoService;
import com.fruitProject.fruit.service.Impl.CartServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("cart")
@RequestMapping("/cart")
public class CartsController {

    @Autowired
    private CartServiceImpl cartService;

    @Autowired
    FruitInfoService fruitInfoServiceImpl;

    //查看购物车
    @RequestMapping(value = "/checkMyCart")
    @ResponseBody
    public CommonReturnType checkMyCart(int userId) throws BusinessException {
        List<CartDO> cartDOList = cartService.selectByUserId(userId);
        return CommonReturnType.create(cartDOList);
    }



    //删除购物车商品(单个)
    @RequestMapping(value = "/deleteSelectFruit")
    @ResponseBody
    public CommonReturnType deleteSelectFruit(@RequestParam(name = "id")int fruitPrimaryId) throws BusinessException {
        int flag= cartService.deleteByPrimaryKey(fruitPrimaryId);
        return CommonReturnType.createAddMessage("删除成功");
    }



    //删除购物车所有商品
    @RequestMapping(value = "/deleteAllFruit")
    @ResponseBody
    public CommonReturnType deleteAllFruit(@RequestParam(name = "id")int userId) throws BusinessException {
        int flag= cartService.deleteByCriteria(userId);
        return CommonReturnType.createAddMessage("删除成功");
    }


    //加入购物车
    @RequestMapping(value = "/addToCart")
    @ResponseBody
    public CommonReturnType addToCart(@RequestParam(value = "userId") String userIdstr,@RequestParam(value = "fruitId")String fruitIdstr) throws BusinessException {

        Integer userId =Integer.valueOf(userIdstr);
        Integer fruitId =Integer.valueOf(fruitIdstr);
        int flag = cartService.countByCriteria(userId,fruitId);
        if(flag ==0){
            FruitInfoDO fruitInfoDO = fruitInfoServiceImpl.selectByPrimaryKey(fruitId);
            CartDO cartDO = new CartDO();
            BeanUtils.copyProperties(fruitInfoDO, cartDO);
            cartDO.setId(null);
            cartDO.setUserId(userId);
            int addToCarrtFlag = cartService.insertSelective(cartDO);
            return CommonReturnType.createAddMessage("加入购物车成功");
        }else
        {
            return CommonReturnType.createAddMessage("已加入购物车");
        }

    }
}
