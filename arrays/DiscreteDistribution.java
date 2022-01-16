public class DiscreteDistribution {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] array = new int[n];
        int[] cumulative = new int[args.length];
        int sum = 0;
        double random;
        int[] probabilities = new int[args.length - 1];
        for (int i = 0; i < args.length - 1; i++) { // assigns the probabilities into the array
            probabilities[i] = Integer.parseInt(args[i + 1]);
        }
        for (int i = 0; i < cumulative.length - 1; i++) { // gets the cumulative sums for each
            sum += probabilities[i]; // sum = 3
            cumulative[i + 1] = sum; // cumulative [3] = 3
        }
        for (int i = 0; i < n; i++) { //for each array index
            random = Math.random() * sum;
            for (int j = 1; j < cumulative.length; j++) { //for each cumulative sum
                if (random < cumulative[j] && random > cumulative[j - 1]) {
                    array[i] = j;
                } // 0,1,2,3
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
