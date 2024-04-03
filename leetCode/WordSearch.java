package leetCode;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int len1 = board.length;
        int len2 = board[0].length;
        boolean[][] visited = new boolean[len1][len2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (isExistChar(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isExistChar(char[][] board, String word, int index, int i, int j, boolean[][] visited) {
        if (index >= word.length())
            return true;
        if (i >= board.length || i < 0 || j < 0 || j >= board[0].length || visited[i][j])
            return false;
        if (board[i][j] == word.charAt(index)) {
            visited[i][j] = true;
            boolean isExistCharacter = isExistChar(board, word, index + 1, i + 1, j, visited)
                    || isExistChar(board, word, index + 1, i, j + 1, visited)
                    || isExistChar(board, word, index + 1, i - 1, j, visited)
                    || isExistChar(board, word, index + 1, i, j - 1, visited);
            visited[i][j] = false;
            return isExistCharacter;
        }
        return false;
    }
}
