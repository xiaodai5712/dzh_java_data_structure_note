package exercise_review;

import javax.sql.rowset.FilteredRowSet;

public class exercise
{
    public static void main(String[] args)
    {
        cal8queens(0);
    }

    // 冒泡排序 从小到大
    public static void bubbleSort(int[] arr)
    {

    }

    // 插入排序 从小到大
    public static void insertionSort(int[] arr)
    {
    }

    // 选择排序 从小到大
    public static void selectionSort(int[] arr)
    {

    }

    // 八皇后问题
    static int[]  result = new int[8];
    static int count = 0;

    private static void cal8queens(int row)
    {
        if(row == 8)
        {
            printAll(result);
            return;
        }
        for(int column = 0; column < 8; column++)
        {
            if(isOK(row,column))
            {
                result[row] = column;
                cal8queens(row+1);
            }
        }
    }

    private static boolean isOK(int row, int column)
    {
        int leftUp = column-1,rightUp = column+1;
        for(int i = row-1; i >= 0; i--)
        {
            if(result[i] == column) return false;
            if(leftUp>=0)
            {
                if(result[i] == leftUp)
                {
                    return false;
                }
            }
            if(rightUp < 8)
            {
                if(result[i] == rightUp)
                {
                    return false;
                }
            }
            rightUp++;
            leftUp--;
        }
        return true;
    }

    private static void printAll(int[] result)
    {
        for(int row = 0; row < 8; row++)
        {
            for(int column = 0; column < 8; column++)
            {
                if(result[row] == column)
                {
                    System.out.print("Q ");
                }
                else
                {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.printf("print exit %s 次 \n",++count);


    }
}
