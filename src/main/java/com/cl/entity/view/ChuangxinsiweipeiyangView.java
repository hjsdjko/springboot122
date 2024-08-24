package com.cl.entity.view;

import com.cl.entity.ChuangxinsiweipeiyangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 创新思维培养
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-26 15:42:16
 */
@TableName("chuangxinsiweipeiyang")
public class ChuangxinsiweipeiyangView  extends ChuangxinsiweipeiyangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ChuangxinsiweipeiyangView(){
	}
 
 	public ChuangxinsiweipeiyangView(ChuangxinsiweipeiyangEntity chuangxinsiweipeiyangEntity){
 	try {
			BeanUtils.copyProperties(this, chuangxinsiweipeiyangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
