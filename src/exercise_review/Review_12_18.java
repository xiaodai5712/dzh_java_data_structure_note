package exercise_review;

import sun.nio.cs.ext.MacHebrew;
import sun.rmi.runtime.Log;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.net.SocketTimeoutException;
import java.util.LinkedList;

/**
 * Date:2019/12/18
 * Author: Dzh
 */
public class Review_12_18
{
    public static void main(String[] args)
    {

        sqrt(88,5);
    }

    private static class Graphic
    {
        public LinkedList<Edge>[] adj;
        public int v;

        public Graphic(int v)
        {
            this.v = v;
            adj = new LinkedList[v];
            for (int i = 0; i < adj.length ; i++)
            {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int sid,int tid,int w)
        {
            adj[sid].add(new Edge(sid,tid,w));
        }

        public class Edge
        {
            public int sid;
            public int tid;
            public int w;

            public Edge(int sid, int tid, int w)
            {
                this.sid = sid;
                this.tid = tid;
                this.w = w;
            }
        }
        public class Vertex
        {
            public int id;
            public int dist;

            public Vertex(int id, int dist)
            {
                this.id = id;
                this.dist = dist;
            }
        }

        public class PriorityQueue
        {
            public Vertex[] nodes;
            public int count;

            public PriorityQueue(int count)
            {
                this.count = count;
            }

            public void add(Vertex vertex)
            {

            }
            public void upgrade(Vertex vertex)
            {

            }
            public Vertex poll()
            {
                return null;
            }
            public boolean isEmpty()
            {
                return false;
            }
        }

        public void dijkstra(int s, int t)
        {
            int[] predecessors = new int[this.v];
            boolean[] isInQueue = new boolean[this.v];
            Vertex[] vertexes = new Vertex[this.v];
            for (int i = 0; i < this.v ; i++)
            {
                vertexes[i] = new Vertex(i,Integer.MAX_VALUE);
            }
            PriorityQueue queue = new PriorityQueue(this.v);
            Vertex v = vertexes[s];
            v.dist = 0;
            queue.add(v);
            isInQueue[s] = true;
            while (! queue.isEmpty())
            {
                Vertex minVertex = queue.poll();
                int k = minVertex.id;
                if(k == t) break;
                for (int i = 0; i < adj[k].size() ; i++)
                {
                    Edge e = adj[k].get(i);
                    Vertex next = vertexes[e.tid];
                    if(next.dist > e.w + minVertex.dist)
                    {
                        next.dist = e.w + minVertex.dist;
                        predecessors[next.id] = minVertex.id;
                        if(isInQueue[next.id])
                        {
                            queue.upgrade(next);
                        }
                        else
                        {
                            queue.add(next);
                            isInQueue[next.id] = true;
                        }
                    }
                }
            }
            System.out.println(s );
            print(s,t,predecessors);

        }

        private void print(int s, int t, int[] predecessors)
        {
            if(s == t) return;
            print(s,predecessors[t],predecessors);
            System.out.print("-->"+t);
        }

    }

    // 基数排序 按位
    private static void radixSort(int[] arr)
    {
        int n = arr.length;
        if(n <= 1) return;
        // 找到最大value
        int maxValue = arr[0];
        for(int value : arr)
        {
            if(value > maxValue) maxValue = value;
        }
        for (int exp = 1; exp < maxValue  ;exp=exp * 10)
        {
            countingSort(arr,exp);
        }
    }

    private static void countingSort(int[] arr, int exp)
    {
        int n = arr.length;
        int[] tempArr = new int[n];
        int[] countArr = new int[10];
        for(int value : arr)
        {
            countArr[(value/exp)%10] ++;
        }
        for (int i = 1; i < countArr.length; i++)
        {
            countArr[i] += countArr[i-1];
        }
        for(int value : arr)
        {
            int index = countArr[(value/exp)%10] -1;
            tempArr[index] = value;
            countArr[(value/exp)%10]--;
        }
        System.arraycopy(tempArr,0,arr,0,n);
    }

    // 二分查找
    private static int binarySearch(int[]arr, int key)
    {
        int low = 0;
        int high = arr.length -1;
        int mid = low + (high - low)/2;
        while(low >= high)
        {
            if(arr[mid] == key) return mid;
            else if(key > arr[mid]) low = mid +1;
            else  high = mid -1;
        }
        return  -1;
    }

    // 二分查找的递归实现
    private static int search(int[]arr, int start,int end,int key)
    {
        if(start > end) return -1;
        int mid = start + (end - start)/2;
        if(arr[mid] == key) return mid;
        else if(key > arr[mid]) return search(arr,mid+1,end,key);
        else return search(arr,start,mid-1,key);
    }

    // 求一个正数的平方根 精确到小数点后6位
    private static double sqrt(int value,int bit)
    {
        // 整数部分
        int low = 0;
        int high = value;
        int mid;
        do
        {
            mid = low + (high - low)/2;
            if(Math.pow(mid+1,2) < value)
            {
                low = mid+1 ;
            }
            else if(Math.pow(mid,2) > value)
            {
                high = mid;
            }
            else if(Math.pow(mid,2) == value)
            {
                System.out.println(mid);
                return mid;
            }

        }
        while ((Math.pow(mid+1,2) <= value)||(Math.pow(mid,2) > value));
        System.out.println(mid);


       double v = mid;
        for (int i = 1; i <= bit ; i++)
        {
            int small = 0;
            int big = 9;
            int k;
            double f;
            double unit = Math.pow(10,-i);

            do
            {
                k = (small + big)/2;

                f = k * unit ;
                if(Math.pow(v+unit+f,2) < value)
                {
                    small = k+1;
                }
                else if(Math.pow(v+f,2) > value)
                {
                    big = k;
                }
                System.out.println(k);
            }
            while (!((Math.pow(v+f+unit,2) > value)&&(Math.pow(v+f,2) < value)));
            v = v+f;

        }

        // 小数部分
        System.out.printf("%.6f",v);
        return v;
    }

}
