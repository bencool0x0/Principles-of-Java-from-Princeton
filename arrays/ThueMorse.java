public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        boolean[] array1 = new boolean[n];
        boolean[] array2 = new boolean[n];
        array1[0] = true;
        array2[0] = false;
        if (n > 1) {
            array2[1] = true;
        }


        for (int i = 1; i < n; i *= 2) {
            if (i * 2 > n) {
                for (int j = 0; j < n - i; j++) {
                    array1[j + i] = array2[j];
                }
            } else {
                for (int j = 0; j < i; j++) {
                    array1[j + i] = array2[j];
                }
            }
            for (int j = 0; j < array2.length; j++) {
                array2[j] = !array1[j];
            }
        }
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1.length; j++) {
                if (array1[i] == array1[j]) {
                    System.out.print("+  ");
                } else {
                    System.out.print("-  ");
                }
            }
            System.out.println();
        }
    }
}
