package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ChuangxinsiweipeiyangEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChuangxinsiweipeiyangView;


/**
 * 创新思维培养
 *
 * @author 
 * @email 
 * @date 2024-03-26 15:42:16
 */
public interface ChuangxinsiweipeiyangService extends IService<ChuangxinsiweipeiyangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChuangxinsiweipeiyangView> selectListView(Wrapper<ChuangxinsiweipeiyangEntity> wrapper);
   	
   	ChuangxinsiweipeiyangView selectView(@Param("ew") Wrapper<ChuangxinsiweipeiyangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChuangxinsiweipeiyangEntity> wrapper);
   	

}

