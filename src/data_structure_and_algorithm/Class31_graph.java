package data_structure_and_algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class Class31_graph
{
    // 31
    public static void main(String[] args)
    {
        Graph graph = new Graph(5);
    }

    public static class Graph
    { // 无向图
        private int v; // 顶点的个数
        private LinkedList<Integer>[] adj; // 邻接表

        public Graph(int v)
        {
            this.v = v;
            adj = new LinkedList[v];
            for (int i=0; i<v; ++i)
            {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int t)
        { // 无向图一条边存两次
            adj[s].add(t);
            adj[t].add(s);
        }


        //  广度优先搜索
        public void bfs(int s, int t) // 搜索从s 到 t 的路径
        {
            if(t == s) return;
            Queue<Integer> queue= new LinkedList<>();
            boolean[] visited = new boolean[v]; // the default state of visited is false
            visited[s] = true;
            queue.add(s);
            int[] prev = new int[v];
            for(int i : prev)
            {
                i = -1;
            }
            while (queue.size() != 0)
            {
                int w = queue.poll();
                for(int i = 0; i < adj[w].size(); i ++)
                {
                    int q = adj[w].get(i);
                    if(! visited[q])
                    {
                        prev[q] = w;
                        if( q == t)
                        {
                            print(prev,s,t);
                            return;
                        }
                        visited[q] = true;
                        queue.add(q);
                    }
                }
            }
        }

        private void print(int[] prev, int s, int t)
        { // 递归打印s->t的路径
            if (prev[t] != -1 && t != s)
            {
                print(prev, s, prev[t]);
            }
            System.out.print(t + " ");
        }
    }

    // DFS Depth First Search


}
