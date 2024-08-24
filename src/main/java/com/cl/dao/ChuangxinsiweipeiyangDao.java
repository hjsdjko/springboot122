package com.cl.dao;

import com.cl.entity.ChuangxinsiweipeiyangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChuangxinsiweipeiyangView;


/**
 * 创新思维培养
 * 
 * @author 
 * @email 
 * @date 2024-03-26 15:42:16
 */
public interface ChuangxinsiweipeiyangDao extends BaseMapper<ChuangxinsiweipeiyangEntity> {
	
	List<ChuangxinsiweipeiyangView> selectListView(@Param("ew") Wrapper<ChuangxinsiweipeiyangEntity> wrapper);

	List<ChuangxinsiweipeiyangView> selectListView(Pagination page,@Param("ew") Wrapper<ChuangxinsiweipeiyangEntity> wrapper);
	
	ChuangxinsiweipeiyangView selectView(@Param("ew") Wrapper<ChuangxinsiweipeiyangEntity> wrapper);
	

}
