package data_structure_and_algorithm;

import com.sun.javafx.robot.FXRobotImage;

import java.io.PipedReader;

/**
 * Date:2019/12/28
 * Author: Dzh
 */
public class Class_35_trie
{
    // 字典树
    public class Trie
    {
        private TrieNode root = new TrieNode('/');

        // 插入一个字符串
        private void insert(String str)
        {
            char[] text = str.toCharArray();
            TrieNode p = root;
            for (char c : text)
            {
                int index = c - 'a';
                if (p.children[index] == null)
                {
                    TrieNode newNode = new TrieNode(c);
                    p.children[index] = newNode;
                }
                p = p.children[index];
            }
            p.isEndChar = true;
        }

        private int find(String str)
        {
            char[] text = str.toCharArray();
            TrieNode p = root;
            for (char c : text)
            {
                int index = c - 'a';
                if(p.children[index] == null)
                {
                    return -1;
                }
                p = p.children[index]; // 一个char 占16 bit 两个字 节
            }
            if(!p.isEndChar) return 0;
            return 1;
        }
        private class TrieNode
        {
            private char data;
            private TrieNode[] children = new TrieNode[26];
            private boolean isEndChar = false;

            public TrieNode(char data)
            {
                this.data = data;
            }
        }
    }
}
