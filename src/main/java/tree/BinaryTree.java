package tree;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Random;

public class BinaryTree<T> implements Tree<T> {

    final static Logger logger = LogManager.getLogger(BinaryTree.class);
    private Node root;
    private static int depthOfTree = 0;

    public static BinaryTree<Integer> generateRandomBinaryTree(int numberOfElements) {

        BinaryTree<Integer> randomBinaryTree = new BinaryTree<>();

        Node<Integer> node = new Node<>(1);

        randomBinaryTree.root = node;

        Random rnd = new Random();
        int randomNumber = rnd.nextInt(3);


        for (int i = 2; i <= numberOfElements; i++) {
            depthOfTree++;
            if (randomNumber == 0) {
                node.left = new Node<>(i);
                node = node.left;
            }
            if (randomNumber == 1) {
                node.right = new Node<>(i);
                node = node.right;
            }
            if (randomNumber == 2) {
                node.left = new Node<>(i);
                node.right = new Node<>(i + 1);
                node = node.left;
                i++;
            }
        }
        System.out.println(depthOfTree);
        return randomBinaryTree;
    }

    public static BinaryTree<Integer> simpleBinaryTreeCreator() {

        BinaryTree<Integer> simpleTree = new BinaryTree<>();
        simpleTree.root = new Node(1);
        Node n = simpleTree.root;
        n.left = new Node(2);
        n.right = new Node(3);
        n.right.left = new Node(6);
        n = n.left;
        n.left = new Node(4);
        n.right = new Node(5);
        return simpleTree;
    }


    private String print(Node n, String result) {
        logger.info(n.value);

        if(n.left != null) {
            //result = n.value+result;
            result += print(n.left, result);

        }
        if(n.right != null) {
            result += print(n.right, result);
        }


        return result + n.value;



//        String current = n.value.toString() + ", ";
//
//        return current + print(n.left) + print(n.right);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[").append(print(root,"")).append("]");
//        int stringBuilderLength = sb.length();
//        sb.replace(stringBuilderLength-3,stringBuilderLength-1,"");
        return sb.toString();
    }

    @Override
    public int depth() {
        return depthOfTree;
    }


    private static class Node<T> {

        private T value;
        private Node<T> left;
        private Node<T> right;

        public Node(T value) {
            this.value = value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> node) {
            node = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> node) {
            node = right;
        }
    }
}
