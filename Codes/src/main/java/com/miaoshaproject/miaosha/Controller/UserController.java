package com.miaoshaproject.miaosha.Controller;

import com.alibaba.druid.util.StringUtils;
import com.miaoshaproject.miaosha.Controller.viewobject.UserVO;
import com.miaoshaproject.miaosha.dataobject.AddressDO;
import com.miaoshaproject.miaosha.dataobject.CartDO;
import com.miaoshaproject.miaosha.dataobject.FruitInfoDO;
import com.miaoshaproject.miaosha.error.BusinessException;
import com.miaoshaproject.miaosha.error.EmBusinessError;
import com.miaoshaproject.miaosha.response.CommonReturnType;
import com.miaoshaproject.miaosha.service.AddressService;
import com.miaoshaproject.miaosha.service.CartService;
import com.miaoshaproject.miaosha.service.FruitInfoService;
import com.miaoshaproject.miaosha.service.Impl.CartServiceImpl;
import com.miaoshaproject.miaosha.service.Impl.UserServiceImpl;
import com.miaoshaproject.miaosha.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Random;

@Controller("user")
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private AddressService addressService;
    @Autowired
    private CartServiceImpl cartService;
    @Autowired
    FruitInfoService fruitInfoServiceImpl;

    @Autowired
    private HttpServletRequest httpServletRequest;


    //用户登陆接口
    @RequestMapping(value = "/login")
    @ResponseBody
    public CommonReturnType login(@RequestBody UserModel testUserModel) throws BusinessException {

        String password = testUserModel.getEncrptPassword();
        String telephone = testUserModel.getTelephone();
        System.out.println(telephone);
        System.out.println(password);
        //入参校验
        if (StringUtils.isEmpty(password) || StringUtils.isEmpty(telephone)) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        System.out.printf("***********************");

        //用户登陆服务，用来校验用户登陆是否合法
        UserModel userModel = userServiceImpl.validatelogin(telephone, password);

        //将凭证加入到用户登陆成功的session内
        this.httpServletRequest.getSession().setAttribute("IS_LOGIN", true);
        this.httpServletRequest.getSession().setAttribute("LOGIN_USER", userModel);

        return CommonReturnType.create(userModel);
    }

    //用户地址查询
    @RequestMapping(value = "/findUserAddress")
    @ResponseBody
    public CommonReturnType findUserAddress(String userId) throws BusinessException {
        System.out.println("--*--" + userId);
       Integer id =Integer.valueOf(userId);

        //入参校验
        if (id == null ) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        System.out.printf("***********************");

        //用户登陆服务，用来校验用户登陆是否合法
        List<AddressDO> addressDOList = addressService.selectByUserId(id);

        return CommonReturnType.create(addressDOList);
    }


    //查看购物车
    @RequestMapping(value = "/checkMyCart")
    @ResponseBody
    public CommonReturnType checkMyCart(int userId) throws BusinessException {
        List<CartDO> cartDOList = cartService.selectByUserId(userId);
        return CommonReturnType.create(cartDOList);
    }



    //删除购物车商品
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

    //用户地址Add
    @RequestMapping(value = "/addUsersAddress")
    @ResponseBody
    public CommonReturnType addUsersAddress(@RequestBody AddressDO addressDO) throws BusinessException {
        int flag = addressService.insertSelective(addressDO);
        return CommonReturnType.create(null);
    }


    //用户注册接口
    @RequestMapping(value = "/register")
    @ResponseBody
    public CommonReturnType register(@RequestBody UserModel userModel) throws BusinessException {
        //验证手机号和对应的otpCode相符合
//        String inSessionOtpCode = (String) this.httpServletRequest.getSession().getAttribute(telephone);

//        if (!StringUtils.equals(otpCode, inSessionOtpCode)) {
//            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "短信验证码不符合");
//        }
        //用户的注册流程
//        UserModel userModel = new UserModel();
//        userModel.setName(name);
//        userModel.setGender(gender);
//        userModel.setAge(age);
//        userModel.setTelephone(telephone);
//        userModel.setRegisterMode("byphone");
//        userModel.setEncrptPassword(password);

        userServiceImpl.register(userModel);
        return CommonReturnType.create(null);
        // if(org.apache.commons.lang3.StringUtils.isNotEmpty(userModel.)
    }


    //用户获取otp短信接口
    @RequestMapping(value = "/getotp", method = {RequestMethod.POST}, consumes = {"application/x-www-form-urlencoded"})
    @ResponseBody
    public CommonReturnType getOtp(@RequestParam(name = "telephone") String telephone) {
        //按照一定的规则生成otp验证码
        Random random = new Random();
        int randomInt = random.nextInt(89999);
        randomInt += 10000;
        String otpCode = String.valueOf(randomInt);

        //将otp验证码同对应的用户手机号关联起来,使用Httpsession的方式绑定她的手机号与otpCode
        httpServletRequest.getSession().setAttribute(telephone, otpCode);


        //将otp验证码通过短信方式发送给用户
        System.out.println("telephone: " + telephone + " &otpCode: " + otpCode);
        return CommonReturnType.create(null);
    }


    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name = "id") Integer id) throws BusinessException {
        //调用service服务获取对应id的用户对象并返回给前端
        UserModel userModel = userServiceImpl.getUserById(id);

        //若获取的对应用户信息不存在
        if (userModel == null) {
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }

        //将核心领域模型转化为可供UI使用的viewobject
        UserVO userVO = convertFromModel(userModel);

        //返回通用对象
        return CommonReturnType.create(userVO);

    }

    private UserVO convertFromModel(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel, userVO);
        return userVO;
    }


}
