package my;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import java_basal_konwledge.TxtFileTest;

import java.io.Serializable;
import java.sql.Time;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

public class MyTest  extends  MyTest2 implements Serializable
{
    static Integer count = 0;
    public static void main(String[] args)
    {
        // 运行的快剪辑 Ctrl Shift F10
//        int[] arr = new int[200];

        int [] arr1 = {1,3,4,5,6,9,11};
//        for(int i = 0;i < arr.length;i ++)
//        {
//            arr[i] = i + 1;
//            System.out.print(arr[i] + ", ");
//
//        }
//        System.out.println();
//        for (int i : arr)
//        {
//            System.out.print(i + ", ");
//        }
//        System.out.println();
//        System.out.println(search(arr,200));
//        int k = factorial(5);
//        System.out.println(k);
//        for(int j : arr1)
//        {
//
//            int i = searchTwo(arr1,j);
//            System.out.println("a[" + i + "] = " + j  );
//        }
//        SortedSet<TxtFileTest.Student> stu = new TreeSet<>();
//        long a = Integer.MAX_VALUE;
//        System.out.println(a);
//        Integer aa  = new Integer(2);
//        int mmm = aa;
//        for(int i : arr1)
//        {
//            if(i == 3)
//            {
//                continue;
//            }
//            System.out.println(i);
//        }


        Thread threadA = new Thread(() ->
        {
            System.out.println(Thread.currentThread().getName() + "开始");
               for(int i = count ; i < 30; i++)
               {
                   try
                   {
                       Thread.sleep(500);
                   } catch (InterruptedException e)
                   {
                       e.printStackTrace();
                   }
                   System.out.print(count++ + ",");
               }
               System.out.println();
               System.out.println("工作线程exit");
        },"二狗子");
        while (count <= 50)
        {

            try
            {
                Thread.sleep(200);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.print(count + ",");
                count ++;
                if(count == 20)
                {
                    System.out.println();
                    System.out.println("工作线程开始");
                    threadA.start();
                    try
                    {
                        System.out.println("主线程等待");
                        threadA.join();
                        System.out.println("主线程继续工作");

                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
        }

    }



    // dzh: 实现二分查找
    private static int search(int[] arr, int key)
    {
        int head = 0;
        int end = arr.length - 1;
        int mid = (head + end)/2;
        int count = -1;
        for(int i = 0; i < getLogarithm(arr.length); i ++)
        {
            System.out.println("总循环次数 =  " +getLogarithm(arr.length) + " i = " + i);
            System.out.println("循环第 " + (i+1) + " 次");
            System.out.println(arr[head]+  "   " + arr[end]);
            // 检查两边是否对应
            if((arr[head] == key) || (arr[end] ==key))
            {
                if(arr[head] == key)
                {
                    count = head + 1;
                    break;
                }
                else
                {
                    count = end + 1;
                    break;
                }
            }
            else
            {
                if(key == arr[mid])
                {
                    count = mid + 1;
                    break;
                }
                else if (key < arr[mid])
                {
                    end = mid;
                    mid  = (head + end)/2;

                }
                else
                {
                    head = mid;
                    mid = (head + end)/2;
                }
            }

        }
        return count;

   }

   // 写法更加简洁的二分查找
    private static int searchTwo(int[] arr, int value)
    {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high)
        {
            int mid = low + (high - low)/2;
            if(arr[mid] == value)
            {
                return  mid;
            }
            else if (arr[mid] > value)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return  -1;
    }


   // 实现任意对数
   private static double getLogarithm(double a)
   {
       return Math.log(a)/Math.log(2);
   }

   // 实现阶乘
    private static int factorial(int x)
    {
        System.out.println("开始运算: " + x + " 的阶乘");
        if(x == 1)
        {
            return 1;
        }
        else
        {
            System.out.println(x + "的阶乘= " + x * factorial(x -1));
            return  x * factorial(x -1);
        }

    }


    public MyTest()
    {
        System.out.println("来自MyTest");
    }



}
