package data_structure_and_algorithm;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.ArrayList;

public class Class13_linear_sort
{
    // 数据结构与算法之美 第十三节:桶排序 计数排序 基数排序
    public static void main(String[] args)
    {
        int[] a = {2,5,3,0,2,3,0,3,3,4,1,3};
        for(int i : CountingSort(a))
        {
            System.out.print(i + " ,");
        }


    }

    /*
    dzh: 记数排序
     */
    private static int[] CountingSort(int[]arr) // key代表数组中数据的范围
    {

        if(arr.length <= 1) return arr;

        // 获取数组arr中的最大值
        int max = arr[arr.length-1];
        for(int i = 0; i < arr.length -1; i ++)
        {
            if(arr[i] > max)
            {
                max = arr[i];
            }
        }
        int[] c = new int[max+1];
        int[] targetArr = new int[arr.length];

         for(int i = 0; i < c.length; i ++)
        {
            int count = 0;
            for(int j : arr)
            {
                if(j == i)
                {
                    count ++;
                }
            }
            if(i != 0)
            {
                c[i] = count + c[i-1];
            }
            else
            {
                c[i] = count;
            }
        }

         for(int j : arr)
         {
             targetArr[c[j]-1] = j;
             c[j] --;
         }

        return targetArr;
    }

    public static<T> void getPair(ArrayList<T> t)
    // static 后面的<T> 是一个泛型方法的声明，如果没有这句，后面方法中泛型参数将没有意义，并且编译器会报错
    {

    }
    private interface test
    {
        void get();
    }
    private interface test1 extends test
    {
        void set();
    }

    // 桶排序 bucketSize 桶容量
    public static void bucketSort(int[] arr, int bucketSize)
    {

    }

    // 数组扩容
    private static void ensureCapacity(int[][] buckets, int bucketIndex)
    {

    }

    // 快速排序
    private static void quickSort()
    {

    }

    // 基数排序
    public void radixSort(int[] arr)
    {
        int max = arr[0];
        for (int i = 0; i < arr.length ; i++)
        {
            if(arr[i] > max)
            {
                max = arr[i];
            }
        }

        // 从各位开始，按位数对数组的整数进行排序
        for (int exp = 0; max/exp > 0 ; exp *= 10)
        {
            countSort(arr,exp);
        }
    }

    private void countSort(int[] arr, int exp)
    {
        int n = arr.length;
        if(n <= 1) return;
        int[] tempArr = new int[n];
        //计算每个元素的个数
        int[] c = new int[10];
        for (int i = 0; i < arr.length ; i++)
        {
            c[(arr[i]/exp)%10] ++;
        }

        // 计算排序后的位置
        for (int i = 1; i < c.length; i++)
        {
            c[i] = c[i] + c[i-1];
        }

        // 临时数组 r ，储存排序之后的结果
        int[] r = new int[arr.length];
        for (int i = 0; i < arr.length ; i++)
        {
            int index = c[(arr[i]/exp)%10] -1;
            r[index] = arr[i];
            c[(arr[i]/exp)%10]--;
        }

        // 将临时数组中的数，copy回arr
        System.arraycopy(r,0,arr,0,arr.length);
    }

}
