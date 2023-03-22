package Examples.Trees;
import java.util.List;
import java.util.ArrayList;

public class GeneralTree {

    public class TreeNode<T> {
        T value;
        List<TreeNode<T>> children;

        public TreeNode(T value) {
            this.value = value;
            this.children = new ArrayList<>();
        }

        public void addChild(TreeNode<T> child) {
            children.add(child);
        }
    }
    public class Tree<T> {
        private TreeNode<T> root; // the root node of the tree

        // constructor to create a new tree with a root value
        public Tree(T value) {
            this.root = new TreeNode<>(value);
        }

        // getter method to get the root node
        public TreeNode<T> getRoot() {
            return root;
        }

        // setter method to set the root node
        public void setRoot(TreeNode<T> root) {
            this.root = root;
        }

        // method to check if the tree is empty
        public boolean isEmpty() {
            return root == null;
        }

        // method to clear the tree
        public void clear() {
            root = null;
        }

        // method to check if the tree contains a specific value
        public boolean contains(T value) {
            return find(value) != null;
        }

        // method to find a node with a specific value
        public TreeNode<T> find(T value) {
            return find(root, value);
        }

        // recursive helper method to find a node with a specific value
        private TreeNode<T> find(TreeNode<T> node, T value) {
            if (node == null) {
                return null;
            } else if (node.value.equals(value)) {
                return node;
            } else {
                TreeNode<T> result = null;
                for (TreeNode<T> child : node.children) {
                    result = find(child, value);
                    if (result != null) {
                        break;
                    }
                }
                return result;
            }
        }

        // method to add a new node as a child of an existing node with a specific value
        public void add(T parentValue, T value) {
            TreeNode<T> parent = find(parentValue);
            if (parent != null) {
                parent.addChild(new TreeNode<>(value));
            }
        }

        // method to remove a node with a specific value from the tree
        public void remove(T value) {
            remove(root, value);
        }

        // recursive helper method to remove a node with a specific value from the tree
        private void remove(TreeNode<T> node, T value) {
            if (node != null) {
                List<TreeNode<T>> children = node.children;
                for (int i = 0; i < children.size(); i++) {
                    TreeNode<T> child = children.get(i);
                    if (child.value.equals(value)) {
                        children.remove(i);
                        return;
                    } else {
                        remove(child, value);
                    }
                }
            }
        }

        // method to get the size of the tree
        public int size() {
            return size(root);
        }

        // recursive helper method to get the size of the tree
        private int size(TreeNode<T> node) {
            if (node == null) {
                return 0;
            } else {
                int count = 1;
                for (TreeNode<T> child : node.children) {
                    count += size(child);
                }
                return count;
            }
        }
    }

    public static void main(String[] args) {
        // create a new tree with root value 1
        GeneralTree myTree = new GeneralTree();

        Tree<Integer> tree = myTree.new Tree<>(1);

        // add some nodes to the tree
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(2, 4);
        tree.add(2, 5);
        tree.add(3, 6);
        tree.add(3, 7);

        // print the size of the tree
        System.out.println("Size of tree: " + tree.size()); // output: Size of tree: 7

        // print whether the tree contains the value 4
        System.out.println("Tree contains 4: " + tree.contains(4)); // output: Tree contains 4: true

        // remove the node with value 4 from the tree
        tree.remove(4);

        // print the size of the tree after removing a node
        System.out.println("Size of tree after removing 4: " + tree.size()); // output: Size of tree after removing 4: 6

        // print whether the tree contains the value 4 after removing it
        System.out.println("Tree contains 6 after removing it: " + tree.contains(6)); // output: Tree contains 4 after removing it: false
    }



}
