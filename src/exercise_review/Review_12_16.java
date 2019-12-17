package exercise_review;

import com.sun.org.apache.xml.internal.dtm.ref.sax2dtm.SAX2RTFDTM;
import util.DzhUtil;

import java.util.Arrays;

/**
 * Date:2019/12/16
 * Author: Dzh
 */
public class Review_12_16
{
    public static void main(String[] args)
    {
        int[] arr = DzhUtil.generateRandomArr(150,200);
        System.out.println(Arrays.toString(arr));
        mergeS(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 归并排序  从小到大
    public static void mergeS(int[] arr)
    {
        int n = arr.length;
        if(n <= 1) return;
        MergeSort(arr,0,n-1);
    }

    private static void MergeSort(int[] arr, int start, int end)
    {
        if(start >= end) return;
        int midLeft = start + (end - start)/2;
        int midRight = midLeft + 1;
        MergeSort(arr,start,midLeft);
        MergeSort(arr,midRight,end);
        merge(arr,start,midLeft,midRight,end);
    }

    private static void merge(int[] arr, int start, int midLeft, int midRight, int end)
    {
        // 1 构建两个临时数组并初始化
        int[] leftArr = new int[midLeft - start + 2];
        int[] rightArr = new int[end - midRight + 2];
        System.arraycopy(arr,start,leftArr,0,leftArr.length-1);
        System.arraycopy(arr,midRight,rightArr,0,rightArr.length-1);
        leftArr[leftArr.length-1] = Integer.MIN_VALUE;
        rightArr[rightArr.length-1] = Integer.MIN_VALUE;

        // 2 合并数组
        int i = 0;
        int j = 0;
        int k = start;
        while (k <= end)
        {
            if (leftArr[i] >= rightArr[j])
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
