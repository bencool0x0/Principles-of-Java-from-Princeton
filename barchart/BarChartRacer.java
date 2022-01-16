// 1. information to take per bar:
// caption, name, country, value, and category
// information to take per barchart:
// number of bars
// 2. for every section of text, draw a bar chart.
// a. repeat this for <records> times:
// 1. make a new bar for each one and a new chart. put the charts in a list
// then take the first <number> ones to chart.add.
// b. draw the chart
// c. remove the chart

import java.util.Arrays;

public class BarChartRacer {
    public static void main(String[] args) {
        StdDraw.setCanvasSize(700, 512);
        StdDraw.enableDoubleBuffering();
        int number = Integer.parseInt(args[1]);
        In file = new In(args[0]);
        String title = file.readLine(); // reads input
        String xAxis = file.readLine(); // reads input
        String dataS = file.readLine(); // reads input
        BarChart barchart = new BarChart(title, xAxis, dataS);
        while (!file.isEmpty()) {
            file.readLine();
            int records = Integer.parseInt(file.readLine());
            Bar[] bars = new Bar[records];
            String caption = null;
            for (int i = 0; i < records; i++) {
                String line = file.readLine();
                String[] parts = line.split("[,]");
                String name;
                int value;
                String category;
                caption = parts[0];
                name = parts[1];
                value = Integer.parseInt(parts[3]);
                category = parts[4];
                bars[i] = new Bar(name, value, category);
            }
            Arrays.sort(bars);
            for (int i = records - 1; i >= records - number; i--) {
                barchart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());
            }
            barchart.setCaption(caption);
            barchart.draw();
            StdDraw.show();
            StdDraw.pause(100);
            barchart.reset();
            StdDraw.clear();
        }
    }
}
