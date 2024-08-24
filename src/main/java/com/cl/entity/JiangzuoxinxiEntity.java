package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 讲座信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-26 15:42:15
 */
@TableName("jiangzuoxinxi")
public class JiangzuoxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JiangzuoxinxiEntity() {
		
	}
	
	public JiangzuoxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 讲座名称
	 */
					
	private String jiangzuomingcheng;
	
	/**
	 * 封面
	 */
					
	private String fengmian;
	
	/**
	 * 开始时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date kaishishijian;
	
	/**
	 * 视频
	 */
					
	private String shipin;
	
	/**
	 * 讲师名称
	 */
					
	private String jiangshimingcheng;
	
	/**
	 * 讲座地点
	 */
					
	private String jiangzuodidian;
	
	/**
	 * 讲座详情
	 */
					
	private String jiangzuoxiangqing;
	
	/**
	 * 赞
	 */
					
	private Integer thumbsupnum;
	
	/**
	 * 踩
	 */
					
	private Integer crazilynum;
	
	/**
	 * 收藏数量
	 */
					
	private Integer storeupnum;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：讲座名称
	 */
	public void setJiangzuomingcheng(String jiangzuomingcheng) {
		this.jiangzuomingcheng = jiangzuomingcheng;
	}
	/**
	 * 获取：讲座名称
	 */
	public String getJiangzuomingcheng() {
		return jiangzuomingcheng;
	}
	/**
	 * 设置：封面
	 */
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
	/**
	 * 设置：开始时间
	 */
	public void setKaishishijian(Date kaishishijian) {
		this.kaishishijian = kaishishijian;
	}
	/**
	 * 获取：开始时间
	 */
	public Date getKaishishijian() {
		return kaishishijian;
	}
	/**
	 * 设置：视频
	 */
	public void setShipin(String shipin) {
		this.shipin = shipin;
	}
	/**
	 * 获取：视频
	 */
	public String getShipin() {
		return shipin;
	}
	/**
	 * 设置：讲师名称
	 */
	public void setJiangshimingcheng(String jiangshimingcheng) {
		this.jiangshimingcheng = jiangshimingcheng;
	}
	/**
	 * 获取：讲师名称
	 */
	public String getJiangshimingcheng() {
		return jiangshimingcheng;
	}
	/**
	 * 设置：讲座地点
	 */
	public void setJiangzuodidian(String jiangzuodidian) {
		this.jiangzuodidian = jiangzuodidian;
	}
	/**
	 * 获取：讲座地点
	 */
	public String getJiangzuodidian() {
		return jiangzuodidian;
	}
	/**
	 * 设置：讲座详情
	 */
	public void setJiangzuoxiangqing(String jiangzuoxiangqing) {
		this.jiangzuoxiangqing = jiangzuoxiangqing;
	}
	/**
	 * 获取：讲座详情
	 */
	public String getJiangzuoxiangqing() {
		return jiangzuoxiangqing;
	}
	/**
	 * 设置：赞
	 */
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
	/**
	 * 设置：踩
	 */
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}
	/**
	 * 设置：收藏数量
	 */
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	/**
	 * 获取：收藏数量
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}

}
