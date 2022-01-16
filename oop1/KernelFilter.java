import java.awt.Color;

public class KernelFilter {

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        return picture;
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        Picture newPic = new Picture(picture.width(), picture.height());
        for (int x = 0; x < picture.width(); x++) {
            for (int y = 0; y < picture.height(); y++) {
                int[][] filter = {
                        {1, 2, 1},
                        {2, 4, 2},
                        {1, 2, 1}
                };
                double red = 0;
                double blue = 0;
                double green = 0;
                Color color;
                int picW = picture.width();
                int picH = picture.height();
                for (int i = 0; i < filter.length; i++) {
                    for (int j = 0; j < filter.length; j++) {
                        int col = ((x + (i - 1)) % (picW) + picW) % picW;
                        int row = ((y + (j - 1)) % (picH) + picH) % picH;
                        red += picture.get(col, row).getRed() * (filter[i][j] / 16.0);
                        blue += picture.get(col, row).getBlue() * (filter[i][j] / 16.0);
                        green += picture.get(col, row).getGreen() * (filter[i][j] / 16.0);
                    }
                }
                if (red < 0) {
                    red = 0;
                } else if (red > 255) {
                    red = 255;
                } else {
                    red = (int) (red + 0.5);
                }
                if (blue < 0) {
                    blue = 0;
                } else if (blue > 255) {
                    blue = 255;
                } else {
                    blue = (int) (blue + 0.5);
                }
                if (green < 0) {
                    green = 0;
                } else if (green > 255) {
                    green = 255;
                } else {
                    green = (int) (green + 0.5);
                }
                color = new Color((int) red, (int) green, (int) blue);
                newPic.set(x, y, color);
            }
        }
        return newPic;
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        Picture newPic = new Picture(picture.width(), picture.height());
        for (int x = 0; x < picture.width(); x++) {
            for (int y = 0; y < picture.height(); y++) {
                int[][] filter = {
                        {0, -1, 0},
                        {-1, 5, -1},
                        {0, -1, 0}
                };
                double red = 0;
                double blue = 0;
                double green = 0;
                Color color;
                int picW = picture.width();
                int picH = picture.height();
                for (int i = 0; i < filter.length; i++) {
                    for (int j = 0; j < filter.length; j++) {
                        int col = ((x + (i - 1)) % (picW) + picW) % picW;
                        int row = ((y + (j - 1)) % (picH) + picH) % picH;
                        red += picture.get(col, row).getRed() * filter[i][j];
                        blue += picture.get(col, row).getBlue() * filter[i][j];
                        green += picture.get(col, row).getGreen() * filter[i][j];
                    }
                }
                if (red < 0) {
                    red = 0;
                } else if (red > 255) {
                    red = 255;
                } else {
                    red = (int) (red + 0.5);
                }
                if (blue < 0) {
                    blue = 0;
                } else if (blue > 255) {
                    blue = 255;
                } else {
                    blue = (int) (blue + 0.5);
                }
                if (green < 0) {
                    green = 0;
                } else if (green > 255) {
                    green = 255;
                } else {
                    green = (int) (green + 0.5);
                }
                color = new Color((int) red, (int) green, (int) blue);
                newPic.set(x, y, color);
            }
        }
        return newPic;
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        Picture newPic = new Picture(picture.width(), picture.height());
        for (int x = 0; x < picture.width(); x++) {
            for (int y = 0; y < picture.height(); y++) {
                int[][] filter = {
                        {-1, -1, -1},
                        {-1, 8, -1},
                        {-1, -1, -1}
                };
                double red = 0;
                double blue = 0;
                double green = 0;
                Color color;
                int picW = picture.width();
                int picH = picture.height();
                for (int i = 0; i < filter.length; i++) {
                    for (int j = 0; j < filter.length; j++) {
                        int col = ((x + (i - 1)) % (picW) + picW) % picW;
                        int row = ((y + (j - 1)) % (picH) + picH) % picH;
                        red += picture.get(col, row).getRed() * filter[i][j];
                        blue += picture.get(col, row).getBlue() * filter[i][j];
                        green += picture.get(col, row).getGreen() * filter[i][j];
                    }
                }
                if (red < 0) {
                    red = 0;
                } else if (red > 255) {
                    red = 255;
                } else {
                    red = (int) (red + 0.5);
                }
                if (blue < 0) {
                    blue = 0;
                } else if (blue > 255) {
                    blue = 255;
                } else {
                    blue = (int) (blue + 0.5);
                }
                if (green < 0) {
                    green = 0;
                } else if (green > 255) {
                    green = 255;
                } else {
                    green = (int) (green + 0.5);
                }
                color = new Color((int) red, (int) green, (int) blue);
                newPic.set(x, y, color);
            }
        }
        return newPic;
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        Picture newPic = new Picture(picture.width(), picture.height());
        for (int x = 0; x < picture.width(); x++) {
            for (int y = 0; y < picture.height(); y++) {
                int[][] filter = {
                        {-2, -1, 0},
                        {-1, 1, 1},
                        {0, 1, 2}
                };
                double red = 0;
                double blue = 0;
                double green = 0;
                Color color;
                int picW = picture.width();
                int picH = picture.height();
                for (int i = 0; i < filter.length; i++) {
                    for (int j = 0; j < filter.length; j++) {
                        int col = ((x + (i - 1)) % (picW) + picW) % picW;
                        int row = ((y + (j - 1)) % (picH) + picH) % picH;
                        red += picture.get(col, row).getRed() * filter[i][j];
                        blue += picture.get(col, row).getBlue() * filter[i][j];
                        green += picture.get(col, row).getGreen() * filter[i][j];
                    }
                }
                if (red < 0) {
                    red = 0;
                } else if (red > 255) {
                    red = 255;
                } else {
                    red = (int) (red + 0.5);
                }
                if (blue < 0) {
                    blue = 0;
                } else if (blue > 255) {
                    blue = 255;
                } else {
                    blue = (int) (blue + 0.5);
                }
                if (green < 0) {
                    green = 0;
                } else if (green > 255) {
                    green = 255;
                } else {
                    green = (int) (green + 0.5);
                }
                color = new Color((int) red, (int) green, (int) blue);
                newPic.set(x, y, color);
            }
        }
        return newPic;
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        Picture newPic = new Picture(picture.width(), picture.height());
        for (int x = 0; x < picture.width(); x++) {
            for (int y = 0; y < picture.height(); y++) {
                int[][] filter = {
                        {1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1}
                };
                double red = 0;
                double blue = 0;
                double green = 0;
                Color color;
                int picW = picture.width();
                int picH = picture.height();
                for (int i = 0; i < filter.length; i++) {
                    for (int j = 0; j < filter.length; j++) {
                        int col = ((x + (i - 4)) % (picW) + picW) % picW;
                        int row = ((y + (j - 4)) % (picH) + picH) % picH;
                        red += picture.get(col, row).getRed() * (filter[i][j] / 9.0);
                        blue += picture.get(col, row).getBlue() * (filter[i][j] / 9.0);
                        green += picture.get(col, row).getGreen() * (filter[i][j] / 9.0);
                    }
                }
                if (red < 0) {
                    red = 0;
                } else if (red > 255) {
                    red = 255;
                } else {
                    red = (int) (red + 0.5);
                }
                if (blue < 0) {
                    blue = 0;
                } else if (blue > 255) {
                    blue = 255;
                } else {
                    blue = (int) (blue + 0.5);
                }
                if (green < 0) {
                    green = 0;
                } else if (green > 255) {
                    green = 255;
                } else {
                    green = (int) (green + 0.5);
                }
                color = new Color((int) red, (int) green, (int) blue);
                newPic.set(x, y, color);
            }
        }

        return newPic;
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        Picture oriPic = new Picture(args[0]);
        identity(oriPic).show();
        gaussian(oriPic).show();
        sharpen(oriPic).show();
        laplacian(oriPic).show();
        emboss(oriPic).show();
        motionBlur(oriPic).show();
    }

}
