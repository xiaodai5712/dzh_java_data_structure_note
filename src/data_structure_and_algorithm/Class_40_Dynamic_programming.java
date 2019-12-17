package data_structure_and_algorithm;

public class Class_40_Dynamic_programming
{
    public static void main(String[] args)
    {

    }

    public static int pack(int[] weight, int[] value, int n ,int w)
    {
        int[][] states = new int[n][w+1];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j <= w; j++)
            {
                states[i][j]= -1;
            }
        }
        states[0][0] = 0;
        if(value[0] > 0)
        {
            states[0][weight[0]] = value[0];
        }
        for(int i=1; i < n; i++)
        {
            for(int j = 0; j < w+1; j++)
            {
                if(states[i-1][j]>=0)
                {
                    states[i][j] = states[i-1][j];
                }
            }
            for(int j = 0; j <= w-weight[i]; j++)
            {
                int v = value[i] + states[i-1][j];
                if(v > states[i][j+weight[i]])
                {
                    states[i][j+weight[i]] = v;
                }
            }
        }
        int maxValue = -1;
        for(int j = 0; j <= w; j++)
        {
            if(states[n-1][j] > maxValue) maxValue = states[n-1][j];
        }
        return  maxValue;
    }

}
