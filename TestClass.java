public class TestClass {
    public void resultMethod() {
        int[] arr = new int[1];
        test(3, arr);
        System.out.println(arr[0]);
    }

    private void test(int n, int[] arr) {
        arr[0]++;
        if(n < 1) {
            return;
        }
        test(n-1, arr);
    }

    public void resultMethod1() {
        int num = 0;
        test1(3, num);
        System.out.println(num);
    }

    private void test1(int n, int num) {
        num++;
        if(n < 1) {
            return;
        }
        test1(n-1, num);
    }

    public static void main(String args[]) throws Exception {
        new TestClass().resultMethod();
        new TestClass().resultMethod1();
    }
}
