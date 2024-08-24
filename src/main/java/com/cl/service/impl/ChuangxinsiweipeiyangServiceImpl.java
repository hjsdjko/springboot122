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


import com.cl.dao.ChuangxinsiweipeiyangDao;
import com.cl.entity.ChuangxinsiweipeiyangEntity;
import com.cl.service.ChuangxinsiweipeiyangService;
import com.cl.entity.view.ChuangxinsiweipeiyangView;

@Service("chuangxinsiweipeiyangService")
public class ChuangxinsiweipeiyangServiceImpl extends ServiceImpl<ChuangxinsiweipeiyangDao, ChuangxinsiweipeiyangEntity> implements ChuangxinsiweipeiyangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChuangxinsiweipeiyangEntity> page = this.selectPage(
                new Query<ChuangxinsiweipeiyangEntity>(params).getPage(),
                new EntityWrapper<ChuangxinsiweipeiyangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChuangxinsiweipeiyangEntity> wrapper) {
		  Page<ChuangxinsiweipeiyangView> page =new Query<ChuangxinsiweipeiyangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ChuangxinsiweipeiyangView> selectListView(Wrapper<ChuangxinsiweipeiyangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChuangxinsiweipeiyangView selectView(Wrapper<ChuangxinsiweipeiyangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
