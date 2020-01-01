package data_structure_and_algorithm;

public class Class17_skipList
{
    // 数据结构与算法之美 17：跳表
    private static final float SKIPLIST_P = 0.5f; // 这个是插入时生成随机的层数的时候使用的
    private static final int  MAX_LEVEL = 16; // 人为规定的最大层数

    private int levelCount =1;  // 这个成员变量是干嘛的？
    private Node head = new Node(); // 带头链表

    // 查找
    public Node find (int value)
    {
        Node p = head;
        for (int i = levelCount-1; i >= 0 ; i--)
        {
            while (p.forwards[i] != null && p.forwards[i].data<value)
            {
                p = p.forwards[i];
            }
        }
        if(p.forwards[0] != null && p.forwards[0].data == value)
        {
            return p.forwards[0];
        }
        else
        {
            return null;
        }
    }

    // 插入
    public void insert (int value)
    {
        int level = randomLevel();
        Node newNode = new Node();
        newNode.data = value;
        newNode.maxLevel = level;
        Node[] update = new Node[level];
        for (int i = 0; i < level; i++)
        {
            update[i] = head;
        }

        // record every level largest value which is smaller than insert value in update[]
        Node p = head;
        for (int i = level-1; i >= 0 ; i--)
        {
            while (p.forwards[i] != null && p.forwards[i].data <value)
            {
                p = p.forwards[i];
            }
            update[i] = p; // use update save node in search path
        }
        // in search path node next node become new node forwards(next)
        for (int i= 0; i< level; i++)
        {
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }

        // update node height
        if(levelCount< level) levelCount = level;
    }

    // 删除
    public void delete(int value)
    {
        Node[] update = new Node[levelCount];
        Node p = head;
        for (int i = levelCount-1; i >= 0 ; i--)
        {
            while(p.forwards[i] != null && p.forwards[i].data < value)
            {
                p = p.forwards[i];
            }
            update[i] = p;
        }

        if(p.forwards[0] != null && p.forwards[0].data == value)
        {
            for (int i = levelCount-1; i >= 0; i++)
            {
                if(update[i].forwards[i] != null && update[i].forwards[i].data ==value)
                {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
        }
        while(levelCount > 1 && head.forwards[levelCount] == null)
        {
            levelCount--;
        }
    }
    // 随机生成插入的层数，但是不同层的概率是不同的
    private int randomLevel()
    {
        int level = 1;
        while(Math.random() < SKIPLIST_P && level < MAX_LEVEL)
        {
            level +=1;
        }
        return level;
    }
    public void printAll()
    {
        Node p = head;
        while(p.forwards[0] != null)
        {
            System.out.print(p.forwards[0] + "");
            p = p.forwards[0];
        }
        System.out.println();
    }
    public class Node
    {
        private int data = -1;
        private Node[] forwards = new Node[MAX_LEVEL];  // 这个数组是用来储存什么的？这个数组用来存储节点在各个了level的下一个节点
        private int maxLevel = 0; // 这个maxLevel 又是什么，节点所拥有的最高层级



        @Override
        public String toString()
        {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ")
                    .append(data)
                    .append("; levers: ")
                    .append(maxLevel)
                    .append(" }");
            return builder.toString();
        }
    }
}
