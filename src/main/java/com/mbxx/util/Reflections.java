package com.mbxx.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

//反射工具类
public abstract class Reflections {

    private static Logger logger= LoggerFactory.getLogger(Reflections.class);

    //通过反射，获得Class定义中声明的泛型参数的类型，泛型类型
    //必须定义在父类中，如无法找到，返回Object.class
    @SuppressWarnings("unchecked")
    public static Class getClassGenericType(final Class clazz){
        return getClassGenericType(clazz,0);
    }

    public static Class getClassGenericType(final Class clazz,final int index){
        Type genType = clazz.getGenericSuperclass();

        if(!(genType instanceof ParameterizedType)){
            return Object.class;
        }

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        if(index >=params.length||index <0){
            logger.warn("Index: " + index + ", Size of " + clazz.getSimpleName() + "'s Parameterized Type: " + params.length);
            return Object.class;
        }
        if(!(params[index] instanceof Class)){
            logger.warn(clazz.getSimpleName() + " not set the actual class on superclass generic parameter");
            return Object.class;
        }

        return (Class) params[index];
    }

    //根据注解类型获取实体的Field
    @SuppressWarnings("unchecked")
    public static Field getFieldByAnnotation(Class entityClass,Class annotationClass){
        Field[] fields=entityClass.getDeclaredFields();
        for (Field field:fields){
            if(field.getAnnotation(annotationClass) !=null){
                makeAccessible(field);
                return field;
            }
        }
        return null;
    }

    //获取实体字段
    public static Field getField(Class entityClass,String fieldName){
        try {
            Field field=entityClass.getDeclaredField(fieldName);
            makeAccessible(field);
            return field;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    //改变private/protected的成员变量为public
    public static void makeAccessible(Field field){
        if(!Modifier.isPublic(field.getModifiers())||
        !Modifier.isPublic(field.getDeclaringClass().getModifiers())){
            field.setAccessible(true);
        }

    }

}
