// 1st do trials and get times for each day
// to do trials: for each trial:
// 1. get a random birthday
// 2. check if that birthday has been recorded before
// 3. stop if they have
// 4. record if they haven't
// 5. add one to times[amount of people] if they have
// 6. repeat until done all trials
// 2nd make a table:
// for each num < n:
// table[num][1] = num + 1
// table[num][2] = times[num]
// table[num][3] = cumulative
// 3rd print table, if cumulative >= 0.5, stop
public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]) + 1;
        int trials = Integer.parseInt(args[1]);
        int[] times = new int[n + 1];
        double cumulative = 0.0;
        for (int t = 0; t < trials; t++) {
            boolean[] peopleBirthdays = new boolean[n];
            for (int i = 0; i < peopleBirthdays.length; i++) {
                int random = (int) (Math.random() * n - 1);
                if (!peopleBirthdays[random]) {
                    peopleBirthdays[random] = true;
                } else {
                    times[i]++;
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (i < n) {
                cumulative += ((double) times[i]) / trials;
                System.out.println((i + 1) + "\t" + times[i] + "\t" + cumulative);
            } else {
                System.out.println((i + 1) + "\t" + times[i] + "\t" + cumulative);
            }
            if (cumulative >= 0.5) {
                break;
            }
        }
    }
}
