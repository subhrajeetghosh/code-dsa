class RishiClass {
    public int fibo_12(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return fibo_12(n - 2) + fibo_12(n - 1);
    }

    public static void main(String args[]) throws Exception {
        System.out.println(new RishiClass().fibo_12(25));
    }
}
