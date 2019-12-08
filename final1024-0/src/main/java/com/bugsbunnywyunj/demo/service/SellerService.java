package com.bugsbunnywyunj.demo.service;

import com.bugsbunnywyunj.demo.entity.SellerInfo;

public interface SellerService {

    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
