package wss;

import wss.Sequence.Sequence;

import java.util.Arrays;

/**
 * @Author: WSS
 * @Date: 2019/2/28
 * @Description: 基于数组实现的线性表，可扩容
 */
public class SequenceArrayImpl implements Sequence {
    //默认长度
    private static final int DEFAULT_CAPACITY = 10;
    //元素个数
    private int size;
    //表名
    private Object[] elementData;
    //最大长度
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    
    //构造方法
    public SequenceArrayImpl() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    //增加元素
    @Override
    public void add(Object data) {
        ensureCapacity(size+1);
        elementData[size++] = data;
    }

    @Override
    public boolean remove(int index) {
        rangCheck(index);
        Object oldDate = elementData[index];
        int movesize = size - index - 1;
        if (movesize > 0){
            System.arraycopy(elementData,index+1,elementData,index,movesize);
        }
        elementData[--size] = null;
        return true;
    }

    @Override
    public Object get(int index) {
        rangCheck(index);
        return elementData[index];
    }

    @Override
    public boolean contains(Object data) {
        if (data == null){
            for (int i = 0;i < size;i++){
                if (elementData[i] == null){
                    return true;
                }
            }
        }else {
            for (int i = 0;i < size;i++){
                if (data.equals(elementData[i]));
                    return true;
            }
        }
        return false;
    }

    //修改指定索引的内容
    @Override
    public Object set(int index, Object newData) {
        //检查索引
        rangCheck(index);
        //替换内容
        Object oldDate = elementData[index];
        elementData[index] = newData;
        //返回原先元素
        return oldDate;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        for (int i = 0;i < size;i++){
            elementData[i] = null;
        }
        this.size = 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData,size);
    }

    /***
     * 确保数组容量足够
     * @param minCap 预计的数组长度，若不满足则扩容
     */
    private void ensureCapacity(int minCap){
        if (minCap - elementData.length > 0){
            grow(minCap);
        }
    }

    /***
     * 数组扩容
     * @param minCap 需要扩容到的长度
     */
    private void grow(int minCap){
        //原数组长度
        int oldCap = elementData.length;
        //扩容一倍
        int newCap = oldCap << 1;
        //若还未到要求
        if (newCap - minCap < 0){
            newCap = minCap;
        }
        //超过阈值，报错
        if(newCap - MAX_ARRAY_SIZE > 0){
            throw new ArrayIndexOutOfBoundsException("超过最大阈值");
        }
        //数组拷贝
        elementData = Arrays.copyOf(elementData,newCap);
    }

    /***
     * 检查索引是否越界
     * @param index 要检查的索引
     */
    private void rangCheck(int index){
        if(index > size){
            throw  new IndexOutOfBoundsException("下标不存在!");
        }
    }
}
