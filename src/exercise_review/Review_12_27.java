package exercise_review;

import sun.text.resources.cldr.bn.FormatData_bn_IN;

/**
 * Date:2019/12/27
 * Author: Dzh
 */
public class Review_12_27
{
    // 跳表
    public class SkipList
    {
        private final int MAX_LEVEL = 16;
        private int levelCount = 1;
        private float skip = 0.5f;
        public Node head = new Node();

        // 按节点的data 查找一个节点
        public Node findNode(int value)
        {
            Node p = head;
            for (int i = MAX_LEVEL-1; i >= 0 ; i--)
            {
                while(p.nextNodes[i] != null && p.nextNodes[i].data < value)
                {
                    p = p.nextNodes[i];
                }
            }
           if(p.nextNodes[0]!= null && p.nextNodes[0].data == value)
           {
               return  p.nextNodes[0];
           }
           else
           {
               return null;
           }
        }

        // 按节点的data,删除一个节点
        public void delete(int value)
        {
            Node[] preNodes = new Node[MAX_LEVEL];
            Node p = head;
            for (int i = levelCount-1; i >= 0; i--)
            {
                while(p.nextNodes[i] != null && p.nextNodes[i].data <value)
                {
                    p = p.nextNodes[i];
                }

                preNodes[i] = p;
            }
            if(p.nextNodes[0] != null && p.nextNodes[0].data == value)
            {
                for (int i = levelCount-1; i >= 0 ; i--)
                {
                    if(preNodes[i].nextNodes[i] != null && preNodes[i].nextNodes[i].data ==value)
                    {
                        preNodes[i].nextNodes[i] = preNodes[i].nextNodes[i].nextNodes[i];
                    }
                }
            }
            while(levelCount > 1 && head.nextNodes[levelCount] ==null)
            {
                levelCount--;
            }

        }

        // 按节点的data值，插入一个节点
        public void insert(int value)
        {
            int level = randomLevel();
            Node p = head;
            Node newNode = new Node();
            newNode.data = value;
            newNode.maxLevel = level;
            Node[] preNodes = new Node[MAX_LEVEL];

            for (int i = level; i >= 0 ; i--)
            {
                while(p.nextNodes[i] != null && p.nextNodes[i].data <value)
                {
                    p = p.nextNodes[i];
                }

                preNodes[i] = p;
            }

            for (int i = level; i >= 0 ; i--)
            {
                newNode.nextNodes[i] = preNodes[i].nextNodes[i];
                preNodes[i].nextNodes[i] = newNode;
            }

            levelCount = Math.max(levelCount, level);
        }

        public class Node
        {
            private int data = -1;
            private Node[] nextNodes = new Node[MAX_LEVEL];
            private int maxLevel = 0;
        }

        public int randomLevel()
        {
            int level = 1;
            while(level < MAX_LEVEL && Math.random() < skip)
            {
                level++;
            }

            return level;
        }
    }

}
