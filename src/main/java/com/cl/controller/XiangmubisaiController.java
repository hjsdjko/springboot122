package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.XiangmubisaiEntity;
import com.cl.entity.view.XiangmubisaiView;

import com.cl.service.XiangmubisaiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 项目比赛
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-26 15:42:15
 */
@RestController
@RequestMapping("/xiangmubisai")
public class XiangmubisaiController {
    @Autowired
    private XiangmubisaiService xiangmubisaiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiangmubisaiEntity xiangmubisai,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			xiangmubisai.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XiangmubisaiEntity> ew = new EntityWrapper<XiangmubisaiEntity>();

		PageUtils page = xiangmubisaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiangmubisai), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XiangmubisaiEntity xiangmubisai, 
		HttpServletRequest request){
        EntityWrapper<XiangmubisaiEntity> ew = new EntityWrapper<XiangmubisaiEntity>();

		PageUtils page = xiangmubisaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiangmubisai), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiangmubisaiEntity xiangmubisai){
       	EntityWrapper<XiangmubisaiEntity> ew = new EntityWrapper<XiangmubisaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiangmubisai, "xiangmubisai")); 
        return R.ok().put("data", xiangmubisaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiangmubisaiEntity xiangmubisai){
        EntityWrapper< XiangmubisaiEntity> ew = new EntityWrapper< XiangmubisaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiangmubisai, "xiangmubisai")); 
		XiangmubisaiView xiangmubisaiView =  xiangmubisaiService.selectView(ew);
		return R.ok("查询项目比赛成功").put("data", xiangmubisaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiangmubisaiEntity xiangmubisai = xiangmubisaiService.selectById(id);
		xiangmubisai = xiangmubisaiService.selectView(new EntityWrapper<XiangmubisaiEntity>().eq("id", id));
        return R.ok().put("data", xiangmubisai);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiangmubisaiEntity xiangmubisai = xiangmubisaiService.selectById(id);
		xiangmubisai = xiangmubisaiService.selectView(new EntityWrapper<XiangmubisaiEntity>().eq("id", id));
        return R.ok().put("data", xiangmubisai);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XiangmubisaiEntity xiangmubisai, HttpServletRequest request){
    	xiangmubisai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiangmubisai);
        xiangmubisaiService.insert(xiangmubisai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XiangmubisaiEntity xiangmubisai, HttpServletRequest request){
    	xiangmubisai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiangmubisai);
        xiangmubisaiService.insert(xiangmubisai);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XiangmubisaiEntity xiangmubisai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiangmubisai);
        xiangmubisaiService.updateById(xiangmubisai);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<XiangmubisaiEntity> list = new ArrayList<XiangmubisaiEntity>();
        for(Long id : ids) {
            XiangmubisaiEntity xiangmubisai = xiangmubisaiService.selectById(id);
            xiangmubisai.setSfsh(sfsh);
            xiangmubisai.setShhf(shhf);
            list.add(xiangmubisai);
        }
        xiangmubisaiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xiangmubisaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
