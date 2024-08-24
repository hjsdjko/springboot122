package com.cl.dao;

import com.cl.entity.PingxuanjieguoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.PingxuanjieguoView;


/**
 * 评选结果
 * 
 * @author 
 * @email 
 * @date 2024-03-26 15:42:16
 */
public interface PingxuanjieguoDao extends BaseMapper<PingxuanjieguoEntity> {
	
	List<PingxuanjieguoView> selectListView(@Param("ew") Wrapper<PingxuanjieguoEntity> wrapper);

	List<PingxuanjieguoView> selectListView(Pagination page,@Param("ew") Wrapper<PingxuanjieguoEntity> wrapper);
	
	PingxuanjieguoView selectView(@Param("ew") Wrapper<PingxuanjieguoEntity> wrapper);
	

}
