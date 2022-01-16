public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        dna = removeWhitespace(dna);
        int count = 0;
        int max = 0;
        for (int i = 0; i < dna.length() - 2; i++) {
            String check = dna.substring(i, i + 3);
            if (check.equals("CAG")) {
                count++;
                i += 2;
                if (max < count) {
                    max = count;
                }
            } else {

                count = 0;
            }
        }
        return max;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        s = s.replace(" ", "");
        s = s.replace("\r\n", "");
        s = s.replace("\n", "");
        s = s.replace("\t", "");
        return s;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats < 10) {
            return "not human";
        } else if (maxRepeats < 36) {
            return "normal";
        } else if (maxRepeats < 40) {
            return "high risk";
        } else if (maxRepeats < 181) {
            return "Huntington's";
        } else {
            return "not human";
        }
    }

    // Sample client (see below).
    public static void main(String[] args) {
        String file = new In(args[0]).readAll(); // reads input
        int repeats = maxRepeats(file);
        System.out.println("max repeats = " + repeats);
        System.out.println(diagnose(repeats));

    }
}
