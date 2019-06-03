package com.waston.bin_tree.impl;

import com.waston.bin_tree.BinTree.My_BinTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description: 二分搜索树
 * @Author: Waston
 * @Date: 2019/5/30 15:49
 */
public class BinSearchTree<E extends Comparable> implements My_BinTree<E> {
    /**
     * 内部类：二叉链节点
     */
    private class Node{
        private E data;
        private Node left;
        private Node right;
        public Node(E data){
            this.data = data;
        }
    }
    private Node root;
    private int size;


    @Override
    public void add(E e) {
        if(root == null){
            Node node = new Node(e);
            root = node;
            size++;
        }

        // 继续根据值遍历子树
        add(root,e);
    }

    /**
     * 内部方法，根据要插入的值递归找到插入的位置，不包含重复元素
     * @param root 子树根节点
     * @param e 要插入的值
     */
    private void add(Node root,E e){
        // 终止条件
        if(e.equals(root.data)){
            return;
        }else if(e.compareTo(root.data) < 0 && root.left == null){
            Node node = new Node(e);
            root.left = node;
            size++;
        }else if(e.compareTo(root.data) > 0 && root.right == null){
            Node node = new Node(e);
            root.right = node;
            size ++;
        }
        // 左子树递归
        if(e.compareTo(root.data) < 0){
            add(root.left,e);
        }
        // 右子树递归
        if(e.compareTo(root.data) > 0){
            add(root.right,e);
        }
    }

    /**
     * 更高效的添加元素的方法
     * @param e
     */
    public void add2(E e){
        root = add2(root,e);
    }

    private Node add2(Node node, E e){
        if(node == null){
            Node newNode = new Node(e);
            size++;
            return newNode;
        }
        // 判断此时e到底在左子树还是右子树插入
        if(e.compareTo(node.data) < 0){
            node.left = add2(node.left,e);
        }
        if(e.compareTo(node.data) > 0){
            node.right = add2(node.right,e);
        }
        return node;
    }

    /**
     * 取得二叉树节点个数
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 查找二叉树中是否包含指定元素
     * @param e
     * @return
     */
    @Override
    public boolean contains(E e) {
        return contains(root,e);
    }

    /**
     * 内部方法，根据值递归检测当前二叉树是否包含指定元素
     * @param root 根节点
     * @param e 要插入的值
     * @return
     */
    private boolean contains(Node root,E e){
        // 终止条件
        if(root == null){
            return false;
        }
        if(e.equals(root.data)){
            return true;
        }
        // 左子树递归
        else if(e.compareTo(root.data) < 0){
            return contains(root.left,e);
        }
        // 右子树递归
        else {
            return contains(root.right,e);
        }
    }

    /**
     * 二叉树前序遍历
     */
    @Override
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 内部方法，递归调用前序遍历
     * @param node
     */
    private void preOrder(Node node){
        // 终止条件
        if(node == null){
            return;
        }
        // 先访问当前树根节点
        System.out.print(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // 前序遍历非递归方法
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            System.out.print(node.data+" ");
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }
    }

