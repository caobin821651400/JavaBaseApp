package cn.cb.app.javabaseapp.proxy;

import cn.cb.app.javabaseapp.XLogUtils;

/**
 * ====================================================
 *
 * @User :caobin
 * @Date :2020/1/5 22:50
 * @Desc :具体的商品
 * ====================================================
 */
public class BbFactory implements WomanToolsFactory {


    @Override
    public void saleWomanTools(String lenght) {
        XLogUtils.e("我要买一个长度为" + lenght + "的假发");
    }
}
