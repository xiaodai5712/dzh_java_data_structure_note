package exercise_review;

import util.DzhUtil;

import java.util.Arrays;

/**
 * Date:2019/12/19
 * Author: Dzh
 */
public class Review_12_19
{
    public static void main(String[] args)
    {
        int[] arr = DzhUtil.generateRandomArr(50,100);
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 选择排序
    private static void selectionSort(int[] arr)
    {
        int n = arr.length;
        if(n <= 1) return;
        for (int i = 0; i < n-1 ; i++)
        {
            int minIndex = i;
            for (int j = i+1; j < n ; j++)
            {
                if(arr[j] < arr[minIndex])
                {
                    minIndex = j;
                }
            }
            swap(arr,minIndex,i);
        }
    }

    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 冒泡排序
    private static void bubbleSort(int[] arr)
    {
        int n = arr.length;
        if(n <= 1) return;
        for (int i = 0; i < n-1; i++)
        {
            boolean flag = false;
            for (int j =0 ; j <n-i-1; j++)
            {
                if(arr[j] > arr[j+1])
                {
                    swap(arr,j,j+1);
                }
                flag = true;
            }
            if (!flag) break;
        }
    }
}
