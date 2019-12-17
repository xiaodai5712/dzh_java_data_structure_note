package data_structure_and_algorithm;


public class CountSort
{
    public static void main(String[] args)
    {
        int[] arr = generateRandomArr(5000,100);
        arr.getClass().getName();

        System.out.println(arr.getClass().toString());
//        System.out.println(Arrays.toString(arr));
        sort(arr);
        countingSort(arr);
//        System.out.println(Arrays.toString(arr));
    }


    // 计数排序
    private static void sort(int[] arr)
    {
        long currentTime = System.currentTimeMillis();
        int n = arr.length;
        if(n <= 1) return;
        int minValue = arr[0];
        int maxValue = arr[1];
        for (int item : arr)
        {
            if (item < minValue) minValue = item;
            if (item > maxValue) maxValue = item;
        }
        int[] countArr = new int[maxValue - minValue +1];
        int[] tempArr = new int[n]; // 这个用来装排完序的数字

        // 这一步时间消耗应该比较大  把他替换掉
        for (int value : arr)
        {
            countArr[value - minValue]++;
        }

        for (int i = 1; i < countArr.length ; i++)
        {
            countArr[i] = countArr[i] + countArr[i-1];
        }


        for (int value : arr)
        {
            int index = value - minValue;
            int location = countArr[index]--;
            tempArr[location-1] = value;
        }
        System.arraycopy(tempArr, 0, arr, 0, n);
        long duration = System.currentTimeMillis() - currentTime;
        System.out.println("我的 消耗时间为：" + duration);
    }

    // 生成一个范围为0 length 数组的长度， maxValue数组的最大值
    public static int[] generateRandomArr(int length, int maxValue)
    {
        int[] arr = new int[length];
        for (int i = 0; i < length ; i++)
        {
            arr[i] = (int)(Math.random()*maxValue);

        }
        return arr;
    }

    // 计数排序，a是数组，n是数组大小。假设数组中存储的都是非负整数。
    public static void countingSort(int[] a)
    {
        long currentTime = System.currentTimeMillis();
        int n = a.length;
        if (n <= 1) return;

        // 查找数组中数据的范围
        int max = a[0];
        for (int i = 1; i < n; ++i) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        int[] c = new int[max + 1]; // 申请一个计数数组c，下标大小[0,max]
        for (int i = 0; i <= max; ++i) {
            c[i] = 0;
        }

        // 计算每个元素的个数，放入c中
        for (int i = 0; i < n; ++i) {
            c[a[i]]++;
        }

        // 依次累加
        for (int i = 1; i <= max; ++i) {
            c[i] = c[i-1] + c[i];
        }

        // 临时数组r，存储排序之后的结果
        int[] r = new int[n];
        // 计算排序的关键步骤，有点难理解
        for (int i = n - 1; i >= 0; --i) {
            int index = c[a[i]]-1;
            r[index] = a[i];
            c[a[i]]--;
        }

        // 将结果拷贝给a数组
        for (int i = 0; i < n; ++i) {
            a[i] = r[i];
        }
        long duration = System.currentTimeMillis() - currentTime;
        System.out.println("王争的 消耗时间为：" + duration);
    }

}
