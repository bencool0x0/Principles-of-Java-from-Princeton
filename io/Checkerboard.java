// 1. not very hard to do, if you need to look here reconsider your intelligence
public class Checkerboard {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(0, n);
        for (double x = 0; x < n; x++) {
            for (double y = 0; y < n; y++) {
                if ((x + y) % 2 != 0) {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                } else {
                    StdDraw.setPenColor(StdDraw.BLUE);
                }
                StdDraw.filledSquare(x + .5, y + .5, .5);
            }
        }
    }
}
