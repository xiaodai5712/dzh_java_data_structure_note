package exercise_review;


import util.DzhUtil;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Date:2019/12/13
 * Author: Dzh
 */

public class Review_12_14
{
    public static void main(String[] args)
    {
        int[] arr = DzhUtil.generateRandomArr(50,100);
        System.out.println(Arrays.toString(arr));
        bucketSort(arr,50);
        System.out.println(Arrays.toString(arr));
        System.out.println(arr.length);

    }
    public class Gra
    {
        public LinkedList<Edge>[] adj;
        public int v;
        public Gra(int v)
        {
            this.v = v;
            this.adj = new LinkedList[v];
            for (int i = 0; i <v ; i++)
            {
                adj[i] = new LinkedList<>();
            }
        }
        public void addEdge(int s,Edge e)
        {
            adj[s].add(e);
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

            public PriorityQueue()
            {
            }
            public PriorityQueue(int v)
            {
                this.count = v;
                this.nodes = new Vertex[v+1]; // 之所以是 v+1 而不是v 是因为 堆 0 号位不放置数据
            }

            public void add(Vertex vertex)
            {

            }
            public void upgrade(Vertex vertex)
            {

            }
            public boolean isEmpty()
            {
                return false;
            }
            public Vertex poll()
            {
                return null;
            }
        }

        public void dijkstra(int s, int t)
        {
            int[] predecessor = new int[this.v];
            boolean[] isInQueue = new boolean[this.v];
            Vertex[] vertexes = new Vertex[this.v];
            for (int i = 0; i < this.v; i++)
            {
                vertexes[i] = new Vertex(i,Integer.MAX_VALUE);
            }
            PriorityQueue queue = new PriorityQueue(this.v);
            vertexes[s].dist = 0;
            queue.add(vertexes[s]);
            isInQueue[s] = true;

            while (queue.isEmpty())
            {
                Vertex minVertex = queue.poll();
                if(minVertex.id == t) break;
                for (int i = 0; i < adj[minVertex.id].size() ; i++)
                {
                    Edge e = adj[minVertex.id].get(i);
                    Vertex nextVertex = vertexes[e.tid];
                    if(e.w+minVertex.dist < nextVertex.dist)
                    {
                        nextVertex.dist = e.w + minVertex.dist;
                        predecessor[nextVertex.id] = minVertex.id;
                        if(isInQueue[nextVertex.id])
                        {
                            queue.upgrade(nextVertex);
                        }
                        else
                        {
                            isInQueue[nextVertex.id] = true;
                            queue.add(nextVertex);
                        }
                    }
                }
            }

            System.out.print(s);
            print(s,t,predecessor);
        }

        private void print(int s, int t, int[] predecessor)
        {
            if(s == t) return;
            print(s,predecessor[t],predecessor);
            System.out.print("->" + t);
        }
    }

    // 桶排序
    public static void bucketSort(int[] arr,int bucketSize)
    {
        int n = arr.length;
        if(n <= 1) return;
        int maxValue = arr[0];
        int minValue = arr[1];
        for (int value : arr)
        {
            if (value < minValue)
            {
                minValue = value;
            } else if (value > maxValue)
            {
                maxValue = value;
            }
        }
        int bucketCount = (maxValue - minValue)/bucketSize + 1;
        int[][] buckets = new int[bucketCount][bucketSize];

        //2 把数据分组放进桶里
        int[] countArr = new int[bucketCount];
        for (int i = 0; i < n ; i++)
        {
            int bucketIndex = (arr[i] - minValue)/bucketSize;
            if(countArr[bucketIndex] == buckets[bucketIndex].length)
            {
                ensureCapacity(bucketIndex,buckets);
            }
            buckets[bucketIndex][countArr[bucketIndex]++] = arr[i];
        }
        for(int[] a : buckets)
        {
            System.out.println(Arrays.toString(a));
        }

        //3 将每个桶中的数据排序，使用快速排序
        for (int i = 0; i <bucketCount; i++)
        {
            quickSortInter(buckets[i],0,countArr[i]-1);
        }

        //4 将各个桶中的数据放回原数组
        int k = 0;
        for (int i = 0; i < buckets.length ; i++)
        {
            if(countArr[i] == 0) continue; // 这个地方出错了
            for(int j = 0; j < countArr[i]; j++)
            {
                arr[k++] = buckets[i][j];
            }
        }
    }


    private static void quickSortInter(int[] arr, int start, int end)
    {
        if(start >= end) return;
        int partition = partition(start,end,arr);
        int midLeft = partition - 1;
        int midRight = partition + 1;
        quickSortInter(arr,start,midLeft);
        quickSortInter(arr,midRight,end);
    }

    private static int partition(int start, int end, int[] arr)
    {
        int pivot = arr[end];
        int i = start;
        for (int j = start; j < end ; j++)
        {
            if(arr[j] <= pivot)
            {
                swap(arr,i,j);
                i++;
            }
        }
        swap(arr,i,end);
        return i;

    }

    private static void swap(int[] arr, int i, int j)
    {
        if(i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void ensureCapacity(int bucketIndex, int[][] buckets)
    {
        int length = buckets[bucketIndex].length * 2;
        int[] newArr = new int[length];
        System.arraycopy(buckets[bucketIndex],0,newArr,0,buckets[bucketIndex].length);
        buckets[bucketIndex] = newArr; // 这个地方出错了
    }
}
