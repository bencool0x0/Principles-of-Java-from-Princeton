// 1. send n,k to generate()
// 2. have generate() generate permutations and send it to count.
// a. created sorted array
// b. find the biggest m(m-1)/2 <= k
// c. reverse the order of the array from 0 to m
// d. move the m index to the left k - m(m-1)/2 spaces to the left to finish the inversions.
// e. wow this works so well wth.
public class Inversions {

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
        int[] array = new int[n];
        for (int i = 0; i < n; i++) { // sorted array
            array[i] = i;
        }
        int max = 0;
        for (int i = 0; i < n; i++) { // get max
            if ((long) i * (i - 1) / 2 <= k) {
                max = i;
            }
        }
        for (int i = 0; i < max; i++) { // reverse first max indexes
            array[i] = max - i - 1;
        }
        long moves = (k - (long) max * (max - 1) / 2);
        if (moves != 0) {
            for (long i = 0; i > -1 * moves; i--) {
                array[(int) (max + i)] = array[(int) (max - 1 + i)];
            }
            array[(int) (max - moves)] = max;
        }
        return array;
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
