package data_structure_and_algorithm;

import sun.awt.image.ImageWatched;
import zero_java.Class137;

public class Class23_BinaryTree_one
{
    //  数据结构与算法之美 22： 二叉树

    public static void main(String[] args)
    {

        Node node_zero = new Node(0);
        Node node_one = new Node(1);
        Node node_two = new Node(2);
        Node node_three = new Node(3);
        Node node_four = new Node(4);
        Node node_five = new Node(5);
        Node node_six = new Node(6);
        node_zero.left = node_one;
        node_zero.right = node_two;
        node_one.left = node_three;
        node_one.right = node_four;
        node_two.left = node_five;
        node_two.right = node_six;

        LinkedBinaryTree linkedBinaryTree = new LinkedBinaryTree(node_zero);
        linkedBinaryTree.preOrder(node_zero);
    }


    // 链式储存的二叉树
    public static class LinkedBinaryTree
    {
        Node root ;
        public LinkedBinaryTree(Node root)
        {
            this.root = root;
        }

        public void preOrder( Node root)
        {
            if(root == null) return;
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // 节点类
    public static class Node
    {
        int data;
        Node left;
        Node right;
        public Node()
        {

        }
        public Node(int data,Node left,Node right)
        {
            this.data = data;
            this.left = left;
            this.right = right;
        }
        public Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

}
