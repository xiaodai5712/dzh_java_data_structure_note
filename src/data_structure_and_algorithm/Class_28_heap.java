package data_structure_and_algorithm;

public class Class_28_heap
{
    // 数据结构与算法之美 28: 堆和堆排序
    public static void main(String[] args)
    {

    }

    public class Heap
    {
        private int[] arr; // 实现堆的数组
        private  int n; //  堆的容量
        private int count; // 当前堆中元素的个数

        public Heap(int capacity)
        {
            arr = new int[capacity + 1]; // 为了下标计算的方便，数组中的第一个位置设为空的，故数组的length为 capacity+1
            n = capacity;
            count = 0;
        }
        public void insert(int data)
        {
            // 首先是特殊情况处理，数组中的数据已经满了
            if(count >= n) return;
            ++ count;
            arr[count] = data;
            int i = count;
            int temp;
            while(i/2 > 0 && arr[i]> arr[i/2]) // 堆化的过程
            {
                temp = arr[i];
                arr[i] = arr[i/2];
                arr[i/2] = temp;

                i = i/2;
            }
        }

        // 删除堆顶的元素
        public void removeMax()
        {
            if(count == 0) return;
            arr[1] = arr[count];
            count -- ;

        }
        // 堆化
        public void heapify(int i) // 这个堆化的过程是自上向下的
        {
            while(true)
            {
                int maxPos = i;
                if(i * 2 <= n && arr[i] < arr[i * 2])
                {
                    maxPos = i * 2;
                }
                if(i * 2 + 1 <= n && arr[maxPos] < arr[i * 2 + 1])
                {
                    maxPos = 2 * i + 1;
                }
                if (maxPos == i)
                {
                    break;
                }
                i = maxPos;
            }
        }

        // 建堆
        private void buildHeap(int[] arr, int n)
        {
            for(int i = n/2; i >= 1; i --)
            {
                heapify(i);
            }
        }

        private void sort(int[] arr,int n) // n = arr.length - 1,即这个堆的容量
        {
            buildHeap(arr,n);
            int k = n;
            while (k > 1)
            {
                int temp = arr[1]; // 把数组中的第一个和最后一个数据交换位置，然后再堆化
                arr[1] = arr[k];
                arr[k] = temp;
                heapify(k-1);
                k --;
            }
        }
    }



}
