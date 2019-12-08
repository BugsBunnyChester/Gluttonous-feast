package com.bugsbunnywyunj.demo.dto;

import com.bugsbunnywyunj.demo.enums.PayStatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.bugsbunnywyunj.demo.entity.OrderDetail;
import com.bugsbunnywyunj.demo.enums.OrderStatusEnum;
import com.bugsbunnywyunj.demo.enums.PayStatusEnum;
import com.bugsbunnywyunj.demo.utils.EnumUtil;
import com.bugsbunnywyunj.demo.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    /** 订单id. */
    private String orderId;

    /** 买家名字. */
    private String buyerName;

    /** 买家手机号. */
    private String buyerPhone;

    /** 买家地址. */
    private String buyerAddress;

    /** 买家微信Openid. */
    private String buyerOpenid;

    /** 订单总金额. */
    private BigDecimal orderAmount;

    /** 订单状态, 默认为0新下单. */
    private Integer orderStatus;

    /** 支付状态, 默认为0未支付. */
    private Integer payStatus;

    /** 创建时间. */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /** 更新时间. */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;

    public String getBuyerAddress(int num) {
        String[] a = new String[1];
        if(buyerAddress==null)
        {
            a[0]="未设置地址";
        }else {
            a = buyerAddress.split(",");
        }
        if(a[num].isEmpty())
        {
            a[num]="空";
        }
        return  a[num];
    }
    public String[] getBuyerAddress(int e,int s) {
        String[] a = new String[1];
        if(buyerAddress==null)
        {
            a[0]="未设置地址";
        }else {
             a = buyerAddress.split(",");
        }
        return  a;
    }

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }
}
