package cn.cb.app.javabaseapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import cn.cb.app.javabaseapp.date1.ReflectionActivity;
import cn.cb.app.javabaseapp.proxy.ProxyActivity;
import cn.cb.app.javabaseapp.thread.ThreadActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //反射
        findViewById(R.id.fanshe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ReflectionActivity.class));
            }
        });

        //代理
        findViewById(R.id.daili).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProxyActivity.class));
            }
        });

        //多线程
        findViewById(R.id.duoxiancheng).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ThreadActivity.class));
            }
        });
    }


}
