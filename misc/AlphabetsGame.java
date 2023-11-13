package misc;

/**
 * https://www.hackerrank.com/challenges/the-minion-game/
 * 
 * @author subhrajeetghosh
 */
public class AlphabetsGame {
    public void alphabatesGame(String str) {
        int stuart = 0;
        int kevin = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                kevin += str.length() - i;
            } else {
                stuart += str.length() - i;
            }
        }
        if (kevin > stuart) {
            System.out.println("Kevin " + kevin);
        } 
        else if(stuart > kevin) {
            System.out.println("Stuart " + stuart);
        } else {
            System.out.println("Draw");
        }
    }
    public static void main(String[] args) {
        new AlphabetsGame().alphabatesGame("BANANA");
    }
}
