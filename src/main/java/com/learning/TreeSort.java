package com.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeSort<T extends Comparable<T>> {

    //type erasure

    public static void main(String[] args) {
        TreeSort<String> treeSort = new TreeSort<>();
        List<String> result = treeSort.sort(Arrays.asList("a", "b", "c"));
        TreeSort<Apple> appleTreeSort = new TreeSort<>();
        List<Apple> appleResult = appleTreeSort.sort(Arrays.asList(new Apple(1), new Apple(5)));
    }

    static class Apple implements Comparable<Apple> {

        private final int weight;

        Apple(int weight) {
            this.weight = weight;
        }

        @Override
        public int compareTo(Apple o) {
            return weight - o.weight;
        }
    }

    /*

    5 1 4 9 1 8 7 3 1 9

    Построение: O(n * log n)
    Поиск одного элемента: O(log n)
             5
       1           9
         4        8
        1


    1 1 1 1 1 1
        1
            1
                1
                    1
                        1
    Худший случай: O(n^2)

     */

    class Node {
        final T value;
        Node left;
        Node right;

        Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    List<T> sort(List<T> arr) {
        Node root = buildTree(arr);
        return treeToList(root);
    }

    List<T> treeToList(Node root) {
        List<T> result = new ArrayList<>();
        addToList(result, root);
        return result;
    }

    void addToList(List<T> list, Node root) {
        if (root.left != null) {
            addToList(list, root.left);
        }
        list.add(root.value);
        if (root.right != null) {
            addToList(list, root.right);
        }
    }

    Node buildTree(List<T> arr) { //returns root
        if (arr.size() == 0) {
            throw new IllegalArgumentException("empty array");
        }
        Node root = new Node(arr.get(0));
        for (int i = 1; i < arr.size(); i++) {
            addNode(root, new Node(arr.get(i)));
        }
        return root;
    }

    void addNode(Node currentRoot, Node node) {
        if (node.value.compareTo(currentRoot.value) >= 0) {
            if (currentRoot.right == null) {
                currentRoot.right = node;
            } else {
                addNode(currentRoot.right, node);
            }
        } else {
            if (currentRoot.left == null) {
                currentRoot.left = node;
            } else {
                addNode(currentRoot.left, node);
            }
        }
    }


}
