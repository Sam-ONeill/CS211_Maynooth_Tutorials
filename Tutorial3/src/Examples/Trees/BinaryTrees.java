package Examples.Trees;

import java.util.*;

public class BinaryTrees {
    public class BinaryTreeNode<T> {
        T value;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public class BinaryTree<T extends Comparable<T>> {
        private BinaryTreeNode<T> root;

        public BinaryTree() {
            root = null;
        }

        public boolean isEmpty() {
            return root == null;
        }

        public BinaryTreeNode<T> getRoot() {
            return root;
        }

        public void setRoot(BinaryTreeNode<T> root) {
            this.root = root;
        }

        public void insert(T value) {
            root = insert(root, value);
        }

        private BinaryTreeNode<T> insert(BinaryTreeNode<T> node, T value) {
            if (node == null) {
                return new BinaryTreeNode<T>(value);
            } else if (value.compareTo(node.value) < 0) {
                node.left = insert(node.left, value);
            } else if (value.compareTo(node.value) > 0) {
                node.right = insert(node.right, value);
            }
            return node;
        }

        public boolean contains(T value) {
            return contains(root, value);
        }

        private boolean contains(BinaryTreeNode<T> node, T value) {
            if (node == null) {
                return false;
            } else if (value.compareTo(node.value) == 0) {
                return true;
            } else if (value.compareTo(node.value) < 0) {
                return contains(node.left, value);
            } else {
                return contains(node.right, value);
            }
        }

        public void remove(T value) {
            root = remove(root, value);
        }

        private BinaryTreeNode<T> remove(BinaryTreeNode<T> node, T value) {
            if (node == null) {
                return null;
            } else if (value.compareTo(node.value) < 0) {
                node.left = remove(node.left, value);
            } else if (value.compareTo(node.value) > 0) {
                node.right = remove(node.right, value);
            } else {
                if (node.left == null) {
                    return node.right;
                } else if (node.right == null) {
                    return node.left;
                } else {
                    node.value = minValue(node.right);
                    node.right = remove(node.right, node.value);
                }
            }
            return node;
        }

        private T minValue(BinaryTreeNode<T> node) {
            T minv = node.value;
            while (node.left != null) {
                minv = node.left.value;
                node = node.left;
            }
            return minv;
        }

        public void printInOrder() {
            System.out.print("In-order traversal: ");
            printInOrder(root);
            System.out.println();
        }

        private void printInOrder(BinaryTreeNode<T> node) {
            if (node != null) {
                printInOrder(node.left);
                System.out.print(node.value + " ");
                printInOrder(node.right);
            }
        }

        public void printPreOrder() {
            System.out.print("Pre-order traversal: ");
            printPreOrder(root);
            System.out.println();
        }

        private void printPreOrder(BinaryTreeNode<T> node) {
            if (node != null) {
                System.out.print(node.value + " ");
                printPreOrder(node.left);
                printPreOrder(node.right);
            }
        }

        public void printPostOrder() {
            System.out.print("Post-order traversal: ");
            printPostOrder(root);
            System.out.println();
        }

        private void printPostOrder(BinaryTreeNode<T> node) {
            if (node != null) {
                printPostOrder(node.left);
                printPostOrder(node.right);
                System.out.print(node.value + " ");
            }
        }

        public int size() {
            return size(root);
        }

        private int size(BinaryTreeNode<T> node) {
            if (node == null) {
                return 0;
            } else {
                return 1 + size(node.left) + size(node.right);
            }
        }

        // Traversal methods

        //Pre-order traversal example
        //Copying a tree
        public BinaryTree<T> copy() {
            BinaryTree<T> newTree = new BinaryTree<>();
            copyPreOrder(this.root, newTree);
            return newTree;
        }

        private void copyPreOrder(BinaryTreeNode<T> node, BinaryTree<T> newTree) {
            if (node != null) {
                newTree.insert(node.value);
                copyPreOrder(node.left, newTree);
                copyPreOrder(node.right, newTree);
            }
        }


        //In-order traversal example
        //Sorting a binary tree
        public List<T> sort() {
            List<T> sortedList = new ArrayList<>();
            inOrderTraversal(root, sortedList);
            Collections.sort(sortedList);
            return sortedList;
        }

        private void inOrderTraversal(BinaryTreeNode<T> node, List<T> sortedList) {
            if (node != null) {
                inOrderTraversal(node.left, sortedList);
                sortedList.add(node.value);
                inOrderTraversal(node.right, sortedList);
            }
        }

        public BinaryTree<Integer> createBinaryTreeFromSortedList(List<Integer> sortedList) {
            if (sortedList == null || sortedList.isEmpty()) {
                return null;
            }
            int midIndex = sortedList.size() / 2;
            BinaryTree<Integer> tree = new BinaryTree<Integer>();
            tree.insert(sortedList.get(midIndex));
            List<Integer> leftSublist = sortedList.subList(0, midIndex);
            List<Integer> rightSublist = sortedList.subList(midIndex + 1, sortedList.size());
            tree.root.left = createBinaryTreeFromSortedList(leftSublist).root;
            tree.root.right = createBinaryTreeFromSortedList(rightSublist).root;
            return tree;
        }



        //Post-order traversal
        //deleting nodes from a tree
        public void deleteNodes(List<T> valuesToDelete) {
            for (T value : valuesToDelete) {
                root = deleteNode(root, value);
            }
        }

        private BinaryTreeNode<T> deleteNode(BinaryTreeNode<T> node, T value) {
            if (node == null) {
                return null;
            }
            if (value.compareTo(node.value) < 0) {
                node.left = deleteNode(node.left, value);
            } else if (value.compareTo(node.value) > 0) {
                node.right = deleteNode(node.right, value);
            } else {
                if (node.left == null) {
                    return node.right;
                } else if (node.right == null) {
                    return node.left;
                } else {
                    T minValue = getMinValue(node.right);
                    node.value = minValue;
                    node.right = deleteNode(node.right, minValue);
                }
            }
            return node;
        }

        private T getMinValue(BinaryTreeNode<T> node) {
            T minValue = node.value;
            while (node.left != null) {
                minValue = node.left.value;
                node = node.left;
            }
            return minValue;
        }


        //Level-order traversal
        //Find the shortest path in a tree

        public List<T> shortestPath(T value) {
            List<T> path = new ArrayList<>();

            Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
            queue.offer(root);

            Map<BinaryTreeNode<T>, BinaryTreeNode<T>> parentMap = new HashMap<>();
            parentMap.put(root, null);

            while (!queue.isEmpty()) {
                BinaryTreeNode<T> curr = queue.poll();

                if (curr.value.equals(value)) {
                    while (curr != null) {
                        path.add(0, curr.value);
                        curr = parentMap.get(curr);
                    }
                    return path;
                }

                if (curr.left != null) {
                    queue.offer(curr.left);
                    parentMap.put(curr.left, curr);
                }

                if (curr.right != null) {
                    queue.offer(curr.right);
                    parentMap.put(curr.right, curr);
                }
            }

            return null;
        }

    }


