import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class TestClass {
    public static void main(String args[] ) throws Exception {
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCount = Integer.parseInt(br.readLine());
        for(int count = 0; count<numCount; count++) {
            int valueN = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] intArray = new int[valueN];
            int arraySum = 0;
            int factorialSum = 0;
            for(int i=0; i<valueN; i++) {
                intArray[i] = Integer.parseInt(st.nextToken());
                arraySum += intArray[i];
                factorialSum += i+1;
            }
            if(arraySum != factorialSum) {
                System.out.println("NO");
            }
            else {
                System.out.println("YES");
            }
        }
    }
}
