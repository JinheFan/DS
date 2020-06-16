package tree;

import java.util.*;

public class HuffmanCoding {
    public static void main(String[] args) {
        String str = "i like like like java do you like a java";
        byte[] bytes = str.getBytes();
        huffmanZip(bytes);
    }

    private static void huffmanZip(byte[] bytes) {
        List<Node> nodes = getNodes(bytes);
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        getCode(huffmanTreeRoot, "", stringBuilder);
        byte[] zipCode = zip(bytes, huffmanCodes);
        System.out.println(Arrays.toString(zipCode));
        byte[] source = decode(huffmanCodes, zipCode);
        System.out.println(new String(source));
    }

    static HashMap<Byte, String> huffmanCodes = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();

    public static void getCode(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if (node == null) {
            return;
        }
        if (node.data == null) {
            getCode(node.left, "0", stringBuilder2);
            getCode(node.right, "1", stringBuilder2);
        } else {
            huffmanCodes.put(node.data, stringBuilder2.toString());
        }
    }

    public static byte[] zip(byte[] bytes, HashMap<Byte, String> huffmanCodes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
        int len;
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        byte[] huffmanBytes = new byte[len];
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String string;
            if (i + 8 > stringBuilder.length()) {
                string = stringBuilder.substring(i);
            } else {
                string = stringBuilder.substring(i, i + 8);
            }
            huffmanBytes[index++] = (byte) Integer.parseInt(string, 2);
        }
        return huffmanBytes;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        root.preOrder();
    }

    public static List<Node> getNodes(byte[] bytes) {
        ArrayList<Node> nodes = new ArrayList<>();
        HashMap<Byte, Integer> map = new HashMap<>();
        for (byte b : bytes) {
            map.put(b, map.getOrDefault(b, 0) + 1);
        }
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    public static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parentNode = new Node(null, leftNode.weight + rightNode.weight);
            parentNode.left = leftNode;
            parentNode.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parentNode);
        }
        return nodes.get(0);
    }

    public static byte[] decode(HashMap<Byte, String> huffmanCodes, byte[] zipCode) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < zipCode.length; i++) {
            boolean flag = (i == zipCode.length - 1);
            stringBuilder.append(byteToBinary(!flag, zipCode[i]));
        }
        System.out.println(stringBuilder.toString());
        HashMap<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length(); ) {
            int count = 1;
            boolean flag = true;
            Byte temp = null;
            while (flag) {
                String str = stringBuilder.substring(i, i + count);
                if(map.get(str) != null) {
                    flag = false;
                    temp = map.get(str);
                } else {
                    count++;
                }
            }
            i += count;
            list.add(temp);
        }
        byte[] res = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static String byteToBinary(boolean flag, byte b) {
        int temp = b;
        if (flag) {
            temp |= 256;
        }
        String string = Integer.toBinaryString(temp);
        if (flag) {
            return string.substring(string.length() - 8);
        }
        return string;
    }

    static class Node implements Comparable<Node> {
        Byte data;
        int weight;
        Node left;
        Node right;

        public Node(Byte data, int weight) {
            this.data = data;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", weight=" + weight +
                    '}';
        }

        public void preOrder() {
            System.out.println(this);
            if (this.left != null) {
                this.left.preOrder();
            }
            if (this.right != null) {
                this.right.preOrder();
            }
        }
    }
}

