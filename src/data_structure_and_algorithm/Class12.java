package data_structure_and_algorithm;

public class Class12
{
    // dzh: 数据结构与算法之美的第12节，归并排序  快速排序

    public static void main(String[] args)
    {
        int[] arr = {5,4,1,9,6,3,2,7,0,8};
        int[] arr1 = quickSort(arr);
        for(int i : arr1)
        {
            System.out.print(i + " ,");
        }
        System.out.print("\n");
        for(int i = arr1.length -1; i >= 0; i --)
        {
            System.out.print(arr1[i]+ " ,");
        }

    }

    // dzh: 归并排序
    private static int[] mergeSort(int[] arr)
    {
        int arrSize = arr.length;
        sortC(arr,0, arrSize - 1);  // start：第 start+1 个元素  end：第 end+1 个元素，这两个数界定了数组的排序范围，并且包括这两个元素
        return  arr;
    }

    //dzh: 递归函数
    private static void sortC(int[] arr,int start, int end)
    {
        if(start >= end) return;

        int q = 1 + ((start + end ) / 2);
        sortC(arr,start,q - 1);
        sortC(arr,q ,end);
        merge(arr,start,q,end);

    }

    // dzh：合并函数
    private static void merge(int[] arr, int start, int mid, int end)
    // 方法中制定了四个参数，数组arr，操作的第一个元素的位置：start，中间元素的位置：mid，
    {
        int[] temp = new int[arr.length];
        int i = start;
        int j = mid;
        int k = 0;

        // 先比较，后赋值
        while ((i <= (mid-1)) && (j <= end))
        {
            if(arr[i] >= arr[j]) // 这个里面的不等号决定了排序是从小到大排还是从大到小排，这里我用的是 " < ", 所以是从小到大排
            {
                temp[k] = arr[i];
                k ++;
                i ++;
            }
            else
            {
                temp[k] = arr[j];
                k ++;
                j ++;
            }
        }
        // 将没有arr 中没有赋值的数，传给temp

        if(i <= (mid-1))
        {
            while (i <= mid-1)
            {
                temp[k] = arr[i];
                k ++;
                i ++;
            }
        }
        if(j <= end)
        {
            while(j <= end)
            {
                temp[k] = arr[j];
                k ++;
                j ++;
            }
        }
        // 将temp中的数copy给arr
        if (end - start + 1 >= 0) System.arraycopy(temp, 0, arr, start, end - start + 1);
    }

    /*
    * 快速排序
    */
    private static int[] quickSort(int[] arr)
    {
        int arrSize = arr.length;
        quick_sortC(arr,0, arrSize - 1);  // start：第 start+1 个元素  end：第 end+1 个元素，这两个数界定了数组的排序范围，并且包括这两个元素
        return arr;
    }

    // 递归
    private static void quick_sortC(int[] arr,int start, int end)
    {
        if(start >= end) return;

        int q = partition(arr,start,end);
        quick_sortC(arr,start,q-1);
        quick_sortC(arr,q+1,end);

    }

    // 分区函数
    private static int partition(int[] arr, int start, int end)
    {
        int pivot = arr[end]; // 选择数组中的最后一个元素作为分区的点
        int i = start;
        int temp ;

        // 这一步的操作我还不太明白是什么意思？
        for(int j = start; j < end; j ++)
        {
            if(arr[j] < pivot)
            {
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i ++;
            }
        }
        temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;
        return  i;
    }

}
