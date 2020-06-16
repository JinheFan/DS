package hash;

public class HashTableDemo {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "a");
        Employee e2 = new Employee(2, "b");
        Employee e3 = new Employee(3, "c");
        Employee e4 = new Employee(8, "d");
        HashTab hashTable = new HashTab(7);
        hashTable.add(e1);
        hashTable.add(e2);
        hashTable.add(e3);
        hashTable.add(e4);
        System.out.println("before delete");
        hashTable.list();
        System.out.println("after delete");
        hashTable.delete(e4.id);
        hashTable.list();
    }
}

class Employee {
    public int id;
    public String name;
    public Employee next;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class EmployeeLinkedList {
    private Employee head;

    public void add(Employee employee) {
        if(head == null) {
            head = employee;
            return;
        }
        Employee cur = head;
        while (true) {
            if(cur.next == null) {
                break;
            }
            cur = cur.next;
        }
        cur.next = employee;
    }

    public void list() {
        if (head == null) {
            return;
        }
        Employee cur = head;
        while (true) {
            System.out.println(cur.name);
            if (cur.next == null) {
                break;
            }
            cur = cur.next;
        }
    }

    public void find(int id) {
        if(head == null) {
            return;
        }
        Employee cur = head;
        while (true) {
            if (cur == null) {
                break;
            }
            if(cur.id == id) {
                System.out.println(cur.name);
                break;
            }
            cur = cur.next;
        }
    }

    public void delete(int id) {
        if(head == null) {
            return;
        }
        Employee cur = head;
        int size = getSize();
        if(size == 1 && cur.id == id) {
            head = null;
        }
        while(true) {
            if (cur == null) {
                break;
            }
            if (cur.next != null && cur.next.id == id) {
                if(cur.next.next != null) {
                    cur.next = cur.next.next;
                    break;
                }
                cur.next = null;
                break;
            }
            cur = cur.next;
        }
    }

    public int getSize() {
        if (head == null) {
            return 0;
        }
        Employee cur = head;
        int res = 1;
        while (true) {
            if (cur.next == null) {
                return res;
            }
            res += 1;
            cur = cur.next;
        }
    }
}

class HashTab {
    private int size;
    EmployeeLinkedList[] employeeLinkedLists;

    public HashTab(int size) {
        this.size = size;
        this.employeeLinkedLists = new EmployeeLinkedList[this.size];
        for (int i = 0; i < size; i++) {
            employeeLinkedLists[i] = new EmployeeLinkedList();
        }
    }

    public int getHashCode(int id) {
        return id % size;
    }

    public void add(Employee employee) {
        int index = getHashCode(employee.id);
        employeeLinkedLists[index].add(employee);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            employeeLinkedLists[i].list();
        }
    }

    public void find(int id) {
        int index = getHashCode(id);
        employeeLinkedLists[index].find(id);
    }

    public void delete(int id) {
        int index = getHashCode(id);
        employeeLinkedLists[index].delete(id);
    }
}
