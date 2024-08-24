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

import com.cl.entity.ChuangxinnenglibisaiEntity;
import com.cl.entity.view.ChuangxinnenglibisaiView;

import com.cl.service.ChuangxinnenglibisaiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 创新能力比赛
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-26 15:42:16
 */
@RestController
@RequestMapping("/chuangxinnenglibisai")
public class ChuangxinnenglibisaiController {
    @Autowired
    private ChuangxinnenglibisaiService chuangxinnenglibisaiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChuangxinnenglibisaiEntity chuangxinnenglibisai,
		HttpServletRequest request){
        EntityWrapper<ChuangxinnenglibisaiEntity> ew = new EntityWrapper<ChuangxinnenglibisaiEntity>();

		PageUtils page = chuangxinnenglibisaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chuangxinnenglibisai), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChuangxinnenglibisaiEntity chuangxinnenglibisai, 
		HttpServletRequest request){
        EntityWrapper<ChuangxinnenglibisaiEntity> ew = new EntityWrapper<ChuangxinnenglibisaiEntity>();

		PageUtils page = chuangxinnenglibisaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chuangxinnenglibisai), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChuangxinnenglibisaiEntity chuangxinnenglibisai){
       	EntityWrapper<ChuangxinnenglibisaiEntity> ew = new EntityWrapper<ChuangxinnenglibisaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chuangxinnenglibisai, "chuangxinnenglibisai")); 
        return R.ok().put("data", chuangxinnenglibisaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChuangxinnenglibisaiEntity chuangxinnenglibisai){
        EntityWrapper< ChuangxinnenglibisaiEntity> ew = new EntityWrapper< ChuangxinnenglibisaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chuangxinnenglibisai, "chuangxinnenglibisai")); 
		ChuangxinnenglibisaiView chuangxinnenglibisaiView =  chuangxinnenglibisaiService.selectView(ew);
		return R.ok("查询创新能力比赛成功").put("data", chuangxinnenglibisaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChuangxinnenglibisaiEntity chuangxinnenglibisai = chuangxinnenglibisaiService.selectById(id);
		chuangxinnenglibisai = chuangxinnenglibisaiService.selectView(new EntityWrapper<ChuangxinnenglibisaiEntity>().eq("id", id));
        return R.ok().put("data", chuangxinnenglibisai);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChuangxinnenglibisaiEntity chuangxinnenglibisai = chuangxinnenglibisaiService.selectById(id);
		chuangxinnenglibisai = chuangxinnenglibisaiService.selectView(new EntityWrapper<ChuangxinnenglibisaiEntity>().eq("id", id));
        return R.ok().put("data", chuangxinnenglibisai);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChuangxinnenglibisaiEntity chuangxinnenglibisai, HttpServletRequest request){
    	chuangxinnenglibisai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chuangxinnenglibisai);
        chuangxinnenglibisaiService.insert(chuangxinnenglibisai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChuangxinnenglibisaiEntity chuangxinnenglibisai, HttpServletRequest request){
    	chuangxinnenglibisai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chuangxinnenglibisai);
        chuangxinnenglibisaiService.insert(chuangxinnenglibisai);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChuangxinnenglibisaiEntity chuangxinnenglibisai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chuangxinnenglibisai);
        chuangxinnenglibisaiService.updateById(chuangxinnenglibisai);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chuangxinnenglibisaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	





    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<ChuangxinnenglibisaiEntity> ew = new EntityWrapper<ChuangxinnenglibisaiEntity>();
        List<Map<String, Object>> result = chuangxinnenglibisaiService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<ChuangxinnenglibisaiEntity> ew = new EntityWrapper<ChuangxinnenglibisaiEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = chuangxinnenglibisaiService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<ChuangxinnenglibisaiEntity> ew = new EntityWrapper<ChuangxinnenglibisaiEntity>();
        List<Map<String, Object>> result = chuangxinnenglibisaiService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<ChuangxinnenglibisaiEntity> ew = new EntityWrapper<ChuangxinnenglibisaiEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = chuangxinnenglibisaiService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<ChuangxinnenglibisaiEntity> ew = new EntityWrapper<ChuangxinnenglibisaiEntity>();
        List<Map<String, Object>> result = chuangxinnenglibisaiService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,ChuangxinnenglibisaiEntity chuangxinnenglibisai, HttpServletRequest request){
        EntityWrapper<ChuangxinnenglibisaiEntity> ew = new EntityWrapper<ChuangxinnenglibisaiEntity>();
        int count = chuangxinnenglibisaiService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chuangxinnenglibisai), params), params));
        return R.ok().put("data", count);
    }


}
