// 1. get m
// 2. get text to use
// 3. count how many numbers of each type there are and store proportion in array
// 4. do math
// 5. print
public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] array = new int[m];
        int total = 0;
        double entropy = 0;
        while (!StdIn.isEmpty()) {
            array[StdIn.readInt() - 1]++;
            total++;
        }
        for (int i = 0; i < m; i++) {
            double proportion = (double) array[i] / total;
            if (array[i] > 0) {
                entropy += proportion * (Math.log(proportion) / Math.log(2.0));
            }
        }
        System.out.printf("%.4f", -entropy);
    }
}
