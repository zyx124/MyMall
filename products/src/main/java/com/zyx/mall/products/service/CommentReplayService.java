package com.zyx.mall.products.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyx.common.utils.PageUtils;
import com.zyx.mall.products.entity.CommentReplayEntity;

import java.util.Map;

/**
 * 
 *
 * @author yuxinzhao
 * @email zhaoyuxin124@gmail.com
 * @date 2020-10-31 22:01:40
 */
public interface CommentReplayService extends IService<CommentReplayEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

