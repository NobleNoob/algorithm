import org.omg.CORBA.Object;

import java.util.Objects;

public class Main<T> {


    private int size;
    private T[] data;
    private int capacity;

    public Main(int capacity) {

        this.capacity = capacity;
        data = (T[])new Object[capacity];
        size = 0;
    }


    private int getSize() {
        return size;
    }

    private int getDataLength() {
        return data.length;
    }

    public void addLast(T arg) {
        add(size,arg);
    }

    public void addFirst(T arg) {
        add(0,arg);
    }


    public boolean isEmpty() {
        return size==0;
    }

    public boolean contains(T arg) {
        for(int i =0; i<size; i++) {
            if (data[i].equals(arg)) {
                return true;
            }
        }
        return false;
    }

    public int find(T arg) {
        for(int i =0; i<size; i++) {
            if (data[i].equals(arg)) {
                return i;
            }
        }
        return -1;
    }


    public T removeFirst() {
        return del(0);
    }

    public T removeLast(){
        return del(size-1);
    }

    public void removeElement(T arg) {
        int index = find(arg);
        if(index !=-1 ) {
            del(index);
        }
    }


    public T findByIndex(int index) {
        if(index <0 || index > size) {
            throw  new IllegalArgumentException("index is illegal");
        }
        return data[index];
    }

    public T del(int index) {
        if(index <0 || index > size) {
            throw  new IllegalArgumentException("index is illegal");
        }
        T num = data[index];
        for(int i = index +1 ; i < size; i++){
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;
        if (size== data.length /2) {
            resize(data.length/2);
        }
        return num;
    }

    public void add(int index,T arg) {
        if(size==getDataLength()) {
            this.resize(2 * data.length);

//            throw new IllegalArgumentException("Array is full");
        }
        if(index <0 || index > size) {
            throw  new IllegalArgumentException("index is illegal");
        }
        //从最后一个元素"size-1" 开始遍历
        for(int i = size -1 ; i >= index; i--){
            //往后挪一位元素并把index值插入
            data[i+1] = data[i];
        }
        data[index] = arg;
        size++;
    }

    private void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];
        for (int i = 0; i <size; i++) {
            newData[i]= data[i];
            data = newData;
        }
    }

    private T[] getData() {
        return data;
    }


    public Main() {
        this(20);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size %d, capacity %d \n",size,data.length));
        res.append('[');

        for (int i=0; i< size; i++) {
            res.append(data[i]);
            if(i!=size-1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

    //Test function
    public static void main(String[] args) {
        Main<Integer> main = new Main();
        for (int i= 0;i <=9;i++) {
            main.addLast(i);
        }

        System.out.println(main);
        main.add(3,20);
        System.out.println(main);
        System.out.println(main.findByIndex(3));
        System.out.println(main.contains(20));
        System.out.println(main.find(1111));

    }
}