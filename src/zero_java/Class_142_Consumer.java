package zero_java;

import java.util.Queue;
import java.util.function.Consumer;

public class Class_142_Consumer<T>
{
    private Queue<T>  tasks;
    public Class_142_Consumer (Queue<T> tasks)
    {
        this.tasks = tasks;
    }
    public T consume() throws InterruptedException
    {
        synchronized(tasks)
        {
            while(tasks.size() == 0)
            {
                System.out.println(String.format("消费者线程%s进入等待",Thread.currentThread().getName())); // 注意这个String 占位符的用法
                tasks.wait(); // 此时，wait（）方法将会释放锁
            }
            T ret = tasks.poll(); // 从队首poll出任务ret
            tasks.notifyAll(); // 再将其他的线程唤醒
            return ret;
        }
    }
}
