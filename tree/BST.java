package tree;

public class BST {
    public static void main(String[] args) {
        int[] nums = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySearchTree tree = new BinarySearchTree();
        for (int i = 0; i < nums.length; i++) {
            tree.add(new Node(nums[i]));
        }
        tree.deleteNode(10);
        tree.inOrder();
    }
}

class BinarySearchTree {
    Node root;

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void inOrder() {
        if (root == null) {
            return;
        }
        root.inOrder();
    }

    public Node search(int value) {
        if (root == null) {
            return null;
        }
        return this.root.search(value);
    }

    public Node searchParentNode(int value) {
        if (root == null) {
            return null;
        }
        return this.root.searchParentNode(value);
    }

    public void deleteNode(int value) {
        if (root == null) {
            return;
        }
        Node target = search(value);
        if (target == null) {
            return;
        }
        if (root.left == null && root.right == null) {//删除根节点

            root = null;
            return;
        }
        Node parentNode = searchParentNode(value);
        if (target.left == null && target.right == null) {// 删除叶节点
            if (parentNode.left != null && parentNode.left == target) {
                parentNode.left = null;
            } else if (parentNode.right != null && parentNode.right == target) {
                parentNode.right = null;
            }
        } else if (target.left != null && target.right != null) {// 删除target节点，但target节点左右子树不为空

            int minValue = deleteRightTreeMin(target.right);
            target.value = minValue;
        } else {// 删除target节点，但target节点左或右子树为空
            if (target.left != null) {
                if (parentNode != null) {
                    if (parentNode.left == target) {
                        parentNode.left = target.left;
                    } else {
                        parentNode.right = target.left;
                    }
                } else {
                    root = target.left;
                }
            } else {
                if (parentNode != null) {
                    if (parentNode.left == target) {
                        parentNode.left = target.right;
                    } else {
                        parentNode.right = target.right;
                    }
                } else {
                    root = target.right;
                }
            }
        }
    }

    public int deleteRightTreeMin(Node node) {// 找右子树最小节点（也可以找左子树最大节点）
        while (node.left != null) {
            node = node.left;
        }
        deleteNode(node.value);
        return node.value;
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    public void inOrder() {
        if (this.left != null) {
            this.left.inOrder();
        }
        System.out.println(this.value);
        if (this.right != null) {
            this.right.inOrder();
        }
    }

    public Node search(int value) {
        if (this.value == value) {
            return this;
        }
        if (this.value > value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    public Node searchParentNode(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        }
        if (this.value > value && this.left != null) {
            return this.left.searchParentNode(value);
        } else if (this.value <= value && this.right != null) {
            return this.right.searchParentNode(value);
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }
}