    public static void main(String[] args) {
        // create a binary tree and add some nodes
        BinaryTrees myTree = new BinaryTrees();

        BinaryTree<Integer> tree = myTree.new BinaryTree<Integer>();
        tree.insert(8);
        tree.insert(4);
        tree.insert(10);
        tree.insert(2);
        tree.insert(6);
        tree.insert(9);
        tree.insert(12);

        // copy the tree using pre-order traversal
        BinaryTrees myCopyTree = new BinaryTrees();

        BinaryTree<Integer> copiedTree = myCopyTree.new BinaryTree<>();
        copiedTree.setRoot(myCopyTree.preOrderCopy(tree.getRoot()));

        // print the copied tree in-order
        System.out.print("In-order traversal of copied tree: ");
        copiedTree.printInOrder(); // output: In-order traversal of copied tree: 2 4 6 8 9 10 12

        // sort the original tree in-order
        System.out.print("Sorted order of original tree: ");
        List<Integer> sortedList = new ArrayList<>();
        inOrderSort(tree.getRoot(), sortedList);
        for (Integer value : sortedList) {
            System.out.print(value + " ");
        }
        System.out.println(); // output: Sorted order of original tree: 2 4 6 8 9 10 12

        /*
                8
               / \
              4   10
             / \    \
            2   6   9
                   \
                   12

         */


        // delete nodes from the original tree using post-order traversal
        tree.remove(6);
        tree.remove(2);
        tree.remove(12);

        // print the modified tree in-order
        System.out.print("In-order traversal of modified tree: ");
        tree.printInOrder(); // output: In-order traversal of modified tree: 4 8 9 10

        /*

                8
               / \
              4   10
                 \
                  9


         */

        // find the shortest path from the root to a node using level-order traversal
        BinaryTreeNode<Integer> node = tree.getRoot().left;
        List<BinaryTreeNode<Integer>> shortestPath = shortestPathToNode(tree.getRoot(), node);
        System.out.print("Shortest path from root to node " + node.value + ": ");
        for (BinaryTreeNode<Integer> n : shortestPath) {
            System.out.print(n.value + " ");
        }
        System.out.println(); // output: Shortest path from root to node 4: 8 4
    }

    // method to copy a binary tree using pre-order traversal
    private <T extends Comparable<T>> BinaryTreeNode<T> preOrderCopy(BinaryTreeNode<T> node) {
        if (node == null) {
            return null;
        }

        BinaryTreeNode<T> copy = new BinaryTreeNode<>(node.value);
        copy.left = preOrderCopy(node.left);
        copy.right = preOrderCopy(node.right);
        return copy;
    }

    // method to sort the values of a binary tree using in-order traversal
    private static <T extends Comparable<T>> void inOrderSort(BinaryTreeNode<T> node, List<T> sortedList) {
        if (node == null) {
            return;
        }
        inOrderSort(node.left, sortedList);
        sortedList.add(node.value);
        inOrderSort(node.right, sortedList);
    }

    // method to find the shortest path from the root to a node using level-order traversal
    private static <T extends Comparable<T>> List<BinaryTreeNode<T>> shortestPathToNode(BinaryTreeNode<T> root, BinaryTreeNode<T> node) {
        List<BinaryTreeNode<T>> path = new ArrayList<>();
        if (root == null || node == null) {
            return path;
        }
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        Map<BinaryTreeNode<T>, BinaryTreeNode<T>> parents = new HashMap<>();
        queue.add(root);
        parents.put(root, null);
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.remove();
            if (current == node) {
                path.add(node);
                BinaryTreeNode<T> parent = parents.get(node);
                while (parent != null) {
                    path.add(0, parent);
                    parent = parents.get(parent);
                }
                return path;
            }
            if (current.left != null) {
                queue.add(current.left);
                parents.put(current.left, current);
            }
            if (current.right != null) {
                queue.add(current.right);
                parents.put(current.right, current);
            }
        }
        return path;
    }




}


