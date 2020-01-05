package cn.cb.app.javabaseapp.date1;

import cn.cb.app.javabaseapp.XLogUtils;

public class People {
    private String name;
    int age;


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
}
