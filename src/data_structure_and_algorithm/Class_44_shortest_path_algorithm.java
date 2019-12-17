package data_structure_and_algorithm;

import java.util.LinkedList;

public class Class_44_shortest_path_algorithm
{

    public class Graphic
    {
        private int v;
        private LinkedList<Edge>[] adj;

        public Graphic(int v)
        {
            this.v = v;
            this.adj = new LinkedList[v];
            for (int i = 0; i < v; i++)
            {
                this.adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int t, int w)
        {
            adj[s].add(new Edge(s, t, w));
        }

        private class Edge
        {
            public int sid; // 起始点id
            public int tid; // 终点id
            public int w; // 权重

            public Edge(int sid, int tid, int w)
            {
                this.sid = sid;
                this.tid = tid;
                this.w = w;
            }
        }

        public class Vertex
        {
            public int id; // 顶点编号id
            public int dist;

            public Vertex(int id, int dist)
            {
                this.id = id;
                this.dist = dist;
            }
        }

        // 这里所谓的优先级队列，实际上是一个小顶堆
        public class PriorityQueue
        {
            private Vertex[] nodes;
            private int count;

            public PriorityQueue(int v)
            {
                this.nodes = new Vertex[v + 1];
                this.count = v;
            }

            public Vertex poll()
            {
                // TODO: 2019/12/10 关于堆的知识都忘记了
                return null;
            }

            public void add(Vertex vertex)
            {

            }

            public void update(Vertex vertex)
            {

            }

            public boolean isEmpty()
            {
                return true;
            }
        }

        // 求顶点s到顶点t的最短距离
        public void dijkstra(int s, int t)
        {
            int[] predecessor = new int[this.v]; // 用来还原最短路径
            Vertex[] vertexes = new Vertex[this.v];
            for (int i = 0; i < this.v; i++)
            {
                vertexes[i] = new Vertex(i, Integer.MAX_VALUE);
            }

            PriorityQueue queue = new PriorityQueue(this.v);  // 小顶堆
            boolean[] isInQueue = new boolean[this.v];
            vertexes[s].dist = 0;
            queue.add(vertexes[s]);
            isInQueue[s] = true;
            while (!queue.isEmpty())
            {
                Vertex minVertex = queue.poll();  // 取堆定元素并删除
                if (minVertex.id == t) break;
                for (int i = 0; i < adj[minVertex.id].size(); i++)
                {
                    Edge e = adj[minVertex.id].get(i);  // 取出一条与minVertex相邻的边
                    Vertex nextVertex = vertexes[e.tid];
                    if (minVertex.dist + e.w < nextVertex.dist)
                    {
                        nextVertex.dist = minVertex.dist + e.w;
                        predecessor[nextVertex.id] = minVertex.id;
                        if (isInQueue[nextVertex.id] == true)
                        {
                            queue.update(nextVertex); // 更新队列中的dist值
                        } else
                        {
                            queue.add(nextVertex);
                            isInQueue[nextVertex.id] = true;
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
            print(s,predecessor[t], predecessor);
            System.out.print("->" + t);
        }
    }

}
