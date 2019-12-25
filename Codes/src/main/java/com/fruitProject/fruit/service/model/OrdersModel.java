package com.fruitProject.fruit.service.model;


import lombok.Data;

import java.util.Date;

@Data
public class OrdersModel {
    private Integer id;

    private Integer idInCarts;

    private String image;

    private String title;

    private String description;

    private long price;

    private Integer state;

    private Integer num;

    private Date orderTime;


}
