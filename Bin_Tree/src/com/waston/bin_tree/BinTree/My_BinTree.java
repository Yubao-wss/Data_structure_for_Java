package com.waston.bin_tree.BinTree;

/**
 * @Description: 二叉树接口
 * @Author: Waston
 * @Date: 2019/5/27 21:08
 */
public interface My_BinTree<E> {


    /**
     * 添加元素
     */
    void add(E e);

    /**
     * 取得二叉树节点个数
     * @return
     */
     int getSize();

    /**
     * 查找二叉树中是否包含指定元素
     * @param e
     * @return
     */
     boolean contains(E e);

    /**
     * 二叉树前序遍历
     */
    void preOrder();

    /**
     * 二叉树中序遍历
     */
    void inOrder();

    /**
     * 二叉树后序遍历
     */
    void postOrder();

    /**
     * 层序遍历
     */
    void levelOrder();

    /**
     * 取得二叉树的最小值节点
     * @return
     */
    E getMin();

    /**
     * 取得二叉树的最大值节点
     * @return
     */
    E getMax();

    /**
     * 移除二叉树的最小值节点
     * @return
     */
    E removeMin();

    /**
     * 移除二叉树的最大值节点
     * @return
     */
    E removeMax();
}
