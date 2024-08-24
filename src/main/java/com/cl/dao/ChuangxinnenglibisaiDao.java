package com.cl.dao;

import com.cl.entity.ChuangxinnenglibisaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChuangxinnenglibisaiView;


/**
 * 创新能力比赛
 * 
 * @author 
 * @email 
 * @date 2024-03-26 15:42:16
 */
public interface ChuangxinnenglibisaiDao extends BaseMapper<ChuangxinnenglibisaiEntity> {
	
	List<ChuangxinnenglibisaiView> selectListView(@Param("ew") Wrapper<ChuangxinnenglibisaiEntity> wrapper);

	List<ChuangxinnenglibisaiView> selectListView(Pagination page,@Param("ew") Wrapper<ChuangxinnenglibisaiEntity> wrapper);
	
	ChuangxinnenglibisaiView selectView(@Param("ew") Wrapper<ChuangxinnenglibisaiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ChuangxinnenglibisaiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ChuangxinnenglibisaiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ChuangxinnenglibisaiEntity> wrapper);



}
