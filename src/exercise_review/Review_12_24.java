package exercise_review;

import util.DzhUtil;

import java.util.Arrays;

/**
 * Date:2019/12/24
 * Author: Dzh
 */
public class Review_12_24
{
    public static void main(String[] args)
    {
        int[] arr = DzhUtil.generateRandomArr(50,30);
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
        int k = searchOne(arr,0);
        System.out.println(k);

    }

    // 查找第一个值等于给定值的元素
    private static int searchOne(int[] arr, int key)
    {
        int low = 0;
        int high = arr.length-1;
        while(low <= high) // 这里将推出循环的条件定位 <= 而不是 < 是因为要考虑到
        {
           int mid = low + (high - low)/2;
           if(arr[mid] == key)
           {
               if(mid == 0)
               {
                   return mid;
               }
               else if(arr[mid-1] != key)
               {
                   return mid;
               }
               else
               {
                   high = mid-1;
               }
           }
           else if(arr[mid] < key)
           {
               low = mid+1;
           }
           else
           {
                high = mid -1;
           }
        }
        return  -1;
    }

    private static void insertSort(int[] arr)
    {
        int n = arr.length;
        if(n <= 1) return;
        for (int i = 1; i < n ; i++)
        {
            int value = arr[i];
            int j = i-1;
            for(; j >=0;j--)
            {
                if(arr[j] > value)
                {
                    arr[j+1] = arr[j];
                }
                else
                {
                    break;
                }
            }
            arr[j+1] = value;
        }
    }

    private static int bsearch(int[] arr, int value) {
        int low = 0;
        int n = arr.length;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == 0) || (arr[mid - 1] != value)) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }
}
