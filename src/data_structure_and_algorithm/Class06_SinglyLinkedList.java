package data_structure_and_algorithm;

import java_basal_konwledge.TxtFileTest;

import java.util.ArrayList;
import java.util.Iterator;

public class Class06_SinglyLinkedList
{
    // 数据结构与算法之美: 06 链表

    private  Node head = null;

    //通过节点值访问节点
    public Node findByValue(int value)
    {
        Node p = head;
        while (p != null && p.data != value)
        {
            p = p.next;
        }
        return p;
    }

    // 通过节点索引访问节点
    public Node findByIndex(int index)
    {
        Node p = head;
        int pos = 0;
        while( p != null && pos != index)
        {
            p = p.next;
            ++ pos;
        }
        return p;
    }

    // 无头结点
    //表头部插入
    //这种操作将如输入的顺序相反 逆序
    public void insertToHead(int value)
    {
        Node newNode = new Node(value,null);
        insertToHead(newNode);
    }
    public void insertToHead(Node newNode)
    {
        if(head == null)
        {
            head = newNode; // 如果原来的头结点就是空的，就把新的节点直接作为头结点
        }
        else
        {
            newNode.next = head;  // 把原来的头结点放在新节点的后面
            head = newNode; // 使先的节点作为头结点
        }
    }

    // 顺序插入，从链表的尾部插入
    public void insertToTail(int value)
    {
        Node newNode = new Node(value,null);

        if(head == null)
        {
            head = newNode; // 如果链表是空的，则把将要插入的节点作为头结点
        }
        else
        {
            // 如果链表不为空，则把新的节点插入到链表的尾部
            Node q =  head;
            while( q.next != null)
            {
                q = q.next;  // 这个循环是用来找到链表的最后一个节点
            }
            newNode.next = q.next; // q.next == null，这一步好像有点多余，newNode.next 本来就是 null
            q.next = newNode;
        }
    }

    // 将新的节点插在节点p的后面
    public void insertAfter(Node p,int value)
    {
        Node newNode = new Node(value,null);
        insertAfter(p,newNode);
    }
    public void insertAfter(Node p,Node newNode)
    {
        if(p == null) return;
        newNode.next = p.next;
        p.next = newNode;
    }

    // 将新的节点，插入到指定的节点之前,这个比之前的方法要复杂一点
    public void insertBefore(Node p,int value)
    {
        Node newNode = new Node(value,null);
        insertBefore(p,newNode);
    }
    public void insertBefore(Node p,Node newNode)
    {
        if(p == null) return; // 如果p是空的，则直接返回
        if(p == head)
        {
            insertToHead(newNode); // 如果p是头节点，则将newNode直接插到链表头部
            return;
        }
        // 接下来更具一般性的操作
        Node q = head;
        while (q != null && q.next != p)
        {
            q = q.next;
        }
        if(q ==null) return;
        newNode.next = p;
        q.next =  newNode;

    }

    // 根据节点删除
    public void deleteByNode(Node p)
    {
        // 删除节点p
        if(p == null || head == null) return;
        if(p == head)
        {
            head = head.next;
            return;
        }
        Node q = head;
        while (q.next != p && q != null)
        {
            q = q.next;
        }
        if(q == null) return;
        q.next = q.next.next;
    }

    // 根据数值删除节点 这个不太好理解
    public void deleteByValue(int value)
    {
        if(head == null) return;
        Node p = head;
        Node q = null;
        while(p != null && p.data != value)
        {
            q = p;
            p = p.next;
        }
        if(p == null) return;
        if(q == null)
        {
            head = head.next;
        }
        else
        {
            q.next = q.next.next;
        }
    }

    // 打印全部节点
    public void printAll()
    {
        if(head == null) return;
        Node p = head;
        while (p != null)
        {
            System.out.println(p);
            p = p.next;
        }
    }

    // 判断两个链表是否相等
    public boolean TFResult(Node left,Node right)
    {
        Node l = left;
        Node r = right;
        System.out.println("left_" + l.data);
        System.out.println("right_" + r.data);
        while(l != null && r != null)
        {
            if(l.data == r.data)
            {
                l = l.next;
                r = r.next;
            }
            else
            {
                break;
            }
        }
        System.out.println("结果是：");
        return l == null && r == null;
    }

    // 判断是否是回文
    public boolean palindrome()
    {
        if(head == null)
            return false;
        else
        {
            System.out.println("开始查找中间节点");
            Node p = head;
            Node q = head;
            if(p.next == null)
            {
                System.out.println("只有一个元素");
                return true;
            }
            while(q.next != null && q.next.next != null)
            {
                p = p.next;
                q = q.next.next; // 因为 q 的步长，是 p 的两倍,所以当 q 走到最后一个节点，p 一定在中间
            }
            System.out.println("中间节点" + p.data);
            System.out.println("开始执行奇数节点的回文判断");
            Node leftLink = null;
            Node rightLink = null;
            if(q.next == null)
            {
                rightLink = p.next;
                leftLink = inverseLinkList(p).next;
                System.out.println("左边第一个节点" + leftLink.data);
                System.out.println("右边第一个节点" + rightLink.data);
            }
            else
            {
                // p q 均为中点
                rightLink = p.next;
                leftLink = inverseLinkList(p);
            }
            return TFResult(leftLink,rightLink);
        }
    }

    // 带头节点的链表的翻转
    public Node inverseLinkList_head( Node p)
    {
        // head为新建的一个头结点
        Node Head = new Node(9999,null);

        // p为原来整个链表的头结点，现在Head指向整个链表
        Head.next = p;
        /*
        带头结点的链表翻转等价于
        从第二个元素开始重新头插法建立链表
        */
        Node cur = p.next;
        p.next = null;
        Node next = null;
        while(cur != null)
        {
            next = cur.next;
            cur.next = Head.next;
            Head.next = cur;

            cur = next;
        }

        return Head; // Head就是新的由头链表的表头
    }

    // 无头结点的链表翻转
    public Node inverseLinkList(Node p)  // 参数p应该是链表的最后一个节点，该函数将翻转整个链表的顺序
    {
        Node pre = null;
        Node r = head;
        System.out.println("z---" + r.data);
        Node next = null;
        while(r != p)
        {
            next = r.next; // 此时 将r.next 的值 赋值给next

            r.next = pre; // 此时r.next = null
            pre = r; // 将r赋值给pre ，即此时 r == head
            r = next;
        }
        r.next = pre;
        return r;
    }

    public static Node createNode(int value)
    {
        return new Node(value,null);
    }

    // 节点类，及其构造方法
    public static class Node
    {
        private int data;
        private Node next;

        public Node(int data,Node next)
        {
            this.data = data;
            this.next = next;
        }
        public int getData()
        {
            return data;
        }
    }

    public static void main(String[] args)
    {

        Iterator<TxtFileTest.Student> iter = new ArrayList<TxtFileTest.Student>().iterator();
        while (iter.hasNext())
        {
            TxtFileTest.Student s = iter.next();
        }
    }
}
