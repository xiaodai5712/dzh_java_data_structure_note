package exercise_review;

import java.time.temporal.ValueRange;

/**
 * Date:2019/12/25
 * Author: Dzh
 */
public class Review_12_25
{
    public static void main(String[] args)
    {

    }

    // 查找最后一个值等于给定值的元素
  public static int searchLast(int[] arr,int value)
  {
      int n = arr.length;
      int low = 0;
      int high = n-1;
      while(low <= high)
      {
          int mid = low + (high - low)/2;
          if(arr[mid] == value)
          {
              if(mid == n-1)
              {
                  return mid;
              }
              else if(arr[mid+1] != value)
              {
                  return mid;
              }
              else
              {
                  low = mid+1;
              }
          }
          else if(arr[mid] > value)
          {
              high = mid -1;
          }
          else
          {
              low = mid + 1;
          }
      }
      return -1;
  }

  // 查找第一个大于等于给定值的元素
    private static int findFirst(int[] arr, int key)
    {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if(arr[mid] < key)
            {
                low = mid +1;
            }
            else
            {
                if(mid == 0)
                {
                    return mid;
                }
                else if(arr[mid -1] < key)
                {
                    return mid;
                }
                else
                {
                    high = mid-1;
                }
            }
        }
        return -1;
    }

    // 查找最后一个小于等于给定值的元素
    private static int findLast(int[] arr, int key)
    {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if(arr[mid] > key)
            {
                high = mid -1;
            }
            else
            {
                if(mid == n-1)
                {
                    return mid;
                }
                else if(arr[mid +1] > key)
                {
                    return mid;
                }
                else
                {
                    low = mid +1;
                }
            }
        }
        return -1;
    }
}
