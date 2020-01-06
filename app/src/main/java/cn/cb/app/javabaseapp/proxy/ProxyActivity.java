package cn.cb.app.javabaseapp.proxy;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import cn.cb.app.javabaseapp.R;
import cn.cb.app.javabaseapp.proxy.dong.ProxyCompany;

public class ProxyActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxy);

        //静态代理
        findViewById(R.id.jingtaidaili).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ManToolsFactory factory = new AaFactory();
                ProxyObject proxyObject = new ProxyObject(factory);
                proxyObject.saleManTools("D");
            }
        });


        //动态代理
        findViewById(R.id.dongtaidaili).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ManToolsFactory factory = new AaFactory();
                ProxyCompany proxyCompany = new ProxyCompany();
                proxyCompany.setFactory(factory);
                //张三来买用品
                ManToolsFactory employeeA = (ManToolsFactory) proxyCompany.getProxyInstance();
                employeeA.saleManTools("E");
            }
        });
        //动态代理2
        findViewById(R.id.dongtaidaili2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WomanToolsFactory factory = new BbFactory();
                ProxyCompany proxyCompany = new ProxyCompany();
                proxyCompany.setFactory(factory);
                //张三老婆来买用品
                WomanToolsFactory employeeB = (WomanToolsFactory) proxyCompany.getProxyInstance();
                employeeB.saleWomanTools("50厘米");
            }
        });
    }
}
