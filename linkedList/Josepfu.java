package linkedList;

public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.countBoy(1, 2, 5);
    }
}

class Boy {
    public int no;
    public Boy next;

    public Boy(int no) {
        this.no = no;
    }
}

class CircleSingleLinkedList {
    private Boy first = null;

    public void addBoy(int nums) {
        if(nums < 1) {
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if(i == 1) {
                first = boy;
                boy.next = boy;
                curBoy = first;
            } else {
                curBoy.next = boy;
                boy.next = first;
                curBoy = boy;
            }
        }
    }

    public void showBoy() {
        if(first == null) {
            return;
        }
        Boy curBoy = first;
        while(true) {
            System.out.println(curBoy.no);
            if(curBoy.next == first) {
                break;
            }
            curBoy = curBoy.next;
        }
    }

    public void countBoy(int start, int count, int nums) {
        if(first == null || start < 1 || start > nums) {
            return;
        }
        Boy helper = first;
        while(true) {
            if(helper.next == first) {
                break;
            }
            helper = helper.next;
        }
        for (int i = 0; i < start - 1; i++) {
            first = first.next;
            helper = helper.next;
        }
        while(true) {
            if(helper == first) {
                break;
            }
            for (int i = 0; i < count - 1; i++) {
                first = first.next;
                helper = helper.next;
            }
            System.out.println(first.no);
            first = first.next;
            helper.next = first;
        }
        System.out.println(first.no);
    }
}
