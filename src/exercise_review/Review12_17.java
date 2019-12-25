package exercise_review;

import data_structure_and_algorithm.CountSort;
import util.DzhUtil;

import java.util.Arrays;

/**
 * Date:2019/12/17
 * Author: Dzh
 */
public class Review12_17
{
    public static void main(String[] args)
    {
        int[] arr = DzhUtil.generateRandomArr(50,100);
        System.out.println(Arrays.toString(arr));
        countingSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    // 插入排序  从小到大
    public static void insertSort(int[] arr)
    {
        int n = arr.length;
        if(n <= 1) return;
        for (int i = 1; i < n; i++)
        {
            int value = arr[i];
            int j = i-1;
            for (; j >= 0; j--)
            {
                if(arr[j] > value)
                {
                    arr[j+1] = arr[j];
                }
                else
                {
                    break; // 这一步是必须得有的，它涉及到J的值
                }
            }
            arr[j+1] = value;
        }
    }

    // 计数排序
    public static void countingSort(int[] arr)
    {
        int n = arr.length;
        if(n <= 1) return;

        int maxValue = arr[0];
        for(int value : arr)
        {
            if(value > maxValue) maxValue = value;
        }
        int[] countArr = new int[maxValue+1];
        int[] tempArr = new int[n];
        for(int value : arr)
        {
            countArr[value]++;
        }
        for (int i = 1; i < countArr.length; i++)
        {
            countArr[i]+= countArr[i-1];
        }
        for (int value : arr)
        {
            int index = countArr[value]-1;
            tempArr[index] = value;
            countArr[value]--;
        }

        System.arraycopy(tempArr,0,arr,0,n);

    }
}
