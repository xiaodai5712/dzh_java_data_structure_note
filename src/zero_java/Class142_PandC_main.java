package zero_java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Class142_PandC_main
{
    public static Object LOCKER = new Object();

    public static void main(String[] args)
    {
        Queue<String> urls = new LinkedList<>();

        Class_142_Consumer<String> consumer = new Class_142_Consumer<>(urls);
        Class_142_Producer<String> producer = new Class_142_Producer<>(urls,1024);
        for(int i = 0; i < 100; i ++ )
        {
            Thread consumerThread = new Thread(()->
            {
                while(true)
                {
                    try
                    {
                        String url = consumer.consume();
                        processURL(url);

                    }catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            },"消费者: " + i);
            consumerThread.start();
        }
        for(int i = 0; i < 3; i ++)
        {
            Thread producerThread = new Thread(()->
            {
                while(true)
                {
                    try
                    {
                        String url = produceRUL();
                        producer.produce(url);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            },"消费者: " + i);
            producerThread.start();
        }

    }
    private static String produceRUL()
    {
        // 每次产生一条URL
        StringBuilder ret = new StringBuilder();
        ret.append("www.");
        for(int i = 0; i < 6;i ++)
        {
            int rand = ((int)(Math.random() * 1000)) % 26;
            char ch = (char) (rand + 'a');
            ret.append(ch);
        }
        ret.append(".com");
        return ret.toString();
    }

    private static void processURL(String url) throws InterruptedException
    {
        System.out.println("开始处理：" + url + "时长2秒");
        Thread.sleep(TimeUnit.SECONDS.toMillis(2));
        System.out.println(String.format("%s已处理完成",url));

    }
}
