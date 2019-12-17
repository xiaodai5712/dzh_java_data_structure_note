package exercise_review;


import java.util.Arrays;

public class Sorts
{
    public static void main(String[] args)
    {
        int[] arr = {9,6,3,1,2,7,4,6,11,8,5,9};
//        int[]arr1 = {6,5,4,3,2,1,0};
//        quickSort(arr1);
//        printArr(arr1);
        System.out.println(Arrays.toString(arr));
        int a = 1 / 3;
        System.out.println(" 1 / 3 = " + a);

    }


    // 冒泡排序 arr 时要进行排序的数组，n 时数组大小
    // 从小到大排序
    public static void bubbleSort(int[] arr)
    {
        int n = arr.length;
        System.out.println("数组中有" + n + "个元素" );
        if(n <= 1) return;
        for(int i = 0; i < n-1  ;i++ )
        {
            System.out.println("第" + (i+1) +"次排序");
            boolean flag = false ;
            for(int j = 0; j < n - i- 1; j++)
            {
                System.out.print(" | i = " + i + ", j = " + j + "|") ;
                if(arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }

            System.out.println();
            printArr(arr);
            if(!flag) break;
        }
        System.out.println("sort exit");
    }
    // 插入排序
    // 从大到小排序
    public void insertionSort(int[] arr)
    {
        int n = arr.length;
        if(n <= 1) return;
        for(int i = 1; i < n; i++)
        {
            int value = arr[i];
            int j = i - 1;
            for(;j >= 0; j--)
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

    // 选择排序
    private static void selectionSort(int[] arr)
    {
      int n = arr.length;
      if(n <= 1) return;
      for(int i = 0; i < n-1; i++)
      {
          int minIndex = i;
          for(int j = i+1;j < n;j++)
          {
              if(arr[j] < arr[minIndex])
              {
                  minIndex = j;
              }
          }
          int temp = arr[minIndex];
          arr[minIndex] = arr[i];
          arr[i] = temp;
      }
    }

    // 打印数组
    private static void printArr(int[]arr)
    {
        for(int i : arr)
        {
            System.out.print(i + ", ");
        }
        System.out.println();
        System.out.println("print exit");
    }

    // 归并排序 从小到大
    public static void mergeSort(int[] arr)
    {
        int n = arr.length;
        mergeSortInternally(arr,0,n-1);

    }
    public static void mergeSortInternally(int[] arr,int start,int end)
    {
        if(start >= end) return;
        int mid = start + (end - start)/2;
        mergeSortInternally(arr,start,mid);
        mergeSortInternally(arr,mid+1,end);
        merge(arr,start,mid,mid+1,end);


    }
    public static void merge(int[]arr,int start,int midLeft,int midRight,int end)
    {
        // 由于数组arr的大小可能是奇数也可能是偶数，而数组的起始位置下标为0，所以arrRight的长度可能比arrLeft的长度小1
        int[] arrLeft = new int[midLeft - start + 2];
        int[] arrRight = new int[end - midRight + 2];

        // 对左边的数组初始化
        for(int i = 0; i < arrLeft.length-1 ; i++)
        {
            arrLeft[i] = arr[start + i];
        }
        arrLeft[arrLeft.length-1] = Integer.MAX_VALUE;

        // 对右边的数组初始化
        for(int i = 0; i < arrRight.length-1 ; i++)
        {
            arrRight[i] = arr[midRight + i];
        }
        arrRight[arrRight.length - 1] = Integer.MAX_VALUE;
        int countR = 0;
        int countL = 0;
        int count = start;
        while(count <= end)
        {
            if(arrLeft[countL] <= arrRight[countR])
            {
                arr[count++] = arrLeft[countL++];
            }
            else
            {
                arr[count++] = arrRight[countR++];
            }
        }

    }

    // 快速排序 从小到大
    private static void quickSort(int[] arr)
    {
        int n = arr.length;
        sort(arr,0,n-1);
    }

    private static void sort(int[] arr, int start, int end)
    {
        if(end <= start) return;
        int q = partition(arr,start,end);
        int midLeft = q-1;
        int midRight = q+1;
        sort(arr,start,midLeft);
        sort(arr,midRight,end);
    }

    private static int partition(int[] arr, int start, int end)
    {
        int pivot = arr[end];
        int i = start;
        for (int j = i; j < end; j++)
        {
            if(arr[j] < pivot)
            {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = pivot;
        arr[end] = temp;
        return i;
    }


}
