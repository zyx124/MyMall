package com.zyx.mall.coupons.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author yuxinzhao
 * @email zhaoyuxin124@gmail.com
 * @date 2020-11-02 21:23:29
 */
@Data
@TableName("sms_home_subject")
public class HomeSubjectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String title;
	/**
	 * 
	 */
	private String subTitle;
	/**
	 * 
	 */
	private Integer status;
	/**
	 * 
	 */
	private String url;
	/**
	 * 
	 */
	private Integer sort;
	/**
	 * 
	 */
	private String img;

}
