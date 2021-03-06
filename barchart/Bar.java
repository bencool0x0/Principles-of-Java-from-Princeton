import java.util.Arrays;

public class Bar implements Comparable<Bar> {
    private final String nam;
    private final int val;
    private final String cat;

    // Creates a new bar.
    public Bar(String name, int value, String category) {
        if (name == null || value < 0 || category == null) {
            throw new IllegalArgumentException("name, value, and or category are invalid.");
        }
        nam = name;
        val = value;
        cat = category;
    }

    // Returns the name of this bar.
    public String getName() {
        return nam;
    }

    // Returns the value of this bar.
    public int getValue() {
        return val;
    }

    // Returns the category of this bar.
    public String getCategory() {
        return cat;
    }

    // Compare two bars by value.
    public int compareTo(Bar that) {
        if (this.getValue() > that.getValue()) {
            return 1;
        } else if (this.getValue() == that.getValue()) {
            return 0;
        } else if (this.getValue() < that.getValue()) {
            return -1;
        } else {
            throw new NullPointerException();
        }
    }

    // Sample client (see below).
    public static void main(String[] args) {
        // create an array of 10 bars
        Bar[] bars = new Bar[10];
        bars[0] = new Bar("Beijing", 22674, "East Asia");
        bars[1] = new Bar("Cairo", 19850, "Middle East");
        bars[2] = new Bar("Delhi", 27890, "South Asia");
        bars[3] = new Bar("Dhaka", 19633, "South Asia");
        bars[4] = new Bar("Mexico City", 21520, "Latin America");
        bars[5] = new Bar("Mumbai", 22120, "South Asia");
        bars[6] = new Bar("Osaka", 20409, "East Asia");
        bars[7] = new Bar("São Paulo", 21698, "Latin America");
        bars[8] = new Bar("Shanghai", 25779, "East Asia");
        bars[9] = new Bar("Tokyo", 38194, "East Asia");

        // sort in ascending order by weight
        Arrays.sort(bars);
    }
}
