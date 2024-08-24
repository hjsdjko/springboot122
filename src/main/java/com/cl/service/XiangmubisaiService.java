package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XiangmubisaiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiangmubisaiView;


/**
 * 项目比赛
 *
 * @author 
 * @email 
 * @date 2024-03-26 15:42:15
 */
public interface XiangmubisaiService extends IService<XiangmubisaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiangmubisaiView> selectListView(Wrapper<XiangmubisaiEntity> wrapper);
   	
   	XiangmubisaiView selectView(@Param("ew") Wrapper<XiangmubisaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiangmubisaiEntity> wrapper);
   	

}

