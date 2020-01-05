package cn.cb.app.javabaseapp.date1;

import androidx.annotation.NonNull;

import cn.cb.app.javabaseapp.XLogUtils;

public class People {
    String name;
    private int age;
//    protected double sex;


    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public People() {
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

    private void test() {

        XLogUtils.v("4->我是私有方法");
    }

    @NonNull
    @Override
    public String toString() {
        return "name = " + name + "    age = " + age;
    }
}
