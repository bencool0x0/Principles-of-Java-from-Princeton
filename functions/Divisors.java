public class Divisors {
    public static int gcd(int a, int b) {
        int gcd = -1;
        int absA = Math.max(Math.abs(a), Math.abs(b));
        int absB = Math.min(Math.abs(a), Math.abs(b));
        while (absA != 0 && absB != 0) {
            int temp = absA;
            absA = absB;
            absB = temp % absB;
        }
        gcd = absA;
        return gcd;
    }

    // 1. get a and b
    // 2. if a == b, then return a
    // 3. two for loops that check divisibility cuz idk how to get prime factors
    public static int lcm(int a, int b) {
        int lcm;
        if (gcd(a, b) == 0) {
            lcm = (int) Double.NaN;
            return lcm;
        }
        lcm = (Math.abs(a) / gcd(a, b)) * Math.abs(b);
        return lcm;
    }

    public static boolean areRelativelyPrime(int a, int b) {
        return gcd(a, b) == 1;
    }

    public static int totient(int n) {
        int numRelPrimes = 0;
        if (n <= 0) {
            return 0;
        }
        for (int i = 1; i <= n; i++) {
            if (gcd(n, i) == 1) {
                numRelPrimes++;
            }
        }
        return numRelPrimes;
    }

    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        StdOut.println("gcd(" + x + ", " + y + ") = " + gcd(x, y));
        StdOut.println("lcm(" + x + ", " + y + ") = " + lcm(x, y));
        StdOut.println("areRelativelyPrime(" + x + ", " + y + ") = " + areRelativelyPrime(x, y));
        StdOut.println("totient(" + x + ") = " + totient(x));
        StdOut.println("totient(" + y + ") = " + totient(y));
    }
}
