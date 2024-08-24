package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ChuangxinnenglibisaiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChuangxinnenglibisaiView;


/**
 * 创新能力比赛
 *
 * @author 
 * @email 
 * @date 2024-03-26 15:42:16
 */
public interface ChuangxinnenglibisaiService extends IService<ChuangxinnenglibisaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChuangxinnenglibisaiView> selectListView(Wrapper<ChuangxinnenglibisaiEntity> wrapper);
   	
   	ChuangxinnenglibisaiView selectView(@Param("ew") Wrapper<ChuangxinnenglibisaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChuangxinnenglibisaiEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ChuangxinnenglibisaiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ChuangxinnenglibisaiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ChuangxinnenglibisaiEntity> wrapper);



}

