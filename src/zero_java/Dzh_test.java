package zero_java;

import my.MyTest2;
import my.Second;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.zip.DeflaterOutputStream;

public class Dzh_test extends MyTest2
{
    public static void main(String[] args)
    {
        System.out.println("输出毫秒单位的时间：" + System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        System.out.println("输出calendar "+calendar);
        Date date = calendar.getTime();
        System.out.println("输出date：" + date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd  HH:mm:ss ");
        String d = simpleDateFormat.format(date);
        System.out.println("输出格式化后的时间 system模式 ："+ simpleDateFormat.format(System.currentTimeMillis()));
        System.out.println("输出格式化后的时间 ：date 模式"+ simpleDateFormat.format(date));
        Date date1 = new Date();
        System.out.println(simpleDateFormat.format(date1));
        Second second = new Second();
        System.out.println(second.id);
        

    }
    public  void test()
    {
        MyTest2 my = new MyTest2();
        Dzh_test dzh_test = new Dzh_test();
        printP();
        ThreadLocal<String> pa = new ThreadLocal<>();
        My my1 = new My();
        my1.dose();
    }
    private  class My
    {
        private int a;
        private void dose()
        {

        }
    }
}
