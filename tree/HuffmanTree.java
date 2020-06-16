package tree;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] nums = {13, 7, 8, 3, 29, 6, 1};
        Node res = createHuffmanTree(nums);
        System.out.println(res);
    }

    public static Node createHuffmanTree(int[] nums) {
        List<Node> list = new ArrayList<>();
        for(int num : nums) {
            list.add(new Node(num));
        }
        while (list.size() > 1) {
            Collections.sort(list);
            System.out.println(list);
            Node leftNode = list.get(0);
            Node rightNode = list.get(1);
            Node parentNode = new Node(leftNode.value + rightNode.value);
            parentNode.left = leftNode;
            parentNode.right = rightNode;
            list.remove(leftNode);
            list.remove(rightNode);
            list.add(parentNode);
        }
        return list.get(0);
    }

    static class Node implements Comparable<Node>{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}
