package dynamicprogrammingcourse;

/**
 * write a function canConstruct(target, wordbank) that accept target String and
 * an array of String
 * the function should return a boolean indicating wheather or not the target
 * can be constructing by concatnating the elements from wordBank
 * you may reuse element of "wordBank" as many time as needed
 * 
 * @author Subhrajeet Ghosh
 */

public class ConstructStringFromWord {
    public boolean canConstruct(String target, String[] wordBank) {
        //return checkCanConstruct(new StringBuilder(), target, wordBank, 0);
        return checkCanConstruct_2ndMethod(target, wordBank, new StringBuilder());
    }

    // Recursion
    public boolean checkCanConstruct(StringBuilder sb, String target, String[] wordBank, int index) {
        if (target.length() < sb.length() || index >= wordBank.length)
            return false;
        else if (target.equals(sb.toString())) {
            return true;
        }
        return checkCanConstruct(new StringBuilder(sb).append(wordBank[index]), target, wordBank, index) ||
                checkCanConstruct(new StringBuilder(sb).append(wordBank[index]), target, wordBank, index + 1)
                || checkCanConstruct(sb, target, wordBank, index + 1);
    }

    // Recursion with Backtracking loop
    public boolean checkCanConstruct_2ndMethod(String target, String[] wordBank, StringBuilder sb) {
        if (target.length() < sb.length())
            return false;
        else if (target.equals(sb.toString())) {
            return true;
        }
        for (String word : wordBank) {
            StringBuilder currentString = new StringBuilder(sb).append(word);
            boolean isTrueThisCombo = checkCanConstruct_2ndMethod(target, wordBank, currentString);
            if (isTrueThisCombo)
                return true;
        }
        return false;
    }

    //Another way of Solutioning
    public boolean checkCanConstruct_3rMethod(String target, String[] wordBank) {
        if(target.isEmpty()) {
            return true;
        }
        for(String word : wordBank) {
            if(target.indexOf(word) == 0) {
                String suffix = target.replace(word, "");
                if(checkCanConstruct_3rMethod(suffix, wordBank) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    //Memorization
    
    public static void main(String[] args) {
        String[] arr = { "abc", "dasa", "def" };
        System.out.println(new ConstructStringFromWord().canConstruct("abcdef", arr));
    }
}
