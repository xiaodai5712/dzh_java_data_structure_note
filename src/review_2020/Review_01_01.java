package review_2020;

import com.sun.org.apache.bcel.internal.generic.SWAP;
import sun.text.normalizer.NormalizerBase;
import util.DzhUtil;

import javax.sound.midi.MidiFileFormat;

import java.util.Arrays;

import static exercise_review.exercise.swap;

/**
 * Date:2020/1/1
 * Author: Dzh
 */
public class Review_01_01
{
    public static void main(String[] args)
    {
        int[] arr = DzhUtil.generateRandomArr(50,200);
        System.out.println(Arrays.toString(arr));
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 复习快速排序 从大到小
    private static void quickSort(int[] arr)
    {
        int n = arr.length;
        if( n <= 1) return;
        quickS(arr,0,n-1);
    }

    private static void quickS(int[] arr, int start, int end)
    {
        if(start >= end) return;  // 这个地方之前也写错了 写成了 start <= end
        int partition = partition(arr,start,end);
        int midLeft = partition -1;
        int midRight = partition + 1;
        quickS(arr,start,midLeft);
        quickS(arr, midRight,end);
    }

    private static int partition(int[] arr, int start, int end)
    {
        int i = start;
        int j = start;
        int pivot = arr[end];
        for (;j <= end; j++)
        {
            if(arr[j] > pivot)
            {
                swap(arr,i,j);
                i++; // 这个地方出过错，忘记 ++ 了
            }
        }
        int p = i;
        swap(arr,i,end);
        return p;
    }
}
