package exercise_review;

import util.DzhUtil;

import java.util.Arrays;

/**
 * Date:2019/12/30
 * Author: Dzh
 */
public class Review_12_30
{
    public static void main(String[] args)
    {
        int[] arr = new int[10];
        System.out.println(Arrays.toString(arr));
//        countingSort(arr);
//        System.out.println(Arrays.toString(arr));
    }

    //计数排序 从大到小
    private static void countingSort(int[] arr)
    {
        int n = arr.length;
        if( n <= 1) return;
        int max = arr[0];
        for(int i : arr)
        {
            max = Math.max(max,i);
        }
        int[] countingArr = new int[max+1];
        int[] tempArr = new int[n];
        for(int i: arr)
        {
            countingArr[i]++;
        }
        for (int i = 1; i < countingArr.length; i++)
        {
            countingArr[i] += countingArr[i-1];
        }

        for(int i : arr)
        {
            int index = countingArr[i]-1;
            tempArr[index] = i;
            countingArr[i]--;
        }
        for (int i = 0; i <n ; i++)
        {
              arr[n-1-i]=tempArr[i];
        }
    }
}
