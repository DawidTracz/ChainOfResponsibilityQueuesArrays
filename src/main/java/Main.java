import list.DawidList;
import queue.FifoListQueue;
import queue.LifoArrayQueue;
import tree.BinaryTree;


public class Main {


    public static void main(String[] args) {

        DawidList<Integer> lista1 = new DawidList<>();
        FifoListQueue<Integer> kolejka = new FifoListQueue<>();
        LifoArrayQueue<Integer> arrayQueue = new LifoArrayQueue<>(5);
        BinaryTree<Integer> firstTree = BinaryTree.simpleBinaryTreeCreator();
        System.out.println(firstTree.toString());

        //        IsLowerCaseChainElement lower = new IsLowerCaseChainElement();
//        lower.setNext(new IsUpperCaseChainElement());
//        lower.find("");

    }
}
