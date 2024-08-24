package com.cl.dao;

import com.cl.entity.PingfenxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.PingfenxinxiView;


/**
 * 评分信息
 * 
 * @author 
 * @email 
 * @date 2024-03-26 15:42:16
 */
public interface PingfenxinxiDao extends BaseMapper<PingfenxinxiEntity> {
	
	List<PingfenxinxiView> selectListView(@Param("ew") Wrapper<PingfenxinxiEntity> wrapper);

	List<PingfenxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<PingfenxinxiEntity> wrapper);
	
	PingfenxinxiView selectView(@Param("ew") Wrapper<PingfenxinxiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<PingfenxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<PingfenxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<PingfenxinxiEntity> wrapper);



}
