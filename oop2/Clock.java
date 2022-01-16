public class Clock {
    private int hours;
    private int mins;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h > 23 || h < 0 || m > 59 || m < 0) {
            throw new IllegalArgumentException("not valid time: " + h + ":" + m);
        }
        hours = h;
        mins = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        if (!s.matches("[0-2][0-3]:[0-5][0-9]")) {
            throw new IllegalArgumentException("invalid time: " + s);
        }
        hours = Integer.parseInt(s.substring(0, 2));
        mins = Integer.parseInt(s.substring(3, 5));
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        return String.format("%02d:%02d", hours, mins);
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (this.hours > that.hours) {
            return false;
        } else if (this.hours < that.hours) {
            return true;
        } else {
            return this.mins < that.mins;
        }
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        if (mins < 59) {
            mins++;
        } else {
            mins = 0;
            hours++;
        }
        if (hours > 23) {
            hours = 0;
        }
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) {
            throw new IllegalArgumentException("no negatives");
        }
        mins += delta;
        if (mins > 59) {
            hours += mins / 60;
            mins %= 60;
        }
        if (hours > 23) {
            hours %= 24;
        }
    }

    // Test client (see below).
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        Clock clock1 = new Clock(h, m);
        Clock clock2 = new Clock("23:58");
        System.out.println("clock1: " + clock1 + " clock2: " + clock2);
        clock1.tic();
        clock2.toc(62);
        System.out.println("clock1: " + clock1 + " clock2: " + clock2);
        System.out.println("is clock1 earlier than clock2: " + clock1.isEarlierThan(clock2));
    }
}
