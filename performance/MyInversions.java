// 1. send n,k to generate()
// 2. have generate() generate permutations and send it to count.
// a. create array[n] that we'll send, and random[n] to use randomly
// b. for each n in array, choose random n in random[] with indexes >= n,
// array[n] = random[random], random[n] = random[random]
// c. send it to count
// 3. have count() count the amount of inversions
// a. for every n in array[], check for every n > greater than the index in array[n] that
// that array[index] is greater than, if it is, count++;
// b. return the number of inversions
// 4. if count == k, then return array[].
// 5. print array[]
// 6. finally made it work, youre a genius POGGEJSFEAKSJFAKBRS
public class MyInversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        long count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] no = new int[]{-1};
        long sum = k;
        int original = n - 1;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        while (sum != 0) {
            int moveTo;
            if (sum >= original) {
                moveTo = (n - 1) - original;
                for (int j = moveTo; j < n; j++) {
                    array[j]--;
                }
                array[moveTo] = original;
                sum -= original;
            } else {
                moveTo = (int) ((n - 1) - sum);
                for (int j = n - 1; j > moveTo; j--) {
                    array[j]--;
                }
                array[moveTo] = original;
                sum -= (n - 1) - moveTo;
            }
            original--;
        }
        if (k == count(array)) {
            return array;
        } else {
            return no;
        }
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        int[] array = generate(n, k);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
