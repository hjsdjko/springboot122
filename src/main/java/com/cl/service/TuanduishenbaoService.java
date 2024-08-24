package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.TuanduishenbaoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TuanduishenbaoView;


/**
 * 团队申报
 *
 * @author 
 * @email 
 * @date 2024-03-26 15:42:15
 */
public interface TuanduishenbaoService extends IService<TuanduishenbaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TuanduishenbaoView> selectListView(Wrapper<TuanduishenbaoEntity> wrapper);
   	
   	TuanduishenbaoView selectView(@Param("ew") Wrapper<TuanduishenbaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TuanduishenbaoEntity> wrapper);
   	

}

