package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussjiangzuoxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussjiangzuoxinxiView;


/**
 * 讲座信息评论表
 *
 * @author 
 * @email 
 * @date 2024-03-26 15:42:16
 */
public interface DiscussjiangzuoxinxiService extends IService<DiscussjiangzuoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussjiangzuoxinxiView> selectListView(Wrapper<DiscussjiangzuoxinxiEntity> wrapper);
   	
   	DiscussjiangzuoxinxiView selectView(@Param("ew") Wrapper<DiscussjiangzuoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussjiangzuoxinxiEntity> wrapper);
   	

}

