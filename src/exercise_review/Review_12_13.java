package exercise_review;

import util.DzhUtil;

/**
 * Date: 2019/12/13 Time: 16:03
 * author: Dzh
 */
public class Review_12_13<T>
{
    public static void main(String[] args)
    {
        int[] arr = DzhUtil.generateRandomArr(1000000,300);
        long t1 = System.currentTimeMillis();
        countingSort(arr);
        long t2 = System.currentTimeMillis() - t1;
        System.out.println("耗时 = " + t2);
    }

    // 计数排序
    private static void countingSort(int[] arr)
    {
        int n = arr.length;
        if(n <= 1) return;
        // 1 取到数组的最大值,构建计数数组
        int maxValue = arr[0];
        for (int i = 1; i < n ; i++)
        {
            if(arr[i] > maxValue) maxValue = arr[i];
        }
        int[] countingArr = new int[maxValue +1];

        // 2 初始化计数数组
        for (int i = 0; i < n ; i++)
        {
            countingArr[arr[i] ]++;
        }

        for (int i = 1; i < countingArr.length ; i++)
        {
            countingArr[i] = countingArr[i] + countingArr[i-1];
        }

        // 3 根据计数排序的思想，将排好序的数据存入 临时数组
        int[] tempArr = new int[n];
        for (int i = 0; i < n ; i++)
        {
            int index = countingArr[arr[i]] ;
            tempArr[index-1] = arr[i];
            countingArr[arr[i]]--;
        }

        // 5 将临时数组中已经排好序的数字，传回原数组
        System.arraycopy(tempArr, 0, arr, 0, n);
    }
}
