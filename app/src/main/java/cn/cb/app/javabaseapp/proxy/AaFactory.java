package cn.cb.app.javabaseapp.proxy;

import cn.cb.app.javabaseapp.XLogUtils;

/**
 * ====================================================
 *
 * @User :caobin
 * @Date :2020/1/5 22:50
 * @Desc :具体的工厂
 * ====================================================
 */
public class AaFactory implements ManToolsFactory {

    @Override
    public void saleManTools(String size) {
        XLogUtils.e("按照需求定制一个size为" + size + "的充气女朋友");
    }
}
