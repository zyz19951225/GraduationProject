package com.shopproject.shop.response;

public class CommonReturnType {
    //表明对应请求的返回处理结果 “succes”或“fail”
    private String status;


    private String message;

    //若status=success，则data内返回前端需要的json数据
    //若status=fail，则data内返回通用的错误码格式
    private Object data;

    //定义一个通用的创建方法，成功
    public static CommonReturnType create(Object result) {
        return CommonReturnType.create(result,"success");
    }

    public static CommonReturnType createAddMessage(String message) {
        CommonReturnType type = new CommonReturnType();
        type.setMessage(message);
        type.setStatus("success");
        type.setData(null);
        return type;

    }

    public static CommonReturnType create(Object result, String status) {
        CommonReturnType type = new CommonReturnType();
        type.setMessage("");
        type.setStatus(status);
        type.setData(result);
        return type;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
