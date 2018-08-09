package com.mbxx.base;


import com.github.pagehelper.PageHelper;
import com.mbxx.constants.Constants;
import com.mbxx.exception.UpdateFailedException;
import com.mbxx.util.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.util.Assert;

import javax.annotation.PostConstruct;
import javax.persistence.Id;
import java.lang.reflect.Field;
import java.util.List;

//基础service实现类
public abstract class BaseService<T> implements Service<T> {

    @Autowired
    private Mapper<T> mapper;

    private Class<T> entityClass;

    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init(){
        this.entityClass= Reflections.getClassGenericType(getClass());
    }

    //insert
    @Transactional(rollbackFor = Exception.class)
    public T insert(T record) {
        mapper.insert(record);
        return record;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<T> insert(List<T> recordList) {
        mapper.insertList(recordList);
        return recordList;
    }

    @Transactional(rollbackFor = Exception.class)
    public T insertSelective(T record) {
        mapper.insertSelective(record);
        return record;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<T> insertSelective(List<T> recordList) {
        //因为mapper暂未提供selectiive的批量擦汗如，此处循环实现
        for(T record:recordList){
            mapper.insertSelective(record);
        }
        return recordList;
    }

    //update
    @Transactional(rollbackFor = Exception.class)
    public T update(T record) {
        int count=mapper.updateByPrimaryKey(record);
        checkUpdate(count,record);
        return record;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<T> update(List<T> recordList) {
    //mapper未提供批量更新，这里循环实现
        for (T record:recordList){
            int count=mapper.updateByPrimaryKey(record);
            checkUpdate(count,record);
        }
        return recordList;
    }

    @Transactional(rollbackFor = Exception.class)
    public T updateSelective(T record) {
        int count=mapper.updateByPrimaryKeySelective(record);
        checkUpdate(count,record);
        return record;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<T> updateSelective(List<T> recordList) {
        for (T record:recordList){
            int count=mapper.updateByPrimaryKeySelective(record);
            checkUpdate(count,record);
        }
        return recordList;
    }

    @Transactional(rollbackFor = Exception.class)
    public int delete(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public int delete(String ids) {
        return mapper.deleteByIds(ids);
    }

    @Transactional(rollbackFor = Exception.class)
    public int delete(Long[] ids) {
        int count=0;
        for(Long id:ids){
            mapper.deleteByPrimaryKey(id);
            count++;
        }
        return count;
    }

    @Transactional(rollbackFor = Exception.class)
    public int delete(T record) {
        return mapper.delete(record);
    }

    @Transactional(rollbackFor = Exception.class)
    public int delete(List<T> recordList) {
        int count=0;
        for(T record:recordList){
            mapper.delete(record);
            count++;
        }
        return count;
    }

    @Transactional(rollbackFor = Exception.class)
    public T parsist(T record) {
        BaseDTO dto=(BaseDTO) record;
        Assert.notNull(dto.get_operate(),"_operate not be null,");
        switch (dto.get_operate()){
            case Constants
                    .Operation.ADD:
                insert(record);
            break;
            case Constants.Operation.UPDATE:
                update(record);
                break;
            case Constants.Operation.DELETE:
                delete(record);
                break;
                default:
                    break;

        }
        dto.set_operate(null);
        return record;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<T> persist(List<T> recordList) {
        for (T record:recordList){
            BaseDTO dto=(BaseDTO) record;
            Assert.notNull(dto.get_operate(),"_operate not be null,");
            switch (dto.get_operate()){
                case Constants
                        .Operation.ADD:
                    insert(record);
                    break;
                case Constants.Operation.UPDATE:
                    update(record);
                    break;
                case Constants.Operation.DELETE:
                    delete(record);
                    break;
                default:
                    break;

            }
            dto.set_operate(null);
        }
        return recordList;
    }

    @Transactional(rollbackFor = Exception.class)
    public T persistSelective(T record) {
        BaseDTO dto=(BaseDTO) record;
        Assert.notNull(dto.get_operate(),"_operate not be null,");
        switch (dto.get_operate()){
            case Constants
                    .Operation.ADD:
                insert(record);
                break;
            case Constants.Operation.UPDATE:
                update(record);
                break;
            case Constants.Operation.DELETE:
                delete(record);
                break;
            default:
                break;

        }
        return record;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<T> persistSelective(List<T> recordList) {
        for (T record:recordList){
            BaseDTO dto=(BaseDTO) record;
            Assert.notNull(dto.get_operate(),"_operate not be null,");
            switch (dto.get_operate()){
                case Constants
                        .Operation.ADD:
                    insert(record);
                    break;
                case Constants.Operation.UPDATE:
                    update(record);
                    break;
                case Constants.Operation.DELETE:
                    delete(record);
                    break;
                default:
                    break;

            }
        }
        return recordList;
    }

    @Transactional(rollbackFor = Exception.class)
    public T get(Long id) {
        T entity=null;
        try {
            entity=entityClass.newInstance();
            Field idField=Reflections.getFieldByAnnotation(entityClass, Id.class);
            idField.set(entity,id);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return mapper.selectByPrimaryKey(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public T get(T record) {
        return mapper.selectOne(record);
    }

    @Transactional(rollbackFor = Exception.class)
    public T get(String key, Object value) {
        T entity=null;
        try {
            entity=entityClass.newInstance();
            Field field=Reflections.getField(entityClass,key);
            assert field != null;
            field.set(entity,value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return mapper.selectOne(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<T> select(String ids) {
        return mapper.selectByIds(ids);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<T> select(T record) {
        return mapper.select(record);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<T> select(String key, Object value) {
        T entity=null;
        try {
            entity=entityClass.newInstance();
            Field field=Reflections.getField(entityClass,key);
            field.set(entity,value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return mapper.select(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<T> select(T record, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return mapper.select(record);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public int count(T record) {
        return mapper.selectCount(record);
    }

    //检查乐观锁
    //更新失败时抛出UpdateFailedException
    protected void checkUpdate(int updateCount,Object record){
        if(updateCount == 0 && record instanceof BaseDTO){
            BaseDTO baseDTO=(BaseDTO) record;
            if(baseDTO.getVersionNumber() !=null){
                throw new UpdateFailedException();
            }
        }
    }
}
