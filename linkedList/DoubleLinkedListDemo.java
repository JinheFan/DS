package linkedList;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        Node node1 = new Node(1, "a", "apple");
        Node node2 = new Node(2, "b", "bug");
        Node node3 = new Node(3, "c", "cat");
        Node node4 = new Node(3, "d", "dog");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(node1);
        doubleLinkedList.add(node2);
        doubleLinkedList.add(node3);

        doubleLinkedList.update(node4);
        doubleLinkedList.delete(node2);
        doubleLinkedList.list();
    }
}

class DoubleLinkedList{
    Node head = new Node(0, "", "");
    public Node getHead() {
        return head;
    }

    public void list() {
        if(head.next == null) {
            return;
        }
        Node cur = head.next;
        while(cur != null) {
            System.out.println(cur);
            cur = cur.next;
        }
    }

    public void add(Node node) {
        Node cur = head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
        node.pre = cur;
    }

    public void update(Node node) {
        if(head == null || head.next == null) {
            return;
        }
        Node cur = head.next;
        boolean flag = false;
        while(true) {
            if(cur == null) {
                break;
            }
            if(cur.no == node.no) {
                flag = true;
                break;
            }
            cur = cur.next;
        }
        if(flag) {
            cur.name = node.name;
            cur.nickName = node.nickName;
        } else {
            System.out.println("没有找到更新的节点");
        }
    }

    public void delete(Node node) {
        if(head == null || head.next == null) {
            return;
        }
        Node cur = head.next;
        boolean flag = false;
        while (true) {
            if(cur == null) {
                break;
            }
            if(cur.no == node.no) {
                flag = true;
                break;
            }
            cur = cur.next;
        }
        if(flag) {
            cur.pre.next = cur.next;
            if (cur.next != null) {    //考虑是否删除的节点是最后一个节点
                cur.next.pre = cur.pre;
            }
        } else {
            System.out.println("没有找到要删除的节点");
        }
    }
}

class Node {
    public int no;
    public String name;
    public String nickName;
    public Node next;
    public Node pre;

    public Node(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "linkedList.Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
