package com.cl.entity.view;

import com.cl.entity.JiangzuoxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 讲座信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-26 15:42:15
 */
@TableName("jiangzuoxinxi")
public class JiangzuoxinxiView  extends JiangzuoxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiangzuoxinxiView(){
	}
 
 	public JiangzuoxinxiView(JiangzuoxinxiEntity jiangzuoxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, jiangzuoxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
