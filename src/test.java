public class test {
    static int[] data = new int[8];

    public static void main(String[] args) {


        for (int i =5-1; i >= data.length; i--) {
            if (i > 0) {
                data[i+1]=i;
                System.out.println(data[i]);
            }
        }
    }
}
