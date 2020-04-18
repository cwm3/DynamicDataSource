//package com.southgis.demo.config;
//
//
//
//import com.southgis.demo.dynamic.DataSourceKey;
//import com.southgis.demo.dynamic.DynamicDataSource;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Map;
//
//
//@Configuration
//public class DynamicDataSourceConfig {
//
//    @Primary
//    @Bean(name = "primary")
//    @ConfigurationProperties(prefix = "spring.datasource.primary")
//    public DataSource defaultDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//
//    @Bean(name = "secondary")
//    @ConfigurationProperties(prefix = "spring.datasource.secondary")
//    public DataSource secondaryDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    /***
//     * 核心动态数据源
//     * @Description: 通过AOP在不同数据源之间动态切换
//     * @param @return
//     * @return DataSource
//     * @throws @throws
//     */
//
//    @Bean(name = "dynamicDataSource")
//    public DataSource dynamicDataSource() {
//        DynamicDataSource dataSource = new DynamicDataSource();
//        dataSource.setDefaultTargetDataSource(defaultDataSource());
//        Map<Object, Object> dataSourceMap = new HashMap<>(2);
//        dataSourceMap.put(DataSourceKey.DB_PRIMARY, defaultDataSource());
//        dataSourceMap.put(DataSourceKey.DB_SECONDARY, secondaryDataSource());
//        dataSource.setTargetDataSources(dataSourceMap);
//        return dataSource;
//    }
//
//    /**
//     * 配置@Transactional注解事物
//     *
//     * @return
//     */
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        return new DataSourceTransactionManager(dynamicDataSource());
//    }
//
//}
