import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


    private int size;
    private int[] data;
    private int capacity;

    private int getSize() {
        return size;
    }

    private int getDataLength() {
        return data.length;
    }

    private void addLast(int arg) {
        add(size,arg);
    }

    private void addFirst(int arg) {
        add(0,arg);
    }


    private boolean isEmpty() {
        return size==0;
    }

    private boolean contains(int arg) {
        for(int i =0; i<size; i++) {
            if (data[i]==arg) {
                return true;
            }
        }
        return false;
    }

    private int find(int arg) {
        for(int i =0; i<size; i++) {
            if (data[i]==arg) {
                return i;
            }
        }
        return -1;
    }




    private int findByIndex(int index) {
        if(index <0 || index > size) {
            throw  new IllegalArgumentException("index is illegal");
        }
        return data[index];
    }

    private void del(int index,int arg) {
        if(index <0 || index > size) {
            throw  new IllegalArgumentException("index is illegal");
        }
        for(int i = size -1 ; i >= index; i--){
            data[i-1] = data[i];
        }
        size--;
    }

    private void add(int index,int arg) {
        if(size==getDataLength()) {
//            this.resize();

            throw new IllegalArgumentException("Array is full");
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

    private void resize() {
        if(size==getDataLength()) {
            data = new int[capacity*2];
        }
    }

    private int[] getData() {
        return data;
    }

    public Main(int capacity) {

        this.capacity = capacity;
        data = new int[capacity];
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
        Main main = new Main();
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
