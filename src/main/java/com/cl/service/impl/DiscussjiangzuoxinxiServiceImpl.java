package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.DiscussjiangzuoxinxiDao;
import com.cl.entity.DiscussjiangzuoxinxiEntity;
import com.cl.service.DiscussjiangzuoxinxiService;
import com.cl.entity.view.DiscussjiangzuoxinxiView;

@Service("discussjiangzuoxinxiService")
public class DiscussjiangzuoxinxiServiceImpl extends ServiceImpl<DiscussjiangzuoxinxiDao, DiscussjiangzuoxinxiEntity> implements DiscussjiangzuoxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussjiangzuoxinxiEntity> page = this.selectPage(
                new Query<DiscussjiangzuoxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussjiangzuoxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussjiangzuoxinxiEntity> wrapper) {
		  Page<DiscussjiangzuoxinxiView> page =new Query<DiscussjiangzuoxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussjiangzuoxinxiView> selectListView(Wrapper<DiscussjiangzuoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussjiangzuoxinxiView selectView(Wrapper<DiscussjiangzuoxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
