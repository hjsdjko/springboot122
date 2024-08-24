package com.cl.dao;

import com.cl.entity.BisaibaomingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BisaibaomingView;


/**
 * 比赛报名
 * 
 * @author 
 * @email 
 * @date 2024-03-26 15:42:16
 */
public interface BisaibaomingDao extends BaseMapper<BisaibaomingEntity> {
	
	List<BisaibaomingView> selectListView(@Param("ew") Wrapper<BisaibaomingEntity> wrapper);

	List<BisaibaomingView> selectListView(Pagination page,@Param("ew") Wrapper<BisaibaomingEntity> wrapper);
	
	BisaibaomingView selectView(@Param("ew") Wrapper<BisaibaomingEntity> wrapper);
	

}
