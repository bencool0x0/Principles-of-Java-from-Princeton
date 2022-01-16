public class ActivationFunction {
    public static double heaviside(double x) {
        if (x > 0) {
            return 1.0;
        } else if (x < 0) {
            return 0.0;
        } else if (x == 0) {
            return 0.5;
        } else {
            return Double.NaN;
        }
    }

    public static double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    public static double tanh(double x) {
        if (x == Double.MAX_VALUE || x == Double.POSITIVE_INFINITY) {
            return 1;
        } else if (x == -Double.MAX_VALUE || x == Double.NEGATIVE_INFINITY) {
            return -1;
        }
        return (Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x));
    }

    public static double softsign(double x) {
        if (x == Double.POSITIVE_INFINITY) {
            return 1;
        } else if (x == Double.NEGATIVE_INFINITY) {
            return -1;
        }
        return x / (1 + Math.abs(x));
    }

    public static double sqnl(double x) {
        if (x <= -2) {
            return -1;
        } else if (-2 < x && x < 0) {
            return x + ((x * x) / 4);
        } else if (0 <= x && x < 2) {
            return x - ((x * x) / 4);
        } else if (2 <= x) {
            return 1;
        } else {
            return Double.NaN;
        }
    }

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        StdOut.println("heaviside(" + x + ") " + "= " + heaviside(x));
        StdOut.println("sigmoid(" + x + ") " + "= " + sigmoid(x));
        StdOut.println("tanh(" + x + ") " + "= " + tanh(x));
        StdOut.println("softsign(" + x + ") " + "= " + softsign(x));
        StdOut.println("sqnl(" + x + ") " + "= " + sqnl(x));
    }
}
