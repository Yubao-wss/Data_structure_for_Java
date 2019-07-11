package src.com.waston.heap;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description: 堆的实现-->大顶堆（根节点大于其所有子节点）
 * 基于数组实现
 * @Author: Waston
 * @Date: 2019/6/6 19:52
 */
class A implements Comparable<A> {

    @Override
    public int compareTo(A o) {
        return 0;
    }
}
public class Heap<E extends Comparable<E>> {
    // 默认初始容量
    private static final int DEFAULT_CAPACITY = 10;
    // 比较器
    private Comparator<E> comparator;
    private int size;
    private E [] elementData;

    public Heap(int initialCapacity, Comparator<E> comparator){
        this.elementData = (E[]) new Object[initialCapacity];
        this.comparator = comparator;
    }

    public Heap(){
        this(DEFAULT_CAPACITY,null);
    }

    public Heap(int initialCapacity){
        this(initialCapacity,null);
    }

    /**
     * 由任意数组构建堆 (Heapify)
     * @param arr
     */
    public Heap(E[] arr){
        elementData = (E[]) new Object[arr.length];
        for(int i = 0;i < arr.length;i++){
            elementData[i] = arr[i];
        }
        size = elementData.length;
        // Heapify
        // 从最后一个非叶子节点开始siftDown
        for(int i = (arr.length - 1 - 1) / 2;i >= 0;i--){
            siftDown(i);
        }
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(E e){
        if(size == elementData.length){
            // 数组扩容
            grow();
        }
        // 向数组末尾添加元素
        elementData[size ++] = e;
        // 上浮
        siftUp(size - 1);
    }

    public E findMax(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("heap is empty");
        }
        return elementData[0];
    }

    public E extractMax(){
        E result = findMax();
        // 交换堆顶元素与最后一个元素的位置
        swap(0,size - 1);
        elementData[--size] = null;
        // 下沉当前堆顶元素
        siftDown(0);
        return result;
    }

    /**
     * 将二叉树当前节点下沉到正确位置
     * @param index
     */
    private void siftDown(int index){
        // 若该节点存在左孩子节点，开始循环
        while(leftChildIndex(index) < size){
            // 获取左孩子节点下标
            int j = leftChildIndex(index);
            // 判断左右哪个大
            if(j + 1 < size){
                // 右孩子存在
                if(compare(elementData[j],elementData[j + 1]) < 0){
                    // 右孩子的值大，j指向右孩子索引下标
                    j++;
                }
            }
            // 不存在右孩子，那么j下标的元素就是最大孩子
            if(compare(elementData[index],elementData[j]) > 0){
                // 此时位置正确，跳出循环
                break;
            }
            // 与最大的孩子进行交换
            swap(index,j);
            // 从交换后的根节点继续进行循环
            index = j;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for(E e: elementData){
            if(e != null){
                res.append(e+"、");
            }
        }
        return res.toString();
    }

    /**
     * 上浮
     * @param index
     */
    private void siftUp(int index){
        while (index > 0 && compare(elementData[index], elementData[parentIndex(index)]) > 0) {
            // 交换当前节点与父节点的值
            swap(index,parentIndex(index));
            // 继续向上进行下一次判断
            index = parentIndex(index);
        }
    }



    /**
     * 交换
     * @param indexA
     * @param indexB
     */
    private void swap(int indexA,int indexB){
        E temp = elementData[indexA];
        elementData[indexA] = elementData[indexB];
        elementData[indexB] = temp;
    }

    /**
     * 数组扩容
     */
    private void grow(){
        int oldCap = elementData.length;
        int newCap = oldCap + (oldCap < 64 ? oldCap : oldCap >> 1);
        if(newCap > Integer.MAX_VALUE - 8){
            throw new IndexOutOfBoundsException("数组长度超限");
        }
        elementData = Arrays.copyOf(elementData,newCap);
    }

    /**
     * 比较
     * @param e1
     * @param e2
     * @return
     */
    private int compare(E e1,E e2){
        // 没有comparator对象或没有实现Comparator接口
        if(comparator == null){
            // 此时E必须为Compareable接口子类，不是会报错
            return (int) e1.compareTo(e2);
        }
        return comparator.compare(e1,e2);
    }

    /**
     * 返回当前节点的左孩子节点下标
     * @param index
     * @return
     */
    private int leftChildIndex(int index){
        return index * 2 + 1;
    }

    /**
     * 返回当前节点的右孩子节点下标
     * @param index
     * @return
     */
    private int rightChildIndex(int index){
        return index * 2 + 2;
    }

    /**
     * 返回当前节点父节点索引下标
     * @param index
     * @return
     */
    private int parentIndex(int index){
        if(index == 0){
            throw new IllegalArgumentException("没有父节点");
        }
        return (index - 1)/2;
    }

    public static void main(String[] args) {
       Object o = new Object();
       Comparable c = (Comparable)o;
    }
}














































