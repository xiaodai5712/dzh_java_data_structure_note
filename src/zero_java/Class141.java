package zero_java;

import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

public class Class141
{
    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("当前线程为：" + Thread.currentThread().getName());
        Object locker = new Object();
        int workingSec = 2;  // 设定睡眠时间，2秒
        int threadCount = 5; // 共5个线程
        for(int i = 0; i < threadCount; i ++)
        {
            Thread thread = new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    System.out.println(getName() + ": 线程开始");
                    try
                    {
                        synchronized (locker)
                        {
                            System.out.println(getName() + ": 将模拟工作2秒");
                            sleepSec(workingSec); // 代表线程在工作
                            System.out.println(getName() + ": 将进入等待状态"); // 哪个线程输出了这句话，就代码其进入了synchronized代码块
                            // wait 方法必须在进入相应对象的synchronized 块中才能调用
                            // 执行 wait 方法之后，自动失去对象的monitor，也就是说其他线程可以进入这个对象的synchronized代码块了
                            locker.wait();
                            // 被唤醒的线程，就相当于执行完了wait方法，开始向下执行
                            // 如果wait不是synchronized代码块中的最后一行，那么第一件事就是“排队”获取之前失去monitor 这里的monitor与locker 锁 是一个意思
                            // 排队加“”是因为synchronized是非公平的，也就是说，不是谁先等待谁先获得
                            System.out.println(getName() + ": 线程继续……");
                            sleepSec(2);
                            System.out.println(getName() + ": 结束" );
                        }
                    }catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            },"工作线程：" + i);
            thread.start();
        }

        // 如果 notify/notifyAll 在wait之前，会怎么样？
        System.out.println("-----------主线程开始sleep-------------");
        // 如果执行notify/的时候，线程还没有进入wait状态，那么notify 是没有效果的
        //  先notify，后进入wait,就是所谓的 lost notification问题，可能造成线程无法进行
        // 止损陈这么说，是因为 synchronized 还是阻碍了notify的执行，但是notify有机会在wait之前执行了
        sleepSec(workingSec -1);
        System.out.println("------------主线程sleep结束------------");
        synchronized(locker)
        {
            // notify/notifyAll 方法必须在进入相应对象的synchronized 块中，才能调用
            System.out.println("------------准备开始唤醒所有------------");
            System.out.println("先睡5秒");
            sleepSec(4);
            locker.notifyAll();

//            for(int i = 0; i < threadCount; i ++)
//            {
//                System.out.println("------------开始逐个唤醒-------------");
//                locker.notify();
//            }

        }
        System.out.println("exit");
    }
    private static void sleepSec(int sec)
    {
        try
        {
            Thread.sleep(TimeUnit.SECONDS.toMillis(sec));
        }catch (InterruptedException e)
        {
            e.printStackTrace(); // 打印站轨迹
        }
    }
    private static String getName()
    {
        return Thread.currentThread().getName();
    }
}
