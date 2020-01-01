package exercise_review;

import util.DzhUtil;

import javax.sound.midi.MidiDevice;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;

/**
 * Date:2019/12/28
 * Author: Dzh
 */
public class Review_12_28
{
    // 桶排序 从大到小 和归并排序
    public static void main(String[] args)
    {
        int[] arr = DzhUtil.generateRandomArr(50,40);
        System.out.println(Arrays.toString(arr));
        bucketSort(arr,3);
        System.out.println(Arrays.toString(arr));
    }

    private static void bucketSort(int[] arr,int bucketSize)
    {
        // 创建并初始化各个参数
        int n = arr.length;
        if(n <= 1) return;
        Integer[] a = new Integer[n];
        for (int i = 0; i <n ; i++)
        {
            a[i] = arr[i];
        }
        int max = DzhUtil.findMax(a);
        int min = DzhUtil.findMin(a);
        int bucketCount = (max - min) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][bucketSize];
        int[] count = new int[bucketCount];

        // 将数组中的各个数分配到各个桶中

        for (int i = 0; i < n; i++)
        {
            int bucketIndex = (arr[i]-min)/ bucketSize;
            if (count[bucketIndex] >= buckets[bucketIndex].length)
            {
                ensureCapacity(buckets,bucketIndex);
            }
            buckets[bucketIndex][count[bucketIndex]++]= arr[i];
        }

        // 对每个桶中的数据排序
        for (int i = 0; i < buckets.length; i++)
        {
            if(count[i] <= 1) continue;
            mergeSort(buckets[i]);

        }

        // 将各桶中排序好的数据 存入新的数组
        int k = 0;
        for (int i = bucketCount-1; i >= 0 ; i--)
        {
            if(count[i] <= 0) continue;
            for (int j = 0; j < count[i]; j++)
            {
                arr[k++] = buckets[i][j];
            }
        }
    }


    private static void mergeSort(int[] arr)
    {
        int n = arr.length;
        if(n <=1) return;
        mergeS(arr,0,n-1);

    }

    private static void mergeS(int[] arr, int start, int end)
    {
        if(start >= end) return;
        int midLeft = start + (end - start)/2;
        int midRight  = midLeft + 1;
        mergeS(arr,start, midLeft);
        mergeS(arr, midRight,end);
        merge(arr,start,midLeft,midRight,end);
    }

    private static void merge(int[] arr, int start, int midLeft, int midRight, int end)
    {
        int[] arrLeft = new int[midLeft- start + 2];
        for (int i = 0; i < arrLeft.length -1; i++)
        {
            arrLeft[i] = arr[i+start];
        }
        arrLeft[arrLeft.length-1] = Integer.MIN_VALUE;
        int[] arrRight = new int[end - midRight +2];
        for (int i = 0; i < arrRight.length -1; i++)
        {
            arrRight[i] = arr[i+midRight];
        }
        arrRight[arrRight.length-1] = Integer.MIN_VALUE;

        int i =0;
        int j =0;
        int k = start;
        while(k <= end)
        {
            if (arrLeft[i] > arrRight[j])
            {
                arr[k++] = arrLeft[i++];
            }
            else
            {
                arr[k++] = arrRight[j++];
            }
        }
    }

    private static void ensureCapacity(int[][] buckets, int i)
    {
        int[] newArr = new int[2*buckets[i].length];
        System.arraycopy(buckets[i],0,newArr,0,buckets[i].length);
        buckets[i] = newArr;
    }
}
