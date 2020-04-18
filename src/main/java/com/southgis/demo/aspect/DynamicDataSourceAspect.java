package com.southgis.demo.aspect;


import com.southgis.demo.annotation.TargetDataSource;
import com.southgis.demo.dynamic.DynamicDataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 动态数据源切换切面
 * @author caihua
 * @date 2020-2-27
 * @version 1.0
 */
@Slf4j
@Aspect
@Component
@Order(-1)
public class DynamicDataSourceAspect {

	private Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

	/**
	 * 切换数据源
	 * @param joinPoint
	 * @param targetDataSource
	 */
	@Before("@annotation(targetDataSource)")
	public void changeDataSource(JoinPoint joinPoint, TargetDataSource targetDataSource) {
		String dataSource = targetDataSource.name();

		if (!DynamicDataSourceContextHolder.isContainsDataSource(dataSource)) {
			//joinPoint.getSignature() ：获取连接点的方法签名对象
			logger.error("数据源 " + dataSource + " 不存在使用默认的数据源 -> " + joinPoint.getSignature());
		} else {
			logger.debug("使用数据源：" + dataSource);
			DynamicDataSourceContextHolder.setDataSourceType(dataSource);
		}
	}

	/**
	 * 清除数据源
	 * @param joinPoint
	 * @param targetDataSource
	 */
	@After("@annotation(targetDataSource)")
	public void clearDataSource(JoinPoint joinPoint, TargetDataSource targetDataSource) {
		logger.debug("清除数据源 " + targetDataSource.name() + " !");
		DynamicDataSourceContextHolder.clearDataSourceType();
	}

}
