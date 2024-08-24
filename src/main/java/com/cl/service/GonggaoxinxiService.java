package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.GonggaoxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.GonggaoxinxiView;


/**
 * 公告信息
 *
 * @author 
 * @email 
 * @date 2024-03-26 15:42:15
 */
public interface GonggaoxinxiService extends IService<GonggaoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GonggaoxinxiView> selectListView(Wrapper<GonggaoxinxiEntity> wrapper);
   	
   	GonggaoxinxiView selectView(@Param("ew") Wrapper<GonggaoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GonggaoxinxiEntity> wrapper);
   	

}

