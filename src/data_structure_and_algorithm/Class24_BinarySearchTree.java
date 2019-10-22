package data_structure_and_algorithm;

public class Class24_BinarySearchTree
{
    //数据结构与算法之美: 24 二叉查找树

    private Node tree;
    public static void main(String[] args)
    {

    }

    // 二叉查找树的查找
    public Node find(int data)
    {
        Node p = tree;
        while(p != null)
        {
            if(data < p.data) p = p.left;
            else if(data > p.data) p = p.right;
            else return p;
        }
        return null;
    }

    // 二叉查找树的插入
    public void insert(int data)
    {
        if(tree == null)
        {
            tree = new Node(data);
            return;
        }
        Node p = tree;
        while(p != null)
        {
            if(data < p.data)
            {
                if(p.right == null)
                {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            }
            else
            {
                if(p.left == null)
                {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    // 二叉查找树的删除操作
    public void delete(int data)
    {
        Node p = tree;
        Node pp = null;
        while(p != null && p.data != data)
        {  // 找到锁妖删除的data对应的节点
            pp = p;
            if(data < p.data) p = p.left;
            else p = p.right;
        } // 循环结束之后 pp 是p 的父节点
        if(p == null) return;
        // 要删除的节点有两个子节点
        if(p.left != null && p.right != null)
        {
            // 首先要找到右子树中，data最小的节点
            Node minP = p.right;
            Node minPP = p; // minPP是minP的父节点
            while(minP.left != null)
            {
                minPP = minP;
                minP = minP.left;

            } // 循环结束之后，minP就是之前所要寻找的节点
            p.data = minP.data; // 将minP 的数据替换到p中
            p = minP; // 下面就变成删了minP了
            pp = minPP;
        }
        // 要删除的节点是叶子节点或者只有一个节点
        Node child; // p的子节点
        if(p.left != null) child = p.left;
        else if(p.right != null) child = p.right;
        else child = null;

        if(pp == null) tree = child; // 要删除的是根节点
        else if(pp.left == p) pp.left = child;
        else pp.right = child;

    }

    private static class Node
    {
        private int data;
        private Node left;
        private Node right;

        public Node(int data)
        {
            this.data = data;
        }
    }
}
