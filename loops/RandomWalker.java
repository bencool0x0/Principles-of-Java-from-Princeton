public class RandomWalker {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        int r = Integer.parseInt(args[0]);
        int steps = 0;
        double random;
        System.out.println("(0, 0)");
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
            System.out.println("(" + x + ", " + y + ")");
        }
        System.out.println("steps = " + steps);
    }
}
