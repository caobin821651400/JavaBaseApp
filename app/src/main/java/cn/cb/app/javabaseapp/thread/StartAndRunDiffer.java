package cn.cb.app.javabaseapp.thread;

public class StartAndRunDiffer {

    public static void main(String[] args) {
        ThreadRun threadRun = new ThreadRun();
        threadRun.setName("threadRun");
//        threadRun.run();//直接掉RUN方法 打印的name是main，也就是说当前的线程是主线程
        threadRun.start();//打印的name是threadRun，单独的一个线程
    }


    /**
     *
     */
    private static class ThreadRun extends Thread {
        @Override
        public void run() {
            int i = 100;
            while (i > 0) {
                try {
                    Thread.sleep(1000);
                    System.err.println("I am " + Thread.currentThread().getName() + " and this i=" + i--);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 普通的方法
     */
    private static class User {
        public void us() {
            System.err.println("ususus");
        }
    }
}
