package com.miaoshaproject.miaosha.Controller;



//import FruitInfoDOMapper;
//import FruitInfoDO;
import com.miaoshaproject.miaosha.dataobject.CarouselMapDO;
import com.miaoshaproject.miaosha.dataobject.FruitInfoDO;
import com.miaoshaproject.miaosha.error.BusinessException;
import com.miaoshaproject.miaosha.response.CommonReturnType;
import com.miaoshaproject.miaosha.service.FruitInfoService;
import com.miaoshaproject.miaosha.service.model.CarouselMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FruitController {


    @Autowired
    FruitInfoService fruitInfoServiceImpl;
    @Autowired
    CarouselMapService carouselMapServiceImpl;

    //获取首页水果展示
    @RequestMapping("/")
    @ResponseBody
    public CommonReturnType test(){
        return CommonReturnType.create(null);
    }



    //获取首页水果展示
    @RequestMapping("/getAllFruitInfoList")
    @ResponseBody
    public CommonReturnType getAllFruitInfoList(){
        List<FruitInfoDO> fruitInfoDOList = fruitInfoServiceImpl.selectByCriteria();
        return CommonReturnType.create(fruitInfoDOList);
    }

    //获取首页轮播图资源
    @RequestMapping("/getAarouselMap")
    @ResponseBody
    public CommonReturnType getAarouselMap(){
        List<CarouselMapDO> carouselMapDOList = carouselMapServiceImpl.selectByCriteria();
        return CommonReturnType.create(carouselMapDOList);
    }

    //水果详情页
    @RequestMapping("/getFruitInfoDetail")
    @ResponseBody
    public CommonReturnType getFruitInfoDetail(@RequestParam(name = "id") Integer id){
        FruitInfoDO fruitInfoDO= fruitInfoServiceImpl.selectByPrimaryKey(id);
        List<FruitInfoDO> fruitInfoDOList = new ArrayList<>();
        fruitInfoDOList.add(fruitInfoDO);
        return CommonReturnType.create(fruitInfoDOList);
    }

    //批量查看商品信息
    @RequestMapping(value = "/selectFruitInfoBatch")
    @ResponseBody
    public CommonReturnType selectFruitInfoBatch(int startNum) throws BusinessException {
        List<FruitInfoDO> fruitInfoDOList = fruitInfoServiceImpl.selectFruitBatch(startNum);
        return CommonReturnType.create(fruitInfoDOList);
    }



}
