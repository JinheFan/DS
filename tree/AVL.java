package tree;

public class AVL {
    public static void main(String[] args) {
        int[] nums = {10, 12, 8, 9, 7, 6};
        AVLTree tree = new AVLTree();
        for (int i = 0; i < nums.length; i++) {
            tree.add(new AVLNode(nums[i]));
        }
        System.out.println(tree.root.height());
        System.out.println(tree.root.leftTreeHeight());
        System.out.println(tree.root.rightTreeHeight());
    }

}

class AVLTree {
    AVLNode root;

    public void add(AVLNode node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
        if (root.rightTreeHeight() - root.leftTreeHeight() > 1) {
            if (root.right.left.height() > root.right.right.height()) {
                root.right.rightRotate();
                root.leftRotate();
            } else {
                root.leftRotate();
            }
            return;
        } else if (root.leftTreeHeight() - root.rightTreeHeight() > 1) {
            if (root.left.right.height() > root.left.left.height()) {
                root.left.leftRotate();
                root.rightRotate();
            }  else {
                root.rightRotate();
            }
        }
    }

    public void inOrder() {
        if (root == null) {
            return;
        }
        root.inOrder();
    }

    public AVLNode search(int value) {
        if (root == null) {
            return null;
        }
        return this.root.search(value);
    }

    public AVLNode searchParentNode(int value) {
        if (root == null) {
            return null;
        }
        return this.root.searchParentNode(value);
    }

    public void deleteNode(int value) {
        if (root == null) {
            return;
        }
        AVLNode target = search(value);
        if (target == null) {
            return;
        }
        if (root.left == null && root.right == null) {//删除根节点

            root = null;
            return;
        }
        AVLNode parentNode = searchParentNode(value);
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

    public int deleteRightTreeMin(AVLNode node) {// 找右子树最小节点（也可以找左子树最大节点）
        while (node.left != null) {
            node = node.left;
        }
        deleteNode(node.value);
        return node.value;
    }
}
class AVLNode {
    int value;
    AVLNode left;
    AVLNode right;

    public AVLNode(int value) {
        this.value = value;
    }

    public int leftTreeHeight() {
        return left == null ? 0 : left.height();
    }

    public int rightTreeHeight() {
        return right == null ? 0 : right.height();
    }

    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    public void leftRotate() {
        AVLNode newNode = new AVLNode(this.value);
        newNode.left = this.left;
        newNode.right = this.right.left;
        this.value = this.right.value;
        this.right = this.right.right;
        this.left = newNode;
    }

    public void rightRotate() {
        AVLNode newNode = new AVLNode(this.value);
        newNode.right = this.right;
        newNode.left = this.left.right;
        this.value = this.left.value;
        this.left = this.left.left;
        this.right = newNode;
    }

    public void add(AVLNode node) {
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

    public AVLNode search(int value) {
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

    public AVLNode searchParentNode(int value) {
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