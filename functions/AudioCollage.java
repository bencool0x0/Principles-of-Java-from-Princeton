public class AudioCollage {
    public static double[] amplify(double[] a, double alpha) {
        double[] audio = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            audio[i] = a[i] * alpha;
        }
        return audio;
    }

    public static double[] reverse(double[] a) {
        double[] audio = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            audio[i] = a[a.length - 1 - i];
        }
        return audio;
    }

    public static double[] merge(double[] a, double[] b) {
        double[] audio = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            audio[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            audio[a.length + i] = b[i];
        }
        return audio;
    }

    public static double[] mix(double[] a, double[] b) {
        int length = Math.max(a.length, b.length);
        double[] newer;
        double[] audio = new double[length];
        if (a.length > b.length) {
            double[] zeros = new double[a.length - b.length];
            newer = merge(b, zeros);
            for (int i = 0; i < audio.length; i++) {
                audio[i] = a[i] + newer[i];
            }
        } else if (b.length > a.length) {
            double[] zeros = new double[b.length - a.length];
            newer = merge(a, zeros);
            for (int i = 0; i < audio.length; i++) {
                audio[i] = b[i] + newer[i];
            }
        } else {
            for (int i = 0; i < audio.length; i++) {
                audio[i] = a[i] + b[i];
            }
        }
        return audio;
    }

    public static double[] changeSpeed(double[] a, double alpha) {
        double[] audio = new double[(int) (a.length / alpha)];
        for (int i = 0; i < audio.length; i++) {
            audio[i] = a[(int) (i * alpha)];
        }
        return audio;
    }

    public static void main(String[] args) {
        double[] piano = StdAudio.read("piano.wav");
        double[] singer = StdAudio.read("singer.wav");
        double[] harp = StdAudio.read("harp.wav");
        double[] chimes = StdAudio.read("chimes.wav");
        double[] exposure = StdAudio.read("exposure.wav");
        double[] introduction = amplify(mix(mix(piano, harp), chimes), 0.75);
        double[] body = mix(singer, amplify(merge(merge(piano, chimes), harp), .75));
        double[] ending = changeSpeed(reverse(chimes), .5);
        double[] piece = new double[exposure.length + introduction.length + body.length + ending.length];
        for (int i = 0; i < exposure.length; i++) {
            piece[i] = exposure[i];
        }
        for (int i = 0; i < introduction.length; i++) {
            piece[i + exposure.length] = introduction[i];
        }
        for (int i = 0; i < body.length; i++) {
            piece[i + exposure.length + introduction.length] = body[i];
        }
        for (int i = 0; i < ending.length; i++) {
            piece[i + exposure.length + introduction.length + body.length] = ending[i];
        }
        StdAudio.play(piece);
    }
}
