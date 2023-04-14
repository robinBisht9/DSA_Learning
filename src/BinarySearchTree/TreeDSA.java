package BinarySearchTree;

import java.util.TreeSet;

public class TreeDSA {
    public static void main(String[] args) {
        TreeSet<Integer> tset = new TreeSet<>();
        tset.add(10);
        tset.add(15);
        tset.add(90);
        tset.add(67);
        System.out.println(tset.higher(18));
        System.out.println(tset.ceiling(14));
    }
}
