package com.cl.dao;

import com.cl.entity.XiangmubisaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiangmubisaiView;


/**
 * 项目比赛
 * 
 * @author 
 * @email 
 * @date 2024-03-26 15:42:15
 */
public interface XiangmubisaiDao extends BaseMapper<XiangmubisaiEntity> {
	
	List<XiangmubisaiView> selectListView(@Param("ew") Wrapper<XiangmubisaiEntity> wrapper);

	List<XiangmubisaiView> selectListView(Pagination page,@Param("ew") Wrapper<XiangmubisaiEntity> wrapper);
	
	XiangmubisaiView selectView(@Param("ew") Wrapper<XiangmubisaiEntity> wrapper);
	

}
