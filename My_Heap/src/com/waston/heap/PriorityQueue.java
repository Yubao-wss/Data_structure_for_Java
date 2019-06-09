package src.com.waston.heap;

/**
 * @Description: 基于大顶堆的优先级队列
 * @Author: Waston
 * @Date: 2019/6/9 11:35
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
    private Heap<E> heap = new Heap<>();

    @Override
    public void enqueue(E e) {
        heap.add(e);
    }

    @Override
    public E dequeue() {
        return heap.extractMax();
    }

    @Override
    public E peek() {
        return heap.findMax();
    }

    @Override
    public int getSize() {
        return heap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
