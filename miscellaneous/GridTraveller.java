package miscellaneous;
/**
 * You are a traveller in the 2D grid. You begin in the top-left corner and your goal is to travel 
 * to the right-bottom corner you can only move down or right
 * 
 * @author subhrajeetghosh
 */

public class GridTraveller {
    //Recursion with Memorization
    public int GridTravellerPath(int m, int n, int[][] arr) {
        if(m==1 && n==1) return 1;
        if(m==0 || n==0) return 0;
        if(arr[m-1][n-1] != 0) return arr[m-1][n-1];
        return arr[m-1][n-1] = GridTravellerPath(m-1, n, arr) + GridTravellerPath(m, n-1, arr);
    }
    public static void main(String[] args) {
        System.out.println(new GridTraveller().GridTravellerPath(2, 3, new int[2][3]));
    }
}
