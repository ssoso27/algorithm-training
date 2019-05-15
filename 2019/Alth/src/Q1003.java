// https://www.acmicpc.net/problem/1003
public abstract class Q1003 extends Question {
    int[] count;

    @Override
    public void solution() {
        count = new int[]{0, 0};
        fibonacci(5);
        System.out.println(count[0] + count[1]);
    }

    private int fibonacci(int n) {
        if (n == 0) {
            count[0]++;
            return 0;
        } else if (n == 1) {
            count[1]++;
            return 1;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}
