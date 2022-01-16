public class BandMatrix {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int i;
        int j;
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                if (Math.abs(i - j) <= m) {
                    System.out.print("*  ");
                } else {
                    System.out.print("0  ");
                }
            }
            System.out.println();
        }
    }
}
