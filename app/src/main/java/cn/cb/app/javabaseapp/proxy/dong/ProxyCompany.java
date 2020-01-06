package cn.cb.app.javabaseapp.proxy.dong;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import cn.cb.app.javabaseapp.XLogUtils;

/**
 * ====================================================
 *
 * @User :caobin
 * @Date :2020/1/5 23:14
 * @Desc :代理公司
 * ====================================================
 */
public class ProxyCompany implements InvocationHandler {

    //持有的真实对象
    private Object factory;


    public void setFactory(Object factory) {
        this.factory = factory;
    }

    /**
     * 通过Proxy动态获取代理对象
     */
    public Object getProxyInstance() {
        //参数1 真实对象的类加载器
        //参数2 真实对象的接口
        //参数3 InvocationHandler
        return Proxy.newProxyInstance(factory.getClass().getClassLoader(),
                factory.getClass().getInterfaces(), this);
    }

    /**
     * 后置处理器
     */
    private void doSthAfter() {
        XLogUtils.v("售后一条龙服务");
    }

    /**
     * 前置处理器
     */
    private void doSthBefore() {
        XLogUtils.d("根据需求，进行市场调研");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        doSthBefore();
        Object result = method.invoke(factory, args);
        doSthAfter();
        return result;
    }
}
