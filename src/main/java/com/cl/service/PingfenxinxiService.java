package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.PingfenxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.PingfenxinxiView;


/**
 * 评分信息
 *
 * @author 
 * @email 
 * @date 2024-03-26 15:42:16
 */
public interface PingfenxinxiService extends IService<PingfenxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PingfenxinxiView> selectListView(Wrapper<PingfenxinxiEntity> wrapper);
   	
   	PingfenxinxiView selectView(@Param("ew") Wrapper<PingfenxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PingfenxinxiEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<PingfenxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<PingfenxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<PingfenxinxiEntity> wrapper);



}

