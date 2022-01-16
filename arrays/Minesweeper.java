//1.create a 2D array to represent the minefield
//2.randomly generate num mines, if one has been selected already, do another
//note: use 10 for the mines so we can use an int array
//3.run a for loop for only none mine indexes to check how many mines are close to them
//3a.assign the index the number of mines that are close to it
//4.print the 2D array manually, if array[i][j] = 10, print *
public class Minesweeper {
    public static void main(String[] args) {
        int rows = Integer.parseInt(args[0]);
        int columns = Integer.parseInt(args[1]);
        int numMines = Integer.parseInt(args[2]);
        int[][] minefield = new int[rows][columns];
        for (int i = 0; i < numMines; i++) { //generates and assigns numMines mines into minefield
            int rRow = (int) (Math.random() * rows);
            int rColumns = (int) (Math.random() * columns);
            if (minefield[rRow][rColumns] != 10) {
                minefield[rRow][rColumns] = 10;
            } else {
                i--;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int minesAround = 0;
                if (minefield[i][j] != 10) {
                    if ((i - 1 >= 0) && (j - 1 >= 0) && minefield[i - 1][j - 1] == 10) {
                        minesAround++;
                    }
                    if ((i - 1 >= 0) && minefield[i - 1][j] == 10) {
                        minesAround++;
                    }
                    if ((i - 1 >= 0) && (j + 1 < columns) && minefield[i - 1][j + 1] == 10) {
                        minesAround++;
                    }
                    if ((j - 1 >= 0) && minefield[i][j - 1] == 10) {
                        minesAround++;
                    }
                    if ((j + 1 < columns) && minefield[i][j + 1] == 10) {
                        minesAround++;
                    }
                    if ((i + 1 < rows) && (j - 1 >= 0) && minefield[i + 1][j - 1] == 10) {
                        minesAround++;
                    }
                    if ((i + 1 < rows) && minefield[i + 1][j] == 10) {
                        minesAround++;
                    }
                    if ((i + 1 < rows) && (j + 1 < columns) && minefield[i + 1][j + 1] == 10) {
                        minesAround++;
                    }
                    minefield[i][j] = minesAround;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (minefield[i][j] == 10) {
                    System.out.print("*  ");
                } else {
                    System.out.print(minefield[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }
}

