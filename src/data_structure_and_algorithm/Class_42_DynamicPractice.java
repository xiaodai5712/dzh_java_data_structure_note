package data_structure_and_algorithm;

import java.time.chrono.MinguoChronology;
import java.util.concurrent.ForkJoinPool;

public class Class_42_DynamicPractice
{
    public static void main(String[] args)
    {

    }

    private static int lwstDp(char[] a , char[] b)
    {
        int n = a.length;
        int m = b.length;
        int[][] minDist = new int[n][m];
        // 初始化 a 与 b的第一个字符的最小编辑距离
        for(int i = 0; i < n; i++)
        {
            if(a[i] == b[0])
            {
                minDist[i][0] = i;
            }
            else if( i != 0)
            {
                minDist[i][0] = minDist[i-1][0] + 1;
            }
            else
            {
                minDist[i][0] = 1;
            }
        }
        // 初始化 b 与 a的第一个字符的最小编辑距离
        for(int i = 0; i < m; i++)
        {
            if(b[i] == a[0])
            {
                minDist[0][i] = i;
            }
            else if( i != 0)
            {
                minDist[0][i] = minDist[0][i-1] + 1;
            }
            else
            {
                minDist[0][i] = 1;
            }
        }

        for (int i = 1; i <n ; i++)
        {
            for (int j = 1; j <m ; j++)
            {
                if(a[i] == b[j]) minDist[i][j] = min(minDist[i-1][j-1],minDist[i-1][j]+1,minDist[i][j-1]+1);
                else minDist[i][j] = min(minDist[i-1][j-1]+1,minDist[i-1][j]+1,minDist[i][j-1]+1);
            }
        }
        return minDist[n-1][m-1];
    }


    private static int min(int x, int y, int z)
    {
        int min = Integer.MAX_VALUE;
        if(x < min) min = x;
        if(y < min) min = y;
        if(z < min) min = z;
        return min;

    }

    private static int lcs(char[]a,char[]b)
    {
        int n = a.length;
        int m = b.length;
        int[][] maxLcs = new int[n][m];
        for (int i = 0; i <n ; i++)
        {
            if(a[i] == b[0]) maxLcs[i][0] = 1;
            else if( i != 0) maxLcs[i][0] = maxLcs[i-1][0];
            else maxLcs[i][0] = 0;
        }
        for (int j = 0; j < m ; j++)
        {
            if(b[j] == a[0]) maxLcs[0][j] = 1;
            else if( j != 0) maxLcs[0][j] = maxLcs[0][j-1];
            else maxLcs[0][j] = 0;
        }

        for (int i = 1 ;i < n; i++)
        {
            for (int j = 1; j <m; j++)
            {
                if(a[i] == b[j]) maxLcs[i][j] = max(maxLcs[i-1][j-1]+1,maxLcs[i-1][j],maxLcs[i][j-1]);
                else maxLcs[i][j] = max(maxLcs[i-1][j-1],maxLcs[i-1][j],maxLcs[i][j-1]);
            }
        }
        return maxLcs[n-1][m-1];
    }

    private static int max(int x, int y, int z)
    {
        int max = Integer.MIN_VALUE;
        if(x > max) max = x;
        if(y > max) max = y;
        if(z > max) max = z;
        return max;

    }
}
