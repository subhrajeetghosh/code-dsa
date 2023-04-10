import java.util.Scanner;

class PermutationCheck {
    public static void main(String args[] ) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
 
            while(testCases-- > 0) {
                int n = scanner.nextInt();
                long prev = 0;
                boolean check = true;
                for(int i = 1; i <= n; i++) {
                    int num = scanner.nextInt();
                    if((num + prev) < i) {
                        check = false;
                        break;
                    }
                    prev = num + prev - i;
                }
 
                if(check && prev == 0) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}

