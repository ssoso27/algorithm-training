import java.util.*;

class Main {

    static double get_std(int[] array, int start, int end, double m) {
        double var = 0.0d;

        for (int i = start; i < end+1; i++) {
            var += Math.pow(array[i] - m, 2);
        }
        var /= (end - start + 1);

        return Math.pow(var, 0.5);
    }

    static void solution(int n, int k, int[] populars) {
        double min = Double.MAX_VALUE;

        for (int i = 0; i < n-k+1; i++) {
            int sum = 0;
            double m = 0.0d;
            double std = 0.0d;
            for (int j = 0; j < k-1; j++) sum += populars[i+j];
            for (int j = i+k-1; j < n; j++) {
                int len = j-i+1;
                sum += populars[j];
                m = (double) sum / len;
                std = get_std(populars, i, j, m);

                if (min > std) {
                    min = std;
                }
            }
        }

        System.out.println(min);
    }

    public static void main(String[] args) {
        int n, k;
        int[] populars;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        populars = new int[n];

        for (int i = 0; i < n; i++) populars[i] = sc.nextInt();

        solution(n, k, populars);
    }
}