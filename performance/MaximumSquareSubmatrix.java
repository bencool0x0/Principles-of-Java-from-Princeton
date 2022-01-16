public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    // 1. start at row[1], max = 1;
    // 2. for each column index per row
    // a. check if row - (max) = 0, if it is, then move onto next row
    // b. check if column + max = n, if it is, then move onto next row
    // c. check for each box expanding right and up of max + 1 size is all 1s, if it is,
    // then max + 1, move onto next index
    public static int size(int[][] a) {
        int max = 0;
        if (a.length == 0) {
            return 0;
        }
        for (int x = 0; x < a.length; x++) {
            for (int y = 0; y < a.length - max; y++) {
                if ((x + 1) - max == 0) {
                    break;
                }
                boolean square = true;
                for (int i = 0; i < max + 1; i++) {
                    for (int j = 0; j < max + 1; j++) {
                        if (a[x - i][y + j] == 0) {
                            square = false;
                            break;
                        }
                    }
                }
                if (square) {
                    max++;
                }
            }
        }
        return max;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = StdIn.readInt();
            }
        }
        System.out.println(size(array));
    }
}
