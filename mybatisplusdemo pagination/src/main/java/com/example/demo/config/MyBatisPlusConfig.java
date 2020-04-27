package com.example.demo.config;

/**
 * @author licha
 * @since 2020/4/21 9:43
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

/**
 * MybatisPlus配置类
 */
@Configuration
public class MyBatisPlusConfig {

    /**
     * 分页插件
     * 或者在mybatis-config.xml配置：
     * 	<plugins>
     *		<!-- mybatisplus分页拦截器 -->
     *		<plugin interceptor="com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor">
     * 		</plugin>
     * 	</plugins>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }
    /**
     * 自定义sql注入器
     * 或者application.properties配置：
     * mybatis-plus.globalConfig.sqlInjector=com.javasgj.springboot.mybatisplus.config.GeneralMybatisPlusSqlInjector
     */
    /*@Bean
    public ISqlInjector iSqlInjector() {

        return new GeneralMybatisPlusSqlInjector();
    }*/

    /**
     * sql性能分析插件，输出sql语句及所需时间
     */
    /*@Bean
    @Profile({"dev","test"})// 设置 dev test 环境开启
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }*/

    /**
     * 乐观锁插件
     */
    /*@Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }*/
}
