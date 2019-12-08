package com.bugsbunnywyunj.demo.entity;

import com.bugsbunnywyunj.demo.enums.OrderStatusEnum;
import com.bugsbunnywyunj.demo.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
@Table(name = "OrderMaster_info")
public class OrderMaster {

    /** 订单id. */
    @Id
    private String orderId;

    /** 买家名字. */
    @Column(name="buyer_name",length = 50)
    private String buyerName;

    /** 买家手机号. */
    @Column(name="buyer_Phone",length = 50)
    private String buyerPhone;

    /** 买家地址. */
    @Column(name="buyer_Address",length = 50)
    private String buyerAddress;

    /** 买家微信Openid. */
    @Column(name="buyer_Openid",length = 50)
    private String buyerOpenid;

    /** 订单总金额. */
    @Column(name="order_Amount",length = 50)
    private BigDecimal orderAmount;

    /** 订单状态, 默认为0新下单. */
    @Column(name="order_Status",length = 50)
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态, 默认为0未支付. */
    @Column(name="pay_Status",length = 50)
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 创建时间. */
    @Column(name="create_Time",length = 50)
    private Date createTime;

    /** 更新时间. */
    @Column(name="update_Time",length = 50)
    private Date updateTime;

}
