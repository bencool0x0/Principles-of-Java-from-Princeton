public class WorldMap {
    public static void main(String[] args) {
        int boundaryX = StdIn.readInt();
        int boundaryY = StdIn.readInt();
        StdDraw.setCanvasSize(boundaryX, boundaryY);
        StdDraw.setXscale(0, boundaryX);
        StdDraw.setYscale(0, boundaryY);
        while (!StdIn.isEmpty()) {
            String region = StdIn.readString();
            int vertices = StdIn.readInt();
            double x[] = new double[vertices];
            double y[] = new double[vertices];
            for (int i = 0; i < vertices; i++) {
                x[i] = StdIn.readDouble();
                y[i] = StdIn.readDouble();
            }
            StdDraw.polygon(x, y);
        }
    }
}
