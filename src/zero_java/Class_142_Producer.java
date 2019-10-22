package zero_java;

import java.util.Queue;

public class Class_142_Producer<T>
{
    private Queue<T>  tasks;
    private int maxTasksCount = 0;
    public Class_142_Producer(Queue<T> tasks,int maxTasksCount)
    {
        this.maxTasksCount = maxTasksCount;
        this.tasks = tasks;
    }

    public void produce(T task) throws InterruptedException
    {
        synchronized (tasks)
        {
            // 如果这个检查不在synchronized代码块中，会怎么样？
            // 如果不用while会怎么样？
            while(tasks.size() >= maxTasksCount)
            {
                System.out.println(String.format("生产者线程：%s 进入等待",Thread.currentThread().getName()));
                tasks.wait();
            }
            tasks.add(task);
            tasks.notifyAll();
        }

    }
}
