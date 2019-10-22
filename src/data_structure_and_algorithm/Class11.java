package data_structure_and_algorithm;

import java.sql.SQLOutput;

public class Class11
{
    // 数据结构与算法中的第11节课
    public static void main(String[] args)
    {
        int[] arr = {5,4,1,9,6,3,2,7,0,8};
        int[] arr1 = selectSort(arr);
        for(int i : arr1)
        {
            System.out.print(i + ",");
        }


    }

    // 选择排序算法
    private static int[] selectSort(int[] arr)
    {
        for(int i = 0;i < arr.length -1; i ++)
        {
            int j = arr.length -2;
            int temp;
            int min = arr[arr.length - 1];
            int count = arr.length - 1;
            // find de min in the unsorted numbers
            for(; j > i; j --)
            {
                if(arr[j] > min)
                {
                    min = arr[j];
                    count = j;
                }
            }
            temp = arr[i];
            arr[i] = min;
            arr[count]  = temp;
        }
        System.out.println("bingo");
        return arr;

    }
    // 冒泡排序,从大到小
    private static int[] bubbleSort(int[] arr)
    {
//        int[] arr1 = new int[arr.length];

        for(int i = 0; i < arr.length; i ++)
        {
            for(int j = arr.length-1; j > i; j --)
            {
                int temp ;
                if(arr[j] > arr[j-1])
                {
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        return arr;

    }
    // 插入排序，a 表示数组，n 表示数组大小
    private static void insertionSort(int[] a, int n)
    {
        if (n <= 1) return;  // 只有一个数的时候，退出方法

        for (int i = 1; i < n; ++i) // 第一个数已经排完，所以 i = 1,
        {
            int value = a[i];
            int j = i - 1;  // 从已经排完序的数中查找位置
            // 查找插入的位置
            for (; j >= 0; --j)
            {
                if (a[j] > value)
                {
                    a[j+1] = a[j];  // 数据移动
                }
                else
                {
                    break;
                }
            }
            a[j+1] = value; // 插入数据
        }
    }

}
