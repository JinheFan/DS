package linkedList;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(1, "a", "apple");
        HeroNode node2 = new HeroNode(2, "b", "bubble");
        HeroNode node3 = new HeroNode(3, "c", "cop");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addOrder(node2);
        singleLinkedList.addOrder(node1);
        singleLinkedList.addOrder(node3);
        HeroNode node4 = new HeroNode(2, "d", "dragon");
        singleLinkedList.update(node4);
        singleLinkedList.list();
    }
}

class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "linkedList.HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");
    public void add(HeroNode node) {
        // head 节点不能动， 因此需要一个temp节点代替head节点来遍历
        HeroNode temp = head;
        while(true) {
            if(temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }
    // 显示链表
    public void list() {
        if(head.next == null) {
            System.out.println("Node is null");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if(temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // 按照no从小到大添加
    public void addOrder(HeroNode node) {
        HeroNode temp = head;
        boolean flag = false;
        while(true) {
            if (temp.next == null) {
                break;
            }
            if(temp.next.no > node.no) {
                break;
            } else if (temp.next.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag) {
            System.out.println("不能添加");
        } else {
            node.next = temp.next;
            temp.next = node;
        }
    }

    public void update(HeroNode node) {
        if(head.next == null) {
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while(true) {
            if(temp == null) {
                break;
            }
            if(temp.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag) {
            temp.name = node.name;
            temp.nickName = node.nickName;
        } else {
            System.out.println("没有找到要更新的节点");
        }
    }

    public void delete(HeroNode node) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if(temp.next == null) {
                break;
            }
            if(temp.next.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("没有找到要删除的节点");
        }
    }

    public static int getSize(HeroNode head) {
        if(head.next == null) {
            return 0;
        }
        HeroNode temp = head.next;
        int count = 0;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static HeroNode findLastKNode(HeroNode head, int k) {
        if(head.next == null) {
            return null;
        }
        int size = getSize(head);
        if(k <= 0 || k > size) {
            return null;
        }
        HeroNode temp = head.next;
        for(int i = 0; i < size - k; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public static void reverse(HeroNode head) {
        if(head.next == null || head.next.next == null) {
            return;
        }
        HeroNode cur = head.next;
        HeroNode next = null; // 指向当前节点的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }

    public static void reversePrint(HeroNode head) {
        if(head.next == null || head.next.next == null) {
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while(cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while(stack != null) {
            System.out.println(stack.pop());
        }
    }
}

