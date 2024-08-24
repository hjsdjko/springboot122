package com.cl.dao;

import com.cl.entity.JiangzuoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiangzuoxinxiView;


/**
 * 讲座信息
 * 
 * @author 
 * @email 
 * @date 2024-03-26 15:42:15
 */
public interface JiangzuoxinxiDao extends BaseMapper<JiangzuoxinxiEntity> {
	
	List<JiangzuoxinxiView> selectListView(@Param("ew") Wrapper<JiangzuoxinxiEntity> wrapper);

	List<JiangzuoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<JiangzuoxinxiEntity> wrapper);
	
	JiangzuoxinxiView selectView(@Param("ew") Wrapper<JiangzuoxinxiEntity> wrapper);
	

}
