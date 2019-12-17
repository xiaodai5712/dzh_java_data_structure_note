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
}
