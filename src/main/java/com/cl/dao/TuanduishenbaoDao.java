package com.cl.dao;

import com.cl.entity.TuanduishenbaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TuanduishenbaoView;


/**
 * 团队申报
 * 
 * @author 
 * @email 
 * @date 2024-03-26 15:42:15
 */
public interface TuanduishenbaoDao extends BaseMapper<TuanduishenbaoEntity> {
	
	List<TuanduishenbaoView> selectListView(@Param("ew") Wrapper<TuanduishenbaoEntity> wrapper);

	List<TuanduishenbaoView> selectListView(Pagination page,@Param("ew") Wrapper<TuanduishenbaoEntity> wrapper);
	
	TuanduishenbaoView selectView(@Param("ew") Wrapper<TuanduishenbaoEntity> wrapper);
	

}
