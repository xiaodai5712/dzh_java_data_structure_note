package my;

import data_structure_and_algorithm.Class11;

import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;

public class Second
{
    public String id = "ddd";
    public MyTest2 a;
    public Second()
    {

    }
    //   这个类，是用来看排序代码的
    public static void main(String[] args)
    {
//        System.out.println("请输入一个整数");
//        Scanner scanner = new Scanner(System.in);
//        int k = scanner.nextInt();
//        System.out.println("你输入了：" + k);
//        int[] arr = {7,5,8,6,0,1,4,9,3,2};
//
//        for(int i : arr)
//        {
////            if( i == 0)
////            {
////                System.out.println(i);
////                return;
////            }
//            System.out.print(i + ", ");
//        }
//        ArrayList<String> strings = new ArrayList<>();
////        List<String> s;
////        LinkedList<String> a;
////        AbstractCollection<String> b;
////        String ks = "abcde";
////        System.out.println( ks.indexOf("e"));
////        char ch = ks.charAt(1);
////        System.out.println(ch);
////        String sss  = "012345678";
////        System.out.println(sss.length());
////        System.out.println(sss.substring(sss.length()));
////        LocalDate date = LocalDate.of(2019,12,2);
////        Calendar calendar = Calendar.getInstance();
////
////        System.out.println("exit");
////        NumberFormat numberFormat = NumberFormat.getNumberInstance();

        for(int i = 1; i < 4; i ++)
        {
            System.out.printf("数字是%d",i);
        }
        System.out.println("exit");

        MyTest myTest = new MyTest();
        myTest.printP();

    }

    public static void sort(int[] arr)
    {
        int n = arr.length;
        mergeSort(arr,0,n-1);
    }

    private static void mergeSort(int[] arr, int start,int end)  // start 是数组的起始下标，end是数组的最后一个下标
    {
        if(start >= end) return;
        int midLeft = start + (end - start)/2;
        int midRight = midLeft + 1;
        mergeSort(arr,start,midLeft);
        mergeSort(arr,midRight,end);
        merge(arr,start,midLeft,midRight,end);


    }

    private static void merge(int[] arr,int start,int midLeft,int midRight,int end)
    {
        int[] leftArr = new int[midLeft - start + 2];
        for(int i = 0; i < leftArr.length -1; i++ )
        {
            leftArr[i] = arr[start + i];
        }
        leftArr[leftArr.length-1] = Integer.MAX_VALUE;
        int[] rightArr = new int[end - midRight + 2];
        for(int i = 0; i < rightArr.length - 1; i++)
        {
            rightArr[i] = arr[midRight + i];
        }
        rightArr[rightArr.length - 1] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int k = start;
        while (k <= end)
        {
            if( leftArr[i] <= rightArr[j])
            {
                arr[k++] = leftArr[i++];
            }
            else
            {
                arr[k++] = rightArr[j++];
            }
        }

    }







}

