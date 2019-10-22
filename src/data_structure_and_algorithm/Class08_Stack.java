package data_structure_and_algorithm;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Class08_Stack
{
    // 数据结构与算法之美 08: 栈
    public static void main(String[] args)
    {
        String[] items = {"床","前","明","月","光"};
        ArrayStack arrayStack = new ArrayStack(items.length);
        int count = 0;
        while (count < items.length)
        {
            arrayStack.push(items[count]);
            count ++;
        }
        System.out.println();
        int i = 0;
        while (count-- > 0)
        {
            System.out.print(arrayStack.pop() + ",");

        }
        System.out.println();
        System.out.println("exit" );
        int a = 1;
        int n = 0;
        int q = ++i + a;
        int p = n++ + a;
        int m = ++n + a;
        System.out.println(q);
        System.out.println(p);
        System.out.println(m);
    }



    public static class ArrayStack
    {
        public int n; // 栈的容量
        public String[] items;
        public int count; // 此刻栈中元素的个数
        public ArrayStack(int n)
        {
            this.items = new String[n];
            this.n = n;
            this.count = 0;
        }
        // 入栈
        public boolean push( String item)
        {
            // 入栈时的特殊情况为，当要入栈时，栈已经满了
            if(count == n) return false;

            // 之后是正常的入栈操作
            items[count] = item;
            System.out.print(item + ",");
            count ++ ;
            return true;
        }
        // 出栈
        public String pop()
        {
            // 特殊情况为 此时栈已经空了
            if(count == 0) return null;

            // 接下来是正常操作
            String temp = items[count-1];
            count --;
            return temp;
        }



    }
}
