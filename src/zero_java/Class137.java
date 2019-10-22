package zero_java;

public class Class137
{
    private static final String Text = "太阳在这个平成的小村庄缓缓升起，又开始了平成的一天。我们故事的主人公睡眼惺忪的起床\n" + "……";

    public static void main(String[] args)
    {
        System.out.println("线程开始，执行线程的名字叫做" + Thread.currentThread().getName());

        for(int i = 1; i <= 2; i ++)
        {
            // 学习创建线程的方法,Runnable接口的里面的run()是线程的执行的方法，执行完毕线程就是结束了
            System.out.println("要创建新的线程了");
            Thread t = new Thread(new PrintStoryRunnable(Text,200 * i),"我的线程：" + i);
            t.start();
            System.out.println("线程started");
        }
        System.out.println("启动线程结束，名字叫做：" + Thread.currentThread().getName());
    }

    public static class PrintStoryRunnable implements Runnable
    {
        private String text;
        private long interval;
        PrintStoryRunnable(String text, long interval)
        {
            this.text = text;
            this.interval = interval;
        }
        @Override
        public void run()
        {
            try
            {
                double num = Math.random();
                System.out.println("执行这段代码的线程叫做: " + Thread.currentThread().getName());
                printSlowly(text,interval);
                System.out.println(Thread.currentThread().getName() + "线程执行结束");
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }

        }
    }
    public static  void printSlowly(String text,long interval) throws InterruptedException
    {
        for(char ch: text.toCharArray())
        {
            Thread.sleep(interval);
            System.out.print(ch);
        }
        System.out.println();
    }

}
