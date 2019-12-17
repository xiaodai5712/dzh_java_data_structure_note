package data_structure_and_algorithm;

public class Class_41_DynamicTheory
{
    public static int midDisDP(int[][] matrix,int n)
    {
        int[][] states = new int[n][n];
        int sum  = 0;
        for(int i = 0; i < n; i++) // 初始化第一行数据
        {
            sum += matrix[0][i];
            matrix[0][i] = sum;
        }
        sum = 0;
        // 初始化第一列数据
        for(int i = 0; i < n; i++)
        {
            sum += matrix[i][0];
            matrix[i][0] = sum;
        }
        for(int i = 1; i < n; i ++)
        {
            for(int j = 1; j < n ; j++)
            {
                states[i][j] = matrix[i][j] + Math.min(states[i-1][j],states[i][j-1]);
            }
        }
        return states[n-1][n-1];
    }

    private int[][] matrix ={{1,3,5,9}, {2,1,3,4},{5,2,6,7},{6,8,4,3}};
    private int n = 4;
    private int[][] mem  = new int[n][n];
    public int minDist(int i,int j)
    {
        if(i == 0 && j == 0) return matrix[0][0];
        if(mem[i][j] > 0) return mem[i][j];
        int leftMin = Integer.MAX_VALUE;
        if(j-1 > 0)
        {
            leftMin = minDist(i,j-1);
        }
        int upMin = Integer.MAX_VALUE;
        if(i-1 > 0)
        {
            upMin = minDist(i-1,j);
        }
        int currentMin = matrix[i][j] + Math.min(leftMin,upMin);
        mem[i][j] = currentMin;
        return  currentMin;
    }
}
