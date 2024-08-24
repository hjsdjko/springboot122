package com.cl.entity.view;

import com.cl.entity.PingxuanjieguoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 评选结果
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-26 15:42:16
 */
@TableName("pingxuanjieguo")
public class PingxuanjieguoView  extends PingxuanjieguoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PingxuanjieguoView(){
	}
 
 	public PingxuanjieguoView(PingxuanjieguoEntity pingxuanjieguoEntity){
 	try {
			BeanUtils.copyProperties(this, pingxuanjieguoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
