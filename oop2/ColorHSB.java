// 1. Take the cmd line arguments and use those to create a ColorHSB class.
// 2. StdIn Read all the predefined color and create ColorHSB objects for each one.
// a. if the sat or brightness are 0, then set hue to 0.
// b. if any of the components are out of range, then throw an IAE.
// 3. Do a for loop checking for each distance while keeping the min.
// a. If distance is null, then return IAE.
// 4. return the closest color with toString format.
public class ColorHSB {

    private int hue;
    private final int sat;
    private final int bright;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359) {
            throw new IllegalArgumentException("hue is out of range: " + h);
        }
        if (s < 0 || s > 100) {
            throw new IllegalArgumentException("saturation is out of range: " + s);
        }
        if (b < 0 || b > 100) {
            throw new IllegalArgumentException("saturation is out of range: " + b);
        }
        hue = h;
        sat = s;
        bright = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + hue + ", " + sat + ", " + bright + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return sat == 0 || bright == 0;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        int distance;
        int abs = Math.abs(hue - that.hue);
        int i = 360 - abs;
        int min = Math.min(abs, i);
        distance = min * min + ((sat - that.sat) * (sat - that.sat)) + ((bright - that.bright) * (bright - that.bright));
        return distance;
    }

    // Sample client (see below).
    public static void main(String[] args) {
        int baseH = Integer.parseInt(args[0]);
        int baseS = Integer.parseInt(args[1]);
        int baseB = Integer.parseInt(args[2]);
        int minDistance = 52401;
        String colorName = "null";
        int colorH = -1;
        int colorS = -1;
        int colorB = -1;
        ColorHSB base = new ColorHSB(baseH, baseS, baseB);
        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            int h = StdIn.readInt();
            int s = StdIn.readInt();
            int b = StdIn.readInt();
            ColorHSB color = new ColorHSB(h, s, b);
            if (base.distanceSquaredTo(color) < minDistance) {
                minDistance = base.distanceSquaredTo(color);
                colorName = name;
                colorH = h;
                colorS = s;
                colorB = b;
            }
        }
        ColorHSB finalColor = new ColorHSB(colorH, colorS, colorB);
        System.out.println(colorName + " " + finalColor);
    }
}
