package my;

import java.util.*;

public class Second
{
    public String id = "ddd";
    public MyTest2 a;
    public Second()
    {

    }
    //   这个类，是用来看排序代码的
    public static void main(String[] args)
    {
        System.out.println("请输入一个整数");
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        System.out.println("你输入了：" + k);
        int[] arr = {7,5,8,6,0,1,4,9,3,2};

        for(int i : arr)
        {
//            if( i == 0)
//            {
//                System.out.println(i);
//                return;
//            }
            System.out.print(i + ", ");
        }
        ArrayList<String> strings = new ArrayList<>();
        List<String> s;
        LinkedList<String> a;
        AbstractCollection<String> b;
    }




}

