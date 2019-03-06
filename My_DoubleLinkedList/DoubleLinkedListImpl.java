package wss.Sequence;

/**
 * @Author: WSS
 * @Date: 2019/3/6
 * @Description: 基于双向链表的线性表
 */
public class DoubleLinkedListImpl implements Sequence{
    private Node head;
    private Node tail;
    private int size;

    private class Node{
        Node prev;
        Object data;
        Node next;

        public Node(Object data){
            this.data = data;
        }

        public Node(Node prev, Object data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

    /***
     * 尾差
     * @param data 要插入的元素
     */
    @Override
    public void add(Object data) {
        Node newNode = new Node(tail,data,null);
        if (head == null){
            head = newNode;
        }else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    @Override
    public boolean remove(int index) {
        rangeCheck(index);

        //要删除的节点
        Node cur = findNode(index);

        Node curPrev = cur.prev;
        Node curNext = cur.next;

        //如果要删除的是头节点
        if(cur == head){
            head = cur.next;
            cur.next = null;
            curPrev.next = null;
        }
        //要删的是尾节点
        else if (cur == tail){
            tail = cur.prev;
            cur.prev = null;
            curPrev.next = null;
        }
        else{
            curPrev.next = cur.next;
            curNext.prev = cur.prev;
            cur.next = null;
            cur.prev = null;

        }
        size--;
        return true;
    }

    @Override
    public Object get(int index) {
        rangeCheck(index);
        return findNode(index).data;
    }

    @Override
    public boolean contains(Object data) {
        Object[] datas = toArray();
        if (data == null) {
            for (int i = 0;i < datas.length;i++) {
                if (datas[i] == null) {
                    return true;
                }
            }
        }else {
            for (int i = 0;i < datas.length;i++) {
                if (data.equals(datas[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object set(int index, Object newData) {
        rangeCheck(index);
        //取得指定位置Node
        Node node = findNode(index);
        Object oldData = node.data;
        node.data = newData;
        return oldData;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (Node temp = head;temp!=null;){
            Node next = temp.next;
            temp.prev = temp.next = null;
            temp.data = null;
            temp = next;
            size--;
        }
    }

    @Override
    public Object[] toArray() {
        Object[] data = new Object[size];
        int i = 0;
        for (Node temp = head;temp != null;temp = temp.next){
            data[i++] = temp.data;
        }
        return data;
    }

    //检查索引
    private void rangeCheck(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("索引不存在！");
        }
    }

    //查找指定索引的内容
    private Node findNode(int index){
        //要查找的节点在中间位置的左边
        if (index < (size >> 1)){
            Node temp = head;
            for (int i = 0;i < index;i++){
                temp = temp.next;
            }
            return temp;
        }else {
            Node temp = tail;
            for (int i = size - 1;i > index;i--){
                temp = temp.prev;
            }
            return temp;
        }
    }


}
