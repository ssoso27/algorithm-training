import java.util.Scanner;

public abstract class Q1389 extends Question {
    Scanner sc;

    public Q1389() {
        this.sc = new Scanner(System.in);
    }

    @Override
    void input() {
        String line;
        int n, m;

        line = sc.nextLine();
        n = Integer.parseInt(line.split(" ")[0]);
        m = Integer.parseInt(line.split(" ")[1]);

        int[][] users = new int[n][n];
        for (int i = 0; i < users.length; i++) {
            for (int j = 0; j < users[0].length; j++) {
                users[i][j] = 0;
            }
        }

        for (int i = 0; i < m; i++) {
            line = sc.nextLine();
            int a = Integer.parseInt(line.split(" ")[0]);
            int b = Integer.parseInt(line.split(" ")[1]);

            users[a][b] = 1;
            users[b][a] = 1;
        }

//        return users;
    }

    @Override
    public void solution() {
//        int[][] users = input();



    }
}
