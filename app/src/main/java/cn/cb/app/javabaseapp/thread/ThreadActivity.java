package cn.cb.app.javabaseapp.thread;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.Callable;

import cn.cb.app.javabaseapp.R;
import cn.cb.app.javabaseapp.XLogUtils;

/**
 * ====================================================
 *
 * @User :caobin
 * @Date :2020/1/6 21:56
 * @Desc :多线程
 * ====================================================
 */
public class ThreadActivity extends AppCompatActivity {

    //并行：同时间允许最多运行的数量
    //并发：一定时间内允许最多运行的数量

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_thread);


        //三种启动方式
        findViewById(R.id.threeType).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                threeType();
            }
        });
    }

    /***
     *
     */
    private void threeType() {
        try {
            //1.直接new Thread()
            UserThread thread1 = new UserThread();
            thread1.start();//只能调一次 再掉一次会报错
            Thread.sleep(5);
            thread1.interrupt();

//            //2.实现Runnable接口
//            new Thread(new MRunAble()).start();
//
//            //3.
//            MCallBack mCallBack = new MCallBack();
//            FutureTask<String> futureTask = new FutureTask(mCallBack);
//            new Thread(futureTask).start();
//            XLogUtils.v(futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /***
     * 第一种方式
     */
    private class UserThread extends Thread {
        @Override
        public void run() {
            super.run();
            XLogUtils.d("状态->" + isInterrupted());
            //通过isInterrupted来结束线程
            //Thread.interrupted()和isInterrupted的区别
            //第一个结束后不会重置中断标志位(false->false) ** 第二个会(false->true)
            while (!isInterrupted()) {
                XLogUtils.d("我是第一种启动线程的方式");
            }
            XLogUtils.d("状态->" + isInterrupted());
        }
    }

    /***
     * 第二种方式
     */
    private class MRunAble implements Runnable {

        @Override
        public void run() {
            XLogUtils.e("我是第二种启动线程的方式");
        }
    }

    /**
     * 第三种实现Callable接口
     */
    private class MCallBack implements Callable<String> {
        @Override
        public String call() throws Exception {
            XLogUtils.i("我是第三种启动线程的方式");
            return "我是第三种方式的返回值";
        }
    }
}
