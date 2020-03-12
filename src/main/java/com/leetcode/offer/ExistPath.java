package com.leetcode.offer;

public class ExistPath {

    /*
        请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。

        [['a','b','c','e'],
        ['s','f','c','s'],
        ['a','d','e','e']]

        但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。

         

        示例 1：

        输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'ABCCED'
        输出：true
        示例 2：

        输入：board = [['a','b'],['c','d']], word = 'abcd'
        输出：false
        提示：

        1 <= board.length <= 200
        1 <= board[i].length <= 200
     */

    public static void main(String[] args) {
//        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//
//        String word = "ABCCED";

        char[][] board = new char[][]{{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};

        String word = "AAB";

        System.out.println(existPath(board, word));

        System.out.println();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean existPath(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && existPath(board, j, i, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean existPath(char[][] board, int column, int row, String word, int index) {

        int nextIndex = index + 1;

        if (nextIndex == word.length()) {
            return true;
        }

        boolean flag = false;

        char ch = board[row][column];
        board[row][column] = ' ';

        char nextChar = word.charAt(nextIndex);
        if (row - 1 >= 0 && board[row - 1][column] == nextChar) {
            flag = existPath(board, column, row - 1, word, nextIndex);
        }

        if (!flag && row + 1 < board.length && board[row + 1][column] == nextChar) {
            flag = existPath(board, column, row + 1, word, nextIndex);
        }

        if (!flag && column - 1 >= 0 && board[row][column - 1] == nextChar) {
            flag = existPath(board, column - 1, row, word, nextIndex);
        }

        if (!flag && column + 1 < board[0].length && board[row][column + 1] == nextChar) {
            flag = existPath(board, column + 1, row, word, nextIndex);
        }

        if (!flag) {
            board[row][column] = ch;
        }


        return flag;
    }

}
