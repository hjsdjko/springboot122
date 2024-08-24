package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiangzuoxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiangzuoxinxiView;


/**
 * 讲座信息
 *
 * @author 
 * @email 
 * @date 2024-03-26 15:42:15
 */
public interface JiangzuoxinxiService extends IService<JiangzuoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiangzuoxinxiView> selectListView(Wrapper<JiangzuoxinxiEntity> wrapper);
   	
   	JiangzuoxinxiView selectView(@Param("ew") Wrapper<JiangzuoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiangzuoxinxiEntity> wrapper);
   	

}

