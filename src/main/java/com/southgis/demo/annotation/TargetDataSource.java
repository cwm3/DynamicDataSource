package com.southgis.demo.annotation;

import java.lang.annotation.*;

/**
 * 在方法上使用，用于指定使用哪个数据源
 * @author caihua
 * @date 2020-2-27
 * @version 1.0
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {

	String name();
}

