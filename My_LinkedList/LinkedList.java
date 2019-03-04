package wss.Sequence;

/**
 * @Author: WSS
 * @Date: 2019/3/3
 * @Description: 链表
 */
public class LinkedList<T> {
    //定义Node类
    public class Node {
        //节点数据
        private T data;
        //指向下一个节点的引用
        private Node next;

        private Node() {
        }

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    //链表头节点
    private Node header;

    //链表尾节点
    private Node tail;

    //链表节点数
    private int size;

    //创建空链表
    public LinkedList() {
        this.header = null;
        this.tail = null;
        this.size = 0;
    }

    //以指定数据元素来创建链表，该链表只有一个元素
    public LinkedList(T element) {
        this.header = new Node(element, null);
        //只有一个节点，头和尾都指向该节点
        this.tail = this.header;
        this.size++;
    }

    /***
     * 返回链表长度
     * @return
     */
    public int length() {
        return this.size;
    }

    /***
     * 获取链表中指定索引的元素
     * @param index 指定索引
     * @return 指定索引元素
     */
    public T get(int index) {
        Node node = this.getNodeByIndex(index);
        return node == null ? null : node.data;
    }

    private Node getNodeByIndex(int index) {
        if (index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        Node curr = this.header;
        for (int i = 0; i < this.size && curr != null; i++, curr = curr.next) {
            if (i == index) {
                return curr;
            }
        }
        return null;
    }

    /***
     * 查找链表中指定元素的索引
     * @param element
     * @return
     */
    public int locate(T element) {
        Node curr = this.header;
        for (int i = 0; i < this.size && curr != null; i++, curr = curr.next) {
            if (curr.data.equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /***
     * 向线性表指定位置插入一个元素
     * @param element
     * @param index
     */
    public void insert(T element,int index){
        if(index < 0 || index > this.size - 1){
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        //空链表
        if (this.header == null){
            this.add(element);
        }else{
            //插入链表头
            if(index == 0){
                addAtHeader(element);
            }else {
                Node preNode = this.getNodeByIndex(index - 1);
                if(preNode == null){
                    throw new IndexOutOfBoundsException("index=" + (index - 1) + "not found node.");
                }
                preNode.next = new Node(element,preNode.next);
                this.size++;
            }
        }
    }

    /***
     * 采用尾插入法为链表添加新节点
     * @param elemnet
     */
    public void add(T elemnet){
            if( this.header == null){
                this.header = new Node(elemnet,null);
                this.tail = this.header;
            }else{
                //创建新节点
                Node newNode = new Node(elemnet,null);
                //新节点作为尾节点
                this.tail.next = newNode;
                this.tail = newNode;
            }
            this.size++;
        }

    /***
     * 头插法为链表添加新节点
      * @param element
     */
    public void addAtHeader(T element){
        this.header = new Node(element,header);
        if(this.tail == null){
            this.tail = this.header;
        }
        this.size++;
    }

    /***
     * 删除链表中指定索引处的元素
     * @param index
     * @return
     */
    public T delete(int index){
        if(index < 0 || index > this.size - 1){
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        Node delNode;
        if(index == 0){
            delNode = this.header;
            this.header = this.header.next;
        }else {
            Node preNode = this.getNodeByIndex(index - 1);
            if(preNode == null){
                throw new IndexOutOfBoundsException("index=" + (index - 1) + "not found node.");
            }
            //获取删除的节点
            delNode = preNode.next;
            //让删除节点的上一个节点的next指向删除节点的next
            preNode.next = delNode.next;
            delNode.next = null;
        }
        this.size--;
        return delNode.data;
    }

    /***
     * 删除表中最后一个元素
     * @return
     */
    public T removeLast(){
        return this.delete(this.size - 1);
    }

    /***
     * 判断链表是否为空
     * @return
     */
    public boolean isEmpty(){
      return this.size == 0;
    }

    /***
     * 清空
     */
    public void clear(){
        this.header = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public String toString() {
        if(this.isEmpty()){
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for(Node curr = this.header;curr != null; curr = curr.next){
            sb.append(curr.data.toString()).append(",");
        }
        sb.setLength(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }
}
