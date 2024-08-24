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


import com.cl.dao.PingxuanjieguoDao;
import com.cl.entity.PingxuanjieguoEntity;
import com.cl.service.PingxuanjieguoService;
import com.cl.entity.view.PingxuanjieguoView;

@Service("pingxuanjieguoService")
public class PingxuanjieguoServiceImpl extends ServiceImpl<PingxuanjieguoDao, PingxuanjieguoEntity> implements PingxuanjieguoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PingxuanjieguoEntity> page = this.selectPage(
                new Query<PingxuanjieguoEntity>(params).getPage(),
                new EntityWrapper<PingxuanjieguoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PingxuanjieguoEntity> wrapper) {
		  Page<PingxuanjieguoView> page =new Query<PingxuanjieguoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<PingxuanjieguoView> selectListView(Wrapper<PingxuanjieguoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PingxuanjieguoView selectView(Wrapper<PingxuanjieguoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
