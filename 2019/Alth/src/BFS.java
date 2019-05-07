import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private int[][] a;
    private boolean[] falseChecker;
    int current;

    public BFS(int[][] a) {
        this.a = a;
        init();
    }

    public BFS() {
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

    public void byQueue() {
        System.out.println("[Queue BFS]");
        Queue<Integer> queue = new LinkedList<>();
        boolean[] check = this.falseChecker;
        int current = this.current;

        check[current] = true;
        queue.add(current);
        System.out.println("add " + (current+1));

        while (!queue.isEmpty()) {
            current = queue.poll();

            for (int i = 0; i < a.length; i++) {
                if (a[current][i] == 1 && !check[i]) {
                    check[i] = true;
                    queue.add(i);
                    System.out.println("add " + (i+1));
                }
            }
        }

        System.out.println("end");
    }
}
