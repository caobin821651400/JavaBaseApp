package cn.cb.app.javabaseapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import cn.cb.app.javabaseapp.date1.People;

public class MainActivity extends AppCompatActivity {

    private String space = "\n  ";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        method();
    }


    /**
     * 获取方法相关
     */
    private void method() {

        try {
            Class clazz = Class.forName("cn.cb.app.javabaseapp.date1.People");

            //1.获取class中所有方法，不能获取private的方法，且父类的方法也能获取到
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                XLogUtils.d("1->" + method.getName() + space);
            }

            //2.获取class中所有方法，包括private的方法，且只能获取到当前类的
            Method[] methods1 = clazz.getDeclaredMethods();
            for (Method method : methods1) {
                XLogUtils.e("2->" + method.getName() + space);
            }

            //实例化对象
            People object = (People) clazz.newInstance();

            //3.获取指定的方法,int必须传int.class不需要传包装类
            Method method = clazz.getDeclaredMethod("setName", String.class);
            Method method2 = clazz.getDeclaredMethod("setAge", int.class);
            method.invoke(object, "曹斌");
            method2.invoke(object, 24);
            XLogUtils.i("3->" + object.getName() + object.getAge());
            XLogUtils.i("3->" + method.toString() + space + "int方法->" + method2.toString() + space);

            //4.调用private方法,必须设置setAccessible(true)
            Method method3 = clazz.getDeclaredMethod("test");
            XLogUtils.d("4->" + method3.toString());
            method3.setAccessible(true);
            method3.invoke(object);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取类相关
     */
    private void clzz() {
        try {
            //1.获取所有的构造方法
            Class cla1 = Class.forName("cn.cb.app.javabaseapp.date1.People");
            Constructor<People>[] constructors = cla1.getConstructors();

            for (Constructor<People> constructor : constructors) {
                XLogUtils.e("1->" + constructor.toString());
            }

            //2.获取指定的构造方法
            Constructor<People> constructor2 = cla1.getConstructor(String.class, int.class);
            XLogUtils.d("2->" + constructor2.toString());

            //3.获取到构造方法后实例化对象
            People people = constructor2.newInstance("曹斌", 24);
            XLogUtils.i("3->" + people.getName() + people.getAge());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
