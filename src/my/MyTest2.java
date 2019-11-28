package my;

public class MyTest2
{

    public String def;
    protected String pro;
    public static void main(String[] args)
    {
         int[]a = {1, 2, 3, 4};
         printPermutations(a, 4, 4); // n ：数组的长度 k：将要处理的数组中数据的个数

    }
    // 调用方式：
// int[]a = a={1, 2, 3, 4}; printPermutations(a, 4, 4);
// k 表示要处理的子数组的数据个数
    public static  void printPermutations(int[] data, int n, int k) {
        if (k == 1)
        {
            for (int i = 0; i < n; ++i)
            {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < k; ++i)
        {
            int tmp = data[i];  // 这三行写的是 data[i] 和 data[k-1] 交换数据
            data[i] = data[k-1];
            data[k-1] = tmp;

            printPermutations(data, n, k - 1);

            tmp = data[i];
            data[i] = data[k-1];
            data[k-1] = tmp;
        }
    }
    void printD()
    {
        System.out.println("这是个测试 default");
    }

    protected  void printP()
    {
        System.out.println("测试 protected");
    }
    public MyTest2()
    {
        System.out.println("wouigdjfkdsafhj ");
    }


}
