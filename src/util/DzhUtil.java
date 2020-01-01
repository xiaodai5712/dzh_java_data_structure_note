package util;

public class DzhUtil
{
    public static final int[] simpleArr =  {6,5,4,3,2,1,0};
    public static int[] generateRandomArr(int length, int maxValue)
    {
        int[] arr = new int[length];
        for (int i = 0; i < length ; i++)
        {
            arr[i] = (int)(Math.random()*maxValue);

        }
        return arr;
    }

    public static<T extends Comparable<T>> T findMax(T[] arr)
    {
        int n = arr.length;
        if(n <= 1) return arr[0];
        T max = arr[0];
        for (int i = 1; i <n; i++)
        {
            if(arr[i].compareTo(max)>0)
            {
                max = arr[i];
            }
        }
        return max;
    }
    public static<T extends Comparable<T>> T findMin(T[] arr)
    {
        int n = arr.length;
        if(n <= 1) return arr[0];
        T min = arr[0];
        for (int i = 1; i <n; i++)
        {
            if(arr[i].compareTo(min)<0)
            {
                min = arr[i];
            }
        }
        return min;
    }
}
