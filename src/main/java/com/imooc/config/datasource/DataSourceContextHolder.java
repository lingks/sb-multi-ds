package com.imooc.config.datasource;

import com.imooc.enums.DataSourceKey;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class DataSourceContextHolder
{
    public static final ThreadLocal<Object> CONTEXT_HOLDER = ThreadLocal.withInitial(DataSourceKey.masterDataSource::name);
    
    public static final List<Object> slaveDataSourceKeys = new ArrayList<>();
    
    public static List<Object> dataSourceKeys = new ArrayList<>();

    private static Lock lock = new ReentrantLock();
    
    /**
     * 用于轮询计数器
     */
    private static int counter = 0;
    
    public static void useMasterDataSource()
    {
        CONTEXT_HOLDER.set(DataSourceKey.masterDataSource);
    }
    
    /**
     * 当使用只读数据源时通过轮训方式选择
     */
    public static void useSlaveDataSource()
    {
        lock.lock();
        try
        {
            int datasourceKeyIndex = counter % slaveDataSourceKeys.size();
            setConsumerType(String.valueOf(slaveDataSourceKeys.get(datasourceKeyIndex)));
            System.out.println("=============================>当前数据源是：" + slaveDataSourceKeys.get(datasourceKeyIndex));
            counter++;
        }
        catch (Exception e)
        {
            useMasterDataSource();
            e.printStackTrace();
        }
        finally
        {
            lock.unlock();
        }
    }

    public static void addDataSource(String key){
        if(!dataSourceKeys.contains(key)){
            dataSourceKeys.add(key);
        }
    }

    public static void addSlaveDataSource(String key){
        if(!slaveDataSourceKeys.contains(key)){
            slaveDataSourceKeys.add(key);
        }
    }
    public static void setConsumerType(String datasourceKey){
        CONTEXT_HOLDER.set(datasourceKey);
    }
    public static String getDataSource()
    {
        return CONTEXT_HOLDER.get().toString();
    }
    
    public static void clear()
    {
        CONTEXT_HOLDER.remove();
    }
    
}
