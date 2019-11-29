package com.shopproject.shop.service;

import com.shopproject.shop.error.BusinessException;
import com.shopproject.shop.service.model.ItemModel;

import java.util.List;

public interface ItemService {

    //创建商品
    ItemModel creatItem(ItemModel itemModel) throws BusinessException;

    //商品列表浏览
    List<ItemModel> listItem();

    //商品详情浏览
    ItemModel getItemById(Integer id);

    //库存扣减
    boolean decreaseStock(Integer itemId, Integer amount) throws BusinessException;
}
