// 1. take three arguments
// 2. set canvas
// a. x scale to high - low
// b. y scale to 1/3 x scale
// 3. separate the x scale into n intervals
// 4. plot the histogram using StdDraw
// a. create an array for values of increments for the histogram
// b. add highest number of values per increment to y scale
// c. draw polygons.

public class Histogram {
    public static void main(String[] args) {
        int sections = Integer.parseInt(args[0]);
        double high = Double.parseDouble(args[1]);
        double low = Double.parseDouble(args[2]);
        int[] array = new int[sections];
        StdDraw.setXscale(0, high - low);
        while (!StdIn.isEmpty()) {
            double value = StdIn.readDouble();
            int increment = 0;
            for (double i = low; i < high; i += (high - low) / (sections)) {
                if (value >= i && value < i + (high - low) / (sections)) {
                    array[increment]++;
                }
                increment++;
            }
        }
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            StdOut.print(array[i] + " ");
        }
        StdDraw.setYscale(0, (high - low) / 3 + max);
        int i = 0;
        for (double j = 0; j < high - low; j += (high - low) / (sections)) { // each increment in the histogram
            double[] Xcoords = {j, j + (high - low) / (sections), j + (high - low) / (sections), j};
            double[] Ycoords = {0, 0, array[i], array[i]};
            StdDraw.filledPolygon(Xcoords, Ycoords);
            i++;
        }
    }
}
