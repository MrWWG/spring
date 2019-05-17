package org.blueberry.springboot.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @program: spring
 * @description: 反射
 * @author: wind
 * @create: 2019-05-08 08:56
 **/
public class ReflectTest {

    /**
     * 获取类对象
     * @return
     * @throws Exception
     */
    public static Class getClasss(String className) throws Exception{
        if(className.isEmpty()){
            return null;
        }
        Class aClass =  Class.forName(className);
        System.out.println("类名(包含包名)：" + aClass.getName());
        System.out.println("类名：" + aClass.getSimpleName());
        System.out.println("父类名：" + aClass.getSuperclass().getSimpleName());

        //无参构造函数默认是私有的，通过下例实例化类会抛异常java.lang.InstantiationException,需要把无参构造函数转为public
        //HelloWorld helloWorld = (HelloWorld) aClass.newInstance();
        //System.out.println("实例化类：" + helloWorld.getName());
        return aClass;
    }

    /**
     * 构造函数
     */
    public static Constructor[] constructor() throws Exception{
        Class aClass = getClasss("org.blueberry.springboot.reflect.HelloWorld");
        //获取public的constructor
        Constructor[] constructors = aClass.getConstructors();
        System.out.println("所有的构造函数：" + constructors.toString());
        Constructor constructor = aClass.getConstructor(new Class[]{long.class,String.class,int.class});
        System.out.println("构造函数的名称：" + constructor.getName());
        HelloWorld helloWorld = (HelloWorld) constructor.newInstance(new Object[]{1,"SSSSS",1});
        System.out.println("通过构造函数实例化一个类：" + helloWorld.getName());
        return constructors;

    }

    /**
     * 成员变量
     * @return
     * @throws Exception
     */
    public static Field[] field() throws Exception{
        Class mClass = getClasss("org.blueberry.springboot.reflect.HelloWorld");
        Field[] fields = mClass.getFields();
        System.out.println("获取所有的成员变量：" + fields.toString());
        return fields;
    }

    public static void main(String[] args) throws Exception  {
        constructor();
        field();
    }


}
