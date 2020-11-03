package com.zyx.mall.orders.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author yuxinzhao
 * @email zhaoyuxin124@gmail.com
 * @date 2020-11-02 22:13:29
 */
@Data
@TableName("oms_refund_info")
public class RefundInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Long orderReturnId;
	/**
	 * 
	 */
	private BigDecimal refund;
	/**
	 * 
	 */
	private String refundSn;
	/**
	 * 
	 */
	private Integer refundStatus;
	/**
	 * 
	 */
	private Integer refundChannel;
	/**
	 * 
	 */
	private String refundContent;

}
