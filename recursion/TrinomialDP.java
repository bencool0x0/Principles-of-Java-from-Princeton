public class TrinomialDP {
    // 1. start with 1, 1, 1 and an array values[n][n + 1]
    // 2. increment n by one
    // a. for each increment,
    // b. for each valid i, array[i + 1][k] = [i][k-1] + [i][k] + [i][k+1]
    // 3. return values[n][k]
    public static long trinomial(int n, int k) {
        if (n == 0) {
            return 1;
        }
        long[][] values = new long[n][n * 2 + 1];
        values[0][0] = 1;
        values[0][1] = 1;
        values[0][2] = 1; //x^2 + x +1
        for (int i = 1; i < n; i++) { // for every power of x^2 + x + 1
            for (int j = 0; j < n * 2 + 1; j++) { // for every coefficient
                if (j == 0) {
                    values[i][j] = 1;
                } else if (j == 1) {
                    values[i][j] = i + 1;
                } else {
                    values[i][j] = values[i - 1][j - 2] + values[i - 1][j - 1] + values[i - 1][j];
                }
            }
        }
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n * 2 + 1; j++) {
        // System.out.print(values[i][j] + " ");
        // }
        //  System.out.println();
        // }
        if (k > n || k < -n) {
            return 0;
        }
        return (values[n - 1][n + k]);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        System.out.println(trinomial(n, k));
    }
}


