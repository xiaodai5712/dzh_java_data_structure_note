package exercise_review;

import java.util.LinkedList;


public class Review
{
    // 2019 12 01 复习
    public static void main(String[] args)
    {
//        cal8queens(0);
        int[]arr = {6,5,4,3,2,1,0};
        bucketSort(arr,2);
        printArr(arr);
    }

    private static void printArr(int[] arr)
    {
        for(int i : arr)
        {
            System.out.print(i + ",");
        }
        System.out.println();
        System.out.println("print exit");
    }


    // 8皇后
   static  int[] result =  new int[8];
    private static void cal8queens(int row)
    {
        if(row == 8)
        {
            printAll(result);
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

    private static boolean isOk(int row, int column)
    {
        int leftUp = column-1, rightUp = column+1;
        for(int i = row-1; i >= 0; i--)
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
            leftUp--;rightUp++;
        }
        return true;
    }

    private static void printAll(int[] result)
    {
        for(int row = 0; row < 8; row++)
        {
            for (int column = 0; column < 8; column++)
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
        System.out.println("exit");
        System.out.println();
    }

    // 快排 从小到大
    private static void quickSort(int[] arr)
    {
        int n = arr.length;
        quickSortInter(arr,0,n-1);
    }

    private static void quickSortInter(int[] arr, int start, int end)
    {
        if(start >= end ) return;
        int partition = partition(arr,start,end);
        int midLeft = partition - 1;
        int midRight = partition + 1;
        quickSortInter(arr,start,midLeft);
        quickSortInter(arr,midRight,end);
    }

    private static int partition(int[] arr, int start, int end)
    {
        int pivot = arr[end];
        int i = start;
        for (int j = start; j < end ; j++)
        {
            if(arr[j] < pivot)
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
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 归并排序
    private static void mergeS(int[] arr)
    {
        int n = arr.length;
        mergeSort(arr,0,n-1);
    }

    private static void mergeSort(int[] arr, int start, int end)
    {
        if(start >= end) return;
        int midLeft = start + (end - start)/2;
        int midRight = midLeft + 1;
        mergeSort(arr,start,midLeft);
        mergeSort(arr,midRight,end);
        merge(arr,start,midLeft, midRight,end);
    }

    private static void merge(int[] arr, int start, int midLeft, int midRight, int end)
    {
        int[] ArrLeft = new int[midLeft - start + 2];
        for(int i= 0; i < ArrLeft.length-1; i++)
        {
            ArrLeft[i] = arr[i + start];
        }
        ArrLeft[ArrLeft.length-1] = Integer.MAX_VALUE;
        int[] ArrRight = new int[end - midRight + 2];
        for(int i = 0; i < ArrRight.length-1; i++)
        {
            ArrRight[i] = arr[i + midRight];
        }
        ArrRight[ArrRight.length-1] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int k = start;
        while (k <= end)
        {
            if(ArrLeft[i] <= ArrRight[j])
            {
                arr[k++] = ArrLeft[i++];
            }
            else
            {
                arr[k++] = ArrRight[j++];
            }
        }
    }

    // 插入排序
    private static void insertSort(int[] arr)
    {
        int n  = arr.length;
        if( n <= 1 ) return;
        for(int i = 1; i<n; i++)
        {
            int value = arr[i];
            int j = i-1;
            for(; j >=0 ; j--)
            {
                if(arr[j] > value)
                {
                    arr[j+1] = arr[j];
                }
                else
                {
                    break;
                }
            }
            arr[j+1] = value;
        }
    }

    // 选择排序
    private static void selectSort(int[] arr)
    {
        int n = arr.length;
        if(n <= 1) return;
        for(int i = 0; i < n-1; i++)
        {
            int miniIndex = i ;
            int j = i + 1;
            for(; j < n; j++)
            {
                if(arr[j] < arr[miniIndex])
                {
                    miniIndex = j;
                }
            }
            swap(arr,miniIndex,i);
        }
    }

    // 冒泡排序
    private static void bubbleSort(int[] arr)
    {
        int n = arr.length;
        if(n <= 1) return;
        for(int i = 0; i < n - 1 ; i++)
        {
            boolean isChanged = false;
            for(int j = 0; j < n-i-1; j++)
            {
                if(arr[j] > arr[j+1])
                {
                    swap(arr,j,j+1);
                    isChanged = true;
                }
            }
            if(!isChanged) break;
        }
    }

    //  2019 12 04 W1 Wed 动态规划第二章 解决路径问题
    public static int midDis(int[][] matrix, int n)
    {
        int[][] states = new int[n][n];
        // 初始化第一行
        int sum = 0;
        for (int i = 0; i < n ; i++)
        {
            sum += matrix[0][1];
            states[0][i] = sum;
        }
        sum = 0;
        for (int i = 0; i <n ; i++)
        {
            sum += matrix[i][0];
            states[i][0] = sum;
        }
        for(int i =1; i < n; i++)
        {
            for(int j = 1; j < n; j++)
            {
                states[i][j] = matrix[i][j] + Math.min(states[i][j-1],states[i-1][j]);
            }
        }

        return states[n-1][n-1];
    }

    // 2019/12/6 动态规划求最长公共子串长度
    public static int length(char[] a, char[] b)
    {
        int n = a.length;
        int m = b.length;
        int[][] l = new int[n][m];
        // 初始化第一行的数据
        for (int i = 0; i < n; i++)
        {
            if(a[i] == b[0])
            {
                l[i][0] = 1;
            }
            else if( i != 0)
            {
                l[i][0] = l[i-1][0];
            }
            else
            {
                l[i][0] = 0;
            }
        }
        for (int i = 0; i <m ; i++)
        {
            if(a[0] == b[i])
            {
                l[0][i] = 1;
            }
            else if( i != 0)
            {
                l[0][i] = l[0][i-1];
            }
            else
            {
                l[0][i] = 0;
            }
        }

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j <m ; j++)
            {
                if(a[i] == b[j])
                {
                    l[i][j] = maxValue(l[i-1][j-1]+1,l[i][j-1],l[i-1][j]);
                }
                else
                {
                    l[i][j] = maxValue(l[i-1][j-1],l[i][j-1],l[i-1][j]);
                }
            }
        }
        return l[n-1][m-1];
    }

    public static int maxValue(int a, int b, int c)
    {
        int max = Integer.MIN_VALUE;
        if(a > max) max = a;
        if(b > max) max = b;
        if(c > max) max = c;
        return max;
    }

    public static void bucketSort(int[] arr, int bucketSize)
    {
        int n = arr.length;
        if(n <= 1) return;
        int minValue = arr[0];
        int maxValue = arr[1];
        for (int i = 0; i < n ; i++)
        {
            if(arr[i] < minValue) minValue = arr[i];
            else if(arr[i] > maxValue) maxValue = arr[i];
        }
        int bucketCount = (maxValue - minValue)/bucketSize + 1;
        int[][] buckets = new int[bucketCount][bucketSize];
        int[] count = new int[bucketCount];
        for (int i = 0; i < n ; i++)
        {
            int bucketIndex = (arr[i] - minValue)/bucketSize;
            if(count[bucketIndex] == buckets[bucketIndex].length)
            {
                ensureCapacity(buckets,bucketIndex);
            }
            buckets[bucketIndex][count[bucketIndex]++] = arr[i];
        }

        // 将每个桶中的数据排序
        for (int i = 0; i < bucketCount; i++)
        {
            quickSortInter(buckets[i],0,count[i]-1);
        }

        // 将桶中的数据 再回传给arr
        int k = 0;
        for (int i = 0; i <bucketCount ; i++)
        {
            if(count[i] == 0) continue;

//            quickSortInter(buckets[i],0,count[i]-1);
            for (int j = 0; j < count[i] ; j++)
            {
                arr[k++] = buckets[i][j];
            }
        }
    }

    private static void ensureCapacity(int[][] buckets, int bucketIndex)
    {
        int[] newArr = new int[buckets[bucketIndex].length * 2];
        for (int i = 0; i < buckets[bucketIndex].length ; i++)
        {
            newArr[i] = buckets[bucketIndex][i];
        }
        buckets[bucketIndex] = newArr;
    }


    // 最短路径算法
    public class Graphic
    {
       private LinkedList<Edge>[] adj;
       private int v;

       public Graphic(int v)
       {
           this.v = v;
           for (int i = 0; i < v ; i++)
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
           private Vertex[] nodes;
           private int count;

           public PriorityQueue(int v)
           {
               this.nodes =new Vertex[v+1];
               this.count = v;
           }

           public Vertex poll()
           {
               return null;
           }
           public void update(Vertex vertex)
           {

           }
           public void add(Vertex vertex)
           {

           }
           public boolean isEmpty()
           {
               return false;
           }

       }

       public void dijkstra(int s, int t)
       {
           Vertex[] vertexes = new Vertex[this.v];
           for (int i = 0; i < this.v; i++)
           {
               vertexes[i] = new Vertex(i,Integer.MAX_VALUE);
           }
           vertexes[s] = new Vertex(s,0);
           int[] predecessors = new int[this.v];
           PriorityQueue queue = new PriorityQueue(this.v);
           queue.add(vertexes[s]);
           boolean[] isInQueue = new boolean[this.v];
           isInQueue[s] = true;
           while(! queue.isEmpty())
           {
               Vertex minVertex = queue.poll();
               if(minVertex.id == t) break;
               for (int i = 0; i <adj[minVertex.id].size() ; i++)
               {
                   Edge e = adj[minVertex.id].get(i);
                   Vertex nextVertex = vertexes[e.tid];
                   if(nextVertex.dist > e.w + minVertex.dist)
                   {
                       nextVertex.dist = e.w + minVertex.dist;
                       predecessors[nextVertex.id] = minVertex.id;
                       if(isInQueue[nextVertex.id])
                       {
                           queue.update(nextVertex);
                       }
                       else
                       {
                           isInQueue[nextVertex.id] = true;
                           queue.add(nextVertex);
                       }
                   }

               }
           }
           System.out.println(s);
           print(s,t,predecessors);
       }

        private void print(int s, int t, int[] predecessors)
        {
            if(s == t) return;
            print(s,predecessors[t],predecessors);
            System.out.print("-->" + t);
        }
    }

}

