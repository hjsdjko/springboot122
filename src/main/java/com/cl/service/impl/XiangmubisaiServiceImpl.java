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


import com.cl.dao.XiangmubisaiDao;
import com.cl.entity.XiangmubisaiEntity;
import com.cl.service.XiangmubisaiService;
import com.cl.entity.view.XiangmubisaiView;

@Service("xiangmubisaiService")
public class XiangmubisaiServiceImpl extends ServiceImpl<XiangmubisaiDao, XiangmubisaiEntity> implements XiangmubisaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiangmubisaiEntity> page = this.selectPage(
                new Query<XiangmubisaiEntity>(params).getPage(),
                new EntityWrapper<XiangmubisaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiangmubisaiEntity> wrapper) {
		  Page<XiangmubisaiView> page =new Query<XiangmubisaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XiangmubisaiView> selectListView(Wrapper<XiangmubisaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiangmubisaiView selectView(Wrapper<XiangmubisaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
