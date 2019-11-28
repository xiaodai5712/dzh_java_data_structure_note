package data_structure_and_algorithm;

public class Class39_backTrack
{
    // 39 回溯算法six
    public static void main(String[] args)
    {
//
//        System.out.println(Integer.MIN_VALUE);
//        int[] a = {4,6,17,13,6,3,7,11,9,1};
//        f(0, 0, a, 10, 100);

        cal8queens(0);
    }

    private static int[] result = new int[8];

    private static void printResult(int[] result)
    {
        for(int row = 0; row < 8; row ++)
        {
            for(int column = 0; column < 8; column++)
            {
                if(result[row] == column) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("print exit");
    }

    private static boolean isOk(int row, int column)
    {
        int leftUp = column-1,rightUp = column+1;
        for(int i = row-1; i>=0; i--)
        {
            if(result[i] == column) return false;
            if(leftUp >= 0)
            {
                if(result[i] == leftUp) return false;
            }
            if(rightUp < 8)
            {
                if(result[i] == rightUp) return false;

            }
            leftUp++; rightUp++;
        }
        return true;
    }

    private static void cal8queens(int row)
    {
        if(row == 8)
        {
            printResult(result);
            return;
        }
        for(int column = 0; column < 8; column++)
        {
            if(isOk(row,column))
            {
                result[row] = column;
                cal8queens(row+1);
            }
        }
    }


//    int[] result = new int[8];//全局或成员变量,下标表示行,值表示queen存储在哪一列
//    public static void cal8queens(int row) { // 调用方式：cal8queens(0);
//        if (row == 8) { // 8个棋子都放置好了，打印结果
//            printQueens(result);
//            return; // 8行棋子都放好了，已经没法再往下递归了，所以就return
//        }
//        for (int column = 0; column < 8; ++column) { // 每一行都有8中放法
//            if (isOk(row, column)) { // 有些放法不满足要求
//                result[row] = column; // 第row行的棋子放到了column列
//                cal8queens(row+1); // 考察下一行
//            }
//        }
//    }
//
//    private static boolean isOk(int row, int column) {//判断row行column列放置是否合适
//        int leftup = column - 1, rightup = column + 1;
//        for (int i = row-1; i >= 0; --i) { // 逐行往上考察每一行
//            if (result[i] == column) return false; // 第i行的column列有棋子吗？
//            if (leftup >= 0) { // 考察左上对角线：第i行leftup列有棋子吗？
//                if (result[i] == leftup) return false;
//            }
//            if (rightup < 8) { // 考察右上对角线：第i行rightup列有棋子吗？
//                if (result[i] == rightup) return false;
//            }
//            --leftup; ++rightup;
//        }
//        return true;
//    }
//
//    private static void  printQueens(int[] result) { // 打印出一个二维矩阵
//        for (int row = 0; row < 8; ++row) {
//            for (int column = 0; column < 8; ++column) {
//                if (result[row] == column) System.out.print("Q ");
//                else System.out.print("* ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }



    public static int maxW = Integer.MIN_VALUE; //存储背包中物品总重量的最大值
    // cw表示当前已经装进去的物品的重量和；i表示考察到哪个物品了；
// w背包重量；items表示每个物品的重量；n表示物品个数
// 假设背包可承受重量100，物品个数10，物品重量存储在数组a中，那可以这样调用函数：
// f(0, 0, a, 10, 100)
    public static  void f(int i, int cw, int[] items, int n, int w)
    {
        if (cw == w || i == n)
        { // cw==w表示装满了;i==n表示已经考察完所有的物品
            if (cw > maxW) maxW = cw;
            return;
        }
        f(i+1, cw, items, n, w);
        if (cw + items[i] <= w)
        {// 已经超过可以背包承受的重量的时候，就不要再装了
            f(i+1,cw + items[i], items, n, w);
        }
    }
}
