package miscellaneous;
import java.util.Stack;

public class ValidateStackSequencesArr {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length != popped.length) {
            return false;
        }
        int i=0;
        int j=0;
        Stack<Integer> st = new Stack<Integer>();
        while(j<popped.length) {
            if(st.empty() || st.peek() != popped[j] && i<pushed.length) {
                st.push(pushed[i++]);
            }
            else if(!st.empty() && st.peek() == popped[j]) {
                st.pop();
                j++;
            }
            else {
                break;
            }
        }
        return st.empty();
    }
}