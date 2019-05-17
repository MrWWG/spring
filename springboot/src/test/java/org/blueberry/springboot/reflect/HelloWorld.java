package org.blueberry.springboot.reflect;

/**
 * @program: spring
 * @description: 测试类
 * @author: wind
 * @create: 2019-05-08 08:51
 **/
public class HelloWorld  extends HelloWorldFather implements InterfaceTest{

    private long id;
    private String name;

    @Override
    public void testA() {
        System.out.println("21312312213");
    }

    private int age;
    private double score;

    public HelloWorld(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public HelloWorld(long id, String name, int age, double score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
