public class RandomWalkers {
    public static void main(String[] args) {
        int count = 0;
        int x;
        int y;
        int steps;
        double random;
        double avg;
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        for (int i = 0; i < trials; i++) {
            x = 0;
            y = 0;
            steps = 0;
            while (Math.abs(x) + Math.abs(y) != r) {
                random = Math.random();
                if (random < .25) {
                    x += 1;
                } else if (random < .5) {
                    y += 1;
                } else if (random < .75) {
                    x -= 1;
                } else {
                    y -= 1;
                }
                steps++;
            }
            count = count + steps;

        }
        avg = (double) count / trials;
        System.out.println("average number of steps = " + avg);
    }
}
