package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.BisaibaomingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BisaibaomingView;


/**
 * 比赛报名
 *
 * @author 
 * @email 
 * @date 2024-03-26 15:42:16
 */
public interface BisaibaomingService extends IService<BisaibaomingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BisaibaomingView> selectListView(Wrapper<BisaibaomingEntity> wrapper);
   	
   	BisaibaomingView selectView(@Param("ew") Wrapper<BisaibaomingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BisaibaomingEntity> wrapper);
   	

}

