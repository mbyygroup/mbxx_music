package com.mbxx.base;

import java.util.List;

//基础通用接口
public interface Service<T> {
    //insert
    //保存一个实体，null属性也会保存，不会使用数据库默认值
    T insert(T record);

    //批量插入，null属性也会保存，不会使用数据库默认值
    List<T> insert(List<T> recordList);

    //保存一个实体，null属性也会保存，会使用数据库默认值
    T insertSelective(T record);

    //批量插入，null属性也会保存，会使用数据库默认值
    List<T> insertSelective(List<T> recordList);


    //update
    //根据主键更新实体全部字段，null值会被全部更新
    T update(T record);

    //批量更新,根据主键更新实体全部字段，null值会被全部更新
    List<T> update(List<T> recordList);

    //根据主键更新不为null的值
    T updateSelective(T record);

    //批量更新,根据主键更新不为null的值
    List<T> updateSelective(List<T> recordList);

    //delete
    //根据主键删除
    int delete(Long id);

    //根据逐渐字符串进行删除，类中只能存在一个带有@ID注解的字段
    int delete(String ids);

    //根据主键删除多个实体，id数组
    int delete(Long[] ids);

    //根据实体属性作为条件进行删除
    int delete(T record);

    //根据主键删除多个实体
    int delete(List<T> recordList);


    //insert or update or delete

    T parsist(T record);

    List<T> persist(List<T> recordList);

    T persistSelective(T record);

    List<T>  persistSelective(List<T> recordList);

    //select
    //根据主键查询
    T get(Long id);

    //根据实体中的属性进行查询，只能有一个返回值，有多个结果会抛出异常
    T get(T record);

    //根据字段和值进行查询，返回一个结果
    T get(String key, Object value);

    //根据主键字符串进行查询
    List<T> select(String ids);

    //根据实体中的属性值进行查询
    List<T> select(T record);

     //据属性和值查询
     List<T> select(String key, Object value);

    // 根据实体中的属性值进行分页查询
     List<T> select(T record, int pageNum, int pageSize);


    //查询全部结果
     List<T> selectAll();

    //根据实体中的属性查询总数
     int count(T record);
}
