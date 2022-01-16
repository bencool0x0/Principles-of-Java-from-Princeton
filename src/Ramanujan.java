public class Ramanujan {

    // Is n a Ramanujan number?
    // we go
    public static boolean isRamanujan(long n) {
        boolean isOne = false;
        long one = 0;
        long w_3 = 0;
        long x;
        for (long w = 1; w * w * w < n / 2; w++) {
            w_3 = w * w * w;
            x = (int) Math.cbrt(n - w_3);
            if (w_3 + x * x * x == n) {
                one = w;
                isOne = true;
                break;
            }
        }
        if (isOne) {
            for (long w = one + 1; w * w * w < n / 2; w++) {
                w_3 = w * w * w;
                x = (int) Math.cbrt(n - w_3);
                if (w_3 + x * x * x == n) {
                    return true;
                }
            }
        }
        return false;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.println(isRamanujan(n));
    }
}
