/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package algorithms;

public class DeepFirstSearch {

    public static void search(Node node,int key){
        // first
        if (node.left!=null){
            search(node,key);
        }
        // mid
        if (node.right!=null){
            search(node,key);
        }
        // last
    }

    public static class Node{
        public Node left;
        public Node right;
        public int value;
    }

}

