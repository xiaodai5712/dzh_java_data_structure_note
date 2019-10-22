package JavaCore;

public class Chapter14
{
    public static void main(String[] args)
    {
        Runnable r = new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("begin");
            }
        };
        Thread t = new Thread(r);
        t.start();
    }
}
