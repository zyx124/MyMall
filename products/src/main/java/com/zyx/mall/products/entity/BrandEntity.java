package com.zyx.mall.products.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * 
 * 
 * @author yuxinzhao
 * @email zhaoyuxin124@gmail.com
 * @date 2020-10-31 22:01:40
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long brandId;
	/**
	 * 
	 */
	@NotBlank(message="Brand name is necessary!")
	@Size(min = 1, max = 100)
	private String name;
	/**
	 * 
	 */
	@NotBlank(message = "Logo URL cannot be empty!")
	@URL(message = "logo must be a valid URL")
	private String logo;
	/**
	 * 
	 */
	@NotEmpty
	private String descript;
	/**
	 * 
	 */
	@NotEmpty
	private Integer showStatus;
	/**
	 * 
	 */
	@NotEmpty
	@Pattern(regexp = "/^[a-zA-Z]$/")
	private String firstLetter;
	/**
	 * 
	 */
	@NotNull
	@Min(value = 0, message = "sort must be larger than 0")
	private Integer sort;

}
