package com.zyx.mall.products.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.zyx.common.valid.AddGroup;
import com.zyx.common.valid.ListValue;
import com.zyx.common.valid.UpdateGroup;
import com.zyx.common.valid.UpdateStatusGroup;
import lombok.Data;
import org.apache.ibatis.annotations.Update;
import org.codehaus.jettison.badgerfish.BadgerFishDOMDocumentParser;
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
	@NotNull(message = "Brand ID in a must for modification!", groups = {UpdateGroup.class})
	@Null(message = "Brand ID cannot be assigned when adding entity!", groups = {AddGroup.class})
	@TableId
	private Long brandId;
	/**
	 * 
	 */
	@NotBlank(message="Brand name is necessary!", groups = {AddGroup.class, UpdateGroup.class})
	private String name;
	/**
	 * 
	 */
	@NotEmpty(message = "Logo URL cannot be empty!", groups = {AddGroup.class})
	@URL(message = "logo must be a valid URL", groups = {AddGroup.class, UpdateGroup.class})
	private String logo;
	/**
	 * 
	 */
	@NotEmpty(groups = {AddGroup.class})
	private String descript;
	/**
	 * 
	 */

	@ListValue(vals={0, 1}, groups = {AddGroup.class, UpdateStatusGroup.class})
	private Integer showStatus;
	/**
	 * 
	 */
	@NotNull(groups = {AddGroup.class, UpdateGroup.class})
	@Pattern(regexp = "^[a-zA-Z]$", groups = {AddGroup.class, UpdateGroup.class})
	private String firstLetter;
	/**
	 * 
	 */
	@NotNull(groups = {AddGroup.class})
	@Min(value = 0, message = "sort must be larger than 0", groups = {AddGroup.class, UpdateGroup.class})
	private Integer sort;

}
