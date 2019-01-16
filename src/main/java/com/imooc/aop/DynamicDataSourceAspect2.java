//package com.imooc.aop;
//
//import com.imooc.config.datasource.DataSourceContextHolder;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//import java.util.logging.Logger;
//
///**
// * @author：linsheng@viomi.com.cn
// * @createtime ： 2019-01-16 11:38
// * @description TODO 描述
// */
//@Aspect
//@Component
//public class DynamicDataSourceAspect2 {
//
//    private final String[] QUERY_PREFIX = {"select"};
//
//    @Pointcut("execution( * com.imooc.service..*.*(..))")
//    public void daoAspect() {
//    }
//
//    @Before("daoAspect()")
//    public void switchDataSource(JoinPoint point) {
//        Boolean isQueryMethod = isQueryMethod(point.getSignature().getName());
//        DataSourceContextHolder.useSlaveDataSource();
//    }
//
//    @After("daoAspect())")
//    public void restoreDataSource(JoinPoint point) {
//        DataSourceContextHolder.clear();
//    }
//
//    private Boolean isQueryMethod(String methodName) {
//        for (String prefix : QUERY_PREFIX) {
//            if (methodName.startsWith(prefix)) {
//                return true;
//            }
//        }
//        return false;
//    }
//}
