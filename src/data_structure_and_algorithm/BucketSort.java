package data_structure_and_algorithm;

import java.util.Arrays;

public class BucketSort
{
    public static void main(String[] args)
    {
        int[] simpleArr =  {6,5,4,3,2,1,0};
        sort(simpleArr,2);
        System.out.println(Arrays.toString(simpleArr));
    }


    public static void  sort(int[] arr, int bucketSize)
    {
        int n = arr.length;
        if(n <= 1) return;
        int maxValue = arr[0];
        int minValue = arr[1];
        for (int i = 0; i < n ; i++)
        {
            if(arr[i] < minValue) minValue = arr[i];
            else if(arr[i] > maxValue) maxValue = arr[i];
        }
        int bucketCount = (maxValue - minValue)/bucketSize + 1;
        int[][] buckets = new int[bucketCount][bucketSize];
        int[] count = new int[bucketCount];
        // 将数组中的数分配至各个桶中
        for (int i = 0; i < n; i++)
        {
            int bucketIndex = (arr[i] - minValue)/ bucketSize;
            if(count[bucketIndex] == buckets[bucketIndex].length)
            {
                ensureCapacity(buckets,bucketIndex);
            }
            buckets[bucketIndex][count[bucketIndex]++] = arr[i];
        }

        // 对每个桶的进行排序
        int k = 0;
        for (int i = 0; i < buckets.length ; i++)
        {
            if(count[i] == 0) continue;
            quickSort(buckets[i],0,count[i]-1);
            for (int j = 0; j < count[i] ; j++)
            {
                arr[k++] = buckets[i][j];
            }
        }
    }

    private static void quickSort(int[] arr, int start, int end)
    {
        if(start >= end) return;
        int partition = partition(arr,start,end);
        int midLeft = partition - 1;
        int midRight = partition + 1;
        quickSort(arr,start,midLeft);
        quickSort(arr,midRight,end);
    }

    private static int partition(int[] arr, int start, int end)
    {
        int pivot = arr[end];
        int j = start;
        for (int i = start; i < end  ; i++)
        {
            if(arr[i] < pivot)
            {
                swap(arr,i,j);
                j++;
            }
        }
        swap(arr,j,end);
        return j;
    }

    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void ensureCapacity(int[][] buckets, int bucketIndex)
    {
        int[] newBucket = new int[buckets[bucketIndex].length * 2];
        for (int i = 0; i < buckets[bucketIndex].length; i++)
        {
            newBucket[i] = buckets[bucketIndex][i];
        }
        buckets[bucketIndex] = newBucket;
    }


}
