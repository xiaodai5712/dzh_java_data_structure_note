package data_structure_and_algorithm;

import com.sun.xml.internal.ws.encoding.ContentTypeImpl;

import java.util.LinkedList;
import java.util.Timer;

public class Class_43
{
    //  2019/12/7
    private LinkedList<Integer>[] adj;

    public class Graph
    {
        private int v; // 顶点个数
        private LinkedList<Integer>[] adj; // 邻接表
        public Graph(int v)
        {
            this.v = v;
            this.adj = new LinkedList[v];
            for (int i = 0; i <v; i++)
            {
                adj[i] = new LinkedList<>();
            }
        }
        public void addEdge(int s, int t)
        {
            adj[s].add(t);
        }

        // kahn算法
        public void topoSortByKahn()
        {
            int[] ints = new int[v];
            // 求图中各的顶点的入度
            for (int i = 0; i < v; i++)
            {
                for (int j = 0; j <adj[i].size() ; j++)
                {
                    int w = adj[i].get(j);
                    ints[w] ++;
                }
            }
            LinkedList<Integer> queue = new LinkedList<>();
            for (int i = 0; i < ints.length ; i++)
            {
                if(ints[i] == 0)
                {
                    queue.add(i);
                }
            }
            while (! queue.isEmpty())
            {
                int i = queue.remove();
                System.out.println("->" + i);
                for (int j = 0; j <adj[i].size() ; j++)
                {
                    int w = adj[i].get(j);
                    ints[w]--;
                    if(ints[w] == 0)
                    {
                        queue.add(w);
                    }
                }
            }
        }

        // dfs算法
        public void topoSortByDFS()
        {
            // 1 构造逆邻接表
            LinkedList<Integer>[] inverseAdj = new LinkedList[v];
            for (int i = 0; i <v; i++)
            {
                inverseAdj[i] = new LinkedList<>();
            }

            // 2 根据逆邻接表给邻接表赋值
            for (int i = 0; i <v ; i++)
            {
                for (int j = 0; j < adj[i].size() ; j++)
                {
                    int w = adj[i].get(j);
                    inverseAdj[w].add(i);
                }
            }

            // 3 构建visited数组，并执行打印
            boolean[] visited = new boolean[v];
            for (int i = 0; i <v ; i++)
            {
                if(! visited[i])
                {
                    visited[i] = false;
                    dfs(i,inverseAdj,visited);
                }
            }
        }

        private void dfs(int i, LinkedList<Integer>[] inverseAdj, boolean[] visited)
        {
            for (int j = 0; j < inverseAdj[i].size() ; j++)
            {
                int w = inverseAdj[i].get(j);
                if(visited[w]) continue;
                visited[w] = true;
                dfs(w,inverseAdj,visited);
            }
            System.out.println("->" + i);
        }


    }
}
