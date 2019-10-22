package zero_java;

public class Class136
{
    public static void main(String[] args)
    {
        try
        {
            printSlowly("我是一个人见人爱，花见花开，车间车爆胎的好孩子\n" + "……",300);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    static void printSlowly(String text,long interval) throws Exception
    {
        char[] chars = text.toCharArray();
        for(char c : chars)
        {
            Thread.sleep(interval);
            System.out.print(c);
        }
        System.out.println();
    }

}
