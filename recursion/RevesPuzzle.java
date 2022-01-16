public class RevesPuzzle {

    private static void hanoi(int n, int k, String from, String temp, String to) {
        if (n == 0) return;
        hanoi(n - 1, k, from, to, temp);
        int j = n + k;
        StdOut.println("Move disc " + j + " from " + from + " to " + to);
        hanoi(n - 1, k, temp, from, to);
    }

    private static void reves(int n, String from, String temp, String to, String temp2) {
        int k = (int) (n + 1 - Math.sqrt(2 * n + 1) + 0.5);
        if (k == 0) {
            StdOut.println("Move disc " + n + " from " + from + " to " + to);
            return;
        }
        reves(k, from, to, temp, temp2);
        hanoi(n - k, k, from, temp2, to);
        reves(k, temp, from, to, temp2);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        String from = "A";
        String temp = "B";
        String to = "D";
        String temp2 = "C";
        reves(n, from, temp, to, temp2);
    }

}
