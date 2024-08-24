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


import com.cl.dao.TuanduishenbaoDao;
import com.cl.entity.TuanduishenbaoEntity;
import com.cl.service.TuanduishenbaoService;
import com.cl.entity.view.TuanduishenbaoView;

@Service("tuanduishenbaoService")
public class TuanduishenbaoServiceImpl extends ServiceImpl<TuanduishenbaoDao, TuanduishenbaoEntity> implements TuanduishenbaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TuanduishenbaoEntity> page = this.selectPage(
                new Query<TuanduishenbaoEntity>(params).getPage(),
                new EntityWrapper<TuanduishenbaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TuanduishenbaoEntity> wrapper) {
		  Page<TuanduishenbaoView> page =new Query<TuanduishenbaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<TuanduishenbaoView> selectListView(Wrapper<TuanduishenbaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TuanduishenbaoView selectView(Wrapper<TuanduishenbaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
