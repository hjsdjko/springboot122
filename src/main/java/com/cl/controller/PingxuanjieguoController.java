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

import com.cl.entity.PingxuanjieguoEntity;
import com.cl.entity.view.PingxuanjieguoView;

import com.cl.service.PingxuanjieguoService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 评选结果
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-26 15:42:16
 */
@RestController
@RequestMapping("/pingxuanjieguo")
public class PingxuanjieguoController {
    @Autowired
    private PingxuanjieguoService pingxuanjieguoService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PingxuanjieguoEntity pingxuanjieguo,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			pingxuanjieguo.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<PingxuanjieguoEntity> ew = new EntityWrapper<PingxuanjieguoEntity>();

		PageUtils page = pingxuanjieguoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, pingxuanjieguo), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PingxuanjieguoEntity pingxuanjieguo, 
		HttpServletRequest request){
        EntityWrapper<PingxuanjieguoEntity> ew = new EntityWrapper<PingxuanjieguoEntity>();

		PageUtils page = pingxuanjieguoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, pingxuanjieguo), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PingxuanjieguoEntity pingxuanjieguo){
       	EntityWrapper<PingxuanjieguoEntity> ew = new EntityWrapper<PingxuanjieguoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( pingxuanjieguo, "pingxuanjieguo")); 
        return R.ok().put("data", pingxuanjieguoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PingxuanjieguoEntity pingxuanjieguo){
        EntityWrapper< PingxuanjieguoEntity> ew = new EntityWrapper< PingxuanjieguoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( pingxuanjieguo, "pingxuanjieguo")); 
		PingxuanjieguoView pingxuanjieguoView =  pingxuanjieguoService.selectView(ew);
		return R.ok("查询评选结果成功").put("data", pingxuanjieguoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PingxuanjieguoEntity pingxuanjieguo = pingxuanjieguoService.selectById(id);
		pingxuanjieguo = pingxuanjieguoService.selectView(new EntityWrapper<PingxuanjieguoEntity>().eq("id", id));
        return R.ok().put("data", pingxuanjieguo);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PingxuanjieguoEntity pingxuanjieguo = pingxuanjieguoService.selectById(id);
		pingxuanjieguo = pingxuanjieguoService.selectView(new EntityWrapper<PingxuanjieguoEntity>().eq("id", id));
        return R.ok().put("data", pingxuanjieguo);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PingxuanjieguoEntity pingxuanjieguo, HttpServletRequest request){
    	pingxuanjieguo.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(pingxuanjieguo);
        pingxuanjieguoService.insert(pingxuanjieguo);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PingxuanjieguoEntity pingxuanjieguo, HttpServletRequest request){
    	pingxuanjieguo.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(pingxuanjieguo);
        pingxuanjieguoService.insert(pingxuanjieguo);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PingxuanjieguoEntity pingxuanjieguo, HttpServletRequest request){
        //ValidatorUtils.validateEntity(pingxuanjieguo);
        pingxuanjieguoService.updateById(pingxuanjieguo);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        pingxuanjieguoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
