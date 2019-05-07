import java.util.Stack;

public class DFS {
    private int[][] a;
    private boolean[] falseChecker;
    int current;

    public DFS(int[][] a) {
        this.a = a;
        init();
    }

    public DFS() {
        this.a = new int[][] {
            {0, 1, 1, 1, 0, 0},
            {1, 0, 0, 0, 1, 0},
            {1, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 1},
            {0, 1, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0}
        };
        init();
    }

    private void init() {
        this.current = 0;
        this.falseChecker = new boolean[a.length];

        for (int i = 0; i < this.falseChecker.length; i++) {
            this.falseChecker[i] = false;
        }
    }

    public void byStack() {
        System.out.println("[Stack DFS]");
        Stack<Integer> stack = new Stack<>();
        boolean[] check = new boolean[a.length];
        int current = 0;

        for (int i = 0; i < check.length; i++) {
            check[i] = false;
        }

        check[current] = true;
        stack.push(current);
        System.out.println("pushed " + (current+1));

        while(!stack.isEmpty()) {
            int top = stack.peek();

            for (int i = 0; i < a.length; i++) {
                if (a[top][i] == 1 && !check[i]) {
                    stack.push(i);
                    check[i] = true;
                    System.out.println("pushed " + (i+1));
                    break;
                } else if (i == a.length-1) {
                    stack.pop();
                }
            }
        }

        System.out.println("end");
    }

    public void byRecursive(boolean[] check, int current) {
        check[current] = true;
        System.out.println("checked " + (current + 1));

        for (int i = 0; i < a.length; i++) {
            if (a[current][i] == 1 && !check[i]) {
                byRecursive(check, i);
            }
        }
    }

    public void byRecursive() {
        System.out.println("[재귀호출 DFS]");
        this.byRecursive(this.falseChecker, this.current);
        System.out.println("end");
    }
}
