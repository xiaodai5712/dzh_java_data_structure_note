package data_structure_and_algorithm;

public class Class16
{
    //  数据结构与算法之美 16:二分查找的变形问题
    public static void main(String[] args)
    {
        int[] arr = {0,1,1,1,3,4,6,6,6,7,7,8,9,9};
        int value = 5;
        int k = versionThree(arr,value);
        System.out.println("a[" + k + "] = " + value);
    }

    // 查找数组中 第一个 值等于给定值的元素 ,我自己的写法
    private static int getVersionOne(int[] arr,int value)
    {
        int low = 0;
        int high = arr.length -1;
        int key = -1;
        while (low <= high)
        {
            int mid = low + (high - low)/2;
            if(arr[mid] == value)
            {
                key = mid;
                break;
            }
            else if( value > arr[mid])
            {
                low = high + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        int count = key - 1;
        for(int j = count;j >= 0;j -- )
        {
            if(arr[j] == value)
            {
                key = j;
            }
            else
            {
                break;
            }
        }
        return  key;
    }

    // 查找数组中 第一个 值等于给定值的元素 ,老师给的写法
    private static int versionTeacher(int[] arr, int value)
    {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high)
        {
            int mid = low + (high - low)/2;
            if(value > arr[mid])
            {
                low = mid + 1;
            }
            else if(value < arr[mid])
            {
                high = mid - 1;
            }
            else
            {
                if(mid == 0 || arr[mid - 1] != value)
                {
                    return mid;
                }
                else
                {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
   // 查找数组中 第一个 值大于等于给定值的元素 ,老师给的写法
   private static int versionThree(int[] arr, int value)
   {
       int low = 0;
       int high = arr.length - 1;
       while (low <= high)
       {
           int mid = low + (high - low)/2;
           if(value <= arr[mid])
           {
               if(mid == 0 || arr[mid - 1] < value)
               {
                   return mid;
               }
               else
               {
                   high = mid - 1;
               }

           }
           else
           {
               low = mid + 1;
           }

       }
       return -1;
   }
}
