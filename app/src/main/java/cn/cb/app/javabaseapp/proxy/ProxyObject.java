package cn.cb.app.javabaseapp.proxy;

import cn.cb.app.javabaseapp.XLogUtils;

/**
 * ====================================================
 *
 * @User :caobin
 * @Date :2020/1/6 12:42
 * @Desc :代理工厂
 * ====================================================
 */
public class ProxyObject implements ManToolsFactory {

    public ManToolsFactory factory;

    public ProxyObject(ManToolsFactory factory) {
        this.factory = factory;
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
    public void saleManTools(String size) {
        doSthBefore();
        //只是代理，真正的还是去掉工厂的方法
        factory.saleManTools(size);
        doSthAfter();
    }
}