    /**
     * 二叉树中序遍历
     */
    @Override
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node){
        if(node == null)
            return;

        inOrder(node.left);
        System.out.print(node.data+" ");
        inOrder(node.right);
    }

    // 中序遍历非递归方法
    public void inOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            if(node.right != null)
                stack.push(node.right);
            System.out.print(node.data+" ");
            if(node.left != null)
                stack.push(node.left);
        }
    }

    /**
     * 二叉树后序遍历
     */
    @Override
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data+" ");
    }

    /**
     * 基于队列实现的二分搜索树层序遍历
     */
    @Override
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty());{
            Node node = queue.poll();
            System.out.print(node.data+" ");
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null){
                queue.add(node.right);
            }
        }

    }

    /**
     * 取得二叉树的最小值节点
     * @return
     */
    @Override
    public E getMin() {
        if(size == 0){
            throw new IllegalArgumentException("BST is Empty!");
        }
        return getMinNode(root).data;
    }

    /**
     * 顺着左子树向下寻找最小值
     * @param node
     * @return
     */
    private Node getMinNode(Node node){
        // 左子树往下再没有左节点，则此节点即为所求
        if(node.left == null){
            return node;
        }

        // 递归遍历
        return getMinNode(node.left);
    }

    /**
     * 取得二叉树的最大值节点
     * @return
     */
    @Override
    public E getMax() {
        if(size == 0){
            throw new IllegalArgumentException("BST is Empty!");
        }
        return getMaxNode(root).data;
    }

    private Node getMaxNode(Node node){
        // 右子树往下再没有右节点，则此节点即为所求
        if(node.right == null){
            return node;
        }

        // 递归遍历
        return getMinNode(node.right);
    }

    /**
     * 移除二叉树的最小值节点
     * @return
     */
    @Override
    public E removeMin() {
        E result = getMin();
        root = removeMinNode(root);
        return result;
    }

    private Node removeMinNode(Node node){
        // 找到要删除的节点
        if(node.left == null){
            Node rightTree = node.right;
            node.right = null;
            size--;
            return rightTree;
        }
        node.left = removeMinNode(node.left);
        return node;
    }

    /**
     * 移除二叉树的最大值节点
     * @return
     */
    @Override
    public E removeMax() {
        E result = getMax();
        root = removeMax(root);
        return result;
    }

    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 删除值为e的任意节点
     * @param e
     */
    public void removeNode(E e){
        root = removeNode(root,e);
    }

    private Node removeNode(Node node,E e){
        if(node == null){
            return null;
        }
        // 要删除的节点在左子树
        else if(e.compareTo(node.data) < 0){
            node.left = removeNode(node.left,e);
            return node;
        }
        // 要删除的节点在右子树
        else if(e.compareTo(node.data) > 0){
            node.right = removeNode(node.right,e);
            return node;
        }
        // 本节点就是要删除的节点
        else{
            // 要删除的节点左子树为空，返回右子树根节点
            if(node.left == null){
                Node rightTree = node.right;
                node.right = null;
                size--;
                return rightTree;
            }
            // 要删除的节点右子树为空，返回左子树根节点
            if(node.right == null){
                Node leftTree = node.left;
                node.left = null;
                size--;
                return leftTree;
            }
            // 要删除的节点左右子树均有值，找到后继或前驱节点
            else{
                // 找到右子树的最小值节点作为后继节点
                Node successor = getMinNode(node.right);
                // 删除右子树的最小节点，链到后继节点的右子树
                successor.right = removeMinNode(node.right);
                // 将原左子树链到后继节点左子树
                successor.left = node.left;
                node.left = node.right = null;
                return successor;
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }

    private void generateBSTString(Node node,int depth,StringBuilder res){
        if(node == null){
            res.append(generateDepth(0)+"null\n");
            return;
        }
        res.append(generateDepth(depth)+node.data+"\n");
        generateBSTString(node.left,depth+1,res);
        generateBSTString(node.right,depth+1,res);
    }

    private String generateDepth(int depth){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < depth; i++){
            sb.append("--");
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        My_BinTree<Integer> searchTree = new BinSearchTree<>();
        int[] num = new int[] {5,1,8,3,4,7,9};
        for(int i = 0;i < num.length;i++){
            ((BinSearchTree<Integer>) searchTree).add(num[i]);
        }
        System.out.println(searchTree);
        /*
            结果：
            5
            --1
            null
            ----3
            null
            ------4
            null
            null
            --8
            ----7
            null
            null
            ----9
            null
            null
        */

        searchTree.preOrder();
        System.out.println();
        ((BinSearchTree<Integer>) searchTree).preOrderNR();

        System.out.println();

        searchTree.inOrder();
        System.out.println();
        ((BinSearchTree<Integer>) searchTree).inOrderNR();
    }
}
