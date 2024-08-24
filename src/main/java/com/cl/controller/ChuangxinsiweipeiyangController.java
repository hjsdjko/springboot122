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

import com.cl.entity.ChuangxinsiweipeiyangEntity;
import com.cl.entity.view.ChuangxinsiweipeiyangView;

import com.cl.service.ChuangxinsiweipeiyangService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 创新思维培养
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-26 15:42:16
 */
@RestController
@RequestMapping("/chuangxinsiweipeiyang")
public class ChuangxinsiweipeiyangController {
    @Autowired
    private ChuangxinsiweipeiyangService chuangxinsiweipeiyangService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChuangxinsiweipeiyangEntity chuangxinsiweipeiyang,
		HttpServletRequest request){
        EntityWrapper<ChuangxinsiweipeiyangEntity> ew = new EntityWrapper<ChuangxinsiweipeiyangEntity>();

		PageUtils page = chuangxinsiweipeiyangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chuangxinsiweipeiyang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChuangxinsiweipeiyangEntity chuangxinsiweipeiyang, 
		HttpServletRequest request){
        EntityWrapper<ChuangxinsiweipeiyangEntity> ew = new EntityWrapper<ChuangxinsiweipeiyangEntity>();

		PageUtils page = chuangxinsiweipeiyangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chuangxinsiweipeiyang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChuangxinsiweipeiyangEntity chuangxinsiweipeiyang){
       	EntityWrapper<ChuangxinsiweipeiyangEntity> ew = new EntityWrapper<ChuangxinsiweipeiyangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chuangxinsiweipeiyang, "chuangxinsiweipeiyang")); 
        return R.ok().put("data", chuangxinsiweipeiyangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChuangxinsiweipeiyangEntity chuangxinsiweipeiyang){
        EntityWrapper< ChuangxinsiweipeiyangEntity> ew = new EntityWrapper< ChuangxinsiweipeiyangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chuangxinsiweipeiyang, "chuangxinsiweipeiyang")); 
		ChuangxinsiweipeiyangView chuangxinsiweipeiyangView =  chuangxinsiweipeiyangService.selectView(ew);
		return R.ok("查询创新思维培养成功").put("data", chuangxinsiweipeiyangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChuangxinsiweipeiyangEntity chuangxinsiweipeiyang = chuangxinsiweipeiyangService.selectById(id);
		chuangxinsiweipeiyang = chuangxinsiweipeiyangService.selectView(new EntityWrapper<ChuangxinsiweipeiyangEntity>().eq("id", id));
        return R.ok().put("data", chuangxinsiweipeiyang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChuangxinsiweipeiyangEntity chuangxinsiweipeiyang = chuangxinsiweipeiyangService.selectById(id);
		chuangxinsiweipeiyang = chuangxinsiweipeiyangService.selectView(new EntityWrapper<ChuangxinsiweipeiyangEntity>().eq("id", id));
        return R.ok().put("data", chuangxinsiweipeiyang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChuangxinsiweipeiyangEntity chuangxinsiweipeiyang, HttpServletRequest request){
    	chuangxinsiweipeiyang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chuangxinsiweipeiyang);
        chuangxinsiweipeiyangService.insert(chuangxinsiweipeiyang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChuangxinsiweipeiyangEntity chuangxinsiweipeiyang, HttpServletRequest request){
    	chuangxinsiweipeiyang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chuangxinsiweipeiyang);
        chuangxinsiweipeiyangService.insert(chuangxinsiweipeiyang);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChuangxinsiweipeiyangEntity chuangxinsiweipeiyang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chuangxinsiweipeiyang);
        chuangxinsiweipeiyangService.updateById(chuangxinsiweipeiyang);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chuangxinsiweipeiyangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
