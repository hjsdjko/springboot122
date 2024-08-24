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


import com.cl.dao.ChuangxinnenglibisaiDao;
import com.cl.entity.ChuangxinnenglibisaiEntity;
import com.cl.service.ChuangxinnenglibisaiService;
import com.cl.entity.view.ChuangxinnenglibisaiView;

@Service("chuangxinnenglibisaiService")
public class ChuangxinnenglibisaiServiceImpl extends ServiceImpl<ChuangxinnenglibisaiDao, ChuangxinnenglibisaiEntity> implements ChuangxinnenglibisaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChuangxinnenglibisaiEntity> page = this.selectPage(
                new Query<ChuangxinnenglibisaiEntity>(params).getPage(),
                new EntityWrapper<ChuangxinnenglibisaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChuangxinnenglibisaiEntity> wrapper) {
		  Page<ChuangxinnenglibisaiView> page =new Query<ChuangxinnenglibisaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ChuangxinnenglibisaiView> selectListView(Wrapper<ChuangxinnenglibisaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChuangxinnenglibisaiView selectView(Wrapper<ChuangxinnenglibisaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<ChuangxinnenglibisaiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<ChuangxinnenglibisaiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<ChuangxinnenglibisaiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
