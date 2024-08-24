package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.PingxuanjieguoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.PingxuanjieguoView;


/**
 * 评选结果
 *
 * @author 
 * @email 
 * @date 2024-03-26 15:42:16
 */
public interface PingxuanjieguoService extends IService<PingxuanjieguoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PingxuanjieguoView> selectListView(Wrapper<PingxuanjieguoEntity> wrapper);
   	
   	PingxuanjieguoView selectView(@Param("ew") Wrapper<PingxuanjieguoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PingxuanjieguoEntity> wrapper);
   	

}

