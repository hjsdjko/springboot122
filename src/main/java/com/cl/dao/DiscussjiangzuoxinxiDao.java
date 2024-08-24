package com.cl.dao;

import com.cl.entity.DiscussjiangzuoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussjiangzuoxinxiView;


/**
 * 讲座信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-03-26 15:42:16
 */
public interface DiscussjiangzuoxinxiDao extends BaseMapper<DiscussjiangzuoxinxiEntity> {
	
	List<DiscussjiangzuoxinxiView> selectListView(@Param("ew") Wrapper<DiscussjiangzuoxinxiEntity> wrapper);

	List<DiscussjiangzuoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussjiangzuoxinxiEntity> wrapper);
	
	DiscussjiangzuoxinxiView selectView(@Param("ew") Wrapper<DiscussjiangzuoxinxiEntity> wrapper);
	

}
