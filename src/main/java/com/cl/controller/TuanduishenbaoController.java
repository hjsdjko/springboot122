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

import com.cl.entity.TuanduishenbaoEntity;
import com.cl.entity.view.TuanduishenbaoView;

import com.cl.service.TuanduishenbaoService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 团队申报
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-26 15:42:15
 */
@RestController
@RequestMapping("/tuanduishenbao")
public class TuanduishenbaoController {
    @Autowired
    private TuanduishenbaoService tuanduishenbaoService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TuanduishenbaoEntity tuanduishenbao,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			tuanduishenbao.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<TuanduishenbaoEntity> ew = new EntityWrapper<TuanduishenbaoEntity>();

		PageUtils page = tuanduishenbaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tuanduishenbao), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TuanduishenbaoEntity tuanduishenbao, 
		HttpServletRequest request){
        EntityWrapper<TuanduishenbaoEntity> ew = new EntityWrapper<TuanduishenbaoEntity>();

		PageUtils page = tuanduishenbaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tuanduishenbao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TuanduishenbaoEntity tuanduishenbao){
       	EntityWrapper<TuanduishenbaoEntity> ew = new EntityWrapper<TuanduishenbaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tuanduishenbao, "tuanduishenbao")); 
        return R.ok().put("data", tuanduishenbaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TuanduishenbaoEntity tuanduishenbao){
        EntityWrapper< TuanduishenbaoEntity> ew = new EntityWrapper< TuanduishenbaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tuanduishenbao, "tuanduishenbao")); 
		TuanduishenbaoView tuanduishenbaoView =  tuanduishenbaoService.selectView(ew);
		return R.ok("查询团队申报成功").put("data", tuanduishenbaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TuanduishenbaoEntity tuanduishenbao = tuanduishenbaoService.selectById(id);
		tuanduishenbao = tuanduishenbaoService.selectView(new EntityWrapper<TuanduishenbaoEntity>().eq("id", id));
        return R.ok().put("data", tuanduishenbao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TuanduishenbaoEntity tuanduishenbao = tuanduishenbaoService.selectById(id);
		tuanduishenbao = tuanduishenbaoService.selectView(new EntityWrapper<TuanduishenbaoEntity>().eq("id", id));
        return R.ok().put("data", tuanduishenbao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TuanduishenbaoEntity tuanduishenbao, HttpServletRequest request){
    	tuanduishenbao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tuanduishenbao);
        tuanduishenbaoService.insert(tuanduishenbao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TuanduishenbaoEntity tuanduishenbao, HttpServletRequest request){
    	tuanduishenbao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tuanduishenbao);
        tuanduishenbaoService.insert(tuanduishenbao);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TuanduishenbaoEntity tuanduishenbao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tuanduishenbao);
        tuanduishenbaoService.updateById(tuanduishenbao);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<TuanduishenbaoEntity> list = new ArrayList<TuanduishenbaoEntity>();
        for(Long id : ids) {
            TuanduishenbaoEntity tuanduishenbao = tuanduishenbaoService.selectById(id);
            tuanduishenbao.setSfsh(sfsh);
            tuanduishenbao.setShhf(shhf);
            list.add(tuanduishenbao);
        }
        tuanduishenbaoService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tuanduishenbaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
