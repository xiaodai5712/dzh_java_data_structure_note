package my;

public class MyTest3
{


    public static void main(String[] args)
    {
        int [] arr = {1,11,4,3,6,9,5};
        sort1(arr,7);
        for(int i : arr)
        {
            System.out.print( i + ",");
        }
        System.out.println("exit");

    }

    // 冒泡排序 从小到大 n 代表数组的大小
    public static void sort1(int[] arr,int n)
    {
        if(arr.length <= 1) return;
        int temp = 0;
        for(int i = 0; i < arr.length; i++)
        {
            boolean flag = false;
//            for(int j = arr.length -1; j >1 + i; j--)
//            {
//                if(arr[j] < arr[j-1])
//                {
//                    temp = arr[j];
//                    arr[j] = arr[j-1];
//                    arr[j-1] = temp;
//                    flag = true;
//                }
//            }
            for(int j = 0; j < arr.length - 1 -i;j ++)
            {
                if(arr[j] > arr[j + 1])
                {
                    temp = arr[j];
                    arr[j] = arr[j+ 1];
                    arr[j+1] = temp;
                }
                flag = true;
            }

                if(!flag) break; // 若在某一轮排序中没有数据交换，则说明数组已经有序，则可以推出排序
        }
    }
}
