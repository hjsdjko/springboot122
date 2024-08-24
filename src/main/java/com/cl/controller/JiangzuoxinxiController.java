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

import com.cl.entity.JiangzuoxinxiEntity;
import com.cl.entity.view.JiangzuoxinxiView;

import com.cl.service.JiangzuoxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 讲座信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-26 15:42:15
 */
@RestController
@RequestMapping("/jiangzuoxinxi")
public class JiangzuoxinxiController {
    @Autowired
    private JiangzuoxinxiService jiangzuoxinxiService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiangzuoxinxiEntity jiangzuoxinxi,
		HttpServletRequest request){
        EntityWrapper<JiangzuoxinxiEntity> ew = new EntityWrapper<JiangzuoxinxiEntity>();

		PageUtils page = jiangzuoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiangzuoxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiangzuoxinxiEntity jiangzuoxinxi, 
		HttpServletRequest request){
        EntityWrapper<JiangzuoxinxiEntity> ew = new EntityWrapper<JiangzuoxinxiEntity>();

		PageUtils page = jiangzuoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiangzuoxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiangzuoxinxiEntity jiangzuoxinxi){
       	EntityWrapper<JiangzuoxinxiEntity> ew = new EntityWrapper<JiangzuoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiangzuoxinxi, "jiangzuoxinxi")); 
        return R.ok().put("data", jiangzuoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiangzuoxinxiEntity jiangzuoxinxi){
        EntityWrapper< JiangzuoxinxiEntity> ew = new EntityWrapper< JiangzuoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiangzuoxinxi, "jiangzuoxinxi")); 
		JiangzuoxinxiView jiangzuoxinxiView =  jiangzuoxinxiService.selectView(ew);
		return R.ok("查询讲座信息成功").put("data", jiangzuoxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiangzuoxinxiEntity jiangzuoxinxi = jiangzuoxinxiService.selectById(id);
		jiangzuoxinxi = jiangzuoxinxiService.selectView(new EntityWrapper<JiangzuoxinxiEntity>().eq("id", id));
        return R.ok().put("data", jiangzuoxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiangzuoxinxiEntity jiangzuoxinxi = jiangzuoxinxiService.selectById(id);
		jiangzuoxinxi = jiangzuoxinxiService.selectView(new EntityWrapper<JiangzuoxinxiEntity>().eq("id", id));
        return R.ok().put("data", jiangzuoxinxi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        JiangzuoxinxiEntity jiangzuoxinxi = jiangzuoxinxiService.selectById(id);
        if(type.equals("1")) {
        	jiangzuoxinxi.setThumbsupnum(jiangzuoxinxi.getThumbsupnum()+1);
        } else {
        	jiangzuoxinxi.setCrazilynum(jiangzuoxinxi.getCrazilynum()+1);
        }
        jiangzuoxinxiService.updateById(jiangzuoxinxi);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiangzuoxinxiEntity jiangzuoxinxi, HttpServletRequest request){
    	jiangzuoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiangzuoxinxi);
        jiangzuoxinxiService.insert(jiangzuoxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiangzuoxinxiEntity jiangzuoxinxi, HttpServletRequest request){
    	jiangzuoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiangzuoxinxi);
        jiangzuoxinxiService.insert(jiangzuoxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiangzuoxinxiEntity jiangzuoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiangzuoxinxi);
        jiangzuoxinxiService.updateById(jiangzuoxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiangzuoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
